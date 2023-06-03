"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Repaso de lista por compresion

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""

# lista de numeros pares entre 1 y 10

pares2 = [n for n in range (1,11) if n%2 ==0]

print(pares2)

# Lista de frutas
frutas =["mango","sandia","melon","aguacate","fresa","durazno","melocoton"]

#Sublista  de frutas sin "a"
fsa= [fruta for fruta in frutas if "a" not in fruta]
print(fsa)

#Sublist con frutas cuyo nombre sea menos o igual a cincoletras
fs4= [fruta for fruta in frutas if len(fruta)<=5]
print(fs4)