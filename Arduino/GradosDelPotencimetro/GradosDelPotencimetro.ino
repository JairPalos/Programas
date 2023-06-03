const int sensorPin=A0;
float sensorValor=0;
float sensorValorGrados=0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  
}

void loop() {
  // put your main code here, to run repeatedly:
  sensorValor=analogRead(sensorPin);
  sensorValor=sensorValor*100/1023;

  sensorValorGrados=map(sensorValor,0,100,0,290);

 Serial.println("------------------------------");
 Serial.println("Porcentaje de Giros: ");
 Serial.println(sensorValor);
 Serial.println("%");
 Serial.println("------------------------------");
 Serial.println("Porcentaje de Grados: ");
 Serial.println(sensorValorGrados);
 Serial.println("*");
 Serial.println("------------------------------");
 delay(100);
}
