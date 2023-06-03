import cv2
import numpy as np
import imutils
class aa:
    def are(ruta):
        
        image=cv2.imread(ruta)
        dst = cv2.fastNlMeansDenoisingColored(image,None,10,10,7,21)
        gray= cv2.cvtColor(dst,cv2.COLOR_BGR2GRAY)
        canny=cv2.Canny(gray,150,300)
        kernel = np.ones((5,5),np.float32)/25
        dst = cv2.filter2D(gray,-1,kernel)
        cnts = cv2.findContours(canny, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        cnts = imutils.grab_contours(cnts)
        c=cnts[0]
        area=cv2.contourArea(c)
        area1= int(area)
        return area1
