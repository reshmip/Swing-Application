/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NeighborhoodAdmin;

import business.EcoDistrict;
import business.Enterprise.Enterprise;
import business.Neighborhood.Neighborhood;
import business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reshmi
 */
public class ManageEnterprisesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterprisesJPanel
     */
    private JPanel userProcessContainer;
    private EcoDistrict ecoDistrict;
    private Neighborhood neighborhood;
    private UserAccount userAccount;
    public ManageEnterprisesJPanel(JPanel userProcessContainer,EcoDistrict ecoDistrict,Neighborhood neighborhood) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoDistrict = ecoDistrict;
        this.neighborhood = neighborhood;
      
        populateTable();
        populateComboBox();
    }

    public void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel)enterpriseTable.getModel();
        model.setRowCount(0);
        if(neighborhood.getEnterpriseList().getEnterpriseList()!=null){
            for (Enterprise enterprise : neighborhood.getEnterpriseList().getEnterpriseList()) {
                
                Object[] row = new Object[3];
                row[0] = enterprise.getOrgName();
                row[1] = enterprise.getEnterpriseType().getValue();
                row[2] = neighborhood.getNeighborhoodName();

                model.addRow(row);
                }
            }
        
    }
    
    public void populateComboBox()
    {
        areasComboBox.removeAllItems();
        entTypeComboBox.removeAllItems();   
        areasComboBox.addItem(neighborhood);

        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            entTypeComboBox.addItem(type);
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
        enterpriseTable = new javax.swing.JTable();
        addEntButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entTypeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        areasComboBox = new javax.swing.JComboBox();
        entNameTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        enterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Enterprise Type", "Neighborhood Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseTable);

        addEntButton.setBackground(new java.awt.Color(0, 153, 0));
        addEntButton.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        addEntButton.setForeground(new java.awt.Color(255, 255, 255));
        addEntButton.setText("ADD");
        addEntButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntButtonActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(0, 153, 0));
        backJButton.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Enterprise", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Neighborhood Name");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Enterprise Type");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Enterprise Name");

        entTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/NeighborhoodAdmin/Community Logo.jpg"))); // NOI18N

        areasComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entNameTxt)
                    .addComponent(areasComboBox, 0, 85, Short.MAX_VALUE)
                    .addComponent(entTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(areasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addGap(75, 75, 75)
                        .addComponent(addEntButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(addEntButton))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addEntButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntButtonActionPerformed
        // TODO add your handling code here:
        Neighborhood neighborhood = (Neighborhood) areasComboBox.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) entTypeComboBox.getSelectedItem();

        if (neighborhood == null || type == null) {
            JOptionPane.showMessageDialog(null, "Select correct values","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(entNameTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the enterprise name","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String name = entNameTxt.getText();
            Enterprise enterprise = neighborhood.getEnterpriseList().createAndAddEnterprise(name, type);
            JOptionPane.showMessageDialog(null, "New enterprise created","Created",JOptionPane.INFORMATION_MESSAGE); 
            entNameTxt.setText("");
        }
        populateTable();
    }//GEN-LAST:event_addEntButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEntButton;
    private javax.swing.JComboBox areasComboBox;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField entNameTxt;
    private javax.swing.JComboBox entTypeComboBox;
    private javax.swing.JTable enterpriseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
