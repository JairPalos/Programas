import cv2
import numpy as np
from statistics import mode
 
class Histograma: 
    
    def histo(ruta):
        img = cv2.imread(ruta, cv2.IMREAD_GRAYSCALE)
        img = cv2.equalizeHist(img)
        suma= sum(img)
        total=len(img)
        promedio=max(suma/total)
        return  float(promedio)