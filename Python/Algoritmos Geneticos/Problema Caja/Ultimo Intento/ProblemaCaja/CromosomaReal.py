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
from GenReal import GenReal as Real

class CromosomaReal:
    def __init__(self, minis, maxis,nbits):
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