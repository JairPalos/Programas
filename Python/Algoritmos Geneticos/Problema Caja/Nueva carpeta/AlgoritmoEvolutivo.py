"""
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO

Undad de Aprendizaje:

Autor: Dr.Asdrulbal López Chau

Descripcion: Mecanismo de Seleccion

Created: on Mon Feb 28 11:28:44 2022

@Autor: Jair Antonio Palos Hernandez
"""
import numpy as np
import random
from GenReal import GenReal
from Poblacion import Poblacion
from FitnessFunction import FitnessFunction
from Seleccion import Seleccion

class AlgoritmoEvolutivo:

    def __init__(self, size, target):#constructor de la clase
        self.sizeInd = target#longitud de la cadena a encontrar
        self.size = size#tamaño de poblacion
        self.pob = None#pob=null(vacio)
        self.target = target#target = a la cadena


    def showPob(self, showAptitude=False):#imprime la poblacion
        if showAptitude:
            aptitudes = [self.ff.evaluate(ind)
                     for ind in self.pob.poblacion]#calcula las aptitudes

        for i in range(self.size):#ciclo en el tamaño de la poblacion
            if showAptitude:#si es true
                print(self.pob.poblacion[i].__str__() +
                      "cercania -> " + str(aptitudes[i]))#imprime los individuos de la poblacion junto a su aptidtud
            else:#si es false
                print(self.pob.poblacion[i])#imprime solo los individuos de la poblacion

    def inicializa(self):#metodo para empezar el algoritmo evolutivo
        pob = Poblacion(self.target, self.size,self.k)#objeto de tipo poblacion se le manda la cadena a encontrar y la longitud
        pob.inicializa()#crea una poblacion
        self.pob = pob#guarda la poblacion
        self.seleccion = Seleccion()#crea un objeto de tipo seleccion
        self.ff = FitnessFunction(self.target,self.k)#crea un objeto de tipofitnessfunction se le manda la palabra a encontrar
        

    def evolucion(self):#metodo para evolucionar
        # 1) Evaluar individuos
        # 2) Seleccionar padres para cruza
        # 3) Generar hijos (cruza)
        # 4) Mutar a algunos
        # 5) Evaluar hijos
        # 6) Seleccionar miembros de la siguiente población
        ####### Implementación #############
        if self.pob is None:#si la poblacion esta vacia
            print("Inicialice la población")#imprime que aun no hay poblacion
            return
        #1) Evaluar individuos
        poblacion = self.pob.poblacion#se obtiene la poblacion del objeto pob
        aptitudes = [self.ff.evaluate(ind)
                     for ind in poblacion]#evalua cada individuo de la pobalacion
        # # 2) Seleccionar padres para cruza
        k1 = int(self.size/2)#divide el tamaño de la poblacion en 2 y lo convierte a entero
        if k1%2 == 1:#si el numero es impar
            k1 += 1#le suma 1
        idx = self.seleccion.selecciona(aptitudes,k1)#guarda k individuos seleccionados, se le mada las aptitudes y un numero k
        #3) Generar hijos (cruza)
        descendencia = []#arreglo vacio
        for i in list(range(0,k1-1,2)):#para cada 2 individuos
            ip = idx[i]#selecciona el indice padre
            im = idx[i+1]#selecciona el indice de la madre
            papa = poblacion[ip]#saca el cromosoma del indice
            mama = poblacion[im]#saca el cromosoma del indice
            hijos = papa.cruza(mama)#crea dos hijos nuevos cruzando el papa con la mama
            descendencia.append(hijos[0])#agrega a descendencia el primer hijo
            descendencia.append(hijos[1])#agrega a descendencia el segundo hijo

        # 4) Mutar a algunos (5%)
        totalMutar = int(np.ceil(len(descendencia)*0.1))#convierte a entero un numero redondeado del 1 porciento de la longitud de la descendencia

        for i in range(totalMutar):#en el tamañ de mutar
            idx = random.choice(range(len(descendencia)))#saca indice de aleatorio de la descendencia
            descendencia[idx].mutar()#muta el individuo del indice
        # 5) Evaluar hijos
        # 6) Seleccionar miembros de la siguiente
        #     población

        # Junto padres e hijos
        for hijo in descendencia:#en descendencia
            poblacion.append(hijo)#agrega a la poblacion un hijo
        # calculo aptitudes de todos
        aptitudes = [self.ff.evaluate(ind)
                     for ind in poblacion]#obtiene las aptitudes despues de evaluar a la poblacion
        # ELITISMO!!!!!
        idxMejor = np.argmax(aptitudes)#obtiene al individuo con la mejor aptitud
        #print(poblacion[idxMejor])
        #print(l)
        # El mejor pasa directamente a la siguiente población
        siguientePob = []#arreglo vacio
        siguientePob.append(poblacion[idxMejor])#agrega el indice con la mejor aptitud a la nueva poblacion
        # Selecciono indices de
        # individuos para la siguiente generacion
        idx = self.seleccion.selecciona(aptitudes,
                                  self.size)#selecciona size numero de  individuos de la poblacion
        # Creo la lista de individuos de la siguiente
        # generación

        for i in idx:#en indices
            siguientePob.append(poblacion[i])#creamos la nueva poblacion
        # Guardo para la siguiente evolución
        self.pob.poblacion = siguientePob#guardamos la nueva poblacion
        
    def elmejor(self):
        poblacion = self.pob.poblacion
        aptitudes = [self.ff.evaluate(ind)
        for ind in poblacion]
        idxMejor = np.argmax(aptitudes)
        print("El mejor:  ",self.pob.poblacion[idxMejor].__str__() +
                      " -> " + str(aptitudes[idxMejor]))