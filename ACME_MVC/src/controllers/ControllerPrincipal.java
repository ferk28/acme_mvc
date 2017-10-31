/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewPersonas;
import views.ViewPrincipal;
import models.ModelMain;
import models.ModelPersonas;
/**
 *
 * @author fernando
 */
public class ControllerPrincipal {
    ViewPrincipal viewprincipal;
    ViewPersonas viewpersonas;
    ModelMain model_main;
    ModelPersonas modelpersonas;

    public ControllerPrincipal(ViewPrincipal viewprincipal,ViewPersonas viewpersonas,ModelMain model_main){
        this.viewprincipal = viewprincipal;
        this.viewpersonas = viewpersonas;
        this.model_main = model_main;
        this.viewprincipal.jmi_personas.addActionListener(e -> jmi_personasActionPerformed());
        this.viewprincipal.jmi_salir.addActionListener(e-> jmi_salirActionPerformed());
        viewprincipal.setVisible(true);
        viewprincipal.setResizable(false); //tamaño
        viewprincipal.setLocationRelativeTo(null);
    }
    public void jmi_personasActionPerformed(){
        this.viewprincipal.setContentPane(viewpersonas);
        this.viewprincipal.revalidate();
        this.viewprincipal.repaint();
    }
    public void jmi_salirActionPerformed(){
        System.exit(0);
    }
}
