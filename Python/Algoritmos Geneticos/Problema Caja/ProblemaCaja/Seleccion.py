#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
Tema:Examen primer parcial
Tema:Primer algoritmo génetico
Alumnos: Palos Hernandez Jair Antonio
         Rojas Osorio Monserrath

Profesor: asdrubal lopez chau
Descripción:  Mecanismo de selección


"""
import numpy as np
import random
class Seleccion:
    
    def selecciona(self, aptitudes, k):
        #selecciona a la poblacion para la siguiente generacion
        # Darle chance a los feos
        aptitudes = np.array(aptitudes) + .001
        '''        
        denom = np.sum(np.exp(aptitudes))
        probabilidades = []
        for aptitud in aptitudes:
            probabilidades.append(np.exp(aptitud)/denom)
        '''
        #lista por compresion  para el calculo de las probabilidades de aptitudes
        #usando softmax
        aptitudes= aptitudes/np.max(np.abs(aptitudes))
        probabilidades = [np.exp(aptitud) / np.sum(np.exp(aptitudes)) for aptitud in aptitudes]
        indices = list( range(len(aptitudes)) )
        return random.choices(indices, probabilidades, k=k)
        
        











