/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NeighborhoodAdmin;

import business.EcoDistrict;
import business.Enterprise.CommunityEnterprise;
import business.Enterprise.Enterprise;
import business.Neighborhood.Neighborhood;
import business.Organization.EnergyResourceOrg;
import business.Organization.Organization;
import business.Organization.PollutionBoardOrg;
import business.UserAccount.UserAccount;
import business.WorkQueue.AreaAdmintoEnergyAdminRequest;
import business.WorkQueue.PollutionWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reshmi
 */
public class ManageAreaAlertsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAreaAlertsJPanel
     */
     private JPanel userProcessContainer;
    private EcoDistrict ecoDistrict;
    private Neighborhood neighborhood;
    private UserAccount account;
    private UserAccount userAcc;
    private Enterprise enterprise;
    private PollutionBoardOrg pollutionBoardOrg;
    public ManageAreaAlertsJPanel(JPanel userProcessContainer, EcoDistrict ecoDistrict, Neighborhood neighborhood, UserAccount account,
                                    PollutionBoardOrg pollutionBoardOrg) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoDistrict = ecoDistrict;
        this.neighborhood = neighborhood;
        this.account = account;
        this.pollutionBoardOrg = pollutionBoardOrg;
        populateAlertsTable(); 
        populateAreaToEnergyAdminAlerts();
    }


    public void populateAlertsTable()
    {
        DefaultTableModel model = (DefaultTableModel)alertsTable.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : account.getWorkQueue().getWorkRequestList())
        {
            if(request instanceof PollutionWorkRequest){
                Object[] row = new Object[6];
                row[0] = request;
                row[1] = request.getSender();
                row[2] = request.getRequestDate();
                row[3] = request.getStatus();
                row[4] = ((PollutionWorkRequest)request).getComment();
                row[5] = ((PollutionWorkRequest)request).getResponse();
                
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
        alertsTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        responseBtn = new javax.swing.JButton();
        responseTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        aleryEnergyOrgBtn = new javax.swing.JButton();
        alertMsgTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        energyAdminAlertTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        alertsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Area", "Sent By", "Alert Sent On", "Status", "Notification Message", "Response Text"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(alertsTable);

        backJButton.setBackground(new java.awt.Color(0, 153, 0));
        backJButton.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/NeighborhoodAdmin/air_alert.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        responseBtn.setBackground(new java.awt.Color(0, 153, 0));
        responseBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        responseBtn.setForeground(new java.awt.Color(255, 255, 255));
        responseBtn.setText("Send");
        responseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responseBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Response Message");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(responseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(responseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(responseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(responseBtn)
                .addContainerGap())
        );

        aleryEnergyOrgBtn.setBackground(new java.awt.Color(0, 153, 0));
        aleryEnergyOrgBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        aleryEnergyOrgBtn.setForeground(new java.awt.Color(255, 255, 255));
        aleryEnergyOrgBtn.setText("Alert Energy Board Admin");
        aleryEnergyOrgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aleryEnergyOrgBtnActionPerformed(evt);
            }
        });

        energyAdminAlertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Area", "Organization Admin", "Sent By", "Sent On", "Alert Message", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(energyAdminAlertTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)))
                        .addGap(15, 15, 15)))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(aleryEnergyOrgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alertMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aleryEnergyOrgBtn)
                    .addComponent(alertMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(backJButton)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void responseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responseBtnActionPerformed
        int selectedRow = alertsTable.getSelectedRow();
        if(selectedRow>=0){
            PollutionWorkRequest request = (PollutionWorkRequest)alertsTable.getValueAt(selectedRow, 0);
            if(request.getStatus().equals("sent to area admin")){
                if(!responseTxt.getText().trim().isEmpty()){
            String response = responseTxt.getText();
            request.setResponse(response);
            request.setStatus("checked");
            populateAlertsTable();
                }else{
                    JOptionPane.showMessageDialog(null, "Kindly enter a message", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Response message is sent already","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row", "WARNING", JOptionPane.WARNING_MESSAGE);
            return; 
        }
    }//GEN-LAST:event_responseBtnActionPerformed

    private void aleryEnergyOrgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aleryEnergyOrgBtnActionPerformed
    if(alertMsgTxt.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Kindly enter an alert message", "Alert Message", JOptionPane.ERROR_MESSAGE);
    }else{
        for(Enterprise ent : neighborhood.getEnterpriseList().getEnterpriseList()){
            if(ent instanceof CommunityEnterprise){
                for(Organization orgz : ent.getOrganizationList().getOrganizationList()){
                    if(orgz instanceof EnergyResourceOrg){
                        for(UserAccount ua : orgz.getUserAccDir().getUserAccountList()){
                            userAcc = ua;
                        }
                    }
                }
            }
        }
        
        Date requestDate = new Date();
        AreaAdmintoEnergyAdminRequest request = new AreaAdmintoEnergyAdminRequest();
        String alert = alertMsgTxt.getText();
        request.setMessage(neighborhood.getNeighborhoodName());
        request.setSender(account);
        request.setReceiver(userAcc);
        request.setRequestDate(requestDate);
        request.setStatus("sent");
        request.setComment(alert);
        Organization org = null;
        for(Enterprise enterprise: neighborhood.getEnterpriseList().getEnterpriseList()){
        for(Organization organization : enterprise.getOrganizationList().getOrganizationList())
            {
                if(organization instanceof EnergyResourceOrg){
                    org = organization;
                    break;
                }
            }
        }
            if(org!=null)
            {
                userAcc.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
            }
            populateAreaToEnergyAdminAlerts();
            JOptionPane.showMessageDialog(null, "Alert sent to the energy source department","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_aleryEnergyOrgBtnActionPerformed

    public void populateAreaToEnergyAdminAlerts(){
        DefaultTableModel dtm = (DefaultTableModel)energyAdminAlertTable.getModel();
        dtm.setRowCount(0);
        if(account.getWorkQueue().getWorkRequestList()!=null){
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList())
        {
            if(request instanceof AreaAdmintoEnergyAdminRequest){
            if(account.getWorkQueue().getWorkRequestList()!=null)
            {
            Object[] row = new Object[6];
            
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getSender();
            row[3] = request.getRequestDate();
            row[4] = ((AreaAdmintoEnergyAdminRequest)request).getComment();
            row[5] = request.getStatus();
            //row[6] = ((PollutionWorkRequest)request).getResponse();
           
            dtm.addRow(row);
            }
        }
        }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alertMsgTxt;
    private javax.swing.JTable alertsTable;
    private javax.swing.JButton aleryEnergyOrgBtn;
    private javax.swing.JButton backJButton;
    private javax.swing.JTable energyAdminAlertTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton responseBtn;
    private javax.swing.JTextField responseTxt;
    // End of variables declaration//GEN-END:variables
}
