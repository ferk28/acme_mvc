/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.*;
import views.*;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
/**
 *
 * @author fernando
 */
public class ControllerBlocdeNotas {
    private FileWriter file_writer = null;
    private FileReader file_reader = null;
    private JFileChooser file_chooser = new JFileChooser();
    private final ModelBlocdeNotas modelBlocdeNotas;
    private final ViewMain viewMain;
    private final ViewBlocdeNotas viewBlocdeNotas;
    
    public ControllerBlocdeNotas(ModelBlocdeNotas modelBlocdeNotas, Object views[]){
        this.modelBlocdeNotas = modelBlocdeNotas;
        this.viewMain = (ViewMain) views[0]; //jmi desde view main
        this.viewBlocdeNotas = (ViewBlocdeNotas) views[0]; //preguntar para que
        initView();
    
    }
    public void initView(){
        viewMain.setTitle("Editor de Texto MVC");
        viewMain.jmi_abrir.addActionListener(e -> jmi_abrirMouseClicked());
        viewMain.jmi_guardar.addActionListener(e -> jmi_guardarMouseClicked());
        viewMain.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    }
    
  private void jmi_abrirMouseClicked(){
        try{
            file_chooser.showOpenDialog(viewBlocdeNotas); //show open view bloc de notas **** view_principal
            modelBlocdeNotas.setArchivo(file_chooser.getSelectedFile());
            file_reader = new FileReader(modelBlocdeNotas.getArchivo());
            int character = 0;
            String content = "";
            while((character = file_reader.read()) != -1){
                content += (char) character;
            }
            file_reader.close();
            System.out.println(content);
            viewBlocdeNotas.jta_archivo.setText(content); //view bloc de notas
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no encontrado");
        }
        catch(IOException err){
            System.err.println("Error en el archivo");
        }
        finally{
            try{
                file_reader.close();
            }
            catch(IOException err){
                System.err.println("Error al cerrar");
            }
        }
    }
    
    public void jmi_guardarMouseClicked(){
        try{
        file_writer = new FileWriter(modelBlocdeNotas.getArchivo(),false);
        file_writer.write(viewBlocdeNotas.jta_archivo.getText()); //view bloc de notas
        file_writer.close();
        
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no Encontrado");
        }
        catch(IOException err){
            System.err.println("Error en el archivo");
        }
    }
    
    public void jmi_salirMouseClicked(){
        viewMain.dispose();
    }
}
