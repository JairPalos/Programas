"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Mecanismo de Seleccion

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""
import numpy as np 
import random

class Seleccion:
    
    def selecciona (self, aptitudes, k=2):
        aptitudes= np.array(aptitudes)+ 0.1
        denom = np.sum(np.exp(aptitudes))
        
      #  probabilidades= []
       # for aptitud in aptitudes:
        #    probabilidades.append(np.exp(aptitud)/denom)
        probabilidades= [np.exp(aptitud)/np.sum(np.exp(aptitudes))for aptitud in aptitudes]
        indices = list(range(len(aptitudes)))
        return random.choices(indices,probabilidades,k =k)
        