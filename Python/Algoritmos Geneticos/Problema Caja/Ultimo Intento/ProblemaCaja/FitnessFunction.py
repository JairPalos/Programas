#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:AE CAJA
Alumnos: Monserrath Rojas Osorio
        Luis Julian Vilchis Medina
        Jair Antonio Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción:  Clase fitnessfunction
evalua individuos para el problema de 
encontrar contraseña

Created on Mon Mar  7 11:13:53 2022

@author: asdruballopezchau
"""
import numpy as np

class FitnessFunction:
    
    def __init__(self, target):
        self.target = target
        self.lamda =1
        self.beta =1
    
    def evaluate(self, ind):
        
        intento = ind
        ladosCaja = intento.getValues()
        vol = 1
        for lado in ladosCaja:
            vol = vol * lado
            x=np.abs(self.target-vol)
        return self.beta*np.exp(-self.lamda*x)