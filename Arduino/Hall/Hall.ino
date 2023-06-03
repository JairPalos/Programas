#include <Wire.h>      // libreria para bus I2C
#include <Adafruit_GFX.h>   // libreria para pantallas graficas
#include <Adafruit_SSD1306.h>   // libreria para controlador SSD1306
 
#define ANCHO 128     // reemplaza ocurrencia de ANCHO por 128
#define ALTO 64       // reemplaza ocurrencia de ALTO por 64

#define OLED_RESET -1      // necesario por la libreria pero no usado
Adafruit_SSD1306 oled(ANCHO, ALTO, &Wire, OLED_RESET);  // crea objeto

const int retardo=1000; //Retardo que se hace entre cada calculo de velocidad angular (1 segundo)
const int n=2; //Numero de imanes en el disco
const int ledA=13; //LED que indica el estado del sensor
int sensor=0; //Aqui se almacena el estado del sensor
long int cont=0; //Se almacena el numero de veces que se ha pasado por una ranura
long int cont2=0; //Con este contador se calcula la velocidad angular
int  vu, rpm, rpm2;

void setup(){
  Wire.begin(9600); //Se inicia la comunicacion serial
  oled.begin(SSD1306_SWITCHCAPVCC, 0x3C); // inicializa pantalla con direccion 0x3C
  
  pinMode(2, INPUT); //El pin 2 se configura como entrada
  pinMode(ledA, OUTPUT);
  attachInterrupt(0, sensorA, CHANGE); //Se habilita la interrupcion externa 0 que esta en el pin 2 del Arduino Uno
   //cada que haya una interrupcion se llevara a   cabo la funcion sensorA()
}
void loop(){
  vu= cont/n;
  rpm=cont2*60000/(n*retardo); 
  rpm2=rpm/60;

  oled.clearDisplay();      // limpia pantalla
  oled.setTextColor(WHITE);   // establece color al unico disponible (pantalla monocromo)
  oled.setCursor(0, 0);     // ubica cursor en inicio de coordenadas 0,0
  oled.setTextSize(1.5);      // establece tamano de texto en 1
  oled.println("Vueltas totales ");  // escribe en pantalla el texto
  oled.println(vu);
  oled.println("Velocidad en RPM ");   
  oled.println(rpm);
  oled.println("Frecuencia: ");   
  oled.println(rpm2);      // escribe texto
  // escribe texto
  oled.display();     // muestra en pantalla todo lo establecido anteriormente
  
  Serial.print("Vueltas totales=");
  Serial.println(cont/n); //Se imprime en el monitor serial el numero de vueltas completas que ha dado
  Serial.print("Velocidad en RPM=");
  Serial.println(cont2*60000/(n*retardo)); //Se imprime la velocidad angular en RPM
  Serial.println();
  cont2=0; //Este contador se reinicia para calcular la siguiente velocidad angular
  delay(retardo); //Retardo entre cada calculo e impresion de resultados
}
//Funcion llamada cada que el pin 2 tiene algun cambio en su estado
void sensorA(){
  sensor=digitalRead(2); // Se lee el pin 2
  if (sensor ==1){ //Hubo un flanco de subida
    digitalWrite(ledA,HIGH); //El LED del pin 13 se enciende
    cont=cont+1; //Los contadores incrementan en uno
    cont2=cont2+1;
  }
  else //Hubo un flanco de bajada
    digitalWrite(ledA,LOW); //El LED del pin 13 se apaga
}
