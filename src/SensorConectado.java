import com.fazecast.jSerialComm.SerialPort;

public class SensorConectado { //Teste para conectar num arduino
    public static void main(String[] args) {
        // Localizar a porta serial conectada ao Arduino
        SerialPort portaSerial = SerialPort.getCommPort("COM3"); // Alterar para a porta correta
        portaSerial.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        portaSerial.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!portaSerial.openPort()) {
            System.out.println("Não foi possível abrir a porta serial.");
            return;
        }

        System.out.println("Conectado ao Arduino.");
        
        // Enviar comandos ou valores simulados para o Arduino
        try {
            int tempSensor = 512; // Valor simulado
            int ldrSensor = 450; // Valor simulado
            int umidadeSensor = 650; // Valor simulado

            // Enviar valores para o Arduino
            String comando = tempSensor + "," + ldrSensor + "," + umidadeSensor + "\n";
            portaSerial.getOutputStream().write(comando.getBytes());
            portaSerial.getOutputStream().flush();

            // Ler resposta do Arduino
            byte[] buffer = new byte[1024];
            int bytesLidos = portaSerial.getInputStream().read(buffer);
            String resposta = new String(buffer, 0, bytesLidos);

            System.out.println("Resposta do Arduino: " + resposta);

        } catch (Exception e) {
            System.err.println("Erro durante a comunicação: " + e.getMessage());
        } finally {
            portaSerial.closePort();
            System.out.println("Conexão encerrada.");
        }
    }
}
