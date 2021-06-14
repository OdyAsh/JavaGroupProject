/*
 *  Group 9
 *  Author: Amro Sherif 201762
 */
package GUIPassenger;
import Person.*;

public class HomePassenger extends javax.swing.JFrame {
    private Passenger currentPassenger;
    
    public HomePassenger(Passenger currentPassenger) {
        initComponents();
        this.currentPassenger = currentPassenger;
        
        //Display the username, name and id respectively
        userNameOutput.setText(this.currentPassenger.getUsername());
        nameOutput.setText(this.currentPassenger.getName());
        Integer ID = this.currentPassenger.getId(); 
        IDOutput.setText(ID.toString());
    }

    private HomePassenger() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header1 = new javax.swing.JLabel();
        Header2 = new javax.swing.JLabel();
        BookTicket = new javax.swing.JButton();
        RemoveTicket = new javax.swing.JButton();
        UpdateTicket = new javax.swing.JButton();
        DisplayBookedTickets = new javax.swing.JButton();
        ModifyAccount = new javax.swing.JButton();
        Exist = new javax.swing.JButton();
        NameLable = new javax.swing.JLabel();
        IDLable = new javax.swing.JLabel();
        userNameLable = new javax.swing.JLabel();
        userNameOutput = new javax.swing.JTextField();
        nameOutput = new javax.swing.JTextField();
        IDOutput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PassengerMenu ");

        Header1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Header1.setText("Cairo Monorail Ticket booking System");

        Header2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Header2.setText("Please, choose one of the following options");

        BookTicket.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BookTicket.setText("Book ticket");
        BookTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookTicketActionPerformed(evt);
            }
        });

        RemoveTicket.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        RemoveTicket.setText("Remove ticket");
        RemoveTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveTicketActionPerformed(evt);
            }
        });

        UpdateTicket.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        UpdateTicket.setText("Update ticket");
        UpdateTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTicketActionPerformed(evt);
            }
        });

        DisplayBookedTickets.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DisplayBookedTickets.setText("Display booked tickets");
        DisplayBookedTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayBookedTicketsActionPerformed(evt);
            }
        });

        ModifyAccount.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ModifyAccount.setText("Modify Account");
        ModifyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyAccountActionPerformed(evt);
            }
        });

        Exist.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Exist.setText("Exit");
        Exist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExistActionPerformed(evt);
            }
        });

        NameLable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NameLable.setText("Name: ");

        IDLable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IDLable.setText("ID:");

        userNameLable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        userNameLable.setText("User Name: ");

        userNameOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameOutputActionPerformed(evt);
            }
        });

        nameOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(BookTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(DisplayBookedTickets)))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ModifyAccount)
                                    .addComponent(RemoveTicket))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UpdateTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Exist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userNameLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userNameOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NameLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDOutput))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(Header2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(Header1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLable)
                    .addComponent(IDLable)
                    .addComponent(userNameLable)
                    .addComponent(userNameOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Header1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Header2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveTicket)
                    .addComponent(BookTicket)
                    .addComponent(UpdateTicket))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisplayBookedTickets)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Exist)
                        .addComponent(ModifyAccount)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExistActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExistActionPerformed

    private void BookTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookTicketActionPerformed
        new BookTicket(currentPassenger).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookTicketActionPerformed

    private void RemoveTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveTicketActionPerformed
        new RemoveTicket(currentPassenger).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RemoveTicketActionPerformed

    private void UpdateTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTicketActionPerformed
        new UpdateTicket(currentPassenger).setVisible(true);
    }//GEN-LAST:event_UpdateTicketActionPerformed

    private void nameOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameOutputActionPerformed

    private void userNameOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameOutputActionPerformed
        
    }//GEN-LAST:event_userNameOutputActionPerformed

    private void DisplayBookedTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayBookedTicketsActionPerformed
        new ShowPassengerBookedTickets(currentPassenger).setVisible(true);
    }//GEN-LAST:event_DisplayBookedTicketsActionPerformed

    private void ModifyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyAccountActionPerformed
        new ModifyAccount(currentPassenger).setVisible(true);
    }//GEN-LAST:event_ModifyAccountActionPerformed

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
            java.util.logging.Logger.getLogger(HomePassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePassenger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookTicket;
    private javax.swing.JButton DisplayBookedTickets;
    private javax.swing.JButton Exist;
    private javax.swing.JLabel Header1;
    private javax.swing.JLabel Header2;
    private javax.swing.JLabel IDLable;
    private javax.swing.JTextField IDOutput;
    private javax.swing.JButton ModifyAccount;
    private javax.swing.JLabel NameLable;
    private javax.swing.JButton RemoveTicket;
    private javax.swing.JButton UpdateTicket;
    private javax.swing.JTextField nameOutput;
    private javax.swing.JLabel userNameLable;
    private javax.swing.JTextField userNameOutput;
    // End of variables declaration//GEN-END:variables
}
