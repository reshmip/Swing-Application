/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.EnterpriseAdmin;

import business.EcoDistrict;
import business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Reshmi
 */
   
public class EnterpriseAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EnterpriseAdminWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoDistrict ecoDistrict;
    public EnterpriseAdminWorkAreaJPanel(JPanel userProcessContainer,Enterprise enterprise,EcoDistrict ecoDistrict) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.ecoDistrict = ecoDistrict;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mngOrganizationsBtn = new javax.swing.JButton();
        mngUserAccBtn = new javax.swing.JButton();
        mngEmployeeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        mngOrganizationsBtn.setBackground(new java.awt.Color(0, 153, 0));
        mngOrganizationsBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        mngOrganizationsBtn.setForeground(new java.awt.Color(255, 255, 255));
        mngOrganizationsBtn.setText("MANAGE ORGANIZATIONS");
        mngOrganizationsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngOrganizationsBtnActionPerformed(evt);
            }
        });

        mngUserAccBtn.setBackground(new java.awt.Color(0, 153, 0));
        mngUserAccBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        mngUserAccBtn.setForeground(new java.awt.Color(255, 255, 255));
        mngUserAccBtn.setText("MANAGE USER  ACCOUNTS");
        mngUserAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngUserAccBtnActionPerformed(evt);
            }
        });

        mngEmployeeBtn.setBackground(new java.awt.Color(0, 153, 0));
        mngEmployeeBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        mngEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        mngEmployeeBtn.setText("MANAGE EMPLOYEES ");
        mngEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngEmployeeBtnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/EnterpriseAdmin/eco-org.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mngUserAccBtn)
                    .addComponent(mngOrganizationsBtn)
                    .addComponent(jLabel1)
                    .addComponent(mngEmployeeBtn))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(mngOrganizationsBtn)
                .addGap(18, 18, 18)
                .addComponent(mngEmployeeBtn)
                .addGap(18, 18, 18)
                .addComponent(mngUserAccBtn)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mngOrganizationsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngOrganizationsBtnActionPerformed
        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_mngOrganizationsBtnActionPerformed

    private void mngUserAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngUserAccBtnActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel manageUserAccountJPanel = new ManageUserAccountJPanel(userProcessContainer, enterprise,ecoDistrict);
        userProcessContainer.add("manageUserAccountJPanel", manageUserAccountJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_mngUserAccBtnActionPerformed

    private void mngEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngEmployeeBtnActionPerformed
        // TODO add your handling code here:
        ManageEmployeeJPanel manageUserAccountJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationList());
        userProcessContainer.add("manageUserAccountJPanel", manageUserAccountJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_mngEmployeeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mngEmployeeBtn;
    private javax.swing.JButton mngOrganizationsBtn;
    private javax.swing.JButton mngUserAccBtn;
    // End of variables declaration//GEN-END:variables
}
