/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Middleware;


import Entidades.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Hugo Rivera
 */
public class Middle {
    byte[] buffer = new byte[4096];
    DatagramPacket request;
    DatagramPacket question;
    DatagramSocket udpSocket;
    String filePath;
    
    public Middle(DatagramSocket udpSocket,String filePath) {
        this.udpSocket=udpSocket;
        this.filePath=filePath;
    }
    public void sendToServer(Data archivo){
        try {
            InetAddress serverDirection = InetAddress.getByName("localhost");
            String message = archivo.toString();
            writeToCSVFile(message);
            File file = new File(filePath);
            
            byte[] bytes = Files.readAllBytes(file.toPath());         
            buffer = bytes;
            
            
            question = new DatagramPacket(buffer,buffer.length,serverDirection,1000);
            udpSocket.send(question);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendToClient(Data archivo,DatagramPacket recived){
        try {
            //InetAddress serverDirection = InetAddress.getByName("localhost");
            String message = archivo.toString();
            writeToCSVFile(message);
            File file = new File(filePath);
            
            byte[] bytes = Files.readAllBytes(file.toPath());         
            buffer = bytes;
            
            
            question = new DatagramPacket(buffer,buffer.length,recived.getAddress(),recived.getPort());
            udpSocket.send(question);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    

    
    private void writeToCSVFile(String message) {
        try(PrintWriter pw=new PrintWriter(filePath)){
            pw.write(message);
        }catch(FileNotFoundException e){
            System.out.println("Error creating/ writing to file");
        }
    }
}
