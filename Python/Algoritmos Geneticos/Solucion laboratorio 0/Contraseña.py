import numpy as np
intento=input("ingresa el intento: ")
def ayuda(intento):
    contrasena="icoag"
    contador =0
    i=0
    for letra in contrasena:
        if intento[i] ==letra:
            contador +=1  
            i+=1      
    return contador
input (ayuda(intento))


def adivina(intento):
    

    return