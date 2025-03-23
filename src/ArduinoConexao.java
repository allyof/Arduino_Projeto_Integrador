import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoConexao {
    private static SerialPort portaSerial;

    public static void conectarArduino(String porta) {
        // Configura a porta para conexão (substitua "COM3" pela porta correta do Arduino)
        portaSerial = SerialPort.getCommPort(porta); 
        portaSerial.setBaudRate(9600); // Taxa de transmissão definida no sketch do Arduino
        portaSerial.setNumDataBits(8);
        portaSerial.setNumStopBits(SerialPort.ONE_STOP_BIT);
        portaSerial.setParity(SerialPort.NO_PARITY);

        // Abrir porta
        if (portaSerial.openPort()) {
            System.out.println("Conectado ao Arduino com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao Arduino.");
        }
    }

    public static void enviarDados(String dado) {
        if (portaSerial != null && portaSerial.isOpen()) {
            // Envia os dados para o Arduino
            portaSerial.getOutputStream().write(dado.getBytes(), 0, dado.length());
            System.out.println("Dados enviados: " + dado);
        } else {
            System.out.println("Porta serial não está aberta.");
        }
    }

    public static String lerDados() {
        if (portaSerial != null && portaSerial.isOpen()) {
            Scanner scanner = new Scanner(portaSerial.getInputStream());
            if (scanner.hasNextLine()) {
                String dado = scanner.nextLine();
                return dado;
            }
        }
        return "Nenhum dado lido.";
    }

    public static void desconectarArduino() {
        if (portaSerial != null && portaSerial.isOpen()) {
            portaSerial.closePort();
            System.out.println("Desconectado do Arduino.");
        }
    }
}
