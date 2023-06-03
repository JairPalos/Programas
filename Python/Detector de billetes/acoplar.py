import cv2
import imutils 
import os

directorio = "C:/Users/Jair Hernandez/Documents/Universidad/2022-B/Sistemas Expertos/Billete20"
try:
    os.mkdir(directorio)
except OSError:
    print("La creación del directorio %s falló" % directorio)
else:
    print("Se ha creado el directorio: %s " % directorio)

img = cv2.imread('20.png')
res = cv2.resize(img, dsize=(500, 300), interpolation=cv2.INTER_CUBIC)
cv2.imwrite(directorio+'nueva'+'.png',res)

def rotar45():
    Rotated_image = imutils.rotate(res, angle=45) 
    cv2.imwrite(directorio+'/nueva1.png',Rotated_image)
    pass

def rotar90():
    Rotated_image2 = imutils.rotate(res, angle=90) 
    cv2.imwrite(directorio+'/nueva2.png',Rotated_image2)
    pass

def rotar135():
    Rotated_image1 = imutils.rotate(res, angle=135) 
    cv2.imwrite(directorio+'/nueva3.png',Rotated_image1)
    pass

def rotar180():
    Rotated_image3 = imutils.rotate(res, angle=180) 
    cv2.imwrite(directorio+'/nueva4.png',Rotated_image3)
    pass

def rotar225():
    Rotated_image4 = imutils.rotate(res, angle=225) 
    cv2.imwrite(directorio+'/nueva5.png',Rotated_image4)
    pass

def rotar270():
    Rotated_image5 = imutils.rotate(res, angle=270) 
    cv2.imwrite(directorio+'/nueva6.png',Rotated_image5)
    pass
def rotar315():
    Rotated_image6 = imutils.rotate(res, angle=315) 
    cv2.imwrite(directorio+'/nueva7.png',Rotated_image6)
    pass
def rotar360():
    Rotated_image7 = imutils.rotate(res, angle=360) 
    cv2.imwrite(directorio+'/nueva8.png',Rotated_image7)
    pass

rotar45()
rotar90()
rotar135()
rotar180()
rotar225()
rotar270()
rotar315()
rotar360()