/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.HospitalAdminRole;

import business.Enterprise.Enterprise;
import business.Organization.HospitalDoctorOrg;
import business.Organization.HouseholdOrg;
import business.Organization.Organization;
import business.Person.Member;
import business.Person.Person;
import business.UserAccount.UserAccount;
import business.WorkQueue.HospitalWorkRequest;
import business.WorkQueue.HosptoHouseWorkRequest;
import business.WorkQueue.WorkRequest;
import business.vitalSignSensor.VitalSign;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.mail.smtp.SMTPTransport;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.AbstractButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jdesktop.xswingx.PromptSupport;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Reshmi
 */
public class ManagePatientsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePatientsJPanel
     */
    private JPanel userProcessContainer;
    //private PersonDirectory personDir;
    private HouseholdOrg houseOrg;
    private UserAccount userAccount;
    private UserAccount account;
    private Enterprise enterprise;
    public ManagePatientsJPanel(JPanel userProcessContainer,HouseholdOrg houseOrg,UserAccount userAccount,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.houseOrg = houseOrg;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        populateComboBox();
        populateDoctorAlertTable();
        populateAlertFamilyTable();
//        populateAlertTable();
        PromptSupport.setPrompt("enter file name", fileNameTxt);
        PromptSupport.setPrompt("message to family admin", adminMsgTxt);
    }

    public void populateComboBox()
    {
        nameComboBox.removeAllItems();
        if(houseOrg.getPersonDir().getPersonDir()!=null){
        for(Person person:houseOrg.getPersonDir().getPersonDir())
        {
            nameComboBox.addItem(person);
        }
       }
    }
    
    public void populateTable(Person person)
    {
        DefaultTableModel model = (DefaultTableModel)vitalSignjTable.getModel();
        TableColumnModel tcm = vitalSignjTable.getColumnModel();
        CustomTableCellRenderer customCellRenderer = new CustomTableCellRenderer();
        model.setRowCount(0);
        //if(houseOrg.getPersonDir().getPersonDir()!=null){
        //for(Person person:houseOrg.getPersonDir().getPersonDir()){
        if(person.getMemberDir().getMemberDirectory()!=null){
        for(Member member:person.getMemberDir().getMemberDirectory()){
        int patientAge = member.getAge();
        if(member.getVitalSignList().getVitalSignList()!=null){
        for(VitalSign vs:member.getVitalSignList().getVitalSignList()){
            Object[] row = new Object[8];
//            vitalSignjTable.getColumnModel().getColumn(7).setMinWidth(0);
//            vitalSignjTable.getColumnModel().getColumn(7).setMaxWidth(0);
//            vitalSignjTable.getColumnModel().getColumn(7).setWidth(0);
            row[0] = member;
            row[1] = vs;
            row[2] = vs.getRespiratoryRate();
            row[3] = vs.getHeartRate();
            row[4] = vs.getBloodPressure();
            row[5] = vs.getTemperature();
            row[6] = member.getVitalSignList().VitalSignStatus(patientAge, vs);
            row[7] = vs.getAlertStatus();
            model.addRow(row);
            tcm.getColumn(6).setCellRenderer(customCellRenderer);
        }
        }
        }
        }
    }
    public class CustomTableCellRenderer extends DefaultTableCellRenderer{
      public Component getTableCellRendererComponent (JTable table, 
    Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
  Component cell = super.getTableCellRendererComponent(
   table, obj, isSelected, hasFocus, row, column);

     TableModel model = vitalSignjTable.getModel();
        String status = (String)model.getValueAt(row, 6);
        if(status.equals("Abnormal"))
        {
            cell.setBackground(Color.red);
        }
        else{
            cell.setBackground(Color.green);
        }
        return cell;
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

        visitBtnGrp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nameComboBox = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vitalSignjTable = new javax.swing.JTable();
        viewChatBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alertRequestDetailsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        vitalSignAlertsTable = new javax.swing.JTable();
        confirmBtn = new javax.swing.JButton();
        visitedRadioBtn = new javax.swing.JRadioButton();
        noShowRadioBtn = new javax.swing.JRadioButton();
        cancenRadioBtn = new javax.swing.JRadioButton();
        submitVisitStatusBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        fwdDoctorBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        alertFamilyAdminBtn = new javax.swing.JButton();
        adminMsgTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        saveReportBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        fileNameTxt = new javax.swing.JTextField();
        saveAsPdfBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Patient Name");

        nameComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameComboBoxActionPerformed(evt);
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

        vitalSignjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Timestamp", "Respiratory Rate", "Heart Rate", "Blood Pressure", "Temperature", "Status", "Alert Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vitalSignjTable);

        viewChatBtn.setBackground(new java.awt.Color(0, 153, 0));
        viewChatBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        viewChatBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewChatBtn.setText("View Chart");
        viewChatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewChatBtnActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        alertRequestDetailsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        alertRequestDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Member Name", "Doctor", "Sent On", "Severity", "Message", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(alertRequestDetailsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Forward Doctor Details", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        vitalSignAlertsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        vitalSignAlertsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Member", "Alert Message", "Sent On", "Visit Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(vitalSignAlertsTable);

        confirmBtn.setBackground(new java.awt.Color(0, 153, 0));
        confirmBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Confirm Appointment");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        visitBtnGrp.add(visitedRadioBtn);
        visitedRadioBtn.setText("Visited");

        visitBtnGrp.add(noShowRadioBtn);
        noShowRadioBtn.setText("Dint Show Up");

        visitBtnGrp.add(cancenRadioBtn);
        cancenRadioBtn.setText("Cancel");

        submitVisitStatusBtn.setText("Submit");
        submitVisitStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitVisitStatusBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(visitedRadioBtn)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitVisitStatusBtn)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(noShowRadioBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancenRadioBtn)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn)
                    .addComponent(visitedRadioBtn)
                    .addComponent(noShowRadioBtn)
                    .addComponent(cancenRadioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(submitVisitStatusBtn))
        );

        jTabbedPane1.addTab("Alert Family Details", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Send Alerts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        fwdDoctorBtn.setBackground(new java.awt.Color(0, 153, 0));
        fwdDoctorBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        fwdDoctorBtn.setForeground(new java.awt.Color(255, 255, 255));
        fwdDoctorBtn.setText("Forward to Doctor");
        fwdDoctorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fwdDoctorBtnActionPerformed(evt);
            }
        });

        alertFamilyAdminBtn.setBackground(new java.awt.Color(0, 153, 0));
        alertFamilyAdminBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        alertFamilyAdminBtn.setForeground(new java.awt.Color(255, 255, 255));
        alertFamilyAdminBtn.setText("Alert Family Admin");
        alertFamilyAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alertFamilyAdminBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alertFamilyAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(adminMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alertFamilyAdminBtn)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fwdDoctorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fwdDoctorBtn)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Save Records", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        saveReportBtn.setBackground(new java.awt.Color(0, 153, 0));
        saveReportBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        saveReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveReportBtn.setText("Export to Excel");
        saveReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveReportBtnActionPerformed(evt);
            }
        });

        saveAsPdfBtn.setBackground(new java.awt.Color(0, 153, 0));
        saveAsPdfBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        saveAsPdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveAsPdfBtn.setText("Save As PDF");
        saveAsPdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsPdfBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileNameTxt)
                    .addComponent(saveAsPdfBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fileNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveAsPdfBtn)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveReportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveReportBtn)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewChatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(viewChatBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void nameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameComboBoxActionPerformed
       
        Person person = (Person)nameComboBox.getSelectedItem();
        if(person!=null)
        populateTable(person);
    }//GEN-LAST:event_nameComboBoxActionPerformed

    public void populateDoctorAlertTable(){
        DefaultTableModel dtm = (DefaultTableModel)alertRequestDetailsTable.getModel();
        dtm.setRowCount(0);
        
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
            if(request instanceof HospitalWorkRequest){
            if(userAccount.getWorkQueue().getWorkRequestList()!=null)
            {
            Object[] row = new Object[6];
            
            row[0] = request;
            UserAccount receiver = ((HospitalWorkRequest)request).getReceiver();
            row[1] = receiver == null ? "Doctor not assigned" : receiver;
            
            row[2] = request.getRequestDate();
            row[3] = request.getSeverity();
            row[4] = ((HospitalWorkRequest)request).getAlert();
            row[5] = request.getStatus();
            dtm.addRow(row);
            }
            }
        }
    }
    public void sendMailToCommunityMember(String to, String subject, String message , String from, String password)
    {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.user",from);
            
            Session session = Session.getDefaultInstance(props);
            MimeMessage mimeMessage = new MimeMessage(session);
            try{
                mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                mimeMessage.setSubject("Alert from Hospital Organization");
                mimeMessage.setText(message);
                SMTPTransport transport = (SMTPTransport)session.getTransport("smtps");
                transport.connect(host,from, password);
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
                transport.close();
            }catch(MessagingException me){
                
            }
    }
    private void viewChatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewChatBtnActionPerformed
         int selectedRow = vitalSignjTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient from table.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        createChart();
    }//GEN-LAST:event_viewChatBtnActionPerformed

    private void saveReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveReportBtnActionPerformed
        try {
                    HSSFWorkbook fWorkbook = new HSSFWorkbook();
                    HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
                    HSSFFont sheetTitleFont = fWorkbook.createFont();
                    File file = new File("C:\\Users\\Reshmi\\OneDrive\\Documents\\reports.xls");
                    HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

                    sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                    //sheetTitleFont.setColor();
                    TableModel model = vitalSignjTable.getModel();
                    TableColumnModel tcm = vitalSignjTable.getColumnModel();
                    HSSFRow fRow1 = fSheet.createRow((short) 0);
                    
                    for(int j = 0; j < tcm.getColumnCount(); j++) {

                     HSSFCell cell = fRow1.createCell((short) j);
                     cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());           
                    
                    }

                    for (int i = 0; i < model.getRowCount(); i++) {
                      
                        HSSFRow fRow = fSheet.createRow((short)i+1);
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            HSSFCell cell = fRow.createCell((short) j);
                            cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
                            cell.setCellValue(model.getValueAt(i, j).toString());
                            cell.setCellStyle(cellStyle);

                        }

                    }
                FileOutputStream fileOutputStream;
                fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                fWorkbook.write(bos);
                bos.close();
                fileOutputStream.close();
                JOptionPane.showMessageDialog(null, "File saved as reports.xls ", "Export", JOptionPane.INFORMATION_MESSAGE);
//                Runtime run = Runtime.getRuntime();
//                run.exec("cmd.exetart " + file);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "File not saved", "Export", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveReportBtnActionPerformed

    private void saveAsPdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsPdfBtnActionPerformed
    Document document = new Document(PageSize.A4.rotate());
    String[] headers = new String[] {"Name", "TimeStamp", "Resp Rate", "Heart Rate","Blood Pressure","Temperature","Status"};
    String filename = fileNameTxt.getText();
    try {
        if(!filename.equals("")){
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));

      document.open();
      PdfContentByte cb = writer.getDirectContent();

      cb.saveState();
      PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header.toUpperCase(), new Font(Font.HELVETICA, 8, Font.BOLD)));
                table.addCell(cell);
                
            }
            table.completeRow();
           
            table.spacingBefore();
            table.spacingAfter();
            document.add(table);
      Graphics2D g2 = cb.createGraphicsShapes(500, 500);
      //cb.showTextAligned(PdfContentByte.ALIGN_CENTER, g2, 200, 300, 0);
      
      Shape oldClip = g2.getClip();
      g2.clipRect(0, 0, 700, 500);

      vitalSignjTable.print(g2);
      g2.setClip(oldClip);

      g2.dispose();
      cb.restoreState();
       JOptionPane.showMessageDialog(null, "file saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } 
        else{
            JOptionPane.showMessageDialog(null, "enter the filename", "FileName", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    document.close();
    }//GEN-LAST:event_saveAsPdfBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        int selectedRow = vitalSignAlertsTable.getSelectedRow();
        if (selectedRow < 0)
        {
           JOptionPane.showMessageDialog(null, "Please select a row", "WARNING", JOptionPane.WARNING_MESSAGE);
           return; 
        }
        else
        {
            
            HosptoHouseWorkRequest request = (HosptoHouseWorkRequest)vitalSignAlertsTable.getValueAt(selectedRow, 0);
            if(request.getStatus().equals("Requested Visit")){
            request.setStatus("Confirmed");
            populateAlertFamilyTable();
            }
            else if(request.getStatus().equals("Visited")){
                JOptionPane.showMessageDialog(null, "Patient has already visited.Kindly confirm a new request", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            else if(request.getStatus().equals("Dint Show Up")){
                JOptionPane.showMessageDialog(null, "Patient dint show up.Kindly confirm a new request", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            else if(request.getStatus().equals("Cancelled")){
                JOptionPane.showMessageDialog(null, "Visit is cancelled.Kindly confirm a new request", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Appointment not requested", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void fwdDoctorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fwdDoctorBtnActionPerformed
        int selectedRow = vitalSignjTable.getSelectedRow();
        Date requestDate = new Date();
        Person person = (Person)nameComboBox.getSelectedItem();
        //account.getPerson().getPersonName();
        String status = (String)vitalSignjTable.getValueAt(selectedRow, 6);
        for(Organization orgz : enterprise.getOrganizationList().getOrganizationList()){
        if(orgz instanceof HospitalDoctorOrg){
        for(UserAccount ua : orgz.getUserAccDir().getUserAccountList()){
            account = ua;
        } 
        }
        }
        if(selectedRow>=0)
        {
            try{
            if(!status.equals("Normal")){
            DefaultTableModel model = (DefaultTableModel)vitalSignjTable.getModel();
            Member member = (Member)model.getValueAt(selectedRow, 0);
            //VitalSign timestamp = (VitalSign)vitalSignjTable.getValueAt(selectedRow, 1);
            String message = member.getMemberName();
            VitalSign vs = (VitalSign)vitalSignjTable.getValueAt(selectedRow, 1);
            if(vs.getAlertStatus().equals("Requested doc")){
                JOptionPane.showMessageDialog(null, "Vital Sign data already sent to doctors",
                    "WARNING",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(vs.getAlertStatus().equals("Doc Reviewed")||vs.getAlertStatus().equals("sent to house")){
                JOptionPane.showMessageDialog(null, "Vital Sign record already reviewed by doctor",
                    "WARNING",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
            vs.setAlertStatus("Requested doc");
            populateTable(person);
            HospitalWorkRequest request = new HospitalWorkRequest();
           
            request.setPerson(person);
            request.setMessage(message);
            request.setSender(userAccount);
            request.setStatus("alert sent");
//            request.setRecordDate(timestamp);
            Organization org = null;
            for(Organization organization : enterprise.getOrganizationList().getOrganizationList())
            {
                if(organization instanceof HospitalDoctorOrg){
                    org = organization;
                    break;
                }
            }
            if(org!=null)
            {
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                org.getWorkQueue().getWorkRequestList().add(request);
                }
            populateDoctorAlertTable();
                JOptionPane.showMessageDialog(null, "Alert Sent to doctor", "Infomation", JOptionPane.INFORMATION_MESSAGE);
                
            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Vital Sign is normal. Cannot forward to doctor", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e){
//                JOptionPane.showMessageDialog(null, "","record",JOptionPane.INFORMATION_MESSAGE);
                }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a Row", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
//                for(WorkRequest req : userAccount.getWorkQueue().getWorkRequestList()){
//                    if(req instanceof HospitalWorkRequest){
//                        if(!((request.getMessage().equals(req.getMessage()))&&
//                            (request.getRecordDate().equals(((HospitalWorkRequest)req).getRecordDate())))){
                            
//                            }
//                            else{
//                                JOptionPane.showMessageDialog(null, "Patient record is already sent to doctor", "WARNING", JOptionPane.WARNING_MESSAGE);
//                            }
//                        }
//                    }

    }//GEN-LAST:event_fwdDoctorBtnActionPerformed

    private void alertFamilyAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alertFamilyAdminBtnActionPerformed
        int selectedRow = vitalSignjTable.getSelectedRow();
        Person person = (Person)nameComboBox.getSelectedItem();
        String status = (String)vitalSignjTable.getValueAt(selectedRow, 6);
        for(Organization orgn : enterprise.getOrganizationList().getOrganizationList()){
            if(orgn instanceof HouseholdOrg)
            for(UserAccount ua : orgn.getUserAccDir().getUserAccountList()){
            if(ua.getPerson().getPersonName().equals(person.getPersonName())){
                account = ua;
            }
        }
        }
        if (selectedRow < 0)
        {
           JOptionPane.showMessageDialog(null, "Please select a row", "WARNING", JOptionPane.WARNING_MESSAGE);
           return; 
        }
        else
        {
            if(!status.equals("Normal")){  
            Member member = (Member)vitalSignjTable.getValueAt(selectedRow, 0);            
            String message = member.getMemberName();
            HosptoHouseWorkRequest request = new HosptoHouseWorkRequest();
            //HospitalWorkRequest request = (HospitalWorkRequest)alertRequestDetailsTable.getValueAt(selectedRow, 0);
            VitalSign vs = (VitalSign)vitalSignjTable.getValueAt(selectedRow, 1); 
            if(!(vs.getAlertStatus().equals("Doc Reviewed")||vs.getAlertStatus().equals("sent to house"))){
                JOptionPane.showMessageDialog(null, "Vital Sign not reviewed by doctor",
                    "WARNING",JOptionPane.WARNING_MESSAGE);
                return;
            }
//            else if(vs.getAlertStatus().equals("sent to house")){
//                JOptionPane.showMessageDialog(null, "Alert already sent to family admin", "WARNING", JOptionPane.WARNING_MESSAGE);
//            }
            else{

            if(adminMsgTxt.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Kindly enter a message", "Message", JOptionPane.WARNING_MESSAGE);
            }
            else{ 
            vs.setAlertStatus("sent to house");
            populateTable(person);
            Date reqDate = new Date();
            request.setMessage(message);
            request.setSender(userAccount);
            request.setReceiver(account);
            request.setRequestDate(reqDate);
            request.setStatus("sent to member");
            request.setAdminMessage(adminMsgTxt.getText());
            Organization org = null;
            for(Organization organization : enterprise.getOrganizationList().getOrganizationList())
            {
                if(organization instanceof HouseholdOrg){
                    org = organization;
                    break;
                }
            }
            if(org!=null)
            {
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
            }
             populateAlertFamilyTable();
            JOptionPane.showMessageDialog(null, "Alert Sent to family admin", "Infomation", JOptionPane.INFORMATION_MESSAGE);
            //Person person = (Person)nameComboBox.getSelectedItem();
            try{
            String to = person.getEmail();
            //String[] to = {"reshmi.padavala@gmail.com","naveensanaka@gmail.com"};
            sendMailToCommunityMember(to,
                    "Alert from Hospital Admin",
                    "Kindly check you account for alert details",
                    "aedtest2015@gmail.com",
                    "Jaffa@123");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Could not send email", "Mail", JOptionPane.WARNING_MESSAGE);
            }
            }
            }
            }else{
                JOptionPane.showMessageDialog(null, "Vital Sign is normal.Alert not triggered", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_alertFamilyAdminBtnActionPerformed

    private void submitVisitStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitVisitStatusBtnActionPerformed
        Enumeration<AbstractButton> bg = visitBtnGrp.getElements();
        while(bg.hasMoreElements()){
        JRadioButton jrd = (JRadioButton)bg.nextElement();
        int selectedRow = vitalSignAlertsTable.getSelectedRow();
        Date currentDate = new Date();
        HosptoHouseWorkRequest request = (HosptoHouseWorkRequest)vitalSignAlertsTable.getValueAt(selectedRow, 0);
        if(jrd.isSelected()){
            if(selectedRow>=0){
                if(request.getAppointmentDate()!=null){
                if(jrd.getText().equals("Visited")){

                    if(!request.getStatus().equals("Cancelled")){
                        if(request.getAppointmentDate().compareTo(currentDate)<0){
                            if(request.getStatus().equals("Confirmed")){
                                request.setStatus("Visited");
                                populateAlertFamilyTable();
                            }
                            else if(request.getStatus().equals("Cancelled")){
                                JOptionPane.showMessageDialog(null, "Appointment is already cancelled", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else if(request.getStatus().equals("Dint Show Up")){
                                JOptionPane.showMessageDialog(null, "Person dint show up.", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Check after the appointment time", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Appointment is already cancelled", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if (jrd.getText().equals("Dint Show Up")){
//                    HosptoHouseWorkRequest request = (HosptoHouseWorkRequest)vitalSignAlertsTable.getValueAt(selectedRow, 0);
                    if(!request.getStatus().equals("Cancelled")){
                        if(request.getAppointmentDate().compareTo(currentDate)<0){
                            if(request.getStatus().equals("Confirmed")){
                                request.setStatus("Dint Show Up");
                                populateAlertFamilyTable();
                            }
                            else if(request.getStatus().equals("Visited")){
                                JOptionPane.showMessageDialog(null, "Person already visited.", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Check after the appointment time", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                        }   
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Appointment is already cancelled", "MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
                else if (jrd.getText().equals("Cancel")){
//                    HosptoHouseWorkRequest request = (HosptoHouseWorkRequest)vitalSignAlertsTable.getValueAt(selectedRow, 0);
                    if(!request.getStatus().equals("Cancelled")){   
                        if(request.getAppointmentDate().compareTo(currentDate)>0){
                            if(request.getStatus().equals("Confirmed")){
                            request.setStatus("Cancelled");
                            populateAlertFamilyTable();
                        }else{
                                request.setStatus("Cancelled");
                                populateAlertFamilyTable();
                            }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Can be cancelled before appointment time", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                   JOptionPane.showMessageDialog(null, "Appointment is already cancelled", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
                JOptionPane.showMessageDialog(null, "Appointment not requested", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        else{
            JOptionPane.showMessageDialog(null, "Kindly select a row!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
        }
    }//GEN-LAST:event_submitVisitStatusBtnActionPerformed

    public void populateAlertFamilyTable(){
        DefaultTableModel model = (DefaultTableModel)vitalSignAlertsTable.getModel();
        model.setRowCount(0);
        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
            if(request instanceof HosptoHouseWorkRequest)
            {
            Object[] row = new Object[5];
            
            row[0] = request;           
            String alert = ((HosptoHouseWorkRequest)request).getAdminMessage();
            row[1] = alert == null ? "No Alert": alert;
            row[2] = request.getRequestDate();
            row[3] = ((HosptoHouseWorkRequest)request).getAppointmentDate();
            //row[6] = ((HospitalWorkRequest)request).getAppointmentTime();
            row[4] = request.getStatus();
            model.addRow(row);
            }
        }
    }
     private void createChart()
    {
        DefaultCategoryDataset vitalSignDataset=new DefaultCategoryDataset();
        int selectedRow = vitalSignjTable.getSelectedRow();
        Member member = (Member) vitalSignjTable.getValueAt(selectedRow, 0);
        ArrayList<VitalSign> vitalSignList = member.getVitalSignList().getVitalSignList();
        /*At least 2 vital sign records needed to show chart */
        if (vitalSignList.isEmpty() || vitalSignList.size() == 1) {
            JOptionPane.showMessageDialog(this, "No vital signs or only one vital sign found. At least 2 vital sign records needed to show chart!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (VitalSign vitalSign : vitalSignList) {
            vitalSignDataset.addValue(vitalSign.getRespiratoryRate(),"RR", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getHeartRate(),"HR", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getBloodPressure(),"BP", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getTemperature(),"Temp", vitalSign.getTimestamp());
        }
        
        JFreeChart vitalSignChart= ChartFactory.createBarChart3D("Vital Sign Chart", "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
        vitalSignChart.setBackgroundPaint(Color.white);
        CategoryPlot vitalSignChartPlot = vitalSignChart.getCategoryPlot();
        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);    
        
        CategoryAxis vitalSignDomainAxis = vitalSignChartPlot.getDomainAxis();
        vitalSignDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis vitalSignRangeAxis = (NumberAxis) vitalSignChartPlot.getRangeAxis();
        vitalSignRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartFrame chartFrame = new ChartFrame("Chart", vitalSignChart);
        chartFrame.setVisible(true);
        chartFrame.setSize(500, 500);

    }
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminMsgTxt;
    private javax.swing.JButton alertFamilyAdminBtn;
    private javax.swing.JTable alertRequestDetailsTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JRadioButton cancenRadioBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField fileNameTxt;
    private javax.swing.JButton fwdDoctorBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox nameComboBox;
    private javax.swing.JRadioButton noShowRadioBtn;
    private javax.swing.JButton saveAsPdfBtn;
    private javax.swing.JButton saveReportBtn;
    private javax.swing.JButton submitVisitStatusBtn;
    private javax.swing.JButton viewChatBtn;
    private javax.swing.ButtonGroup visitBtnGrp;
    private javax.swing.JRadioButton visitedRadioBtn;
    private javax.swing.JTable vitalSignAlertsTable;
    private javax.swing.JTable vitalSignjTable;
    // End of variables declaration//GEN-END:variables
}
