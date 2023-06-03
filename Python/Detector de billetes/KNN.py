import numpy as np
import pandas as pd
from math import sqrt 
from statistics import mode
class KNN:
    def __init__(self,dato=None):
        self.dato=dato

    def clasifica(self):
       
        euclidiana=[]
        csv=pd.read_csv('C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Proyecto/Datos.csv')
        clase=csv["clase"]
        rasgos=csv[['area','color','objetos','Histograma']]

        for rasgo in rasgos.index:##ailoc
           euclidiana.append((clase[rasgo],sqrt((int(self.dato[0])-int(rasgos['area'][rasgo]))**2+(int(self.dato[1])-int(rasgos['color'][rasgo]))**2
           +(int(self.dato[2])-int(rasgos['objetos'][rasgo]))**2+(float(self.dato[3])-float(rasgos['Histograma'][rasgo]))**2)))
       
        euclidiana=sorted(euclidiana,key=lambda dist: dist[1])
        vecinos=euclidiana[:160]
        nuevaclase=[]

        for i in vecinos:
          nuevaclase.append(i[0])
        
        moda=mode(nuevaclase)
        
        
        
        return moda
