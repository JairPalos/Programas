#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
int inputPot1 = A1; // Pin de lectura Potenciometro 1 - Lineal
// Variables
int valuePort1 = 0; // Almacena posicion Potenciometro 1
int valuePort2 = 0; // Almacena posicion Potenciometro 2
int a=0;
int b=0;
float angulo=0;
unsigned long tiempoac;
unsigned long tiempoant=0;
unsigned long deltiempo;
int n=0;
// Definir constantes
#define ANCHO_PANTALLA 128 // ancho pantalla OLED
#define ALTO_PANTALLA 64 // alto pantalla OLED
// Objeto de la clase Adafruit_SSD1306
Adafruit_SSD1306 display(ANCHO_PANTALLA, ALTO_PANTALLA, &Wire, -1);
void setup(){
  Serial.begin(9600); // Configura e inicia comunicacion serie a 9600 Baudios
  if (display.begin(SSD1306_SWITCHCAPVCC, 0x3C))
    Serial.println("Pantalla OLED iniciada correctamente");
  else Serial.println("No se encuentra la pantalla OLED");
}
void loop(){
  
  // Lectura analogica y conversión a digital
  valuePort1 = analogRead(inputPot1);
  delay(500);
  while(true){
    valuePort2 = analogRead(inputPot1);
    a=(int)(valuePort1*.29);
    b=(int)(valuePort2*.29);
    if(a!=b){
      tiempoac=millis();
      Serial.println("Hay cambio"); 
      deltiempo=tiempoac-tiempoant;
      tiempoant=tiempoac;
      Serial.println("tiempo en segundos que tardo el cambio: ");
      // Limpiar buffer
    display.clearDisplay();
    // Tamaño del texto
    display.setTextSize(1);
    // Color del texto
    display.setTextColor(SSD1306_WHITE);
    // Escribir texto
    display.setCursor(0, 5); //Posicion del cursor
    display.print("val 1: ");
    display.print(a);
    display.setCursor(70, 5);
    display.print("val 2:");
    display.println(b);
    display.setCursor(40, 25);
    display.print("tiempo:");
    display.println(deltiempo);
    display.setCursor(0, 35);
    display.print("velocidad a/s:");
    if(a<b){
      angulo=b-a;
    }else{
      angulo=a-b;
    }
    display.println(angulo/(deltiempo*.001));
    Serial.println(angulo);
    
    display.setCursor(40, 45);
    // Enviar a pantalla
    display.display();
      delay(100);
      a=0;
      b=0;
      break;
    }else{
      Serial.println("No hay cambio"); 
      delay(100);
    }
  } 
}
