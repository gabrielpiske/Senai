import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket socket = new DatagramSocket(9876); // Porta do servidor
            byte[] receiveData = new byte[1024];

            System.out.println("Servidor UDP esperando por dados...");

            while (true) {
                DatagramPacket receiPacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receiPacket);

                String mensagem = new String(receiPacket.getData(), 0, receiPacket.getLength());
                System.out.println("Mensagem recebida: " + mensagem);

                InetAddress clientAddress = receiPacket.getAddress();
                int clientPort = receiPacket.getPort();
                String resposta = "Mensagem recebida!";
                DatagramPacket sendPacket = new DatagramPacket(resposta.getBytes(), resposta.length(), clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
