# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: REDES NEURONALES
Tema: Cromosoma Real para AG
Alumno: Monserrath Rojas Osorio
        Luis Julian Vilchis Medina
        Jair Antonio Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción: Cromosoma Real para AG
Created on Mon Apr 25 13:26:42 2022

@author: mons
"""
import numpy as np
from GenReal import GenReal as Real
from Poblacion import Poblacion
from FitnessFuction import FitnessFuction

class CromosomaReal:
    def __init__(self, minis, maxis,nbits,size):
        '''
        

        Parameters
        ----------
        minis : list
            DESCRIPTION.valores minimos
        maxis : list
            DESCRIPTION. valores maximos
        nbits : list
            DESCRIPTION. longitud de cada gen

        Returns
        -------
        None.

        '''
        #si la longitud de los valores minimos y maximos es diferente
        if len(minis) != len(maxis):
            return
        self.size = size#tamaño de poblacion
        self.pob = None#pob=null(vacio)
        self.minis = minis.copy()
        self.maxis = maxis.copy()
        self.nbits = nbits.copy()
        self.genes = []
        #obtiene los valores minimos, maximos y el numero de bits de cada gen 
        for min, max,nbits in zip(minis, maxis,nbits):
            gen = Real(min, max,nbits)
            self.genes.append(gen)
            
    def init(self):
        # Inicializa los genes 
        for gen in self.genes:
            gen.init()

    def __str__(self):
         # Regresa los genes como cadena de ceros y unos
        cad = ""
        for gen in self.genes:
            cad = cad + gen.__str__()
        return cad

    def getValues(self):
         # guarda los valores reales de cada gen 
        values = []
        for gen in self.genes:
            values.append(gen.getValue())
        return values

    def cruzar(self, madre):
        #realiza la cruza de todos los genes madre y padre
        genesHijos1 = []
        genesHijos2 = []
        for papa, mama in zip(self.genes, madre.genes):
            g = papa.cruzar(mama)
            genesHijos1.append(g[0])
            genesHijos2.append(g[1])
        h1 = CromosomaReal(self.minis, self.maxis,self.nbits)
        h2 = CromosomaReal(self.minis, self.maxis,self.nbits)
        h1.genes = genesHijos1
        h2.genes = genesHijos2
        return [h1, h2]
    
    def mutar(self):
        #muta los genes
        for gen in self.genes:
            gen.mutar()
            
    def inicializa(self):#metodo para empezar el algoritmo evolutivo
        pob = Poblacion(self.minis,self.maxis,self.nbits,self.size)#objeto de tipo poblacion se le manda la cadena a encontrar y la longitud
        pob.inicializa()#crea una poblacion
        self.pob = pob#guarda la poblacion
        self.ff = FitnessFuction(self.genes)#crea un objeto de tipofitnessfunction se le manda la palabra a encontrar
     
    def showPob(self, showAptitude=False):#imprime la poblacion
         if showAptitude:
             aptitudes = [self.ff.evaluate(self.genes)
                      for ind in self.pob.poblacion]#calcula las aptitudes

         for i in range(self.size):#ciclo en el tamaño de la poblacion
             if showAptitude:#si es true
                 print(self.pob.poblacion[i].__str__() +
                       "cercania -> " + str(aptitudes[i]))#imprime los individuos de la poblacion junto a su aptidtud
             else:#si es false
                 print(self.pob.poblacion[i])#imprime solo los individuos de la poblacion
    
    
    