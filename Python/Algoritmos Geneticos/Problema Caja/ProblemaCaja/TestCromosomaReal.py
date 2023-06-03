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
from mpl_toolkits.mplot3d import axes3d
import numpy as np
from AlgoritmoEvolutivo import AlgoritmoEvolutivo
from matplotlib import pyplot as plt
from matplotlib import style
k= np.power(11,1/3)
       #  h    w   l   
minis = [k/2,k/2 ,2*k]
maxis = [k/16,k/3,4*k]
nbits = [16,16,16]

#crea el objeto tipo Algoritmo evolutivo 
                        #minis, maxis,nbits,volumen,iteraciones
ae = AlgoritmoEvolutivo(minis,maxis,nbits,11,10)
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

#print("Volumen es: ")
array =[]
array = ae.volumen(True)
print("Arreglo es", array)
print("Altura",array[0])
print("Largo",array[2])
print("Ancho",array[1])

style.use('ggplot') 
fig = plt.figure()
ax1 = fig.add_subplot(111, projection='3d')

# Definimos los datos
x3 = [array[2],array[0]]
y3 = [array[0],array[1]]
z3 = [array[1],array[2]]

dx = [1,0.005]  # Width of each bar
dy = [1,0.005]  # Depth of each bar
dz = [1,0.005]        # Height of each bar

# utilizamos el método bar3d para graficar las barras
ax1.bar3d(x3, y3, z3, dx, dy,dz)

# Mostramos el gráfico
plt.show()


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