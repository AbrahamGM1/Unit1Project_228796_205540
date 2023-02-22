/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Entidades.Archivo;
import com.opencsv.CSVParser;
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
public class Negocio {
    Archivo archivo;
    final int SERVERPORT = 1000;
    byte[] buffer = new byte[1024];
    DatagramSocket udpSocket;
    String filePath="bmi_client.csv";
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
            File file = new File(filePath);
            
            byte[] bytes = Files.readAllBytes(file.toPath());         
            buffer = bytes;
            DatagramPacket question = new DatagramPacket(buffer,buffer.length,serverDirection,SERVERPORT);
            udpSocket.send(question);
            
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            udpSocket.receive(request);
            
            //File file =new File(filePath);
            
            //File.writeByteArrayToFile(file, request.getData());
            FileUtils.writeByteArrayToFile(new File(filePath), request.getData());
            file =new File(filePath);
            String [] sArray= new String[4];
            try {
            String s= FileUtils.readFileToString(file);
            sArray= s.split(",");
            
            }
            catch (IOException e) {
            e.printStackTrace();
            }
            for (int i = 0; i < sArray.length; i++) {
                System.out.println(sArray[i]);
            }
            Float altura =Float.parseFloat(sArray[0]);
            Float peso =Float.parseFloat(sArray[1]);
            Float bmi =Float.parseFloat(sArray[2]);
            String resultado=sArray[3];
            
            //Archivo archivo=new Archivo(altura,peso,20,resultado);
            
            //udpSocket.close();
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
        try(PrintWriter pw=new PrintWriter(filePath)){
            pw.write(message);
        }catch(FileNotFoundException e){
            System.out.println("Error creating/ writing to file");
        }
    }
     
}
