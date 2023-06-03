"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Script  de puebas solucion laboratorio

Created: on Mon Feb 28 11:28:44 2022
"""
from laboratorio0 import Sistema as MySistem
from laboratorio0 import MyHack
s = MySistem()
hack = MyHack(s)
print(s.login("jair","acaaa"))


hack.fuerzaBruta()