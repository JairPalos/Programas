#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM Zumpango

Unidad de Aprendizaje: 

Author: Jair Antonio Palos Hernandez

Descripción:  Clase fitnessfunction
evalua individuos para el problema de 
encontrar contraseña

Created on Mon Mar  7 11:13:53 2022

@author: 
"""

class FitnessFunction:## se crea ala la clase fitnessFuction
    
    def __init__(self, target="holam"):## Se crea el constructor  con un modelo
        self.target = target
    
    def evaluate(self, ind):## Cea la cion de evaluar
        '''
        Evalua la aptitud de un individuo
        Parameters
        ----------
        ind : Individuo
            DESCRIPTION. Representa una
            contraseña

        Returns
        -------
        int
            DESCRIPTION. Aptitud del 
            individuo es la cantidad de
            letras en la posicion correcta

        '''
        intento = ind.cromosoma## los intentos  se crean individuos en el cromosoma 
        ctr = 0##  Se crea un contador
        for letraP, letraC in zip(self.target, intento):##compara cada letra
            if letraP == letraC:## Si las dos letras son iguales 
                ctr += 1 ## aumenta el contador
        return ctr##regresa el contador
    
        