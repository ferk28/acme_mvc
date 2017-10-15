/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.swing.*;
/**
 *
 * @author fernando
 */
public class ModelOrdenarAsc {
    private DefaultListModel modelo_lista_numeros;
    private double valor_insertado = 6;
    private double promedio = 6;
    
    public double getValor_Insertado(){
        return valor_insertado;
    }
    
    public double getPromedio(){
        return promedio;
    }
    
    public DefaultListModel getModelo_Lista_Numeros(){
        return modelo_lista_numeros;
    }
    
    public void setValor_Insertado(double valor_insertado){
        this.valor_insertado = valor_insertado;
    }
    
    public void setPromedio(double promedio){
        this.promedio = promedio;
    }
    
    public void Crear_Modelo_Lista(){
      modelo_lista_numeros = new DefaultListModel();
    }
    
    public void Insertar_Valor(double valor){
        modelo_lista_numeros.addElement(valor);
    }    

    public void Ordenar_Ascendente(){
        double tamaño_array = modelo_lista_numeros.getSize();
         int auxiliar_parseo;
         double temp_storage;
         
        for (int times = 0; times < tamaño_array; times++) {
            for (int index = 0; index < tamaño_array - 1; index++) {
                auxiliar_parseo = index + 1;
                if (Double.parseDouble(modelo_lista_numeros.getElementAt(index).toString()) > Double.parseDouble(modelo_lista_numeros.getElementAt(auxiliar_parseo).toString())) {
                    temp_storage = Double.parseDouble(modelo_lista_numeros.getElementAt(auxiliar_parseo).toString());
                    modelo_lista_numeros.setElementAt(modelo_lista_numeros.getElementAt(index), auxiliar_parseo);
                    modelo_lista_numeros.setElementAt(temp_storage, index);
                }
            }
        }
    }
    
    public void Promediar_Lista(){
         double tamaño_array = modelo_lista_numeros.getSize();
         int auxiliar_parseo;
         double sumatoria_temperaturas = 0;
         
         for(int a = 0; a < tamaño_array; a ++){
          sumatoria_temperaturas +=  Double.parseDouble(modelo_lista_numeros.getElementAt(a).toString());
         }
         promedio = sumatoria_temperaturas / tamaño_array;
    }
    
}
