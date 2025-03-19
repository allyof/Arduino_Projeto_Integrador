// Sensor de Temperatura
class Temperatura {
    public static String verificarTemperatura(int valor) {
        float temp = (valor * (5.0f / 1023.0f) - 0.5f) * 100.0f; //valor pegado do arduino e convertido para Graus Celsios
        System.out.println("Temperatura: " + temp + "°C");

        if (temp <= 20) { //Mostra qual LED DO ARDUINO vai ser ligado
            return "LED7 ON, LED6 OFF, LED5 OFF";
        } else if (temp >= 21 && temp <= 30) {
            return "LED7 OFF, LED6 ON, LED5 OFF";
        } else {
            return "LED7 OFF, LED6 OFF, LED5 ON";
        }
    }
}

// Sensor de Luminosidade
class Luminosidade {
    public static String verificarLuminosidade(int ldrValor) {
        System.out.println("Luminosidade (LDR): " + ldrValor);

        if (ldrValor < 500) {
            return "LUZ ON";
        } else {
            return "LUZ OFF";
        }
    }
}

// Sensor de Umidade
class Umidade {
    public static String verificarUmidade(int umidadeValor) {
        System.out.println("Umidade: " + umidadeValor);

        if (umidadeValor < 300) { //Mostra qual LED DO ARDUINO vai ser ligado
            return "LED2 ON, LED3 OFF, LED4 OFF - Solo seco";
        } else if (umidadeValor >= 300 && umidadeValor < 700) {
            return "LED2 OFF, LED3 ON, LED4 OFF - Solo moderado";
        } else {
            return "LED2 OFF, LED3 OFF, LED4 ON - Solo úmido";
        }
    }
}

// Classe Principal para Exibir os Resultados
public class SensorSimulador {
    public static void main(String[] args) {
        // Valores simulados (substituir com leitura de sensores reais, se necessário)
        int tempSensor = 512; // Simulado
        int ldrSensor = 450; // Simulado
        int umidadeSensor = 650; // Simulado

        // Verificar e exibir resultados uma vez
        System.out.println(Temperatura.verificarTemperatura(tempSensor));
        System.out.println(Luminosidade.verificarLuminosidade(ldrSensor));
        System.out.println(Umidade.verificarUmidade(umidadeSensor));
    }
}
