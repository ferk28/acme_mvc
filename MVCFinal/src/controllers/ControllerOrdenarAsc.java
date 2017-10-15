/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import javax.swing.DefaultListModel;
import views.*;
import models.*;

/**
 *
 * @author fernando
 */
public class ControllerOrdenarAsc {
    private final ViewOrdenarAsc viewordenarasc;
    private final ModelOrdenarAsc modelordenarasc;
    
    public ControllerOrdenarAsc(ViewOrdenarAsc view_OrdenarAsc, ModelOrdenarAsc model_ModelOrdenarAsc){
        this.viewordenarasc = view_OrdenarAsc;
        this.modelordenarasc = model_ModelOrdenarAsc;
        initView();
    }

    public ControllerOrdenarAsc(ModelMayor model_ascendente, Object[] views) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void initView(){
        viewordenarasc.jtf_insertar_numero.setText("" + modelordenarasc.getValor_Insertado());
        viewordenarasc.jbtn_insertar.addActionListener(e -> jbtn_insertar_numeroMouseClicked());
        viewordenarasc.jbtn_asc.addActionListener(e -> jbtn_ascendenteMouseClicked());
        viewordenarasc.jbtn_promedio.addActionListener(e -> jbtn_promedioMouseClicked());
        modelordenarasc.Crear_Modelo_Lista();
        viewordenarasc.jl_list1.setModel(modelordenarasc.getModelo_Lista_Numeros());
    }
    
    public void jbtn_insertar_numeroMouseClicked(){
        modelordenarasc.setValor_Insertado(Double.parseDouble(viewordenarasc.jtf_insertar_numero.getText()));
        modelordenarasc.Insertar_Valor(modelordenarasc.getValor_Insertado());
    }
    
    public void jbtn_ascendenteMouseClicked(){
        modelordenarasc.Ordenar_Ascendente();
        viewordenarasc.jl_list1.setModel(modelordenarasc.getModelo_Lista_Numeros());
    }
    
    public void jbtn_promedioMouseClicked(){
        modelordenarasc.Promediar_Lista();
        viewordenarasc.jlb_promedio.setText("" + modelordenarasc.getPromedio());
    }
        
}
