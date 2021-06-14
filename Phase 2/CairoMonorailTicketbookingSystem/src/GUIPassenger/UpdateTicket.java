/*
 *  Group 9
 *  Author: Amro Sherif 201762
 */
package GUIPassenger;
import Person.*;
import javax.swing.JOptionPane;
import Station.*;
import UserDefinedExceptions.FindTrainException;

public class UpdateTicket extends javax.swing.JFrame {
    private Passenger currentPassenger;
    
    public UpdateTicket(Passenger currentPassenger) {
        initComponents();
        this.currentPassenger = currentPassenger;
        
        if(currentPassenger.getPassengerTickets().isEmpty()){
            JOptionPane.showMessageDialog(null, "You do not have any booked tickets");
            this.dispose();
            new HomePassenger(currentPassenger).setVisible(true);
        }
    }

    private UpdateTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Header1 = new javax.swing.JLabel();
        changeSeatNumberRButton = new javax.swing.JRadioButton();
        changeTimeSlotRButton = new javax.swing.JRadioButton();
        sourceInput = new javax.swing.JTextField();
        destinationInput = new javax.swing.JTextField();
        timeSlotInput = new javax.swing.JTextField();
        seatNumberInput = new javax.swing.JTextField();
        sourceLabel = new javax.swing.JLabel();
        destinationLabel = new javax.swing.JLabel();
        timeSlotLabel = new javax.swing.JLabel();
        seatNumberLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        showBookedTicketsButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Header1.setText("Cairo Monorail Ticket booking System");

        buttonGroup1.add(changeSeatNumberRButton);
        changeSeatNumberRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        changeSeatNumberRButton.setText("Change seat number");

        buttonGroup1.add(changeTimeSlotRButton);
        changeTimeSlotRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        changeTimeSlotRButton.setText("Change time slot");

        sourceLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        sourceLabel.setText("Source:");

        destinationLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        destinationLabel.setText("Destination:");

        timeSlotLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        timeSlotLabel.setText("Time slot:");

        seatNumberLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        seatNumberLabel.setText("Seat number:");

        submitButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        showBookedTicketsButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        showBookedTicketsButton.setText("Show booked tickets");
        showBookedTicketsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBookedTicketsButtonActionPerformed(evt);
            }
        });

        previousButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showBookedTicketsButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Header1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sourceLabel)
                                .addComponent(destinationLabel)
                                .addComponent(timeSlotLabel)
                                .addComponent(seatNumberLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sourceInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(destinationInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(timeSlotInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(seatNumberInput, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(changeSeatNumberRButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeTimeSlotRButton))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSlotInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeSlotLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeSeatNumberRButton)
                    .addComponent(changeTimeSlotRButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(showBookedTicketsButton)
                    .addComponent(previousButton))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String source = sourceInput.getText(), destination =  destinationInput.getText();
        int seatNumber = Integer.valueOf(seatNumberInput.getText()), timeSlot = Integer.valueOf(timeSlotInput.getText());
        
        if(changeSeatNumberRButton.isSelected()){        
            try{
                int trainIndex = currentPassenger.findTrain(source, destination, timeSlot);
                new ShowAndBookAvailableTickets(trainIndex, currentPassenger, timeSlot, 2, seatNumber).setVisible(true);
            }
            catch(FindTrainException e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        else{
            int newTimeSlot = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter the new time slot"));
            
            try{
               int trainIndex = currentPassenger.findTrain(source, destination, newTimeSlot);
            
                if(Station.getTrainsList().get(trainIndex).getTakenSeats().get(newTimeSlot).get(seatNumber - 1) == true){
                    JOptionPane.showMessageDialog(null, "the seat is taken");
                }
                else{
                    currentPassenger.updateTimeSlot(trainIndex, newTimeSlot, timeSlot, seatNumber);
                    
                    try{
                        Station.setTrainsList(Station.getTrainsList());
                        Station.setPassengersList(Station.getPassengersList());
                        JOptionPane.showMessageDialog(null, "The time slot has been updated successfully");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Cannot access the file to retrieve the data");
                    }
                }     
            }
            catch(FindTrainException e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void showBookedTicketsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBookedTicketsButtonActionPerformed
        new ShowPassengerBookedTickets(currentPassenger).setVisible(true);
    }//GEN-LAST:event_showBookedTicketsButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        new HomePassenger(currentPassenger).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_previousButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Header1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton changeSeatNumberRButton;
    private javax.swing.JRadioButton changeTimeSlotRButton;
    private javax.swing.JTextField destinationInput;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JButton previousButton;
    private javax.swing.JTextField seatNumberInput;
    private javax.swing.JLabel seatNumberLabel;
    private javax.swing.JButton showBookedTicketsButton;
    private javax.swing.JTextField sourceInput;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField timeSlotInput;
    private javax.swing.JLabel timeSlotLabel;
    // End of variables declaration//GEN-END:variables
}
