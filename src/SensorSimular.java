import java.util.Random;

// Sensor de Temperatura
class Temperatura {
    public static int gerarValorSensor() {
        Random random = new Random();
        return random.nextInt(39); // Gera valores aleatórios entre 0 e 39
    }

    public static String verificarTemperatura(int temp) {
        if (temp <= 20) { 
            return "Temperatura: " + temp + "°C - Ambiente frio";
        } else if (temp >= 21 && temp <= 30) {
            return "Temperatura: " + temp + "°C - Ambiente agradável";
        } else {
            return "Temperatura: " + temp + "°C - Ambiente quente";
        }
    }
}

// Sensor de Luminosidade
class Luminosidade {

    public static int gerarValorLuz(){
            Random random = new Random();
                return random.nextInt(974);
            
        }
        public static String verificarLuminosidade(int ldrValor) {
            if (ldrValor < 500) {
                return "Luminosidade: " + ldrValor + " - Escurecendo - Ligando luz";
            } else {
                return "Luminosidade: " + ldrValor + " - Clareando o dia - Desligando luz";
            }
        }
    }
    
    // Sensor de Umidade
    class Umidade {

        public static int gerarValorUmidade(){
            Random random = new Random();
            return random.nextInt(900);
        }
        public static String verificarUmidade(int umidadeValor) {
            if (umidadeValor < 300) {
                return "Umidade: " + umidadeValor + " - Solo seco";
            } else if (umidadeValor >= 300 && umidadeValor < 700) {
                return "Umidade: " + umidadeValor + " - Solo moderado";
            } else {
                return "Umidade: " + umidadeValor + " - Solo úmido";
            }
        }
    }
    
    // Classe Principal para Exibir os Resultados
    public class SensorSimular {
        public static void main(String[] args) {

        // // Conecte-se ao Arduino (especifique a porta correta)
        // ArduinoConexao.conectarArduino("COM3");

        // // Enviar comando para o Arduino
        // ArduinoConexao.enviarDados("LER_SENSORES");

        // // Ler resposta do Arduino (simulando a leitura dos sensores)
        // String dadosLidos = ArduinoConexao.lerDados();
        // System.out.println("Dados recebidos do Arduino: " + dadosLidos);

        // // Fechar conexão
        // ArduinoConexao.desconectarArduino();

            // Gerar valores simulados dinamicamente
            int tempSensor = Temperatura.gerarValorSensor(); // Gera valor aleatório
            int ldrSensor = Luminosidade.gerarValorLuz(); // Simulado int ldrValor
        int umidadeSensor = Umidade.gerarValorUmidade(); // Simulado int umidadeValor

        // Verificar e exibir resultados na classe principal
        String resultadoTemperatura = Temperatura.verificarTemperatura(tempSensor);
        System.out.println(resultadoTemperatura);
        String resultadoLuminosidade = Luminosidade.verificarLuminosidade(ldrSensor);
        System.out.println(resultadoLuminosidade);
        String resultadoUmidade = Umidade.verificarUmidade(umidadeSensor);
        System.out.println(resultadoUmidade);
    }
}
