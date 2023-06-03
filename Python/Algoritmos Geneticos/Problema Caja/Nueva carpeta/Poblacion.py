"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Se crea  la classe de poblacion

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""

from GenReal import GenReal
class Poblacion:

    def __init__(self, mini,maxi,nbits, size =100):
        self.size=size 
        self.mini=mini
        self.maxi=maxi
        self.nbits=nbits

    def inicializa(self):
        poblacion =[]
        for i in range (self.size):
            gen = GenReal(self.mini,self.maxi,self.nbits)
            gen.init(self.mini,self.maxi,self.nbits)
            poblacion.append(gen)
        self.poblacion = poblacion 