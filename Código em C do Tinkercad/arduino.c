#include <Arduino.h>
// c++

//Luminosidade
const int LUZ = 8;
//Temperatura
const int SENSOR_TEMP = 0;
const int LED7 = 7;
const int LED6 = 6;
const int LED5 = 5;
//Umidade
const int SENSOR_SOLO = 2;
const int LED4 = 4;
const int LED3 = 3;
const int LED2 = 2;
void setup() {
	Serial.begin(9600);
  	pinMode(LUZ, OUTPUT); //luminosidade
  	pinMode(LED7, OUTPUT); //temp
    pinMode(LED6, OUTPUT);// temp
    pinMode(LED5, OUTPUT); //temp
  	pinMode(LED4, OUTPUT); //umidade
    pinMode(LED3, OUTPUT); //umidade
    pinMode(LED2, OUTPUT); //umidade
}

void loop() {
	//Temperatura
  int val = analogRead(SENSOR_TEMP);
  	float temp = (val * (5.0/1023.0) -0.5)*100.0; //Calcular temperatura
 	
  if (temp<=20){
  	digitalWrite(LED7, HIGH);
 	digitalWrite(LED6, LOW);
 	digitalWrite(LED5, LOW);
  }else if (temp >=21 && temp <=30){
    digitalWrite(LED7, LOW);
 	digitalWrite(LED6, HIGH);
 	digitalWrite(LED5, LOW);
  }else{
    digitalWrite(LED7, LOW);
 	digitalWrite(LED6, LOW);
 	digitalWrite(LED5, HIGH);
  }
  
  
  	Serial.println(temp);
  	delay(300);

// Controle do LED de luminosidade  
  int LDR = analogRead(A1); //Posição do Led
  Serial.println(LDR);
  
  if(LDR<500)
    digitalWrite(LUZ,HIGH);
  else
    digitalWrite(LUZ,LOW);
  
  delay(500);
  
 //Umidade
  int umidade = analogRead(SENSOR_SOLO);
  Serial.println(umidade);
  
    if(umidade<300){ //Ligar para baixa umidade
    digitalWrite(LED2, HIGH);
 	digitalWrite(LED3, LOW);
 	digitalWrite(LED4, LOW);
    Serial.println("Solo seco");
  }else if (umidade >=300 && umidade <700){ //ligar para umidade moderada
    digitalWrite(LED2, LOW);
 	digitalWrite(LED3, HIGH);
 	digitalWrite(LED4, LOW);
    Serial.println("Solo moderado");
  }else{ //ligar para alta umidade
    digitalWrite(LED2, LOW);
 	digitalWrite(LED3, LOW);
 	digitalWrite(LED4, HIGH);
    Serial.println("Solo umido");
  }
  delay(500);
}

// link: https://www.tinkercad.com/things/1zEbztSx5vf/editel?sharecode=Ikx8dIcEkF9BDzyquOggBItcl1vbDxv9uZ7V0_I_tlo