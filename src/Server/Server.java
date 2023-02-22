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
 * @author Hugo Rivera, Abraham Gómez
 */
public class Server {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        //Initialized variables
        final int PORT = 1000;
        byte[] buffer = new byte[4096];
        DatagramSocket udpSocket;
        Middle mid;
       
           try {
            
            System.out.println("Start");
            //Create a new UDP socket
            udpSocket = new DatagramSocket(PORT);
            String filePath="bmi_server.csv";
            mid=new Middle(udpSocket,filePath);
            DatagramPacket request = new DatagramPacket(buffer,buffer.length);
            
            while(true){
            System.out.println("Waiting information ....");
            
            //The socket receive the request
            udpSocket.receive(request);
            //Writes a byte array to a file creating the file if it does not exist.
            FileUtils.writeByteArrayToFile(new File(filePath), request.getData());
            //A new file is created with the given path
            File file =new File(filePath);
            //We create a new string using the file created as a base
            String s= FileUtils.readFileToString(file);
            //Array of strings made up of each of the elements of the file that are separated by the comma
            String []sArray= s.split(",");
            //Based on the order of the array elements, we store each of these in variables
            Float height =Float.parseFloat(sArray[0]);
            Float weight =Float.parseFloat(sArray[1]);
            Float bmi = weight/(height*height); 
            String result="";               
            //We make a new object with all the elements extracted from the file and then send it to the middleware
            //so that it can be sent to the client
            Data objectFile=new Data(height,weight,bmi,result);
            mid.sendToClient(objectFile,request);
            System.out.println(objectFile.toString());
            }
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        

    
    }
    
}

