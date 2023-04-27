/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import Vista.Vista_Farmacia;
import Controlador.Controlador_farmacia;
/**
 *
 * @author carlos
 */
public class Farmacia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista_Farmacia vista= new Vista_Farmacia();
        Controlador_farmacia control=new Controlador_farmacia(vista);   
        control.iniciar_control();
        
    }
    
}
