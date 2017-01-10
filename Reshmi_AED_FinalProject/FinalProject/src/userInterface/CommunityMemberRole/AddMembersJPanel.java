/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.CommunityMemberRole;

import business.Person.Member;
import business.Person.MemberDirectory;
import business.Person.Person;
import business.Validations.MyNumericVerifier;
import business.Validations.MyStringVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Reshmi
 */
public class AddMembersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddMembersJPanel
     */
    private JPanel userProcessContainer;
    private Person person;
    private MemberDirectory memDir;
    public AddMembersJPanel(JPanel userProcessContainer,Person person) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.person = person;
        populateComboBox();
        familyHeadTxt.setText(person.getPersonName());
        addVerifiers();
    }
    
    private void addVerifiers() {
        InputVerifier integerVerifier = new MyNumericVerifier();
        InputVerifier stringVerifier = new MyStringVerifier();
        memNameTxt.setInputVerifier(stringVerifier);
        dobTxt.setInputVerifier(integerVerifier);
    }

    public void populateComboBox()
    {
        relationsComboBox.removeAllItems();
        relationsComboBox.addItem("self");
        relationsComboBox.addItem("father");
        relationsComboBox.addItem("mother");
        relationsComboBox.addItem("husband");
        relationsComboBox.addItem("wife");
        relationsComboBox.addItem("son");
        relationsComboBox.addItem("daughter");
        relationsComboBox.addItem("sister");
        relationsComboBox.addItem("brother");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMemerBtn = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        relationsComboBox = new javax.swing.JComboBox();
        dobTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        memNameTxt = new javax.swing.JTextField();
        familyHeadTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        addMemerBtn.setBackground(new java.awt.Color(0, 153, 0));
        addMemerBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        addMemerBtn.setForeground(new java.awt.Color(255, 255, 255));
        addMemerBtn.setText("Add");
        addMemerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemerBtnActionPerformed(evt);
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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/CommunityMemberRole/family.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        relationsComboBox.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        relationsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dobTxt.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Family Head");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Relation to the head");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Age");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Member Name");

        memNameTxt.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        familyHeadTxt.setEditable(false);
        familyHeadTxt.setBackground(new java.awt.Color(255, 255, 255));
        familyHeadTxt.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dobTxt)
                        .addComponent(relationsComboBox, 0, 80, Short.MAX_VALUE)
                        .addComponent(memNameTxt))
                    .addComponent(familyHeadTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(familyHeadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(relationsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addMemerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMemerBtn)
                    .addComponent(backJButton))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
       Component component = componentArray[componentArray.length - 1];
       ManagePersonProfileJPanel mngPersonProfilejp = (ManagePersonProfileJPanel) component;
       mngPersonProfilejp.populateTable();
       CardLayout layout = (CardLayout) userProcessContainer.getLayout();
       layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addMemerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemerBtnActionPerformed
        if(memNameTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the member name", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(dobTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the member age", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
        Member member = new Member();
        //person.getMemberDir().addMember(member);
        member.setFamilyHead(person.getPersonName());
        member.setMemberName(memNameTxt.getText());
        member.setAge(Integer.parseInt(dobTxt.getText()));
        String relation = relationsComboBox.getSelectedItem().toString();
        member.setRelation(relation);
        person.getMemberDir().addMember(member);
        //memDir.addMember(member);
        
        JOptionPane.showMessageDialog(null, "member added successfully", "create", JOptionPane.INFORMATION_MESSAGE);
        resetFields();
        }
    }//GEN-LAST:event_addMemerBtnActionPerformed

    public void resetFields()
    {
        memNameTxt.setText("");
        dobTxt.setText("");
        populateComboBox();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemerBtn;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JTextField familyHeadTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField memNameTxt;
    private javax.swing.JComboBox relationsComboBox;
    // End of variables declaration//GEN-END:variables
}
