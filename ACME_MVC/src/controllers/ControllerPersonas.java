/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import javax.swing.JOptionPane;
import models.ModelPersonas;
import views.ViewPersonas;
/**
 *
 * @author fernando
 */
public class ControllerPersonas {
    private final ModelPersonas model_personas;
    private final ViewPersonas view_personas;
    
    public ControllerPersonas(ModelPersonas model_personas, ViewPersonas view_personas){
        this.model_personas = model_personas;
        this.view_personas = view_personas;
        view_personas.jbtn_primero.addActionListener(e-> jbtn_primero_clic());
        view_personas.jbtn_anterior.addActionListener(e-> jbtn_anterior_clic());
        view_personas.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_clic());
        view_personas.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_clic());
        view_personas.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_clic());
        view_personas.jbtn_agregar.addActionListener(e-> jbtn_agregar_clic());
        view_personas.jbtn_quitar.addActionListener(e-> jbtn_quitar_clic());
        
        initView();
    }
    
    public void initView(){
        model_personas.Conectar();
        model_personas.seleccionarTodos();
        model_personas.moverPrimero();
        
        
        view_personas.jbtn_agregar.setEnabled(false);//cush
        view_personas.jtf_id.setEditable(false);        
        
        getValores();
    }
    public void getValores(){
        view_personas.jtf_id.setText("" + model_personas.getId_persona());
        view_personas.jtf_nombre.setText(model_personas.getNombre());
        view_personas.jtf_email.setText(model_personas.getEmail());
        view_personas.jtf_telefono.setText(model_personas.getTelefono());
    }
    public void setvalores(){
        model_personas.setId_persona(Integer.parseInt(view_personas.jtf_id.getText()));
        model_personas.setNombre(view_personas.jtf_nombre.getText());
        model_personas.setTelefono(view_personas.jtf_telefono.getText());
        model_personas.setEmail(view_personas.jtf_email.getText());
    }
    public void jbtn_nuevo_clic(){
        agregar_true();
        
        view_personas.jtf_id.setText("0");
        view_personas.jtf_email.setText("");
        view_personas.jtf_nombre.setText("");
        view_personas.jtf_telefono.setText("");
    }
    public void jbtn_agregar_clic(){
        
        if(view_personas.jtf_nombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setvalores();
        model_personas.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_modificar_clic(){
        setvalores();
        model_personas.actualizar();
        getValores();
    }
    public void jbtn_quitar_clic(){
        setvalores();
        model_personas.borrar();
        getValores();
    }
    public void jbtn_primero_clic(){
        model_personas.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_clic(){
        model_personas.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_clic(){
        model_personas.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_clic(){
        model_personas.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        view_personas.jbtn_agregar.setEnabled(false);
        view_personas.jbtn_modificar.setEnabled(true);
        view_personas.jbtn_quitar.setEnabled(true);          
    }
    public void agregar_true(){
        view_personas.jbtn_agregar.setEnabled(true);
        view_personas.jbtn_quitar.setEnabled(false);
        view_personas.jbtn_modificar.setEnabled(false);        
    }
    
}
