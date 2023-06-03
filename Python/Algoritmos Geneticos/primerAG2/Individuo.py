#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Primer algoritmo génetico
Alumno: Palos Hernandez Jair Antonio, Rojas Osorio Monserrath
Profesor: Dr. Asdrúbal López Chau
Descripción:  Primer Algoritmo Genético. Clase Individuo.

Created on Mon Feb 28 12:26:50 2022

@author: asdruballopezchau
"""
import random
import numpy as np
class Individuo:
    #constructor Individuo
    def __init__(self):
        #define el alfabeto
        self.alfabeto = "abcdefghijklmnopqrtsuvwxyz"
        self.cromosoma = ""
    
    def init(self, sizeInd=5):
        #se genera el cromosoma del alfabeto dependiendo del tamaño del individuo
        self.cromosoma = ''.join(random.choices(self.alfabeto, k=sizeInd))
        #instancia el tamaño del individuo
        self.sizeInd = sizeInd 

        
    def cruza(self, mother):
        #realiza la cruza para obtener 2 individuos 
        #
        padre = str(self.cromosoma)
        #
        madre = str(mother.cromosoma)
        #cross point
        #divide el tamaño del indice devolviendolo como entero
        mitad = int(self.sizeInd/2)
        #GENERA HIJOS A PARTIR DE LOS GENES DE LOS PADRES
        #hijo1
        #cruza los genes del padre y madre
        son1 = padre[0:mitad] + madre[mitad:]
        #hijo2
        #cruza los genes de la madre y el padre
        son2 = madre[0:mitad] + padre[mitad:]
        #crea el primero individuo
        ind1 = Individuo()
        ind1.sizeInd = self.sizeInd 
        ind1.cromosoma = son1
        #crea el segundo individuo
        ind2 = Individuo()
        ind2.sizeInd = self.sizeInd 
        ind2.cromosoma = son2
        return [ind1, ind2]
    
        #devuelve en cadena de caracteres el cromosoma
    def __str__(self):
        return self.cromosoma
    
    def mutar(self):
        #indice del numero aleatorio a elegir
        idx = np.random.randint(self.sizeInd)
        #letra aleatoria que se va a cambiar 
        cambiar = ''.join(random.choices(self.alfabeto, k=1))
        #cambia el cromosoma a lista
        self.cromosoma =  list(self.cromosoma)
        #Realiza el cambio de letra en el indice aleatorio
        self.cromosoma[idx] = cambiar
        #junta el cromosoma
        self.cromosoma = ''.join(self.cromosoma)

        
        
    


'''
# 1) Representación de la solución: La cromosoma será
una cadena de 5 caracteres. Cada gen es un caracter.
# 2) Función de evaluación o aptitud: Es el número de letras
en posición correcta.
# 3) Selección de progenitores: Mayor aptitud, más probabilidad
de ser elegido.
# 4) Operadores genéticos: 
#    a) Cruza: Cruza por un punto.
#    b) Mutación: Cambiar un gen (letra) mediante un proceso
                estocástico
'''