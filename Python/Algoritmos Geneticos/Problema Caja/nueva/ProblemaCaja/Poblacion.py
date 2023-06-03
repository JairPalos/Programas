#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Primer algoritmo génetico
Alumno: Palos Hernandez Jair Antonio, Rojas Osorio Monserrath
Profesor: Dr. Asdrúbal López Chau

Descripción:  Población de individuos

Created on Mon Mar  7 11:31:12 2022

@author: asdruballopezchau
"""
#from Individuo import Individuo
from CromosomaReal import CromosomaReal 
class Poblacion:
    #constructor Poblacion con tamaño de poblacion de 100
    def __init__(self,min,max,nbits, target, size):
        self.min=min
        self.max=max
        self.nbits=nbits
        self.size = size
        self.target = target

    def inicializa(self):
        #INICIALIZACIÓN DE LA POBLACIÓN
        poblacion = []
        #agrega poblacion para la nueva poblacion con sus individuos
        for i in range(self.size):
            ind = CromosomaReal(self.min,self.max,self.nbits)
            #ind.sizeInd = len(self.target)
            ind.init()
            #agrega a la poblacion individuos
            poblacion.append(ind)
        self.poblacion = poblacion
        
   
        
        
        
        
        
        
        
        
        
        
        
        