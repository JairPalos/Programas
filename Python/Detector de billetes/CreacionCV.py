import csv
import pandas as pd
from aa import aa
from Color import Color
from Objetos import Objetos
from Histograma import Histograma

array=[]
for i in range(10):
    for j in range(16):
        ruta='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Proyecto/Billetes/'+str(i+1)+'/nueva'+str(j+1)+'.png'
           # print(ruta)
        area=aa.are(ruta)
        co=Color.color(ruta)
        ob=Objetos.numero(ruta)
        hist=Histograma.histo(ruta)
        array.append(area)
        array.append(co)
        array.append(ob)
        array.append(hist)

caracteristicas=pd.DataFrame(array,columns=['clases','area','color','histograma'])
caracteristicas.to_csv('C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Proyecto/Datos.csv')