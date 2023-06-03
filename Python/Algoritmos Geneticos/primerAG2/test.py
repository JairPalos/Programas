#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Primer algoritmo génetico
Alumno: Monserrath Rojas Osorio
Profesor: Palos Hernandez Jair Antonio, Rojas Osorio Monserrath
Descripción:  Script de pruebas

Created on Mon Feb 28 13:33:22 2022

@author: asdruballopezchau
"""

from AlgoritmoEvolutivo import AlgoritmoEvolutivo
#crea el objeto tipo Algoritmo evolutivo con 300 individuos y la contraseña a descubrir
ae = AlgoritmoEvolutivo(1000, "icoag")
#iniciliza el objeto algoritmo genetico 
ae.inicializa()
#muestra la poblacion inicial
ae.showPob(True)
ae.elmejor()
#realiza las evolucion para las nuevas generaciones
for i in range(5):
    ae.evolucion()
print("------------")
#muestra la poblacion final
ae.showPob(True)
ae.elmejor()
