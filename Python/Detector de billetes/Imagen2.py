#Jair Antonio Palos Hernandez
#Jose Ferancisco Sandoval Rodriguez

import cv2
import numpy as np
import pytesseract as tsc
from PIL import Image
from tkinter import *
from skimage.transform import resize

cap=cv2.VideoCapture(0)
path='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/'
def getContornos(img, frame):
    contornos, hirarchy=cv2.findContours(img, cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_NONE)
    index=0
    for aux in contornos:
        area= cv2.contourArea(aux)
        ##print(area)
        if area > 500:
            cv2.drawContours(frame,aux,-1,(255,0,0),3)
            perimetro=cv2.arcLength(aux,True)
            aprrox = cv2.approxPolyDP(aux,0.02*perimetro,True)
            objContorno=len(aprrox)
            x,y,w,h =cv2.boundingRect(aprrox)
            print(objContorno)
            if(objContorno == 4):
                aspecto = w/float(h)
                if aspecto>0.95 and aspecto<1.05:
                    objectType="Cuadrado"
                else:
                    objectType="Billete"
                    cv2.imwrite(path+'ima'+'.png',frame)
            else:
                objectType="No identificado"
            
            cv2.rectangle(frame,(x,y),(x+w,y+h),(0,255,0),2)
            cv2.putText(frame,objectType,(x+(w//2)-10,y+(h//2)-10),cv2.FONT_HERSHEY_COMPLEX,0.7,(0,0,0),2)
def mostrar():
   ## imagen2 = PhotoImage(file='20.png')
    imagen2 = PhotoImage(file='ima.png')
    labelImagen2 = Label(miFrame, image = imagen2)
    labelImagen2.place(x=10, y=50)
    raiz.mainloop() 
    
def color():
    ##img1=cv2.imread('20.png') 
    img1=cv2.imread('ima.png') 
    img2=cv2.imread('veinte.png') 
    imahsv = cv2.cvtColor(img1, cv2.COLOR_BGR2HSV)
    morado_baja=np.array([100,50,50],np.uint8)
    morado_alta=np.array([160,255,255],np.uint8)
    mascara=cv2.inRange(imahsv,morado_baja,morado_alta)
    #cv2.imshow('Que es?',imahsv)
    #cv2.imshow('Mascara',mascara)
    res1 = resize(imahsv, (140, 54))
    res2 = resize(img2, (140, 54))
    resta=cv2.subtract(res1,res2)
    #print(resta[0,0])
    s=np.sum(resta)
    
    if(s<5000):
        print(s)
        print("Es un billete de 20")
        imagen = PhotoImage(file='20.png')
        cuadroDeTexto = Text(miFrame, height=20, width=62)
        cuadroDeTexto.place(x=680, y=350)
        labelImagen = Label(miFrame, image = imagen)
        labelImagen.place(x=680, y=50)
        texto20 = """\nEste billete es de 20 pesos mexicanos. Cuenta con una imagen de Benito Juárez García. Dicha imagen está acompañada de una viñeta compuesta por una balanza en primer plano, que simboliza el equilibrio y la justicia, y un libro que representa las Leyes de Reforma promulgadas en 1859.\n"""
        cuadroDeTexto.insert(END, texto20)
        cuadroDeTexto.config(state='disabled')
        raiz.mainloop() 

    elif (s>5000 and s<=9000):
        rosa_baja=np.array([140,50,50],np.uint8)
        rosa_alta=np.array([170,255,255],np.uint8)
        mascara3=cv2.inRange(imahsv,morado_baja,morado_alta)
        res1 = resize(imahsv, (140, 54))
        res2 = resize(img2, (140, 54))
        resta=cv2.subtract(res1,res2)
        s1=np.sum(resta)
        print(s1)
        if(s1<=9000):
            print("Es un billete de 50")
            cuadroDeTexto = Text(miFrame, height=20, width=62)
            cuadroDeTexto.place(x=680, y=350)
            imagen = PhotoImage(file='C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/50.png')
            labelImagen = Label(miFrame, image = imagen)
            labelImagen.place(x=680, y=50)

            texto50 = """\nEste billete es de 50 pesos mexicanos. Cuenta con una imagen de José María Morelos y Pavón. A la izquierda del retrato, se aprecia una viñeta formada por el estandarte de Morelos, dos cañones entrecruzados y el arco, la flecha y la palabra SUD, elementos, estos últimos, utilizados en las monedas acuñadas por el jefe insurgente. Finalmente, se pueden observar mariposas monarca, características del estado de Michoacán.\n"""
            cuadroDeTexto.insert(END, texto50)
            cuadroDeTexto.config(state='disabled')
            
            raiz.mainloop() 
    else:
        ama_baja=np.array([100,50,50],np.uint8)
        ama_alta=np.array([160,255,255],np.uint8)
        mascara3=cv2.inRange(imahsv,morado_baja,morado_alta)
        res1 = resize(imahsv, (140, 54))
        res2 = resize(img2, (140, 54))
        resta=cv2.subtract(res1,res2)
        print(resta[0,0])
        s2=np.sum(resta)
        print(s2)
        print("Es un billete de 100")
        cuadroDeTexto = Text(miFrame, height=20, width=62)
        cuadroDeTexto.place(x=680, y=350)
        imagen = PhotoImage(file='100.png')
        labelImagen = Label(miFrame, image = imagen)
        labelImagen.place(x=680, y=50)
        texto100 = """\nEste billete es de 100 pesos mexicanos. Cuenta con una imagen de Nezahualcóyotl. Esta está acompañada de una alegoría a los versos: "Amo el canto del zentzontle/pájaro de cuatrocientas voces…" que aparecen en el billete. Dicha alegoría está integrada por las representaciones de un zentzontle, cuatro símbolos de la palabra, una pieza de jade, una flor y dos hombres sentados.\n"""
        cuadroDeTexto.insert(END, texto100)
        cuadroDeTexto.config(state='disabled')

        raiz.mainloop() 
def escaner():
    ret,frame=cap.read()
    imgray=cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
    imgBlur=cv2.GaussianBlur(imgray,(7,7),1)
    imgCanny=cv2.Canny(imgBlur,50,50)
    getContornos(imgCanny,frame)
    cv2.imshow('Imagen 2',frame)


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

BotonAso=Button(raiz,text="Asociar", height = 3, width = 20, command=color)
BotonAso.place(x=450, y=600)

miFrame.pack()
raiz.mainloop() 



