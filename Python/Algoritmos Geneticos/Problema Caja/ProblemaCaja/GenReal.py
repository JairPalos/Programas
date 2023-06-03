2# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: REDES NEURONALES
Tema: Representación Real para AG
Alumno: Monserrath Rojas Osorio
        Luis Julian Vilchis Medina
        Jair Antonio Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción: representacion Real para AG
Created on Mon Apr 25 12:05:22 2022

@author: mons
"""
import numpy as np
import random
import math

class GenReal:
    def __init__(self,min,max,nbits):
        self.min=min
        self.max=max
        self.nbits=nbits
        #calcula Delta --> |min-max|/nbits^2
        self.delta=np.abs(min-max)/2**nbits

    
    def init(self):
        # Inicializa el gen pseudoaletoriamente con 
        # ceros y unos
        #gen[0]-->signo
        #gen[1:]-->numero
            self.gen = random.choices([0, 1], k=self.nbits)
    
    def cruzar(self,mama):
        #Aplica cruza de este gen con el gen de la madre
       padre = self.gen.copy()
       madre = mama.gen.copy()
       #cross point
       #divide el tamaño del indice devolviendolo como entero
       cp1 = int(np.ceil((self.nbits - 1)/3.))
       cp2 = 2 * cp1
       #realiza la cruza para el primer hijo
       #toma el signo del padre
       son1 = padre[0:cp1]
       #toma el primer crosspoint con genes de la madre
       son1.extend(madre[cp1:cp2])
       #toma el segundo crosspoint con genes del padre
       son1.extend(padre[cp2:])
       #realiza la cruza para el segundo hijo
       #toma el signo de la madre
       son2 = madre[0:cp1]
       #toma el primer crosspoint con genes del padre
       son2.extend(padre[cp1:cp2])
       #toma el segundo crosspoint con genes de la madre
       son2.extend(madre[cp2:])
       
       s1 = GenReal(self.min, self.max,self.nbits)
       s2 = GenReal(self.min, self.max,self.nbits)
       s1.gen = son1
       s2.gen = son2
       return [s1, s2]
    
    def mutar(self):
        #inicializa el gen-->muta
        self.init()
    
    def __str__(self):
         # Regresa el gen como cadena de ceros y unos
        return str(self.gen)
    
    def getValue(self):
        #Regresa el valor real que representa el gen
        particion = int(''.join([str(i) for i in self.gen]), 2)
        return self.min + self.delta*particion