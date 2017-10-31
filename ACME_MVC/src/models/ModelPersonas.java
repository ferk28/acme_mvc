/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
        
/**
 *
 * @author fernando
 */
public class ModelPersonas {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_persona;
    private String nombre;
    private String telefono;
    private String email;
    
    public void setId_persona(int id_persona){
        this.id_persona = id_persona;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getId_persona(){
        return id_persona;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    public void Conectar(){
        
            try { //jdbc:mysql://mysql-t.sourceforge.net:3306/acme_mvc //jdbc:mysql://localhost:/acme_mvc:4040
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/acme_mvc","root","fernando");
                st = conexion.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error 101" + ex);
        }
    }
    public void llenarValores(){
        try{
            setId_persona(rs.getInt("id_personas"));
            setNombre(rs.getString("nombre"));
            setTelefono(rs.getString("telefono"));
            setEmail(rs.getString("email"));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 102" + ex);
        }
    }
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 103" + ex);
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 104" + ex);
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
                llenarValores();
                }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 105" + ex);
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
                llenarValores();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 106" + ex);
        }
    }
    public void seleccionarTodos(){
        try{
            sql="SELECT * FROM personas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 107" + ex);
        }
    }
    public void insertar(){ //String nombre, String telefono, String email
        try{
            sql = "INSERT INTO personas(nombre, telefono, email) VALUES (?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, email);
            ps.executeUpdate();
            
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 108" + ex);
        }
    }
    public void borrar(){ //int id_persona
        try{
            sql = "DELETE FROM personas WHERE id_personas = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_persona);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 109" + ex);
        }
    }
    public void actualizar(){ //int id_persona, String nombre, String telefono, String email
        try{
            sql = "UPDATE personas SET nombre=? , telefono=? , email=? WHERE id_personas= ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(4, id_persona);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, email);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error 110" + ex);
        }
    }
} 
