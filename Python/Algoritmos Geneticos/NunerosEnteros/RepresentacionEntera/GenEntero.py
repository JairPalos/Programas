#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
UNIVERSIDAD AUTÓNOMA DEL ESTADO DE MÉXICO
CU UAEM ZUMPANGO
UA: Algoritmos Genéticos
Tema:Gen Entero
Alumnos: Monserrath Rojas Osorio
         Jair Palos Hernandez
Profesor: Dr. Asdrúbal López Chau
Descripción:  Representación entera 


"""
import numpy as np
import random
class GenEntero:
    
    def __init__(self, mini, maxi):
        # Calcular el numero de bits necesarios
        max = np.max([np.abs(maxi), np.abs(mini)])        
        self.nbits = 1 + int(np.ceil(np.log(max)/np.log(2)))
        self.maxi = maxi
        self.mini = mini
        
    def initGen(self):
        # Inicializa el gen pseudoaletoriamente con 
        # ceros y unos
        #gen[0]-->signo
        #gen[1:]-->numero
            self.gen = random.choices([0, 1], 
                                      k=self.nbits)
            #mientras no sea valido el gen,genera otro pseudoaleatorio
            while not self.isValid():
                self.gen = random.choices([0, 1], 
                                          k=self.nbits)
            
    def isValid(self):
        #valida que el gen este dentro del rango mini y maxi
        value = self.getValue()
        if value >= self.mini and value <= self.maxi:
            return True
        else:
            return False            
    
    def getValue(self):
        #Regresa el valor entero que representa el gen
        value = int(''.join([str(i) for i 
                     in self.gen[1:]]), 2)
        #si el valor de signo es 1, lo regresa negativo
        if self.gen[0] == 1:
            value = -value
        
        return value
    def prevencionModulo(self):
        
        value = self.getValue()
        #si el valor esta fuera del rango maximo
        if value > self.maxi:
            #print("valor",value)
            #obtiene el modulo maximo--> valor%(max+1)
            modulomax = value%(self.maxi+1)
            #convierte el modulo maximo a binario
            value1 =format(modulomax,"b")
            #agrega ceros para coincidir con en numero de bits del gen
            value1=value1.zfill(self.nbits)
            #pasa el gen a lista de enteros
            value1=[int(i) for i in str(value1)]
            #print("binmax",modulomax)
            return value1
        #si el valor esta fuera del rango minimo
        if value < self.mini:
            #print("valor",value)
            #obtiene el modulo minimo --> valor%(min-1)
            modulomin = value%(self.mini-1)
            #convierte el modulo minimo a binario
            value2 = format(modulomin,"b")
            #agrega ceros para coincidir con en numero de bits del gen
            value2=value2.zfill(self.nbits)
            #convierte el gen a lista
            l=list(value2)
             # el valor de signo '-', regresa 1
            l[0]='1'
            #junta el valor modificado a la lista
            value2="".join(l)
            #pasa el gen a lista de enteros
            value2=[int(i) for i in str(value2)]
            #print("binmin",modulomin)
            return value2
        #print("valor",value)
        #print("max",self.maxi)
        #print("max+1",(self.maxi+1))
        #print("min",self.mini)
        #print("min-1",(self.mini-1))
    
    
    def cruzar(self, genMadre):
       #Aplica cruza de este gen con el gen de la madre
       padre = self.gen.copy()
       madre = genMadre.gen.copy()
       #cross point
       #divide el tamaño del indice devolviendolo como entero
       cp1 = int(np.ceil((self.nbits - 1)/3.))
       cp2 = 2 * cp1
       #realiza la cruza para el primer hijo
       #toma el signo del padre
       son1 = padre[0:cp1]
       #toma el primer crosspoint con genes de la madre
       son1.extend(madre[cp1:cp2])
       #toma el segundo crosspoint con genes del padre
       son1.extend(padre[cp2:])
       #realiza la cruza para el segundo hijo
       #toma el signo de la madre
       son2 = madre[0:cp1]
       #toma el primer crosspoint con genes del padre
       son2.extend(padre[cp1:cp2])
       #toma el segundo crosspoint con genes de la madre
       son2.extend(madre[cp2:])
       
       s1 = GenEntero(self.mini, self.maxi)
       s2 = GenEntero(self.mini, self.maxi)
       s1.gen = son1
       s2.gen = son2
       
       if s1.isValid():
           #print("hijo1",s1)
           s1.gen = son1
           #print(s1.getValue())
           
       # TODO: Prevenir hijos inválidos
       # (Método Preventivo o "más vale prevenir que
       # bautizar")
       # a) Por módulo
       else:
           s1.gen=s1.prevencionModulo()
           #print(s1.getValue())
           #print("hijo1prev",s1)
       if s2.isValid():
          # print("hijo2",s2)
           s2.gen = son2
           #print(s2.getValue())
       else:
           s2.gen=s2.prevencionModulo()
           #print(s2.getValue())
           #print("hijo2prev",s2)
       # b) Crear nuevo individuo (mutar)
       # c) crosspoint aleatorio
       # d) Otros
       return [s1, s2]
    
    
    def mutar(self):
        self.initGen()
        '''
        #indice del numero aleatorio a elegir
        idx = np.random.choice(self.nbits)
        #numero aleatorio que se va a cambiar 
        cambiar1=0
        cambiar2=1
        #Realiza el cambio de numero en el indice aleatorio
        #si en el indice aleatorio hay un 1, lo cambia a 0
        if self.gen[idx] == 1:
           self.gen[idx] = cambiar1
        #en caso contrario, es decir hay un 0, lo cambia a 1
        else:
            self.gen[idx] = cambiar2
        '''
       
    def __str__(self):
        # Regresa el gen como cadena de ceros y unos
        return str(self.gen)
        
        
        
        
        
        
        
        
        
        
        