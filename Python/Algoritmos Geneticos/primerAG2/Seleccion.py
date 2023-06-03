#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Primer algoritmo génetico
Alumno: Monserrath Rojas Osorio
Profesor: Palos Hernandez Jair Antonio, Rojas Osorio Monserrath
Descripción:  Mecanismo de selección

Created on Mon Mar  7 11:38:30 2022

@author: asdruballopezchau
"""
import numpy as np
import random
class Seleccion:
    
    def selecciona(self, aptitudes, k=2):
        #selecciona a la poblacion para la siguiente generacion
        # Darle chance a los feos
        aptitudes = np.array(aptitudes) + .01
        '''        
        denom = np.sum(np.exp(aptitudes))
        probabilidades = []
        for aptitud in aptitudes:
            probabilidades.append(np.exp(aptitud)/denom)
        '''
        #lista por compresion  para el calculo de las probabilidades de aptitudes
        #usando softmax
        probabilidades = [np.exp(aptitud)/np.sum(np.exp(aptitudes)) for aptitud in aptitudes]
        indices = list(range(len(aptitudes)))
        
        return random.choices(indices, probabilidades, k=k)
        
        











