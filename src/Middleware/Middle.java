/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Middleware;

import Client.Negocio;
import Entidades.Archivo;
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
    byte[] buffer = new byte[1024];
    DatagramSocket udpSocket;
    String filePath;
    public Middle(DatagramSocket udpSocket,String filePath) {
        this.udpSocket=udpSocket;
        this.filePath=filePath;
    }
    public void send(Archivo archivo){
        try {
            InetAddress serverDirection = InetAddress.getByName("localhost");
            String message = archivo.toString();
            writeToCSVFile(message);
            File file = new File(filePath);
            
            byte[] bytes = Files.readAllBytes(file.toPath());         
            buffer = bytes;
            DatagramPacket question = new DatagramPacket(buffer,buffer.length,serverDirection,udpSocket.getPort());
            udpSocket.send(question);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Archivo recive(){
            try {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                udpSocket.receive(request);
                FileUtils.writeByteArrayToFile(new File(filePath), request.getData());
                File file =new File(filePath);
                String [] sArray= new String[4];
                String s= FileUtils.readFileToString(file);
                sArray= s.split(",");
                for (int i = 0; i < sArray.length; i++) {
                    System.out.println(sArray[i]);
                }
                Float altura =Float.parseFloat(sArray[0]);
                Float peso =Float.parseFloat(sArray[1]);
                Float bmi =Float.parseFloat(sArray[2]);
                String resultado=sArray[3];
                
                Archivo archivo=new Archivo(altura,peso,bmi,resultado);
                
                return archivo;
                
            }
            catch (IOException ex) {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
            }
           return null; 
    }

    
    private void writeToCSVFile(String message) {
        try(PrintWriter pw=new PrintWriter(filePath)){
            pw.write(message);
        }catch(FileNotFoundException e){
            System.out.println("Error creating/ writing to file");
        }
    }
}
