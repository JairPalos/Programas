#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Test Cromosoma Entero
Alumnos: Monserrath Rojas Osorio
         Jair Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción:  test cromosoma entero

"""

from CromosomaEntero import CromosomaEntero as CInt

       #    w   x   y    z
minis = [-1000, 0 ,-2000,-500]
maxis = [1000 ,120,55   ,0]

for i in range(5):
    mama= CInt(minis, maxis)
    mama.init()
    print(i+1,") individuo")
    print(mama.__str__())
    print(mama.getValues())
    print("---------------------------------------------------------------------------------------------------------------------------")
for i in range(5):
    papa= CInt(minis, maxis)
    papa.init()
    print(i+6,") individuo")
    print(papa.__str__())
    print(papa.getValues())
    print("---------------------------------------------------------------------------------------------------------------------------")

hijos = papa.cruzar(mama)
print("hijo 1")
print(hijos[0].__str__())
print(hijos[0].getValues())
print("hijo 2")
print(hijos[1].__str__())
print(hijos[1].getValues())

hijos[0].mutar()
print('Hijo 1 mutado: ')
print(hijos[0].__str__())
print(hijos[0].getValues())

'''
papa= CInt(minis, maxis)
papa.init()
print("papa")
print(papa.__str__())
print(papa.getValues())

mama= CInt(minis, maxis)
mama.init()
print("mama")
print(mama.__str__())
print(mama.getValues())
hijos = papa.cruzar(mama)
print("hijo 1")
print(hijos[0].__str__())
print(hijos[0].getValues())
print("hijo 2")
print(hijos[1].__str__())
print(hijos[1].getValues())

hijos[0].mutar()
print('Hijo 1 mutado: ')
print(hijos[0].__str__())
print(hijos[0].getValues())
hijos[1].mutar()
print('Hijo 2 mutado: ')
print(hijos[1].__str__())
print(hijos[1].getValues())

for i in range(5):
    papa= CInt(minis, maxis)
    papa.init()
    print(")",i,"papa")
    print(papa.__str__())
    print(papa.getValues())
    mama= CInt(minis, maxis)
    mama.init()
    print(")",i,"papa")
    print(mama.__str__())
    print(mama.getValues())
    print("----------------------------")'''