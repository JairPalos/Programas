# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: REDES NEURONALES
Tema: test Representación Real para AG
Alumno: Monserrath Rojas Osorio
        Luis Julian Vilchis Medina
        Jair Antonio Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción: test representacion Real para AG
Created on Mon Apr 25 12:46:59 2022

@author: mons
"""

from GenReal import GenReal

papa = GenReal(-1, 1,12)
papa.init()
print("papa")
print(papa.__str__())
print(papa.getValue() )
mama = GenReal(-1, 3.3,4)
mama.init()
print("mama")
print(mama.__str__())
print(mama.getValue() )
print("---------------------------")
hijos = papa.cruzar(mama)
print("hijo 1 ")
print(hijos[0].__str__())
print(hijos[0].getValue())
print("hijo 2 ")
print(hijos[1].__str__())
print(hijos[1].getValue())
hijos[0].mutar()
print('Hijo 1 mutado: ')
print(hijos[0].__str__())
print(hijos[0].getValue())
hijos[1].mutar()
print('Hijo 2 mutado: ')
print(hijos[1].__str__())
print(hijos[1].getValue())