
package com.sistemas.controllers;

import com.sistemas.views.ventana;

public class ninoController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ventana zooView = new ventana();
        MotorController motorController = new MotorController();        
        EventHandler eventController = new EventHandler(zooView);
        zooView.setMotorController(motorController);
        motorController.addEscuchador(eventController);
        motorController.ejecutar();
       
        
    }
    
}
