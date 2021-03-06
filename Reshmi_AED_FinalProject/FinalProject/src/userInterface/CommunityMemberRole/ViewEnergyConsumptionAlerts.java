/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.CommunityMemberRole;

import business.Enterprise.Enterprise;
import business.Organization.HouseholdOrg;
import business.Organization.Organization;
import business.Sensors.Sensor;
import business.UserAccount.UserAccount;
import business.WorkQueue.HighEnergyConsumptionWorkRequest;
import business.WorkQueue.HospitalWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reshmi
 */
public class ViewEnergyConsumptionAlerts extends javax.swing.JPanel {

    /**
     * Creates new form ViewEnergyConsumptionAlerts
     */
    private JPanel userProcessContainer;
    private HouseholdOrg houseOrg;
    private Enterprise enterprise;
    private UserAccount account;
    public ViewEnergyConsumptionAlerts(JPanel userProcessContainer,UserAccount account,Enterprise enterprise,Organization org) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.houseOrg = (HouseholdOrg)org;
        populateAlertsTable();
    }

     public void populateAlertsTable()
    {
        DefaultTableModel model = (DefaultTableModel)energyAlertsTable.getModel();
        model.setRowCount(0);
        for(WorkRequest request : account.getWorkQueue().getWorkRequestList())
        {
            if(request instanceof HighEnergyConsumptionWorkRequest){
            Object[] row = new Object[6];
            
            row[0] = request;
            row[1] = ((HighEnergyConsumptionWorkRequest)request).getEnergyConsumed();
            row[2] = request.getSender();
            
            row[3] = ((HighEnergyConsumptionWorkRequest)request).getComment();
            row[4] = request.getRequestDate();
            row[5] = request.getStatus();
            model.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        energyAlertsTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        responseTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sendResponseBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        energyAlertsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Appliance ", "Consumption", "Alert By", "Comments", "Sent On", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(energyAlertsTable);

        backJButton.setBackground(new java.awt.Color(51, 153, 0));
        backJButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/CommunityMemberRole/electrical_alert.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Response Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        responseTxt.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Response");

        sendResponseBtn.setBackground(new java.awt.Color(0, 153, 0));
        sendResponseBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        sendResponseBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendResponseBtn.setText("Send");
        sendResponseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendResponseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(sendResponseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 88, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(responseTxt)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(responseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sendResponseBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(backJButton)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void sendResponseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendResponseBtnActionPerformed
        int selectedRow = energyAlertsTable.getSelectedRow();
        if (selectedRow < 0)
        {
           JOptionPane.showMessageDialog(null, "Please select a row", "WARNING", JOptionPane.WARNING_MESSAGE);
           return; 
        }
        else
        {
            HighEnergyConsumptionWorkRequest request = (HighEnergyConsumptionWorkRequest)energyAlertsTable.getValueAt(selectedRow, 0);
            String response = responseTxt.getText();
            request.setResponse(response);
            request.setStatus("checked");
            populateAlertsTable();
        }
    }//GEN-LAST:event_sendResponseBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable energyAlertsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField responseTxt;
    private javax.swing.JButton sendResponseBtn;
    // End of variables declaration//GEN-END:variables
}
