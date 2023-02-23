/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Client;

import Entidades.Data;
import Middleware.Middle;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Hugo Rivera, Abraham Gómez
 */
public class Client extends javax.swing.JFrame {


    //Variables initialized
    Data fileObject;
    DatagramSocket udpSocket;
    String filePath="bmi_client.csv";
    public Client() {
        try {
            fileObject=new Data();
            udpSocket=new DatagramSocket();
            initComponents();
            init();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCalcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBMI = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCalcular.setText("Calculate BMI");
        btnCalcular.setToolTipText("");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel1.setText("Height (m)");

        jLabel2.setText("Weight(kg)");

        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        jLabel3.setText("BMI CALCULATOR");

        jLabel4.setText("Result:");

        txtResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultActionPerformed(evt);
            }
        });

        jLabel5.setText("BMI:");

        txtBMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBMIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtWeight, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHeight))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBMI)
                    .addComponent(txtResult))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(65, 65, 65)
                .addComponent(btnCalcular)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Components are initialized with default values
     */
    private void init(){
        txtHeight.setText("");
        txtWeight.setText("");
        txtResult.setText("");
        txtResult.setEnabled(false);
        txtBMI.setText("");
        txtBMI.setEnabled(false);
    }
    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResultActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        /**
         * assign to the object the values that the user enters from the interface 
         * and after that, send them to the middleware to later display the results obtained 
         * with the modified object.
         */
        fileObject.setHeight(Float.parseFloat(txtHeight.getText()));
        fileObject.setWeight(Float.parseFloat(txtWeight.getText()));
        Middle mid= new Middle(udpSocket,filePath);
        mid.sendToServer(fileObject);
        fileObject=receive();
        
        //Updates de interface with the data recived
        txtHeight.setText(String.valueOf(fileObject.getHeight()));
        txtWeight.setText(String.valueOf(fileObject.getWeight()));
        txtResult.setText(determineBMIResult(fileObject.getBmi()));
        txtBMI.setText(String.valueOf(fileObject.getBmi()));
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtBMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBMIActionPerformed

    /**
     * method that waits to receive a file from the server, once it receives it, 
     * it writes the byte array obtained from the server in the csv file, 
     * then it takes out each of the elements that make up the csv and forms with them a new object
     * 
     * @param args the command line arguments
     */
    private Data receive(){
        try {
                System.out.println("Waiting information ...");
                InetAddress serverDirection = InetAddress.getByName("localhost");
                byte[] buffer = new byte[4096];
                DatagramPacket request = new DatagramPacket(buffer,buffer.length,serverDirection,1000);
                udpSocket.receive(request);
                FileUtils.writeByteArrayToFile(new File(filePath), request.getData());
                File file =new File(filePath);
                String [] sArray= new String[4];
                String s= FileUtils.readFileToString(file);
                sArray= s.split(",");
                
                Float heigth =Float.parseFloat(sArray[0]);
                Float weigth =Float.parseFloat(sArray[1]);
                Float bmi =Float.parseFloat(sArray[2]);
                String result=sArray[3];
                
                Data data=new Data(heigth,weigth,bmi,result);
                
                return data;
                
            }
            catch (IOException ex) {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
    /**
     * Method that is responsible of determinate what is the result based on the BMI from the user
     * @param bmi - the BMI to determinate the result
     * @return A string with the result of the BMI
     */
    public String determineBMIResult(float bmi) {
        if (bmi < 18.5f) {
            return "Skinny";
        } else if (bmi >= 18.6f && bmi <= 24.9f) {
            return "Healthy";
        } else if (bmi >= 25f && bmi <= 29.9f) {
            return "Overweight";
        } else if (bmi > 30f) {
            return "Obese";
        }

        return null;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBMI;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtResult;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
