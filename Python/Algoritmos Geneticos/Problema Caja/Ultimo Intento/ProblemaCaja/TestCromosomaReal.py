# -*- coding: utf-8 -*-
"""
+UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: REDES NEURONALES
Tema: Test Cromosoma Real para AG
Alumnos: Monserrath Rojas Osorio
        Luis Julian Vilchis Medina
        Jair Antonio Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción: Test Cromosoma Real para AG
Created on Mon Apr 25 13:36:35 2022

@author: mons
"""
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
from AlgoritmoEvolutivo import AlgoritmoEvolutivo

vol=input("introduzca un volumen: ")
v = int(vol)

k= np.power(v,1/3)
       #  h    w   l   
minis = [k/3,k/2 ,2*k]
maxis = [k/15,k/3,4*k]
nbits = [16,16,16]

#crea el objeto tipo Algoritmo evolutivo 
                        #minis, maxis,nbits,volumen,iteraciones
ae = AlgoritmoEvolutivo(minis,maxis,nbits,v,100)
#iniciliza el objeto algoritmo genetico 
ae.inicializa()

#muestra la poblacion inicial
ae.showPob(True)
ae.elmejor()
#realiza las evolucion para las nuevas generaciones
for i in range(100):
    ae.evolucion()
print("------------")
#muestra la poblacion final
ae.showPob(True)
ae.elmejor()
ae.graf()


'''
r= CReal(minis, maxis,nbits)
r.init()
print(r.__str__())
print(r.getValues())
f=FF(11)
print("\n")
print("fitness =" + str(f.evaluate(r)))

print("\n")
r2= CReal(minis, maxis,nbits)
r2.init()
print(r2.__str__())
print(r2.getValues())
print("\n")
print("fitness =" + str(f.evaluate(r2)))
'''