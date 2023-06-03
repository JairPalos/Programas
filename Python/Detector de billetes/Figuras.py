import cv2


image=cv2.imread('nueva2.png')
dst = cv2.fastNlMeansDenoisingColored(image,None,10,10,7,21)
gray= cv2.cvtColor(dst,cv2.COLOR_BGR2GRAY)
canny=cv2.Canny(gray,10,100)
cv2.imshow('con',canny)
cv2.waitKey(0)
conts,_=cv2.findContours(canny,cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)
print(len(conts))
cv2.drawContours(image,conts,-1,(255,0,0),2)

for c in conts:
    epsilon=0.01*cv2.arcLength(c,True)
    aprox=cv2.approxPolyDP(c,epsilon,True)
    print(c)
    if (len(c) > 1):
        x,y,w,h=cv2.boundingRect(aprox)
        if len(aprox)==4:
            aspect_ratio= float(w)/h
            if aspect_ratio>1:
                
                cv2.putText(image,"Rectangulo",(x,y-5),1,1,(0,255,0),1)
            cv2.drawContours(image,[c],0,(255,0,0),2)
a=min(conts)
print("minimos:" + str(a))
cv2.imshow('con',image)
cv2.waitKey(0)
#print("area "+str(area))
    
