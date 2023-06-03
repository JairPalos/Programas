
package com.sistemas.controllers;

import com.sistemas.util.Helper;
import com.sistemas.views.ventana;
import jess.*;


public class EventHandler implements JessListener{

    ventana vista;
    public EventHandler(ventana vista) {
        this.vista = vista;
    }

    @Override
    public void eventHappened(JessEvent je){
        int type = je.getType();
        Rete rete = (Rete)je.getSource();
        Context context = je.getContext();
        Helper helper = new Helper(rete);

        if(type == JessEvent.DEFRULE_FIRED){
           Fact nodoActual = helper.findFactByTempleteName("MAIN::nodo-actual");
            if (nodoActual != null){
                String slotV;
                Fact nodo = null;
                try {
                    slotV = nodoActual.get(0).toString();
                    nodo = helper.findFactByTemplateName("MAIN::Nodo", "nombre", slotV);
                    if (nodo != null){
                        String tipo = nodo.getSlotValue("tipo").stringValue(context);
                        if (tipo.equals("pregunta")){
                            String pregunta = nodo.getSlotValue("pregunta").stringValue(context);
                            vista.cambiarPregunta(pregunta);
                        }else if(tipo.equals("respuesta")){
                            String respuesta = nodo.getSlotValue("respuesta").stringValue(context);
                            vista.darRespuesta("El niño tiene: "+respuesta);
                        }
                    }
                } catch (JessException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
