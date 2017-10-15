/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.*;
import models.*;
/**
 *
 * @author fernando
 */
public class ControllerOperaciones {
    private final ViewOperaciones view_operaciones;
    private final ModelOperaciones model_operaciones;
    
    public ControllerOperaciones(ViewOperaciones view_operaciones, ModelOperaciones model_operaciones){
        this.view_operaciones = view_operaciones;
        this.model_operaciones = model_operaciones;
        initView();
    }
    
    public void initView(){
        view_operaciones.jbtn_sumar.addActionListener(e -> jbtn_sumarMouseClicked());
        view_operaciones.jbtn_restar.addActionListener(e -> jbtn_restarMouseClicked());
        view_operaciones.jbtn_multiplicar.addActionListener(e -> jbtn_multiplicarMouseClicked());
        view_operaciones.jbtn_dividir.addActionListener(e -> jbtn_dividirMouseClicked());
        view_operaciones.jtf_numero1.setText("" + model_operaciones.getNumero_1());
        view_operaciones.jtf_numero2.setText("" + model_operaciones.getNumero_2());
        view_operaciones.jl_resultado.setText("" + model_operaciones.getResultado());
    }
    
    public void jbtn_sumarMouseClicked(){
        model_operaciones.setNumero_1(Double.parseDouble(view_operaciones.jtf_numero1.getText()));
        model_operaciones.setNumero_2(Double.parseDouble(view_operaciones.jtf_numero2.getText()));
        model_operaciones.Sumar();
        view_operaciones.jl_resultado.setText("" + model_operaciones.getResultado());
    }
    
    public void jbtn_restarMouseClicked(){
        model_operaciones.setNumero_1(Double.parseDouble(view_operaciones.jtf_numero1.getText()));
        model_operaciones.setNumero_2(Double.parseDouble(view_operaciones.jtf_numero2.getText()));
        model_operaciones.Restar();
        view_operaciones.jl_resultado.setText("" + model_operaciones.getResultado());
    }
    
    public void jbtn_multiplicarMouseClicked(){
        model_operaciones.setNumero_1(Double.parseDouble(view_operaciones.jtf_numero1.getText()));
        model_operaciones.setNumero_2(Double.parseDouble(view_operaciones.jtf_numero2.getText()));
        model_operaciones.Multiplicar();
        view_operaciones.jl_resultado.setText("" + model_operaciones.getResultado());
    }
    
    public void jbtn_dividirMouseClicked(){
        model_operaciones.setNumero_1(Double.parseDouble(view_operaciones.jtf_numero1.getText()));
        model_operaciones.setNumero_2(Double.parseDouble(view_operaciones.jtf_numero2.getText()));
        model_operaciones.Dividir();
        view_operaciones.jl_resultado.setText("" + model_operaciones.getResultado());
    }    
}
