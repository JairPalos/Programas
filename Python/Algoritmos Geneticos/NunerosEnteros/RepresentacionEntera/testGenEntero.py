#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Test Gen Entero
Alumnos: Monserrath Rojas Osorio
         Jair Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción:  prueba gen entero


"""

from GenEntero import GenEntero

papa = GenEntero(-100, 30)
papa.initGen()
print("papa")
print(papa.__str__())
print(papa.getValue() )
print("---------------------------")
mama = GenEntero(-10, 100)
mama.initGen()
print("mama")
print(mama.__str__())
print(mama.getValue() )
print("---------------------------")
hijos = papa.cruzar(mama)
print("hijo 1 ")
print(hijos[0].__str__())
print(hijos[0].getValue())
print("---------------------------")
print("hijo 2 ")
print(hijos[1].__str__())
print(hijos[1].getValue())
print("---------------------------")
'''
hijos[0].mutar()
print('Hijo 1 mutado: ')
print(hijos[0].__str__())
print(hijos[0].getValue())
hijos[1].mutar()
print('Hijo 2 mutado: ')
print(hijos[1].__str__())
print(hijos[1].getValue())'''












