/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author fernando
 */
public class Main {
   private static ViewMain viewMain;
   private static ModelMain modelMain;
   private static ControllerMain controllerMain;
   
   /***************************************************************************/
   
   private static ViewBlocdeNotas viewBlocdeNotas;
   private static ViewMayor viewMayor;
   private static ViewOperaciones viewOperaciones;
   private static ViewOrdenarAsc viewOrdenarAsc;
   
   private static ModelBlocdeNotas modelBlocdeNotas;
   private static ModelMayor modelMayor;
   private static ModelOperaciones modelOperaciones;
   private static ModelOrdenarAsc modelOrdenarAsc;
   
   private static ControllerBlocdeNotas controllerBlocdeNotas;
   private static ControllerMayor controllerMayor;
   private static ControllerOperaciones controllerOperaciones;
   private static ControllerOrdenarAsc controllerOrdenarAsc;
   
   
    public static void main (String ferk[]){
        
        viewBlocdeNotas = new ViewBlocdeNotas();
        viewMayor = new ViewMayor();
        viewOperaciones = new ViewOperaciones();
        viewOrdenarAsc = new ViewOrdenarAsc();
        
        modelBlocdeNotas = new ModelBlocdeNotas();
        modelMayor = new ModelMayor();
        modelOperaciones = new ModelOperaciones();
        modelOrdenarAsc = new ModelOrdenarAsc();
        
        //controllerBlocdeNotas = new ControllerBlocdeNotas(ViewBlocdeNotas, ModelBlocdeNotas); /*error*/
        
        // profe lo hice conforme a su blog de panel, solo tengo error de aqui hacia abajo! pero no supe como de lo demas si
        controllerBlocdeNotas = new ControllerBlocdeNotas(modelBlocdeNotas, ferk);
        controllerMayor = new ControllerMayor(modelMayor, viewMayor);
        controllerOperaciones = new ControllerOperaciones(viewOperaciones, modelOperaciones);
        controllerOrdenarAsc = new ControllerOrdenarAsc(modelMayor, ferk);
                
        viewMain = new ViewMain();
        modelMain = new ModelMain();
        controllerMain = new ControllerMain(modelMain, ferk);
    }
    
}
