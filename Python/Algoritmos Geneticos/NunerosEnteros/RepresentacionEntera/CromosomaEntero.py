#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:cromosoma Entero
Alumnos: Monserrath Rojas Osorio
         Jair Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción:  cromosoma entero 


"""
from GenEntero import GenEntero as Entero

class CromosomaEntero:
    
    def __init__(self, minis, maxis):
        #si la longitud de los valores minimos y maximos es diferente
        if len(minis) != len(maxis):
            return
        #declara variables donde se guardarán los valores maximos,minimos y genes
        self.minis = minis.copy()
        self.maxis = maxis.copy()
        self.genes = []
        #obtiene los valores minimos y maximos de cada gen 
        for min, max in zip(minis, maxis):
            gen = Entero(min, max)
            self.genes.append(gen)
            
    def init(self):
        # Inicializa los genes 
        for gen in self.genes:
            gen.initGen()

    def __str__(self):
         # Regresa los genes como cadena de ceros y unos
        cad = ""
        for gen in self.genes:
            cad = cad + gen.__str__()
        return cad

    def getValues(self):
         # guarda los valores decimales de cada gen 
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
        h1 = CromosomaEntero(self.minis, self.maxis)
        h2 = CromosomaEntero(self.minis, self.maxis)
        h1.genes = genesHijos1
        h2.genes = genesHijos2
        return [h1, h2]
    
    def mutar(self):
        #muta los genes
        for gen in self.genes:
            gen.mutar()
        