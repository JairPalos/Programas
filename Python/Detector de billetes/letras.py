import pytesseract
from PIL import Image, ImageFilter 

pytesseract.pytesseract.tesseract_cmd = r'C:/Program Files/Tesseract-OCR/tesseract.exe'

img = Image.open('nueva4.png')
image = img.convert("L") 
image2 = image.filter(ImageFilter.FIND_EDGES) 
image2.show()
text = pytesseract.image_to_string(image2, lang='eng')
print(text)