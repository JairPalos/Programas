import pytesseract as tess
from PIL import Image
import cv2
import numpy as np


class Color:
    def color(ruta):
        bgr=cv2.imread(ruta)
        b,g,r=cv2.split(bgr)
        total=b+g+r
        vals, counts = np.unique(total, return_counts=True)
        mode_value = vals[counts == np.max(counts)]
        h="".join(map(str, mode_value))
        #print(mode_value)
        h1=int(h)
        return  h1