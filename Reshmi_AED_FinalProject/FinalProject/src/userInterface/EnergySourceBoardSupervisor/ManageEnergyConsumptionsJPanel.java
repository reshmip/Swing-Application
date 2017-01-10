/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.EnergySourceBoardSupervisor;

import business.Enterprise.Enterprise;
import business.Organization.HouseholdOrg;
import business.Organization.Organization;
import business.Person.Member;
import business.Person.Person;
import business.Sensors.Sensor;
import business.UserAccount.UserAccount;
import business.WorkQueue.HighEnergyConsumptionWorkRequest;
import business.WorkQueue.WorkRequest;
import business.vitalSignSensor.VitalSign;
import com.sun.mail.smtp.SMTPTransport;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import javafx.scene.chart.PieChart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jdesktop.xswingx.PromptSupport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Reshmi
 */
public class ManageEnergyConsumptionsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnergyConsumptionsJPanel
     */
    private JPanel userProcessContainer;
     private HouseholdOrg houseOrg;
    private UserAccount userAccount;
    private UserAccount account;
    private Enterprise enterprise;
    public ManageEnergyConsumptionsJPanel(JPanel userProcessContainer,HouseholdOrg houseOrg,UserAccount userAccount,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.houseOrg = houseOrg;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        PromptSupport.setPrompt("image name", fileNameTxt);
        PromptSupport.setPrompt("file path", attachmentpath_Txt);
        PromptSupport.setPrompt("file name", name_attach);
        PromptSupport.setPrompt("alert message to house", commentsTxt);
        populateComboBox();
        populateAlertTable();
        populateCalculations();
    }
    
    public void populateComboBox()
    {
        houseAdminComboBox.removeAllItems();
        for(Person person:houseOrg.getPersonDir().getPersonDir()){
            if(houseOrg.getPersonDir().getPersonDir()!=null){
            houseAdminComboBox.addItem(person);
            }
        }
    }
    
    public void populateTable(Person person)
    {
        DefaultTableModel model = (DefaultTableModel)applianceTable.getModel();
        TableColumnModel tcm = applianceTable.getColumnModel();
        CustomTableCellRenderer customCellRenderer = new CustomTableCellRenderer();
        model.setRowCount(0);
        if(person.getSensorsList().getSensorsList()!=null)
        {
            for(Sensor sensor:person.getSensorsList().getSensorsList())
            {
                Object[] row = new Object[5];
                row[0] = sensor;
                String appName = sensor.getSensorType().getValue();
                row[1] = appName;
                int watts = sensor.getNumberWatt();
                row[2] = watts;
                row[3] = sensor.getHours();
                row[4] = sensor.getConsumptionLevel();
                model.addRow(row);
                tcm.getColumn(4).setCellRenderer(customCellRenderer);
            }
            populateCalculations();
        }
        
    }
    
    public void populateCalculations()
    {
        int reading = 0;
        int hours = 0;
        float energyPerDay = 0;
        float energyPerMonth = 0;
        float energyPerYear = 0;
        DefaultTableModel dtm = (DefaultTableModel)applianceTable.getModel();
        int count = dtm.getRowCount();
        for(int row = count-1;row>=0;row-- ){
            reading = (int)dtm.getValueAt(row, 2);
            hours = (int)dtm.getValueAt(row, 3);
            energyPerDay = energyPerDay + ((reading*hours)/1000);
        }
        
        energyPerDayTxt.setText(String.valueOf(energyPerDay));
        energyPerMonth = energyPerDay * 30;
        energyPerMonthTxt.setText(String.valueOf(energyPerMonth));
        energyPerYear = energyPerDay * 365;
        energyPerYearTxt.setText(String.valueOf(energyPerYear));
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        houseAdminComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        applianceTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        alertDetailsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        energyPerYearTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        energyPerMonthTxt = new javax.swing.JTextField();
        energyPerDayTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        name_attach = new javax.swing.JTextField();
        attachmentpath_Txt = new javax.swing.JTextField();
        uplaodBtn = new javax.swing.JButton();
        sendMailBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        sendAlertBtn = new javax.swing.JButton();
        commentsTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        fileNameTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        houseAdminComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        houseAdminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseAdminComboBoxActionPerformed(evt);
            }
        });

        applianceTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        applianceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Appliance ID", "Appliance Name", "No of Watt", "No of Hours", "Consumption"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(applianceTable);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("House Admin");

        backJButton.setBackground(new java.awt.Color(0, 153, 0));
        backJButton.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        alertDetailsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        alertDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Appliance", "House Admin", "Sent By", "Message", "Status", "Sent On", "Response"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(alertDetailsTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Energy Consumption", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel8.setText("kWh/year");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel6.setText("kWh/day");

        energyPerYearTxt.setEditable(false);
        energyPerYearTxt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel7.setText("kWh/month");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Energy consumed per day");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Energy consumed per year");

        energyPerMonthTxt.setEditable(false);
        energyPerMonthTxt.setBackground(new java.awt.Color(255, 255, 255));

        energyPerDayTxt.setEditable(false);
        energyPerDayTxt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Energy consumed per month ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(energyPerYearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(energyPerMonthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(energyPerDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(energyPerDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(energyPerMonthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(energyPerYearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/EnergySourceBoardSupervisor/analyse_usage.jpg"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alert Family Admin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11), new java.awt.Color(102, 0, 102))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        uplaodBtn.setBackground(new java.awt.Color(0, 153, 0));
        uplaodBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        uplaodBtn.setForeground(new java.awt.Color(255, 255, 255));
        uplaodBtn.setText("Upload File");
        uplaodBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uplaodBtnActionPerformed(evt);
            }
        });

        sendMailBtn.setBackground(new java.awt.Color(0, 153, 0));
        sendMailBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        sendMailBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendMailBtn.setText("Send Mail");
        sendMailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(attachmentpath_Txt)
                    .addComponent(name_attach, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uplaodBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendMailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachmentpath_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uplaodBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_attach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendMailBtn))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));

        sendAlertBtn.setBackground(new java.awt.Color(0, 153, 0));
        sendAlertBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        sendAlertBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendAlertBtn.setText("Send Alert");
        sendAlertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendAlertBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commentsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(sendAlertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendAlertBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        saveBtn.setBackground(new java.awt.Color(0, 153, 0));
        saveBtn.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save as Image");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileNameTxt)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(30, 30, 30)
                                    .addComponent(houseAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(houseAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void houseAdminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseAdminComboBoxActionPerformed
        
        Person person = (Person)houseAdminComboBox.getSelectedItem();
        if(person!=null)
        populateTable(person);
    }//GEN-LAST:event_houseAdminComboBoxActionPerformed

    private void sendAlertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendAlertBtnActionPerformed
        int selectedRow = applianceTable.getSelectedRow();
        Date requestDate = new Date();
        Person person = (Person)houseAdminComboBox.getSelectedItem();
        //account.getPerson().getPersonName();
        String consumption = (String)applianceTable.getValueAt(selectedRow, 4);
        for(UserAccount ua : houseOrg.getUserAccDir().getUserAccountList()){
            if(ua.getPerson().getPersonName().equals(person.getPersonName())){
                account = ua;
            }
        }
        if(selectedRow>=0)
        {
            if(!consumption.equals("Efficient")){
            if(!commentsTxt.getText().equals("")){
            DefaultTableModel model = (DefaultTableModel)applianceTable.getModel();
            Sensor sensor = (Sensor)model.getValueAt(selectedRow, 0);
            String message = sensor.getSensorType().getValue();
            HighEnergyConsumptionWorkRequest request = new HighEnergyConsumptionWorkRequest();
            request.setMessage(message);
            request.setSender(userAccount);
            request.setReceiver(account);
            request.setStatus("sent");
            request.setEnergyConsumed(sensor.getNumberWatt());
            String comment = commentsTxt.getText();
            request.setComment(comment);
            request.setRequestDate(requestDate);
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
            populateAlertTable();
            JOptionPane.showMessageDialog(null, "Alert Sent", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Kindly enter an alert message","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Consumption is efficient.Alert not triggered", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a Row", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_sendAlertBtnActionPerformed

    public class CustomTableCellRenderer extends DefaultTableCellRenderer{
      public Component getTableCellRendererComponent (JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

     TableModel model = applianceTable.getModel();
        String status = (String)model.getValueAt(row, 4);
        if(!status.equals("Efficient"))
        {
            cell.setBackground(Color.ORANGE);
        }
        else{
            cell.setBackground(Color.cyan);
        }
        return cell;
      }
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        JTableHeader tableHeaderComp = applianceTable.getTableHeader();
    int totalWidth = tableHeaderComp.getWidth() + applianceTable.getWidth();
    int totalHeight = tableHeaderComp.getHeight() + applianceTable.getHeight();
    BufferedImage tableImage = new BufferedImage(totalWidth, totalHeight,
        BufferedImage.TYPE_INT_RGB);
    Graphics2D g2D = (Graphics2D) tableImage.getGraphics();
    tableHeaderComp.paint(g2D);
    g2D.translate(0, tableHeaderComp.getHeight());
    applianceTable.paint(g2D);
    String name = fileNameTxt.getText();
    try{ 
    if(!name.equals("")){
    ImageIO.write(tableImage,"png",new File("C:\\Users\\Reshmi\\Documents\\NetBeansProjects\\FinalProject\\Saved Files\\"+name+".png"));
    JOptionPane.showMessageDialog(null, "image saved as "+name+".png","Saved" , JOptionPane.INFORMATION_MESSAGE);
    }
    else{
    JOptionPane.showMessageDialog(null, "enter name to be saved","No image name",JOptionPane.ERROR_MESSAGE);
    }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         DefaultPieDataset piedataset=new DefaultPieDataset();
        int rowcount=applianceTable.getRowCount();
        
        for(int i=0;i<=rowcount-1;i++){
            Sensor sensor = (Sensor)applianceTable.getValueAt(i,0);
            int j = sensor.getNumberWatt()*sensor.getHours();
            piedataset.setValue(sensor.getSensorType(), j);
            
        }
            JFreeChart freechart=ChartFactory.createPieChart("Pie Chart for Carbon Monoxide Levels", piedataset, true, true, Locale.ENGLISH);
            PiePlot plot=(PiePlot)freechart.getPlot();
            ChartFrame frame=new ChartFrame("Pie Chart",freechart);
            frame.setVisible(true);
            frame.setSize(500,500);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void uplaodBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uplaodBtnActionPerformed
       
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        if(f!=null){
        path = f.getAbsolutePath();
        if(path!=null){
        attachmentpath_Txt.setText(path);
        }}
        else{
            JOptionPane.showMessageDialog(null, "File not selected", "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_uplaodBtnActionPerformed

    private void sendMailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMailBtnActionPerformed
        if(!(name_attach.getText().trim().isEmpty()||attachmentpath_Txt.getText().trim().isEmpty())){
        Person person = (Person)houseAdminComboBox.getSelectedItem(); 
        String to = person.getEmail();
            //String[] to = {"reshmi.padavala@gmail.com","naveensanaka@gmail.com"};
            sendMailToCommunityMember(to,
                    "Alert from Hospital Admin",
                    "Kindly check you account for alert details",
                    "aedtest2015@gmail.com",
                    "Jaffa@123");
        JOptionPane.showMessageDialog(null, "Mail sent to the house admin", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Upload the image and give a filename", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sendMailBtnActionPerformed

    public void sendMailToCommunityMember(String to, String subject, String message , String from, String password)
    {
        String host = "smtp.gmail.com";
        message = "Some of the appliances in your house are running inefficient." +"\n"
                + "Kindly check or replace your appliance " + "\n" + "Check the attachment for details or visit your account" ;
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
                mimeMessage.setSubject("Alert from Energy Board");
                
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(message);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(path);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(name_attach.getText()+".png");
                multipart.addBodyPart(messageBodyPart);
                mimeMessage.setContent(multipart);

                SMTPTransport transport = (SMTPTransport)session.getTransport("smtps");
                transport.connect(host,from, password);
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
                System.out.println("sent");
                transport.close();
            }catch(MessagingException me){
                
            }
    }

    public void populateAlertTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)alertDetailsTable.getModel();
        dtm.setRowCount(0);
        
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
            if(userAccount.getWorkQueue().getWorkRequestList()!=null)
            {
            Object[] row = new Object[7];
            
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getSender();
            row[3] = ((HighEnergyConsumptionWorkRequest)request).getComment();
            row[4] = request.getStatus();
            row[5] = request.getRequestDate();
            row[6] = ((HighEnergyConsumptionWorkRequest)request).getResponse();
           // row[1] = request.getStatus();
            
            dtm.addRow(row);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alertDetailsTable;
    private javax.swing.JTable applianceTable;
    private javax.swing.JTextField attachmentpath_Txt;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField commentsTxt;
    private javax.swing.JTextField energyPerDayTxt;
    private javax.swing.JTextField energyPerMonthTxt;
    private javax.swing.JTextField energyPerYearTxt;
    private javax.swing.JTextField fileNameTxt;
    private javax.swing.JComboBox houseAdminComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name_attach;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton sendAlertBtn;
    private javax.swing.JButton sendMailBtn;
    private javax.swing.JButton uplaodBtn;
    // End of variables declaration//GEN-END:variables
    String path;
}
