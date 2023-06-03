#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Geneticos

Tema:
Profesor: Dr. Asdrúbal López Chau
Descripción: Encontrar passwr con fuerza bruta 
    
Created on Mon Feb 21 12:35:45 2022

@author: rogelioortegabarrera
        Jair Antonio Palos Hernandez
        Monserrath Rojas Osorio
"""

intento = input("Bienvenidio a Algoritmos Gemeticos, digite contraseña para entrar: ")
contador = 0
contador1 =0
alfabeto = "abcdefghijklmnopqrstuvwxyz"
passw = "icoag"
i=0
for letra in passw:
        if intento[i] ==letra:
            contador1 +=1  
            i+=1      
print("numero de veces",contador1)

for c1 in alfabeto:
    for c2 in alfabeto:
        for c3 in alfabeto:
            for c4 in alfabeto:
                for c5 in alfabeto:
                    intento = c1+c2+c3+c4+c5
                    if intento != passw:
 
                            contador +=1


print("numero de veces ", contador)
