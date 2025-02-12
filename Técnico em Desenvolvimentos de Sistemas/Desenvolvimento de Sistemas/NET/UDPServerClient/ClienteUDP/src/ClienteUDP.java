import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress servAddress = InetAddress.getByName("10.74.241.178");
            //InetAddress servAddress = InetAddress.getByName("localhost"); // endereço do servidor

            while (true) {
                Scanner ler = new Scanner(System.in);
                System.out.println("Entre com a mensagem: ");
                String mensagem = ler.nextLine();
                byte[] sendData = mensagem.getBytes();

                //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, servAddress, 9876);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, servAddress, 9000);
                socket.send(sendPacket); // envio ao servidor

                // recebe resposta
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String resposta = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Resposta do servidor: " + resposta);

                //socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
