/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Entidades.Archivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo Rivera
 */
public class Negocio {
    Archivo archivo;
    final int SERVERPORT = 1000;
    byte[] buffer = new byte[1024];
    DatagramSocket udpSocket;
    public Negocio() {
        try {
            udpSocket=new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(Archivo archivo){
        try {
            InetAddress serverDirection = InetAddress.getByName("localhost");
            String message = archivo.toString();
            writeToCSVFile(message);
            buffer = message.getBytes();
            DatagramPacket question = new DatagramPacket(buffer,buffer.length,serverDirection,SERVERPORT);
            udpSocket.send(question);
            udpSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    private String bytesToString(byte[] datos){
//        
//        try {
//            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
//            udpSocket.receive(request);
//            String message = new String(request.getData());
//            System.out.println(message);
//            
//            udpSocket.close();
//            
//        } catch (SocketException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//    
//    private Archivo csvToObject(String csv){
//    
//    }
    
    private void writeToCSVFile(String message) {
        try(PrintWriter pw=new PrintWriter("bmiinformation.csv")){
            pw.write(message);
        }catch(FileNotFoundException e){
            System.out.println("Error creating/ writing to file");
        }
    }
     
}
