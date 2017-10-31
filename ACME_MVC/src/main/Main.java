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
    private static ViewPrincipal viewprincipal;
    private static ModelMain modelmain;
    private static ControllerPrincipal controller_main;
    
    private static ViewPersonas viewpersonas;
    private static ModelPersonas modelpersonas;
    private static ControllerPersonas controller_personas;  
    
    public static void main (String ferk[]){
       viewpersonas = new ViewPersonas();
       modelpersonas = new ModelPersonas();
       controller_personas = new ControllerPersonas(modelpersonas, viewpersonas);
       
       viewprincipal = new ViewPrincipal();
       modelmain = new ModelMain();
       controller_main = new ControllerPrincipal(viewprincipal, viewpersonas, modelmain);
    }
    
}
