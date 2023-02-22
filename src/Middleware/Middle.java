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
 * @author Hugo Rivera, Abraham Gómez
 */
public class Middle {
    
    //Initialized variables
    byte[] buffer = new byte[4096];
    DatagramPacket request;
    DatagramPacket question;
    DatagramSocket udpSocket;
    String filePath;
    
    /**
     * Constructor for the middleware
     * 
     * @param udpSocket - The socket to communicate with
     * @param filePath - the filepath that will be used for the cretion of the CSV
     */
    public Middle(DatagramSocket udpSocket,String filePath) {
        this.udpSocket=udpSocket;
        this.filePath=filePath;
    }
    
    /**
     * Method which is called by the client so that it can send it's information to the server,
     * converts the String formed by the object sent as a parameter into csv, to later 
     * convert them to bytes and send them to the server
     * 
     * @param fileObject - the object that will be converted to CSV
     */
    public void sendToServer(Data fileObject){
        try {
            InetAddress serverDirection = InetAddress.getByName("localhost");
            //Converts the String of the object to a CSV            
            String message = fileObject.toString();
            writeToCSVFile(message);
            File file = new File(filePath);
            //Read all of the bytes from the CSV file
            byte[] bytes = Files.readAllBytes(file.toPath());         
            buffer = bytes;
            
            //Sends to the client the bytes from the file
            question = new DatagramPacket(buffer,buffer.length,serverDirection,1000);
            udpSocket.send(question);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Method which is called by the server so that it can send it's information to the client,
     * converts the String formed by the object sent as a parameter into csv, to later 
     * convert them to bytes and send them to the client as a response 
     * 
     * @param fileObject - the object that will be converted to CSV
     * @param recived - the request sended by the server
     */
    public void sendToClient(Data fileObject,DatagramPacket recived){
        try {
            //Converts the String of the object to a CSV
            String message = fileObject.toString();
            writeToCSVFile(message);
            File file = new File(filePath);
            //Read all of the bytes from the CSV file
            byte[] bytes = Files.readAllBytes(file.toPath());         
            buffer = bytes;
            
            //Sends to the client the bytes from the file
            question = new DatagramPacket(buffer,buffer.length,recived.getAddress(),recived.getPort());
            udpSocket.send(question);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    /**
     * Method that takes care of write the string in a CSV file 
     * @param message - The message to convert
     */
    private void writeToCSVFile(String message) {
        //Write into the specified file the message received as a parameter
        try(PrintWriter pw=new PrintWriter(filePath)){
            pw.write(message);
        }catch(FileNotFoundException e){
            System.out.println("Error creating/ writing to file");
        }
    }
}
