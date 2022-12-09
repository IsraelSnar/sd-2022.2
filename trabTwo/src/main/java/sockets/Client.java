/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author israel
 */
public class Client {

    private final int port;

    /**
     * Configura porta do servidor remoto
     *
     * @param port
     */
    public Client(int port) {
        this.port = port;
    }

    /**
     * Para fazer backup
     *
     * @param arrAl Array de objetos
     * @param ipDns Ip ou DNS do servidor
     */
    public void enviar(ArrayList<Object> arrAl, String ipDns) {
        Socket s = null;
        try {
            int serverPort = this.port;

            s = new Socket(ipDns, serverPort); // se o arquivo for executado no terminal, pega o IP do servidor como parametro

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

//            System.out.println(arrAl.toString());
            out.writeObject(arrAl);

            out.close();
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

    /**
     * Envia para o servidor para fazer backup
     * O servidor é local, por isso não envia IP/DNS
     * @param arrAl Array de objetos
     */
    public void enviar(ArrayList<Object> arrAl) {
        
        this.enviar(arrAl, "localhost");
    }
}
