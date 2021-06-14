/*
 *  Group 9
 *  Author: Amro Sherif 201762
 */
package GUIPassenger;
import Person.*;
import Station.*;
import javax.swing.JOptionPane;

public class ModifyAccount extends javax.swing.JFrame {
    private Passenger currentPassenger;
    private int passengerIndex;
    
    public ModifyAccount(Passenger currentPassenger){
        initComponents();
        this.currentPassenger = currentPassenger;
        changeNamePanel.setVisible(false);
        changeUserNamePanel.setVisible(false);
        changePasswordPanel.setVisible(false);
        
        try{
            passengerIndex = Station.findUserName(currentPassenger.getUsername());
        }
        catch(Exception e){
            
        }
    }

    private ModifyAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        showOptionsPanel = new javax.swing.JPanel();
        Header1 = new javax.swing.JLabel();
        changeNameRButton = new javax.swing.JRadioButton();
        changeUserNameRButton = new javax.swing.JRadioButton();
        changePasswordRButton = new javax.swing.JRadioButton();
        continueButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        changeNamePanel = new javax.swing.JPanel();
        Header2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        showNameLabel = new javax.swing.JLabel();
        enterNewNameLabel = new javax.swing.JLabel();
        enterNewNameInput = new javax.swing.JTextField();
        submit1 = new javax.swing.JButton();
        changeUserNamePanel = new javax.swing.JPanel();
        Header3 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        showUserNameLabel = new javax.swing.JLabel();
        enterNewUserNameLabel = new javax.swing.JLabel();
        enterNewUserNameInput = new javax.swing.JTextField();
        submit2 = new javax.swing.JButton();
        changePasswordPanel = new javax.swing.JPanel();
        Header4 = new javax.swing.JLabel();
        enterNewPasswordLabel = new javax.swing.JLabel();
        submit3 = new javax.swing.JButton();
        enterNewPasswordInput = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Header1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Header1.setText("Cairo Monorail Ticket booking System");

        buttonGroup1.add(changeNameRButton);
        changeNameRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        changeNameRButton.setText("Change name");
        changeNameRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameRButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(changeUserNameRButton);
        changeUserNameRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        changeUserNameRButton.setText("Change username");
        changeUserNameRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserNameRButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(changePasswordRButton);
        changePasswordRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        changePasswordRButton.setText("Change password");

        continueButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        continueButton.setText("Continue");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        previousButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showOptionsPanelLayout = new javax.swing.GroupLayout(showOptionsPanel);
        showOptionsPanel.setLayout(showOptionsPanelLayout);
        showOptionsPanelLayout.setHorizontalGroup(
            showOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOptionsPanelLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(showOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showOptionsPanelLayout.createSequentialGroup()
                        .addComponent(Header1)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showOptionsPanelLayout.createSequentialGroup()
                        .addComponent(continueButton)
                        .addGap(18, 18, 18)
                        .addComponent(previousButton)
                        .addGap(239, 239, 239))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showOptionsPanelLayout.createSequentialGroup()
                        .addComponent(changeNameRButton)
                        .addGap(18, 18, 18)
                        .addComponent(changeUserNameRButton)
                        .addGap(18, 18, 18)
                        .addComponent(changePasswordRButton)
                        .addGap(108, 108, 108))))
        );
        showOptionsPanelLayout.setVerticalGroup(
            showOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showOptionsPanelLayout.createSequentialGroup()
                .addComponent(Header1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(showOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeNameRButton)
                    .addComponent(changeUserNameRButton)
                    .addComponent(changePasswordRButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(showOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continueButton)
                    .addComponent(previousButton))
                .addGap(60, 60, 60))
        );

        Header2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Header2.setText("Cairo Monorail Ticket booking System");

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nameLabel.setText("Name:");

        showNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        enterNewNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        enterNewNameLabel.setText("Enter new name");

        submit1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        submit1.setText("Submit");
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changeNamePanelLayout = new javax.swing.GroupLayout(changeNamePanel);
        changeNamePanel.setLayout(changeNamePanelLayout);
        changeNamePanelLayout.setHorizontalGroup(
            changeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeNamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(changeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(enterNewNameInput)
                    .addComponent(enterNewNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(265, 265, 265))
            .addGroup(changeNamePanelLayout.createSequentialGroup()
                .addGroup(changeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changeNamePanelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(changeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(changeNamePanelLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(216, 216, 216)
                                .addComponent(showNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Header2)))
                    .addGroup(changeNamePanelLayout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(submit1)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        changeNamePanelLayout.setVerticalGroup(
            changeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(changeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(showNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterNewNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterNewNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit1)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        Header3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Header3.setText("Cairo Monorail Ticket booking System");

        userNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        userNameLabel.setText("Username:");

        showUserNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        enterNewUserNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        enterNewUserNameLabel.setText("Enter new user name");

        submit2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        submit2.setText("Submit");
        submit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changeUserNamePanelLayout = new javax.swing.GroupLayout(changeUserNamePanel);
        changeUserNamePanel.setLayout(changeUserNamePanelLayout);
        changeUserNamePanelLayout.setHorizontalGroup(
            changeUserNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(changeUserNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                        .addComponent(userNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Header3))
                .addGap(131, 131, 131))
            .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(submit2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                .addGroup(changeUserNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(enterNewUserNameLabel))
                    .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(enterNewUserNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        changeUserNamePanelLayout.setVerticalGroup(
            changeUserNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeUserNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(changeUserNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLabel)
                    .addComponent(showUserNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterNewUserNameLabel)
                .addGap(5, 5, 5)
                .addComponent(enterNewUserNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit2)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        Header4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Header4.setText("Cairo Monorail Ticket booking System");

        enterNewPasswordLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        enterNewPasswordLabel.setText("Enter new user name");

        submit3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        submit3.setText("Submit");
        submit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changePasswordPanelLayout = new javax.swing.GroupLayout(changePasswordPanel);
        changePasswordPanel.setLayout(changePasswordPanelLayout);
        changePasswordPanelLayout.setHorizontalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordPanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(enterNewPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePasswordPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Header4)
                .addContainerGap())
            .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changePasswordPanelLayout.createSequentialGroup()
                    .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(changePasswordPanelLayout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(submit3))
                        .addGroup(changePasswordPanelLayout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(enterNewPasswordLabel)))
                    .addContainerGap(131, Short.MAX_VALUE)))
        );
        changePasswordPanelLayout.setVerticalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(enterNewPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changePasswordPanelLayout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(enterNewPasswordLabel)
                    .addGap(31, 31, 31)
                    .addComponent(submit3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(showOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(changeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(changeUserNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(changePasswordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(showOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(changeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(changeUserNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(changePasswordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeUserNameRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserNameRButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeUserNameRButtonActionPerformed

    private void changeNameRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameRButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeNameRButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        showOptionsPanel.setVisible(false);
        if(changeNameRButton.isSelected()){
            changeNamePanel.setVisible(true);
            showNameLabel.setText(currentPassenger.getName());
        }
        else if(changeUserNameRButton.isSelected()){
            changeUserNamePanel.setVisible(true);
            showUserNameLabel.setText(currentPassenger.getUsername());
        }
        else if(changePasswordRButton.isSelected()){
            changePasswordPanel.setVisible(true);
        }
    }//GEN-LAST:event_continueButtonActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        String newName = enterNewNameInput.getText();
        Station.getPassengersList().get(passengerIndex).setName(newName);
        
        try{
            Station.setPassengersList(Station.getPassengersList());
            JOptionPane.showMessageDialog(null, "The name has been updated successfully");
            changeNamePanel.setVisible(false);
            showOptionsPanel.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot access the file to retrieve the data");
        }
    }//GEN-LAST:event_submit1ActionPerformed

    private void submit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit2ActionPerformed

        String newUserName = enterNewUserNameInput.getText();
        
        try{
            int checkUserName = Station.findUserName(newUserName);

            if(checkUserName != -1){
                JOptionPane.showMessageDialog(null, "The username already exists");
            }
            else{
                Station.getPassengersList().get(passengerIndex).setUsername(newUserName);
                
                try{
                    Station.setPassengersList(Station.getPassengersList());
                    JOptionPane.showMessageDialog(null, "Your username has been updated successfully");
                    changeUserNamePanel.setVisible(false);
                    showOptionsPanel.setVisible(true);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Cannot access the file to retrieve the data");
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot access the file to retrieve the data");
        }
    }//GEN-LAST:event_submit2ActionPerformed

    private void submit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit3ActionPerformed
        char temp[] = enterNewPasswordInput.getPassword();
        String newPassword = new String(temp);
        
        Station.getPassengersList().get(passengerIndex).setPassword(newPassword);
        
        try{
            Station.setPassengersList(Station.getPassengersList());
            JOptionPane.showMessageDialog(null, "Your password has been updated successfully");
            changePasswordPanel.setVisible(false);
            showOptionsPanel.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot access the file to retrieve the data");
        }
    }//GEN-LAST:event_submit3ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ModifyAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Header1;
    private javax.swing.JLabel Header2;
    private javax.swing.JLabel Header3;
    private javax.swing.JLabel Header4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel changeNamePanel;
    private javax.swing.JRadioButton changeNameRButton;
    private javax.swing.JPanel changePasswordPanel;
    private javax.swing.JRadioButton changePasswordRButton;
    private javax.swing.JPanel changeUserNamePanel;
    private javax.swing.JRadioButton changeUserNameRButton;
    private javax.swing.JButton continueButton;
    private javax.swing.JTextField enterNewNameInput;
    private javax.swing.JLabel enterNewNameLabel;
    private javax.swing.JPasswordField enterNewPasswordInput;
    private javax.swing.JLabel enterNewPasswordLabel;
    private javax.swing.JTextField enterNewUserNameInput;
    private javax.swing.JLabel enterNewUserNameLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel showNameLabel;
    private javax.swing.JPanel showOptionsPanel;
    private javax.swing.JLabel showUserNameLabel;
    private javax.swing.JButton submit1;
    private javax.swing.JButton submit2;
    private javax.swing.JButton submit3;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
