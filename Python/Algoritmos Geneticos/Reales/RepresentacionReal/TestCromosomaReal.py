# -*- coding: utf-8 -*-
"""
+UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: REDES NEURONALES
Tema: Test Cromosoma Real para AG
Alumno: Monserrath Rojas Osorio
        Luis Julian Vilchis Medina
        Jair Antonio Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción: Test Cromosoma Real para AG
Created on Mon Apr 25 13:36:35 2022

@author: mons
"""

from CromosomaReal import CromosomaReal as CReal

       #    w   x   y    z
minis = [-5.9, -1 ,100]
maxis = [12 ,0,201.13]
nbits = [32,16,64]

for i in range(5):
    mama= CReal(minis, maxis,nbits)
    mama.init()
    print(i+1,") individuo")
    print(mama.__str__())
    print(mama.getValues())
    print("---------------------------------------------------------------------------------------------------------------------------")
for i in range(5):
    papa= CReal(minis, maxis,nbits)
    papa.init()
    print(i+6,") individuo")
    print(papa.__str__())
    print(papa.getValues())
    print("---------------------------------------------------------------------------------------------------------------------------")

hijos = papa.cruzar(mama)
print("-----hijo 1--------------------------------------------------------------------------------------------------------------------")
print(hijos[0].__str__())
print(hijos[0].getValues())
print("-----hijo 2--------------------------------------------------------------------------------------------------------------------")
print(hijos[1].__str__())
print(hijos[1].getValues())

hijos[0].mutar()
print('-----Hijo 1 mutado-------------------------------------------------------------------------------------------------------------')
print(hijos[0].__str__())
print(hijos[0].getValues())

