from aa import aa
from Color import Color
from Objetos import Objetos
from Histograma import Histograma
import csv
with open ('Datos.csv','w',newline="") as csvfile:
    writer =csv.writer(csvfile)
    writer.writerow(['clase']+['area']+['color']+['objetos']+['Histograma'])
with open ('Datos.csv','a',newline="") as csvfile:
    for i in range(10):
        for j in range(16):
            ruta='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Proyecto/Billetes/'+str(i+1)+'/nueva'+str(j+1)+'.png'
            area=aa.are(ruta)
            co=Color.color(ruta)
            ob=Objetos.numero(ruta)
            hist=Histograma.histo(ruta)
            writer =csv.writer(csvfile)
            writer.writerow([i]+[area]+[co]+[ob]+[hist])
    