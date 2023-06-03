"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Sript de pruebas

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""

from AlgoritmoEvolutivo import AlgoritmoEvolutivo

ae=AlgoritmoEvolutivo(100,"holai")
ae.inicializa()
ae.showPob(True)
ae.evolucion()