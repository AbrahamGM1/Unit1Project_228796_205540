/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import Entidades.Archivo;
import Middleware.Middle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
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
        byte[] buffer = new byte[1024];
        DatagramSocket udpSocket;
        Middle mid;
        
        try {
            System.out.println("Ready to recive");
            udpSocket = new DatagramSocket(PORT);
            String filePath="bmi_server.csv";
            mid=new Middle(udpSocket,filePath);
            Archivo archivo=mid.recive();
            mid.send(archivo);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        try {
//            System.out.println("Start");
//            DatagramSocket udpSocket = new DatagramSocket(PORT);
//            
//            DatagramPacket request = new DatagramPacket(buffer,buffer.length);
//            udpSocket.receive(request);
//            FileUtils.writeByteArrayToFile(new File("bmi_servidor.csv"), request.getData());
//            File file =new File("bmi_servidor.csv");
//            String [] sArray= new String[4];
//            try {
//            //String line = FileUtils.readLine(file, StandardCharsets.UTF_8);
//            String s= FileUtils.readFileToString(file);
//            sArray= s.split(",");
//
//            //sArray.forEach(System.out::println);
//            }
//            catch (IOException e) {
//            e.printStackTrace();
//            }
//            for (int i = 0; i < sArray.length; i++) {
//                System.out.println(sArray[i]);
//            }
//            Float altura =Float.parseFloat(sArray[0]);
//            Float peso =Float.parseFloat(sArray[1]);
//            Float bmi =Float.parseFloat(sArray[2]);
//            String resultado=sArray[3];
//            
//            Archivo archivo=new Archivo(altura,peso,20,resultado);
//            writeToCSVFile(archivo.toString());
//            
//            file =new File("bmi_servidor.csv");
//            byte[] bytes = Files.readAllBytes(file.toPath());
//            buffer=bytes;
//            int portClient = request.getPort();
//            InetAddress direction = request.getAddress();
//            
//            DatagramPacket response = new DatagramPacket(buffer, buffer.length,direction,portClient);
//            
//            udpSocket.send(response);
//            
//            
//            
//        } catch (SocketException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private static void writeToCSVFile(String message) {
//        try(PrintWriter pw=new PrintWriter("bmi_stats.csv")){
//            pw.write(message);
//        }catch(FileNotFoundException e){
//            System.out.println("Error creating/ writing to file");
//        }
//    }
    
    }
}