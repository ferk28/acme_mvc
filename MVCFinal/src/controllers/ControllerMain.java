/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.*;
import views.*;

/**
 *
 * @author fernando
 */
public class ControllerMain {
    private final ModelMain model_principal; //final***********************
    private final ViewOrdenarAsc view_ascendente;
    private final ViewBlocdeNotas view_editor_texto;
    private final ViewMayor view_mayor3_numeros;
    private final ViewOperaciones view_operaciones;
    private final ViewMain view_principal;

   public ControllerMain(ModelMain model_principal, Object views[]){
        this.model_principal = model_principal;
        this.view_ascendente = (ViewOrdenarAsc) views[0];
        this.view_editor_texto = (ViewBlocdeNotas) views[1];
        this.view_mayor3_numeros = (ViewMayor) views [2];
        this.view_operaciones = (ViewOperaciones) views[3];
        this.view_principal = (ViewMain) views[4];
        initView();
    }
    public void initView(){
        view_principal.setTitle("Remedial MVC");
        view_principal.jmi_ascendente.addActionListener(e -> jmi_ascendenteMouseClicked());
        view_principal.jmi_bloc_de_notas.addActionListener(e -> jmi_editor_textoMouseClicked());
        view_principal.jmi_Mayor.addActionListener(e -> jmi_mayor3_numerosMouseClicked());
        view_principal.jmi_operaciones.addActionListener(e -> jmi_operacionesMouseClicked());
        view_principal.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
        view_principal.setLocationRelativeTo(null);
        view_principal.setVisible(true);
    }
    
    public void jmi_ascendenteMouseClicked(){
        view_principal.setContentPane(view_ascendente);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
    public void jmi_editor_textoMouseClicked(){
        view_principal.setContentPane(view_editor_texto);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
    public void jmi_mayor3_numerosMouseClicked(){
        view_principal.setContentPane(view_mayor3_numeros);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
    public void jmi_operacionesMouseClicked(){
        view_principal.setContentPane(view_operaciones);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
    public void jmi_salirMouseClicked(){
        view_principal.dispose();
    }
       
}
