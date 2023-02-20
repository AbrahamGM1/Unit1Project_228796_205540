/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spide
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GUI gui=new GUI();
        gui.setVisible(true);
        
//        final int SERVERPORT = 1000;
//        byte[] buffer = new byte[1024];
//        
//        
// 
//        
//        try {
//            
//            InetAddress serverDirection = InetAddress.getByName("localhost");
//            DatagramSocket udpSocket = new DatagramSocket();
//            String message = "Hello from the client!";
//            buffer = message.getBytes();
//            DatagramPacket question = new DatagramPacket(buffer,buffer.length,serverDirection,SERVERPORT);
//            udpSocket.send(question);
//            
//            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
//            udpSocket.receive(request);
//            
//            message = new String(request.getData());
//            System.out.println(message);
//            
//            udpSocket.close();
//            
//            
//        } catch (SocketException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
