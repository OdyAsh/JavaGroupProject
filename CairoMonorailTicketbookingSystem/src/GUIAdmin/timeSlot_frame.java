/*
 *  Group 9
 *  Author: 
 */
package GUIGeneral;

import Transportation.Train;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class timeSlot_frame extends javax.swing.JFrame {

    /**
     * Creates new form tineSlot_frame
     */
    public String oldTimeSlot;
    public String newTimeSlot;
    ArrayList<Boolean> Boolean;

    /**
     *
     */
    public Train pa;
    public timeSlot_frame() {
        this.Boolean = new ArrayList<>();
        initComponents();
    }

    /**
     *
     * @param pa
     */
    public timeSlot_frame(Train pa) {
        this.Boolean = new ArrayList<>();
         this.pa=pa;
        initComponents();
    }
      public timeSlot_frame(String oldTimeSlot,String newTimeSlot,ArrayList<Boolean> timeSlot) {
        this.Boolean = new ArrayList<>();
          this.oldTimeSlot=oldTimeSlot;
          this.newTimeSlot=newTimeSlot;
           
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

        oldTime = new javax.swing.JTextField();
        newTime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Enter = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        oldTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldTimeActionPerformed(evt);
            }
        });

        jLabel1.setText("Old_timeSlot");

        jLabel2.setText("new_timeSlot");

        Enter.setText("Enter");
        Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newTime, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(oldTime)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Enter)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addComponent(Enter)
                .addGap(19, 19, 19)
                .addComponent(Back)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oldTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldTimeActionPerformed

    private void EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterActionPerformed
        // TODO add your handling code here:
        oldTimeSlot=oldTime.getText();
        newTimeSlot=newTime.getText();
         if(oldTime.getText().equals("")||newTime.getText().equals(""))
         {
               JOptionPane.showMessageDialog(this,"You can't leave this field empty!");
         }
         else
         {
             int oldtime=Integer.parseInt(oldTime.getText());
             int newtime=Integer.parseInt(newTime.getText());
               for (int i = 0 ; i <= 9; i++) {
             if(pa.getTakenSeats().get(oldtime).get(i)==true)
             {
                 JOptionPane.showMessageDialog(this,"the seat is already taken");
                 break;
             }
             else
             {
                 //final int snl=pa.getSEATNUMLIMIT();
                 
                pa.getTakenSeats().remove( oldtime);
                pa.getTakenSeats().put(newtime, Boolean );
            
                
                  JOptionPane.showMessageDialog(this,"the time slot has changed successfully");
             }
               }
         }
    }//GEN-LAST:event_EnterActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.toBack();
        Modify_frame newframe=new  Modify_frame();
        newframe.setVisible(true);
        newframe.toFront();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(timeSlot_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new timeSlot_frame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField newTime;
    private javax.swing.JTextField oldTime;
    // End of variables declaration//GEN-END:variables
}
