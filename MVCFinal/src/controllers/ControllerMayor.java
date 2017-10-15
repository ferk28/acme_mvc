/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelMayor;
import views.ViewMayor;
/**
 *
 * @author fernando
 */
public class ControllerMayor {
    ModelMayor modelmayor;
    ViewMayor viewmayor;    

public ControllerMayor(ModelMayor modelmayor,ViewMayor viewmayor){ //view_mayor****
this.modelmayor = modelmayor;
this.viewmayor = viewmayor;
InitView();
}
public void InitView(){
    viewmayor.jtf_numero1.setText(String.valueOf(modelmayor.getN1()));
    viewmayor.jtf_numero2.setText(String.valueOf(modelmayor.getN2()));
    viewmayor.jtf_numero3.setText(String.valueOf(modelmayor.getN3()));
    viewmayor.jtf_resultado.setText(String.valueOf(modelmayor.getM()));
    viewmayor.setVisible(true);
    viewmayor.jbtn_calcular.addActionListener(e->jbtn_calcular_click());
    
}
public void jbtn_calcular_click(){
    modelmayor.setN1(Integer.parseInt(viewmayor.jtf_numero1.getText()));
    modelmayor.setN2(Integer.parseInt(viewmayor.jtf_numero2.getText()));
    modelmayor.setN3(Integer.parseInt(viewmayor.jtf_numero3.getText()));
    modelmayor.mayor();
    viewmayor.jtf_resultado.setText(String.valueOf(modelmayor.getM()));
}    
}
