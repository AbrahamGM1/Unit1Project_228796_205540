/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spide
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int PORT = 1000;
        byte[] buffer = new byte[1024];
        
        try {
            System.out.println("Start");
            DatagramSocket udpSocket = new DatagramSocket(PORT);
            
            DatagramPacket request = new DatagramPacket(buffer,buffer.length);
            udpSocket.receive(request);
            
            String s = new String(request.getData());
            System.out.println(s);
            
            int portClient = request.getPort();
            InetAddress direction = request.getAddress();
            
            
            s = "Hello from the server!!";
            buffer = s.getBytes();
            
            
            DatagramPacket response = new DatagramPacket(buffer, buffer.length,direction,portClient);
            
            udpSocket.send(response);
            
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
