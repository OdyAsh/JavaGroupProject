/*
 *  Group 9
 *  Author: Abdo_203795
 */


package GUIGeneral;

/**
 *
 * @author abdo_203795
 */
import GUIAdmin.HomeAdmin;
import Person.*;
import Station.Station;
import Transportation.Route;
import Transportation.Train;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Admin_frame1 extends javax.swing.JFrame {
    
    /**
     * Creates new form Admin_frame1
     */
   
    public Admin pa;

    public String id;
    public Admin_frame1() 
    {
        initComponents();
    }
    public Admin_frame1(Admin pa) 
    {
        this.pa=pa;
        initComponents();
    }
    public Admin_frame1(String id) 
    {
        this.id=id;
        initComponents();
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup10 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ID_ser_text = new javax.swing.JTextField();
        Modify_Button = new javax.swing.JRadioButton();
        Delete_button = new javax.swing.JRadioButton();
        Enter_1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));

        buttonGroup10.add(Modify_Button);
        Modify_Button.setText("Modify train");
        Modify_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modify_ButtonActionPerformed(evt);
            }
        });

        buttonGroup10.add(Delete_button);
        Delete_button.setText("Delete train");
        Delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_buttonActionPerformed(evt);
            }
        });

        Enter_1.setText("Enter ");
        Enter_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enter_1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Please enter the Id");

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 130, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Modify_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_ser_text, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(Enter_1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(ID_ser_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Modify_Button)
                .addGap(38, 38, 38)
                .addComponent(Delete_button)
                .addGap(18, 18, 18)
                .addComponent(Enter_1)
                .addGap(27, 27, 27)
                .addComponent(back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Modify_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modify_ButtonActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_Modify_ButtonActionPerformed

    private void Enter_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enter_1ActionPerformed
        // TODO add your handling code here:
         id = ID_ser_text.getText();
        pa=new Admin("ahmed495@gmail.com","79933%345");
        
        if(ID_ser_text.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"You can't leave this field empty!");
         
        }
     
        else
        {
            int ID = Integer.parseInt(ID_ser_text.getText());
            int found=0;
             try {
                 found = pa.removeTrain(ID);
             } catch (Exception ex) {
                 Logger.getLogger(Admin_frame1.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       if(found != -1)
       {
            //Station.getTrainsList().remove(found);
            if (Modify_Button.isSelected())
            {
                Modify_frame M=new Modify_frame();
                M.setVisible(true);
                dispose();
            
            }
            else if(Delete_button.isSelected())
            {  
      
             
                try {
                    pa.removeTrain(found);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Admin_frame1.class.getName()).log(Level.SEVERE, null, ex
                    );
                }
                JOptionPane.showMessageDialog(this, "The train that has the id that you enterd has deleted");
                Admin_frame1 VIs=new Admin_frame1();
                VIs.setVisible(true);
                
            
          this.toBack(); 
          setVisible(false);
          new Modify_frame().toFront();
          new Modify_frame().setState(java.awt.Frame.NORMAL); 
        }
        }
       
       else
       {
            JOptionPane.showMessageDialog(this, "Sorry id that you enterd is not in the list");
       }
        }
        
    
    
        
    }//GEN-LAST:event_Enter_1ActionPerformed

    private void Delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_buttonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Delete_buttonActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
          this.toBack();
        HomeAdmin newframe=new  HomeAdmin();
        newframe.setVisible(true);
        newframe.toFront();
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
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
       
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        /* Create and display the form *y        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin_frame1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Delete_button;
    private javax.swing.JButton Enter_1;
    private javax.swing.JTextField ID_ser_text;
    private javax.swing.JRadioButton Modify_Button;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
