/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import Entidades.Data;
import Middleware.Middle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

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
        byte[] buffer = new byte[4096];
        DatagramSocket udpSocket;
        Middle mid;
        
           try {
            System.out.println("Start");
            udpSocket = new DatagramSocket(PORT);
            String filePath="bmi_server.csv";
            mid=new Middle(udpSocket,filePath);
            DatagramPacket request = new DatagramPacket(buffer,buffer.length);
            
            while(true){
            System.out.println("Waiting information ....");
            udpSocket.receive(request);
            FileUtils.writeByteArrayToFile(new File(filePath), request.getData());
            File file =new File(filePath);
            String s= FileUtils.readFileToString(file);
            String []sArray= s.split(",");
                
            Float altura =Float.parseFloat(sArray[0]);
            Float peso =Float.parseFloat(sArray[1]);
            Float bmi = peso/(altura*altura); 
            String resultado="";
                
            Data archivo=new Data(altura,peso,bmi,resultado);
            
            mid.sendToClient(archivo,request);
            System.out.println(archivo.toString());
            }
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        

    
    }
    
}

