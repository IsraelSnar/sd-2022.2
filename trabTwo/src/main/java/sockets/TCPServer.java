package sockets;

import java.net.*;
import java.io.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer {

    public static void main(String args[]) {

        try {
            System.out.println("Servidor iniciado");
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println(clientSocket.getInetAddress().getHostAddress());
                System.out.println("conexão estabelecida");
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }
}

class Connection extends Thread {

    ObjectInputStream in;
    ObjectOutputStream out;
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try { // an echo server
//            int i = in.readInt();
//            Object data;
            ArrayList<Object> arrAl = new ArrayList<>();
            
//            for (int j = 0; j <= i; j++){
               Object data = in.readObject(); // read a line of data from the stream
                arrAl = (ArrayList<Object>) data;
//            }
            
            System.out.println("Informações recebidas pelo socket: ");
            System.out.println(arrAl);
            this.writeFile(data);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                out.flush();
                out.reset();
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                // close failed 
            }
        }
    }
    
    public void writeFile(Object data) {
        // envia os dados de um conjunto (array) de Pessoas
        File fi;
        try {
            fi = new File("object.dat");
            
            if (!fi.exists()) fi.createNewFile();
            
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fi));
            
            objOut.writeObject(data);
            objOut.close();
            
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
