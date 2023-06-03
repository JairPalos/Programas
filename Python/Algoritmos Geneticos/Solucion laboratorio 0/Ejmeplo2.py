import numpy as np

intentos= input(" la contrasena correcta: ")
passw="icoag"
contador =0
i=0

for c1 in passw:
    if intentos[i] == c1:
        contador +=1
        for c2 in passw:
            if intentos[i] == c2:
                contador +=1
            for c3 in passw:
                if intentos[i] == c3:
                    contador +=1
                for c4 in passw:
                    if intentos[i] == c4:
                        contador +=1
                    for c5 in passw:
                        if intentos[i] == c5:
                            contador +=1

input(contador)
