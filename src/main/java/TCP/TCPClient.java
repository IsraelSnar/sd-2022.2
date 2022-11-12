package TCP;

import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main(String args[]) {
        // arguments supply message and hostname
        Socket s = null;
        try {
            int serverPort = 7895;

            if (args.length >= 1) {
                s = new Socket(args[0], serverPort); // se o arquivo for executado no terminal, pega o IP do servidor como parametro
            } else {
                s = new Socket("localhost", serverPort); // se for executado em IDE deixa o valor fixo e vai
            }

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            if (args.length >= 2) {
                out.writeUTF(args[1]);
            } else {
                out.writeUTF("Nome: Israel\nCPF: 098\nIdade: 19");
            }
            String data = in.readUTF(); // read a line of data from the stream
            System.out.println("Received: " + data);
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {
                System.out.println("close:" + e.getMessage());
            }
        }
    }
}
