"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Primer Algoritmo Genrico. Clase individuo

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""
import random
import numpy as np

class Individuo:

		def __init__ (self):
			self.alfabeto = "abcdefghijklmnopqrstuvwxyz"
			self.cromosoma = ""

		def init(self):
			random.cromosoma = ''.join(random.choices(self.alfabeto, k=5))

		

		def cruzar (self, mother):
			padre = self.cromosoma
			madre = mother.cromosoma
			son1 = padre [0:3] + madre[3:]
			son2 = madre [0:3] + padre[3:]
			ind1 = Individuo()
			ind1.cromosoma = son1
			ind2 = Individuo()
			ind2.cromosoma = son2
			return [ind1, ind2]

		def __str__(self):
			return self.cromosoma

		def mutar (self):
			idx = np.random.randint(5)
			cambiar =''.join (random.choices(self.alfabeto, k=1))
			self.cromosoma = list(self.cromosoma)
			self.cromosoma[idx] = cambiar
			self.cromosoma = ''.join(self.cromosoma)
