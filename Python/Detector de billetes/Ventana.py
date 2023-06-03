import cv2
import numpy as np
import pytesseract as tsc
from PIL import Image, ImageTk
from tkinter import Tk,Button,Frame,Label,Text,PhotoImage,END
from aa import aa
from Color import Color
from Objetos import Objetos
from Histograma import Histograma
from KNN import KNN

from tkinter import filedialog
r=0
def escaner():
   archivo=filedialog.askopenfile(mode='r', filetypes=[('Archivos de imagen', '.png')])
   obj=[]
   print(archivo.name)
   area=aa.are(archivo.name)
   co=Color.color(archivo.name)
   ob=Objetos.numero(archivo.name)
   hist=Histograma.histo(archivo.name)
   obj.append(area)
   obj.append(co)
   obj.append(ob)
   obj.append(hist)
   print(obj)
   respuesta=KNN(obj)
   global r
   r=respuesta.clasifica()
   global ruta
   ruta=archivo.name

def asociar():
   if(r ==0):
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/20.png')
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto20 = """\nEste billete es de 20 pesos mexicanos. Cuenta con una imagen de Benito Juárez García. Dicha imagen está acompañada de una viñeta compuesta por una balanza en primer plano, que simboliza el equilibrio y la justicia, y un libro que representa las Leyes de Reforma promulgadas en 1859.\n"""
      cuadroDeTexto.insert(END, texto20)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==1):
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/20_4.png')
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto20 = """\nSe representa la consumación del proceso histórico de la Independencia de México.El motivo de la composición consiste en un fragmento de la obra artística referenciada con la cédula "Solemne y pacífica entrada del Ejército de las Tres Garantías a la Ciudad de México el día 27 de septiembre del memorable año de 1821” /1, de autor anónimo y que forma parte de la colección del Museo Nacional de Historia, Castillo de Chapultepec, localizado en la Ciudad de México. A su izquierda ondea la Bandera del Ejército de las Tres Garantías y, a la derecha, la Bandera de México..\n"""
      cuadroDeTexto.insert(END, texto20)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==2):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/50.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto50 = """\nSe representa el periodo histórico del México Antiguo. La viñeta o motivo principal de la composición consiste en un fragmento del dorso del monolito denominado "TEOCALLI DE LA GUERRA SAGRADA", que muestra un águila posada sobre un nopal con el “Atl tlachinolli”* en el pico.\n"""
      cuadroDeTexto.insert(END, texto50)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==3):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/50_3.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto50 = """\nEste billete es de 50 pesos mexicanos. Cuenta con una imagen de José María Morelos y Pavón. A la izquierda del retrato, se aprecia una viñeta formada por el estandarte de Morelos, dos cañones entrecruzados y el arco, la flecha y la palabra SUD, elementos, estos últimos, utilizados en las monedas acuñadas por el jefe insurgente. Finalmente, se pueden observar mariposas monarca, características del estado de Michoacán.\n"""
      cuadroDeTexto.insert(END, texto50)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==4):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/100.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto100 = """\nEste billete es de 100 pesos mexicanos. Cuenta con una imagen de Nezahualcóyotl. Esta está acompañada de una alegoría a los versos: "Amo el canto del zentzontle/pájaro de cuatrocientas voces…" que aparecen en el billete. Dicha alegoría está integrada por las representaciones de un zentzontle, cuatro símbolos de la palabra, una pieza de jade, una flor y dos hombres sentados.\n"""
      cuadroDeTexto.insert(END, texto100)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==5):

      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = Image.open('C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/100_3.png')
      res = imagen.resize((200, 200))
      img = ImageTk.PhotoImage(res)
      labelImagen2 = Label(miFrame, image = img)
      labelImagen2.place(x=680, y=50)
      texto100 = """\nSe representa el proceso histórico de la Colonia con Sor Juana Inés de la Cruz, la más importante poeta y escritora de la literatura novohispana. La efigie de Sor Juana Inés de la Cruz está acompañada por una viñeta en la que se representa un fragmento del patio principal del Antiguo Colegio de San Ildefonso, ubicado en el Centro Histórico de la Ciudad de México, recinto emblemático de la labor educativa durante la Nueva España..\n"""
      cuadroDeTexto.insert(END, texto100)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==6):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/200.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto100 = """\nSe representa el proceso histórico de la Independencia de México con Miguel Hidalgo y Costilla, quien el 16 de septiembre de 1810, lanzó el grito de Dolores iniciando la gesta independentista, por lo que es conocido como el “Padre de la Patria”, y José María Morelos y Pavón, quien continuó la lucha insurgente a la muerte de Hidalgo, y es conocido como el “Siervo de la Nación”.\n"""
      cuadroDeTexto.insert(END, texto100)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==7):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/200_1.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto100 = """\nComo motivo principal ostenta la efigie de la escritora Juana Inés de Asbaje y Ramírez de Santillana, mejor conocida como Sor Juana Inés de la Cruz. Su imagen está acompañada de una viñeta conformada por una composición de libros, un tintero, dos plumas y una ventana que hace referencia a la biblioteca o lugar de trabajo de Sor Juana y sus herramientas para escribir dentro del claustro donde pasó gran parte de su vida..\n"""
      cuadroDeTexto.insert(END, texto100)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==8):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/500_2.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto100 = """\nEl motivo principal es un autorretrato del muralista Diego Rivera, complementado con una viñeta compuesta por su obra de caballete titulada “DESNUDO CON ALCATRACES”, tres pinceles y una paleta, en representación de los instrumentos que utilizaba al crear sus obras de arte.\n"""
      cuadroDeTexto.insert(END, texto100)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 
   elif (r ==9):
      cuadroDeTexto = Text(miFrame, height=20, width=62)
      cuadroDeTexto.place(x=680, y=350)
      imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billetes/500.png')
      labelImagen = Label(miFrame, image = imagen)
      labelImagen.place(x=680, y=50)
      texto100 = """\nSe representa el proceso histórico de la Reforma y la restauración de la República con el Presidente Benito Juárez (1806-1872), quien expidió las Leyes de Reforma con apoyo de los liberales radicales. Por su defensa de las libertades humanas, que fue ejemplo para otros países latinoamericanos, fue proclamado Benemérito de las Américas..\n"""
      cuadroDeTexto.insert(END, texto100)
      cuadroDeTexto.config(state='disabled')
      raiz.mainloop() 


def mostrar():
    print(ruta)
    imagen = Image.open(ruta)
    res = imagen.resize((500, 300))
    img = ImageTk.PhotoImage(res)
    labelImagen2 = Label(miFrame, image = img)
    labelImagen2.place(x=40, y=100)
    raiz.mainloop() 

raiz=Tk()
raiz.geometry("1200x700")
raiz.title("Detección de imagenes")
raiz.resizable(False, False)
miFrame=Frame(raiz, width=1200,height=700)
miFrame.config(bg="#006699")

'''Textos'''

#texto200 = """\nEste billete es de 200 pesos mexicanos. Cuenta con una imagen de Juana Inés de Asbaje y Ramírez de Santillana. Su imagen está acompañada de una viñeta conformada por una composición de libros, un tintero, dos plumas y una ventana que hace referencia a la biblioteca o lugar de trabajo de Sor Juana y sus herramientas para escribir dentro del claustro donde pasó gran parte de su vida.\n"""
#cuadroDeTexto.insert(END, texto200)

'''Botones'''
BotonIniciar=Button(raiz,text="Escanear", height = 3, width = 20, command=escaner)
BotonIniciar.place(x=50, y=600)

BotonMos=Button(raiz,text="Mostrar", height = 3, width = 20, command=mostrar)
BotonMos.place(x=250, y=600)

BotonAso=Button(raiz,text="Asociar", height = 3, width = 20, command=asociar)
BotonAso.place(x=450, y=600)

miFrame.pack()
raiz.mainloop()