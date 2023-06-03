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

class FitnessFuction:
    def __init__(self, target='holam'):
        self.target = target
    
    def evaluate (self, ind):
        '''
        Evalua la aptitud de un individuo
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
        intento= ind.cromosoma
        ctr=0
        for letraP,letraC in zip(self.target,intento):
            if letraP ==letraC:
                ctr = ctr + 1
        return ctr





