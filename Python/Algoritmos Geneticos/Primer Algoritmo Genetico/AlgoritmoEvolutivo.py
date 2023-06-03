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
from Individuo import Individuo
from Poblacion import Poblacion
from FitnessFuction import FitnessFuction
from Seleccion import Seleccion 

class AlgoritmoEvolutivo:# Se crea la clase algoritmoevolutivo

    def __init__(self, size=100,target ="icoic"):# Se crea el constructor con el numero de la poblacion
        self.size = size# Se define el tamaño
        self.pob = None# Se define la poblacion
        self.target= target# Cromosoma
   
    def showPob (self,showAptitude =False):#muestra la poblacion
        if showAptitude:#si la aptitud es baja
            aptitudes=[self.ff.evaluate(ind)for ind in self.pob.poblacion]##se les da un un minimo de aprovacion
        for i in range (self.size):##el rango se determina atraves del tamaño
            if showAptitude:##Si son las ap
                print(self.pob.poblacion[i].__str__()+ " ->",str(aptitudes[i]))## Muestra  a los individuos
            else:## si no
                print(self.pob.poblacion)## muestra la poblacion


    def inicializa(self):## Se crea la inilializacion de los individuos
        pob=Poblacion(self.size)##Se crea el numero de los individuos depeniendo de la clase poblacion
        pob.inicializa()#llama ak metodo inicializa
        self.pob=pob##le pasa el valor a poblacion
        self.seleccion = Seleccion()##tomar el valor de la clase llamada seleccion
        self.ff=FitnessFuction(self.target)## toma el valor de la funcion llamada fitnessfuction

    def evolucion(self):##  Se crea la funcion evolucion
        #1)Evaluar  individuos
        #2)Seleccionar padres para cruza
        #3)Generar hijos(cruza)
        #4)Mutar a algunos
        #5)Evaluar hijos
        #6)Seleccionar miembros de la siguiente poblacion
        #######################################################
        if self.pob is None:## si la poblacion esta vacia
            print("Inicilalice la poblacion ")## impime
            return## regresa
        #############################################################
        #1)Evaluar individuos
    
        poblacion = self.pob.poblacion##se llama a la poblacion
        aptitudes = [self.ff.evaluate(ind)for ind in poblacion]##evalua a cada individuo en la poblacion
        
        #############################################################
        #2)Seleccionar padres para cruza
        
        k= int(self.size/2)## divide el tamaño de la poblacion en dos
        if k%2 == 1:##hace lo pares
            k +=1##incrementa el valor
        idx= self.seleccion.selecciona(aptitudes, k)##seleciona a traves en sus  aptitudes

        ###########################################################
        #3)Generar hijos(cruza)
        
        descendencia =[]##se crea un arreglo llamada descendencia
        for i in list (range (0, k-1, 2)) :##crea la lista de dos a partir de k
            ip =  idx[i]##se crea el arreglo  para el padre
            im = idx [i+1]## se crea el arreglo para la madre
            papa= poblacion[ip]##el padre lo toma de poblacion con ip
            mama= poblacion[im]##la madre los toma en la poblacion de im
            hijos = papa.cruzar(mama)##los hijos atravez de papa llama a cruzar con mama
            descendencia.append(hijos[0])## toma de hijos la cruza uno
            descendencia.append(hijos[1])##toma de hijos la cruza dos

        #############################################################
        #4)Mutar a algunos (%5)

        totalMutar=int (np.ceil(len(descendencia)*0.05))##
        for i in range (totalMutar):##
            idx = random.choices(range(len(descendencia)))##
            descendencia[idx].mutar()##

        #############################################################
        #5)Evaluar hijos / #6)Seleccionar miembros de la siguiente poblacion
        #Junto padres e hijos
        for hijo in descendencia:##
            poblacion.append(hijo)##
        #Calculo las aptitudes de todos
        aptitudes = [self.ff.evaluate(ind)for ind in poblacion]##
        #ELITISMO!!!!!!!!!!
        idxMejor = np.argmax(aptitudes)##
        #El mejor pasa directamente a ña siguiente poblacion
        siguientePob=[]##
        siguientePob.append(poblacion[idxMejor])##
        #Selecciona individuos  de individuos  para la siguiente generacion
        idx= self.seleccion.selecciona(aptitudes, self.size)##
        #Creo la lista de individuos de la siguiente genereacion
       
        for i in idx:##
            siguientePob.append(poblacion[i])##

        #Guardo para la siguiente generacion
        self.pob.poblacion = siguientePob##

