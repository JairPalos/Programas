#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: INTELIGENCIA ARTIFICIAL
Tema: 
Alumno: Tu Nombre
Profesor: Dr. Asdrúbal López Chau
Descripción: 
 
Created on Mon May  2 13:08:08 2022
 
@author: Jair Hernandez
"""



from matplotlib import pyplot
import numpy as np
from CromosomaReal import CromosomaReal as Real
from FitnessFuction import FitnessFuction as FF

k=np.power(11,1/3)
minimos=[k/8,k/2,k/2*k]
maximos=[k/15,k/3,4*k]
nbits=[16,16,16]
r=Real(minimos,maximos,nbits,100)
r.inicializa()
#muestra la poblacion inicial
print("poblacion inicial")
r.showPob(True)


soluciones = ('numero 1','numero 2','numero 3','numero 4')
valores = (5,3,5,3)
colores = ('red','blue','green','#DD98AA','#18492D')

pyplot.pie(valores,colors=colores,labels=soluciones,autopct ='%1.1f%%')

pyplot.axis('equal')
pyplot.title('Mejores valores')
pyplot.show()