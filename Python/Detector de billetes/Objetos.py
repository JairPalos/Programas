import cv2

class Objetos:

    def  numero(ruta):
        axu=0
        image=cv2.imread(ruta)
        dst = cv2.fastNlMeansDenoisingColored(image,None,10,10,7,21)
        gray= cv2.cvtColor(dst,cv2.COLOR_BGR2GRAY)
        canny=cv2.Canny(gray,150,400)
        #cv2.imshow('i',canny)
        #cv2.imwrite('G1.png',canny)
        #cv2.waitKey(0)
        conts,_=cv2.findContours(canny,cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)
        #print(len(conts))
        cv2.drawContours(image,conts,-1,(255,0,0),2)
        for c in conts:
           pass
        return len(c)
