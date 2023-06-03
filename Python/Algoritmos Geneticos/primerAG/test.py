#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM Zumpango

Unidad de Aprendizaje: 

Author: Dr. Jair Antonio Palos Hernandez

Descripción:  Script de pruebas

Created on Mon Feb 28 13:33:22 2022

@author: 
"""

from AlgoritmoEvolutuvo import AlgoritmoEvolutivo

ae = AlgoritmoEvolutivo(200, "hola")
ae.inicializa()

ae.showPob(True)
ae.elmejor()
for i in range(300):
    ae.evolucion()
print("------------")
ae.showPob(True)
ae.elmejor()
