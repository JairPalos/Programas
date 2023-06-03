"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Se crea  la classe de poblacion

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""
from Individuo import Individuo
class Poblacion:

    def __init__(self, size =100):
        self.size=size 


    def inicializa(self):
        poblacion =[]
        for i in range (self.size):
            ind = Individuo()
            ind.init()
            poblacion.append(ind)
        self.poblacion = poblacion 