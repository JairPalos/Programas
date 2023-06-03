"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Lista de compresion

Created: on Mon Feb 28 11:28:44 2022

"""
nombres= ["leonardo","Joel","Fernando"]
apellidos= ["bernal","vargas","dominguez"]

for i in range(len(nombres)):
	nombre = nombres[i]
	apellido = apellidos[i]
	print(nombres+ " "+ apellidos)

for nombre, apellido in zip(nombres,apellidos):
	print(nombres+ " "+ apellidos)
