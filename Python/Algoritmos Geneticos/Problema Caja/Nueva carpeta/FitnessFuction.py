"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Clase fitnessfunvtion
evalua individuos para el problema de 
encontrar contraseña

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""

from GenReal import GenReal as  Real
import numpy as np 
class FitnessFuction:
    def __init__(self, target):
        self.target = target
        self.lamda =1
        self.beta=1
    
    def evaluate (self, ind):
        '''
        Evalua la aptitud de un l
        Parameters
        ___________

        ind: Individuo
            Description: Representa una contraseña

        Returns
        --------
        int 
            Description:
            Aptitud del individuo en la cnatidad 
            de letras en posicion coreecta
        '''
        intento= ind
        ladodeCaja = intento.getValues()
        vol=1
        for lado in ladodeCaja:
            vol = vol*lado
        x=np.abs(self.target -vol)
        return self.beta*np.exp(-self.lamda*x)




