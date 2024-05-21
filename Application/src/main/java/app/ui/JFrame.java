package app.ui;

import app.database.*;
import app.enums.*;
import app.objects.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JFrame extends javax.swing.JFrame {

    private int activityId;
    private Obj_Profesor currentUser;
    private Map<Integer, Integer> activitiesMap = new HashMap<>();

    public JFrame() {
        initComponents();
        initComponentsEx();
        activityId = 0;
        currentUser = null;
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new JFrame().setVisible(true);
        });
    }

    private void initComponentsEx() {
        showPanel(jPanel1);

        setMaximumSize(new java.awt.Dimension(750, 516));
        setMinimumSize(new java.awt.Dimension(750, 516));
        setPreferredSize(new java.awt.Dimension(750, 516));
    }

    private void showPanel(JPanel panelToShow) {
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);

        panelToShow.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField4 = new javax.swing.JPasswordField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        datePicker1 = new raven.datetime.component.date.DatePicker();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACEX v1.5");
        setMaximumSize(new java.awt.Dimension(750, 516));
        setMinimumSize(new java.awt.Dimension(750, 516));
        setPreferredSize(new java.awt.Dimension(750, 516));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(39, 39, 39));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 260));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Iniciar Sesión");

        jLabel2.setText("Correo Electrónico:");

        jTextField1.setBackground(new java.awt.Color(30, 30, 30));
        jTextField1.setToolTipText("Introduzca su correo electrónico");

        jLabel3.setText("Contraseña:");

        jPasswordField1.setBackground(new java.awt.Color(30, 30, 30));
        jPasswordField1.setToolTipText("Introduzca su contraseña");

        jButton1.setText("Login");
        jButton1.setToolTipText("Iniciar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );

        jPanel2.setBackground(new java.awt.Color(39, 39, 39));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Actividades Solicitadas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Inicio", "Fin", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(39, 39, 39));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jButton2.setToolTipText("Actualizar tabla de actividades solicitadas");
        jButton2.setMargin(new java.awt.Insets(4, 13, 3, 14));
        jButton2.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(39, 39, 39));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/account.png"))); // NOI18N
        jButton3.setToolTipText("Modificar datos personales");
        jButton3.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton3.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(39, 39, 39));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jButton4.setToolTipText("Cerrar sesión");
        jButton4.setMargin(new java.awt.Insets(4, 15, 3, 14));
        jButton4.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cargar .CSV");
        jButton5.setToolTipText("Cargar archivos .csv a la base de datos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Nueva");
        jButton6.setToolTipText("Nueva solicitud");
        jButton6.setMaximumSize(new java.awt.Dimension(85, 27));
        jButton6.setMinimumSize(new java.awt.Dimension(85, 27));
        jButton6.setPreferredSize(new java.awt.Dimension(85, 27));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Modificar");
        jButton7.setToolTipText("Modificar solicitud seleccionada");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Eliminar");
        jButton8.setToolTipText("Eliminar solicitud seleccionada");
        jButton8.setMaximumSize(new java.awt.Dimension(85, 27));
        jButton8.setMinimumSize(new java.awt.Dimension(85, 27));
        jButton8.setPreferredSize(new java.awt.Dimension(85, 27));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(272, 272, 272)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(55, 55, 55))
        );

        jButton5.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBackground(new java.awt.Color(39, 39, 39));
        jPanel3.setPreferredSize(new java.awt.Dimension(508, 256));
        jPanel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Cambiar Contraseña");

        jLabel6.setText("Correo Electrónico:");

        jTextField2.setBackground(new java.awt.Color(30, 30, 30));
        jTextField2.setToolTipText("Introduzca su correo electrónico");

        jLabel7.setText("Contraseña Actual:");

        jPasswordField2.setBackground(new java.awt.Color(30, 30, 30));
        jPasswordField2.setToolTipText("Introduzca su contraseña actual");

        jLabel8.setText("Nueva Contraseña:");

        jPasswordField3.setBackground(new java.awt.Color(30, 30, 30));
        jPasswordField3.setToolTipText("Introduzca la nueva contraseña");

        jLabel9.setText("Nueva Contraseña:");

        jPasswordField4.setBackground(new java.awt.Color(30, 30, 30));
        jPasswordField4.setToolTipText("Introduzca nuevamente la nueva contraseña");

        jButton9.setText("Actualizar");
        jButton9.setToolTipText("Cambiar contraseña");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Cancelar");
        jButton10.setToolTipText("Cancelar el cambio de contraseña");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordField4)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(38, 38, 38))
        );

        jPanel4.setBackground(new java.awt.Color(39, 39, 39));
        jPanel4.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel4AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Proceso");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Información General");

        jSeparator1.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator1.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator2.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator2.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("1.  Información General");

        jLabel13.setText("Solicitante:");

        jTextField3.setBackground(new java.awt.Color(30, 30, 30));
        jTextField3.setToolTipText("Nombre y apellidos del solicitante");

        jLabel14.setText("Departamento:");

        jTextField4.setBackground(new java.awt.Color(30, 30, 30));
        jTextField4.setToolTipText("Departamento al que pertenece el solicitante");

        jLabel15.setText("Nombre Act.:");
        jLabel15.setToolTipText("");

        jTextField5.setBackground(new java.awt.Color(30, 30, 30));
        jTextField5.setToolTipText("Nombre de la actividad a realizar");

        jLabel16.setText("Comentario Act.:");

        jTextArea1.setBackground(new java.awt.Color(30, 30, 30));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Comentario de la actividad a realizar");
        jScrollPane2.setViewportView(jTextArea1);

        jCheckBox1.setText("Actividad prevista en la programación del curso");
        jCheckBox1.setToolTipText("Habilitar/Deshabilitar");

        jButton11.setText("< Anterior");
        jButton11.setToolTipText("Página previa");
        jButton11.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton11.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton11.setPreferredSize(new java.awt.Dimension(94, 27));

        jButton12.setText("Siguiente >");
        jButton12.setToolTipText("Página siguiente");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Finalizar");
        jButton13.setToolTipText("Finalizar solicitud");
        jButton13.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton13.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton13.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton14.setText("Cancelar");
        jButton14.setToolTipText("Cancelar solicitud");
        jButton14.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton14.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton14.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel67.setText("Tipo Act.;");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Extraescolar", "Complementaria" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solicitada", "Aceptada", "Denegada", "Realizada" }));
        jComboBox2.setToolTipText("Estado de la actividad");

        jLabel68.setText("Estado Act.:");

        jLabel69.setText("Comentario Estado:");

        jTextField6.setToolTipText("Comentario del estado de la actividad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel69))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2))
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(48, 48, 48))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jPanel5.setBackground(new java.awt.Color(39, 39, 39));
        jPanel5.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel5AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Proceso");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Fecha y Hora");

        jSeparator3.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator3.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator4.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator4.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel19.setText("1.  Información General");

        jLabel20.setText("-");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("2.  Fecha y Hora");

        datePicker1.setToolTipText("Días de inicio y fin de la actividad");
        datePicker1.setDateSelectionMode(raven.datetime.component.date.DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);

        jFormattedTextField1.setBackground(new java.awt.Color(30, 30, 30));
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setToolTipText("Hora de inicio de la actividad");

        jFormattedTextField2.setBackground(new java.awt.Color(30, 30, 30));
        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.setToolTipText("Hora de fin de la actividad");
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jButton15.setText("< Anterior");
        jButton15.setToolTipText("Página anterior");
        jButton15.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton15.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton15.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Siguiente >");
        jButton16.setToolTipText("Página siguiente");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Finalizar");
        jButton17.setToolTipText("Finalizar solicitud");
        jButton17.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton17.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton17.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton18.setText("Cancelar");
        jButton18.setToolTipText("Cancelar solicitud");
        jButton18.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton18.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton18.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel24))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addComponent(jLabel20)))
                                    .addGap(18, 18, 18))))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(39, 39, 39));
        jPanel6.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel6AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Proceso");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Transporte");

        jSeparator5.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator5.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator6.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator6.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel23.setText("1.  Información General");

        jLabel25.setText("2.  Fecha y Hora");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("3.  Transporte");

        jScrollPane3.setPreferredSize(new java.awt.Dimension(456, 200));

        jTable2.setBackground(new java.awt.Color(30, 30, 30));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Importe", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setToolTipText("Seleccione los transportes a utilizar en la actividad");
        jScrollPane3.setViewportView(jTable2);

        jButton19.setText("< Anterior");
        jButton19.setToolTipText("Página anterior");
        jButton19.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton19.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton19.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Siguiente >");
        jButton20.setToolTipText("Página siguiente");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Finalizar");
        jButton21.setToolTipText("Finalizar solicitud");
        jButton21.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton21.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton21.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton22.setText("Cancelar");
        jButton22.setToolTipText("Cancelar solicitud");
        jButton22.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton22.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton22.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(30, 30, 30));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton23.setToolTipText("Añadir fila");
        jButton23.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton23.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton23.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton23.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(30, 30, 30));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton24.setToolTipText("Eliminar fila seleccionada");
        jButton24.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton24.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton24.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton24.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton20)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(48, 48, 48))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(39, 39, 39));
        jPanel7.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel7AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Proceso");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Alojamiento");

        jSeparator7.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator7.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator8.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator8.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel29.setText("1.  Información General");

        jLabel30.setText("2.  Fecha y Hora");

        jLabel31.setText("3.  Transporte");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("4.  Alojamiento");

        jScrollPane4.setPreferredSize(new java.awt.Dimension(456, 200));

        jTable3.setBackground(new java.awt.Color(30, 30, 30));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Importe", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setToolTipText("Seleccione los alojamientos a reservar durante la actividad");
        jScrollPane4.setViewportView(jTable3);

        jButton25.setText("< Anterior");
        jButton25.setToolTipText("Página anterior");
        jButton25.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton25.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton25.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Siguiente >");
        jButton26.setToolTipText("Página siguiente");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Finalizar");
        jButton27.setToolTipText("Finalizar solicitud");
        jButton27.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton27.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton27.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton28.setText("Cancelar");
        jButton28.setToolTipText("Cancelar solicitud");
        jButton28.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton28.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton28.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(30, 30, 30));
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton29.setToolTipText("Añadir fila");
        jButton29.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton29.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton29.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton29.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(30, 30, 30));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton30.setToolTipText("Eliminar fila seleccionada");
        jButton30.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton30.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton30.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton30.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton26)
                        .addGap(18, 18, 18)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(48, 48, 48))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(39, 39, 39));
        jPanel8.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel8AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Proceso");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Profesores Participantes");

        jSeparator9.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator9.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator10.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator10.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel35.setText("1.  Información General");

        jLabel36.setText("2.  Fecha y Hora");

        jLabel37.setText("3.  Transporte");

        jLabel38.setText("4.  Alojamiento");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("5.  Profesores Participantes");

        jScrollPane5.setPreferredSize(new java.awt.Dimension(456, 200));

        jTable4.setBackground(new java.awt.Color(30, 30, 30));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre y Apellidos"
            }
        ));
        jTable4.setToolTipText("Seleccione los profesores que participarán en la actividad");
        jScrollPane5.setViewportView(jTable4);

        jButton31.setText("< Anterior");
        jButton31.setToolTipText("Página anterior");
        jButton31.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton31.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton31.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("Siguiente >");
        jButton32.setToolTipText("Página siguiente");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("Finalizar");
        jButton33.setToolTipText("Finalizar solicitud");
        jButton33.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton33.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton33.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton34.setText("Cancelar");
        jButton34.setToolTipText("Cancelar solicitud");
        jButton34.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton34.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton34.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(30, 30, 30));
        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton35.setToolTipText("Añadir fila");
        jButton35.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton35.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton35.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton35.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(30, 30, 30));
        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton36.setToolTipText("Eliminar fila seleccionada");
        jButton36.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton36.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton36.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton36.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton32)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(48, 48, 48))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(39, 39, 39));
        jPanel9.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel9.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel9AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Proceso");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Profesores Responsables");

        jSeparator11.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator11.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator12.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator12.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel42.setText("1.  Información General");

        jLabel43.setText("2.  Fecha y Hora");

        jLabel44.setText("3.  Transporte");

        jLabel45.setText("4.  Alojamiento");

        jLabel46.setText("5.  Profesores Participantes");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setText("6.  Profesores Responsables");

        jScrollPane6.setPreferredSize(new java.awt.Dimension(456, 200));

        jTable5.setBackground(new java.awt.Color(30, 30, 30));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre y Apellidos"
            }
        ));
        jTable5.setToolTipText("Seleccione los profesores responsables de la actividad");
        jScrollPane6.setViewportView(jTable5);

        jButton37.setText("< Anterior");
        jButton37.setToolTipText("Página anterior");
        jButton37.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton37.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton37.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setText("Siguiente >");
        jButton38.setToolTipText("Página siguiente");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Finalizar");
        jButton39.setToolTipText("Finalizar solicitud");
        jButton39.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton39.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton39.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton40.setText("Cancelar");
        jButton40.setToolTipText("Cancelar solicitud");
        jButton40.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton40.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton40.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(30, 30, 30));
        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton41.setToolTipText("Añadir fila");
        jButton41.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton41.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton41.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton41.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(30, 30, 30));
        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton42.setToolTipText("Eliminar fila seleccionada");
        jButton42.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton42.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton42.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton42.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton38)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel47))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(39, 39, 39));
        jPanel10.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel10.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel10AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setText("Proceso");
        jLabel48.setToolTipText("");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("Cursos Participantes");

        jSeparator13.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator13.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator14.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator14.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel50.setText("1.  Información General");

        jLabel51.setText("2.  Fecha y Hora");

        jLabel52.setText("3.  Transporte");

        jLabel53.setText("4.  Alojamiento");

        jLabel54.setText("5.  Profesores Participantes");

        jLabel55.setText("6.  Profesores Responsables");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setText("7.  Cursos Participantes");

        jScrollPane7.setPreferredSize(new java.awt.Dimension(456, 200));

        jTable6.setBackground(new java.awt.Color(30, 30, 30));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Alumnos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable6.setToolTipText("Seleccione los cursos que participarán en la actividad");
        jScrollPane7.setViewportView(jTable6);

        jButton43.setText("< Anterior");
        jButton43.setToolTipText("Página anterior");
        jButton43.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton43.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton43.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Siguiente >");
        jButton44.setToolTipText("Página siguiente");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Finalizar");
        jButton45.setToolTipText("Finalizar solicitud");
        jButton45.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton45.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton45.setPreferredSize(new java.awt.Dimension(86, 27));

        jButton46.setText("Cancelar");
        jButton46.setToolTipText("Cancelar solicitud");
        jButton46.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton46.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton46.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(30, 30, 30));
        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton47.setToolTipText("Añadir fila");
        jButton47.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton47.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton47.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton47.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setBackground(new java.awt.Color(30, 30, 30));
        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton48.setToolTipText("Eliminar fila seleccionada");
        jButton48.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton48.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton48.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton48.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton44)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(48, 48, 48))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(39, 39, 39));
        jPanel11.setPreferredSize(new java.awt.Dimension(750, 516));
        jPanel11.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel11AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setText("Proceso");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setText("Grupos Participantes");

        jSeparator15.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator15.setPreferredSize(new java.awt.Dimension(170, 2));

        jSeparator16.setForeground(new java.awt.Color(100, 100, 100));
        jSeparator16.setPreferredSize(new java.awt.Dimension(440, 2));

        jLabel59.setText("1.  Información General");

        jLabel60.setText("2.  Fecha y Hora");

        jLabel61.setText("3.  Transporte");

        jLabel62.setText("4.  Alojamiento");

        jLabel63.setText("5.  Profesores Participantes");

        jLabel64.setText("6.  Profesores Responsables");

        jLabel65.setText("7.  Cursos Participantes");

        jScrollPane8.setPreferredSize(new java.awt.Dimension(456, 200));

        jTable7.setBackground(new java.awt.Color(30, 30, 30));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Alumnos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable7.setToolTipText("Seleccione los grupos que participarán en la actividad");
        jScrollPane8.setViewportView(jTable7);

        jButton49.setText("< Anterior");
        jButton49.setToolTipText("Página anterior");
        jButton49.setMaximumSize(new java.awt.Dimension(94, 27));
        jButton49.setMinimumSize(new java.awt.Dimension(94, 27));
        jButton49.setPreferredSize(new java.awt.Dimension(94, 27));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setText("Siguiente >");
        jButton50.setToolTipText("Página siguiente");

        jButton51.setText("Finalizar");
        jButton51.setToolTipText("Finalizar solicitud");
        jButton51.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton51.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton51.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton52.setText("Cancelar");
        jButton52.setToolTipText("Cancelar solicitud");
        jButton52.setMaximumSize(new java.awt.Dimension(86, 27));
        jButton52.setMinimumSize(new java.awt.Dimension(86, 27));
        jButton52.setPreferredSize(new java.awt.Dimension(86, 27));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setBackground(new java.awt.Color(30, 30, 30));
        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton53.setToolTipText("Añadir fila");
        jButton53.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton53.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton53.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton53.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(30, 30, 30));
        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton54.setToolTipText("Eliminar fila seleccionada");
        jButton54.setMargin(new java.awt.Insets(4, 14, 3, 14));
        jButton54.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton54.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton54.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setText("8.  Grupos Participantes");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton50)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(48, 48, 48))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel66))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ****************************
     */
    /**
     * ********** LOGIN ***********
     */
    /**
     * ****************************
     */
    // Validar las credenciales del usuario.
    private boolean isValidCredentials1(String email, String password) {
        try {
            DAO_Profesor daoProfesor = new DAO_Profesor();
            List<Obj_Profesor> profesores = daoProfesor.getAll();

            for (Obj_Profesor profesor : profesores) {
                if (profesor.getEmail().equalsIgnoreCase(email) && profesor.getPassword().equals(password) && profesor.isActivo()) {
                    currentUser = profesor;
                    return true;
                }
            }

            JOptionPane.showMessageDialog(this, "Las credenciales introducidas son incorrectas o el usuario está inactivo.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    // Evento: Al mostrar panel -> 1
    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        setLayout(null);
        jPanel1.setBounds(218, 100, 300, 260);
        jPanel1.putClientProperty(FlatClientProperties.STYLE, "arc: 12");

        jTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        jPasswordField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
        jPasswordField1.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true");
    }//GEN-LAST:event_jPanel1AncestorAdded

    // Evento: Al pulsar botón -> Login
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = jTextField1.getText();
        String password = new String(jPasswordField1.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isValidCredentials1(email, password)) {
            showPanel(jPanel2);
        }
        jPasswordField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * ****************************
     */
    /**
     * * ACTIVIDADES SOLICITADAS **
     */
    /**
     * ****************************
     */
    private List<Object> getActivities() {
        try {
            List<Object> approvedActivities = new ArrayList<>();

            DAO_Actividad_Aprobada daoAprobada = new DAO_Actividad_Aprobada();
            List<Obj_Actividad_Aprobada> actividadesAprobadas = daoAprobada.getAll();

            Set<Integer> activityIds = new HashSet<>();
            for (Obj_Actividad_Aprobada actividad : actividadesAprobadas) {
                activityIds.add(actividad.getId());
                if (currentUser.getPerfil() != Enum_Perfil.PROFESOR || actividad.getSolicitante().getId() == currentUser.getId()) {
                    approvedActivities.add(actividad);
                }
            }

            DAO_Actividad_Solicitada daoSolicitada = new DAO_Actividad_Solicitada();
            List<Obj_Actividad_Solicitada> actividadesSolicitadas = daoSolicitada.getAll();
            for (Obj_Actividad_Solicitada actividad : actividadesSolicitadas) {
                if (!activityIds.contains(actividad.getId()) && (currentUser.getPerfil() != Enum_Perfil.PROFESOR || actividad.getSolicitante().getId() == currentUser.getId())) {
                    approvedActivities.add(actividad);
                }
            }

            return approvedActivities;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    private void refreshTable1(List<?> actividades) {
        int rowIndex = 0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Object actividad : actividades) {
            if (actividad instanceof Obj_Actividad_Solicitada) {
                Obj_Actividad_Solicitada actividadSolicitada = (Obj_Actividad_Solicitada) actividad;

                if (currentUser.getPerfil() == Enum_Perfil.PROFESOR && currentUser.getId() != actividadSolicitada.getSolicitante().getId()) {
                    continue;
                }

                String fechaInicioFormateada = actividadSolicitada.getFechaInicio().format(dateFormatter) + " " + actividadSolicitada.getHoraInicio().format(timeFormatter);
                String fechaFinFormateada = actividadSolicitada.getFechaFin().format(dateFormatter) + " " + actividadSolicitada.getHoraFin().format(timeFormatter);

                model.addRow(new Object[]{
                    actividadSolicitada.getNombre(),
                    fechaInicioFormateada,
                    fechaFinFormateada,
                    actividadSolicitada.getEstado()
                });

                activitiesMap.put(rowIndex, actividadSolicitada.getId());
                rowIndex++;
            } else if (actividad instanceof Obj_Actividad_Aprobada) {
                Obj_Actividad_Aprobada actividadAprobada = (Obj_Actividad_Aprobada) actividad;

                String fechaInicioFormateada = actividadAprobada.getFechaInicio().format(dateFormatter) + " " + actividadAprobada.getHoraInicio().format(timeFormatter);
                String fechaFinFormateada = actividadAprobada.getFechaFin().format(dateFormatter) + " " + actividadAprobada.getHoraFin().format(timeFormatter);

                model.addRow(new Object[]{
                    actividadAprobada.getNombre(),
                    fechaInicioFormateada,
                    fechaFinFormateada,
                    actividadAprobada.getEstado()
                });

                activitiesMap.put(rowIndex, actividadAprobada.getId());
                rowIndex++;
            }
        }
    }

    private boolean isDeletable(Object actividad) {
        if (actividad instanceof Obj_Actividad_Solicitada) {
            Obj_Actividad_Solicitada actividadSolicitada = (Obj_Actividad_Solicitada) actividad;
            return actividadSolicitada.getEstado() == Enum_Estado.SOLICITADA;
        } else if (actividad instanceof Obj_Actividad_Aprobada) {
            return false;
        }
        return false;
    }

    private void deleteActivity(int actividadId) {
        try {
            DAO_Actividad_Solicitada daoActividad = new DAO_Actividad_Solicitada();
            if (daoActividad.delete(actividadId)) {
                JOptionPane.showMessageDialog(this, "Se eliminó la solicitud seleccionada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la solicitud.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Evento: Al mostrar panel -> 2
    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorAdded
        setLayout(null);
        jPanel2.setBounds(0, 0, 750, 516);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        if ((currentUser.getPerfil() == Enum_Perfil.PROFESOR) || (currentUser.getPerfil() == Enum_Perfil.GRUPO_DIRECTIVO)) {
            jButton5.setEnabled(false);
        } else {
            jButton5.setEnabled(true);
        }

        activityId = 0;
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        refreshTable1(getActivities());
    }//GEN-LAST:event_jPanel2AncestorAdded

    // Evento: Al clicar tabla -> 1
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int rowSelected = jTable1.getSelectedRow();

        if (jTable1.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione solo una actividad a la vez.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        activityId = activitiesMap.getOrDefault(rowSelected, 0);
        jButton7.setEnabled(activityId != 0);

        Object actividadSeleccionada = null;
        for (Object actividad : getActivities()) {
            if (actividad instanceof Obj_Actividad_Solicitada) {
                Obj_Actividad_Solicitada actividadSolicitada = (Obj_Actividad_Solicitada) actividad;
                if (actividadSolicitada.getId() == activityId) {
                    actividadSeleccionada = actividadSolicitada;
                    break;
                }
            } else if (actividad instanceof Obj_Actividad_Aprobada) {
                Obj_Actividad_Aprobada actividadAprobada = (Obj_Actividad_Aprobada) actividad;
                if (actividadAprobada.getId() == activityId) {
                    actividadSeleccionada = actividadAprobada;
                    break;
                }
            }
        }

        jButton8.setEnabled(actividadSeleccionada != null && isDeletable(actividadSeleccionada));
    }//GEN-LAST:event_jTable1MouseClicked

    // Evento: Al pulsar botón -> Refresh
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        activityId = 0;
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        refreshTable1(getActivities());
        JOptionPane.showMessageDialog(this, "La tabla se ha actualizado.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Evento: Al pulsar botón -> Profile
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showPanel(jPanel3);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Evento: Al pulsar botón -> Logout
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        currentUser = null;
        showPanel(jPanel1);
    }//GEN-LAST:event_jButton4ActionPerformed

    // Evento: Al pulsar botón -> Nueva
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        activityId = 0;
        showPanel(jPanel4);
    }//GEN-LAST:event_jButton6ActionPerformed

    // Evento: Al pulsar botón -> Madificar
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        showPanel(jPanel4);
        restorePanel4();
        restorePanel5();
        restoreTable2();
        restoreTable3();
        restoreTable4();
        restoreTable5();
        restoreTable6();
        restoreTable7();
    }//GEN-LAST:event_jButton7ActionPerformed

    // Evento: Al pulsar botón -> Eliminar
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        deleteActivity(activityId);
        activityId = 0;
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        refreshTable1(getActivities());
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * ****************************
     */
    /**
     * *** CAMBIAR CONTRASEÑA ****
     */
    /**
     * ****************************
     */
    // Valida las credenciales del usuario.
    private boolean isValidCredentials2(String password, String newPassword1, String newPassword2) {
        if (!newPassword1.equals(newPassword2)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas nuevas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!newPassword1.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
            JOptionPane.showMessageDialog(this, "La nueva contraseña debe tener al menos 8 caracteres incluyendo letras y números.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (currentUser != null && currentUser.getPassword().equals(password)) {
            currentUser.setPassword(newPassword1);

            try {
                DAO_Profesor daoProfesor = new DAO_Profesor();
                daoProfesor.update(currentUser);
                JOptionPane.showMessageDialog(this, "La contraseña ha sido cambiada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Las credenciales introducidas son incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Evento: Al mostrar panel -> 3
    private void jPanel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel3AncestorAdded
        setLayout(null);
        jPanel3.setBounds(113, 85, 508, 256);
        jPanel3.putClientProperty(FlatClientProperties.STYLE, "arc: 12");

        jTextField2.setEditable(false);
        jTextField2.setText(currentUser.getEmail());
        jPasswordField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña Actual");
        jPasswordField2.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true");
        jPasswordField3.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nueva contraseña");
        jPasswordField3.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true");
        jPasswordField4.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nueva contraseña");
        jPasswordField4.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true");
    }//GEN-LAST:event_jPanel3AncestorAdded

    // Evento: Al pulsar botón -> Actualizar
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String password = new String(jPasswordField2.getPassword());
        String newPassword1 = new String(jPasswordField3.getPassword());
        String newPassword2 = new String(jPasswordField4.getPassword());

        if (password.isEmpty() || newPassword1.isEmpty() || newPassword2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isValidCredentials2(password, newPassword1, newPassword2)) {
            showPanel(jPanel2);
        }
        jPasswordField2.setText("");
        jPasswordField3.setText("");
        jPasswordField4.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        showPanel(jPanel2);
        jPasswordField2.setText("");
        jPasswordField3.setText("");
        jPasswordField4.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * ****************************
     */
    /**
     * **** SUBIR ARCHIVO CSV *****
     */
    /**
     * ****************************
     */
    private boolean isValidCSVFile(String path) throws IOException {
        int index = 1;
        String line;
        DAO_Profesor daoProfesor = new DAO_Profesor();
        DAO_Departamento daoDepartamento = new DAO_Departamento();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine();

            if (!path.contains("profesores")) {
                return false;
            }

            List<Obj_Profesor> existingProfessors = daoProfesor.getAll();
            for (Obj_Profesor existingProf : existingProfessors) {
                existingProf.setActivo(false);
                daoProfesor.update(existingProf);
            }

            while ((line = reader.readLine()) != null) {
                String[] linea = line.split(",");
                if (linea.length > 1) {
                    try {
                        int departamentoId = Integer.parseInt(linea[4]);
                        Obj_Departamento departamento = daoDepartamento.getById(departamentoId);

                        if (departamento == null) {
                            continue;
                        }

                        String profesorEmail = linea[3];

                        boolean isActive = false;
                        Obj_Profesor existingProf = null;

                        for (Obj_Profesor existing : existingProfessors) {
                            if (existing.getEmail().equals(profesorEmail)) {
                                isActive = true;
                                existingProf = existing;
                                break;
                            }
                        }

                        if (isActive) {
                            existingProf.setActivo(true);
                            daoProfesor.update(existingProf);
                        } else {
                            String password = randomPassword(8);
                            Obj_Profesor profesor = new Obj_Profesor(
                                    0,
                                    departamentoId,
                                    linea[2],
                                    linea[1],
                                    linea[0],
                                    linea[3],
                                    password,
                                    Enum_Perfil.PROFESOR,
                                    true
                            );

                            profesor.setDepartamento(departamento);
                            daoProfesor.update(profesor);
                        }
                        index++;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private String randomPassword(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    // Evento: Al pulsar botón -> Cargar .CSV
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(this, """
        Tenga en cuenta que los profesores actuales pasarán a estado inactivo.
                                            
        Por favor, asegúrese de que el archivo CSV cumpla con:
         - Nombre: 'profesores.csv'.
         - Columnas: apellidos, nombre, dni, email, departamento.
         - Las columnas no necesitan coincidir exactamente.""",
                "Cargar archivo CSV", JOptionPane.INFORMATION_MESSAGE
        );

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String absolutePath = selectedFile.getAbsolutePath();

            try {
                if (isValidCSVFile(absolutePath)) {
                    JOptionPane.showMessageDialog(this, "El archivo se ha cargado satisfactoriamente a la base de datos.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo seleccionado no cumple con los requisitos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Se produjo un error al intentar leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * ****************************
     */
    /**
     * ***** NUEVA SOLICITUD ******
     */
    /**
     * ****************************
     */
    private void restorePanel4() {
        if (activityId > 0) {
            DAO_Actividad_Solicitada daoActividad = new DAO_Actividad_Solicitada();
            Obj_Actividad_Solicitada datos = daoActividad.getById(activityId);
            jLabel11.setText("Modificar Información General");
            jTextField5.setText(datos.getNombre());
            jTextArea1.setText(datos.getComentarioActividad());
            jCheckBox1.setEnabled(datos.isPrevista());
            jComboBox1.setSelectedItem(datos.getTipo());
            jComboBox2.setSelectedItem(datos.getEstado());
            jTextField6.setText(datos.getComentarioEstado());
        } else {
            jLabel11.setText("Información General");
        }
    }

    private void restorePanel5() {
        if (activityId > 0) {
            DAO_Actividad_Solicitada daoActividad = new DAO_Actividad_Solicitada();
            Obj_Actividad_Solicitada datos = daoActividad.getById(activityId);
            jLabel18.setText("Modificar Fecha y Hora");
            datePicker1.setSelectedDateRange(datos.getFechaInicio(), datos.getFechaFin());
            jFormattedTextField1.setText(datos.getHoraInicio().toString());
            jFormattedTextField2.setText(datos.getHoraFin().toString());
        } else {
            jLabel18.setText("Fecha y Hora");
        }
    }

    private void restoreTable2() {
        JComboBox<String> comboBox = new JComboBox<>();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        try {
            DAO_Transporte daoTransporte = new DAO_Transporte();
            List<Obj_Transporte> transportes = daoTransporte.getAll();

            for (Obj_Transporte transporte : transportes) {
                comboBox.addItem(transporte.getNombre());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        jTable2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        if (activityId > 0) {
            DAO_Transporte_Utilizado daoTransporte = new DAO_Transporte_Utilizado();
            List<Obj_Transporte_Utilizado> transportes = daoTransporte.getAll();
            jLabel28.setText("Modificar Transporte");

            for (Obj_Transporte_Utilizado transporte : transportes) {
                if (transporte.getActividad().getId() == activityId) {
                    model.addRow(new Object[]{transporte.getTransporte().getNombre(), transporte.getImporte(), transporte.getComentario()});
                }
            }
        } else {
            jLabel28.setText("Transporte");
        }
    }

    private void restoreTable3() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable3.getColumnCount(); i++) {
            jTable3.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

        if (activityId > 0) {
            DAO_Alojamiento_Utilizado daoAlojamiento = new DAO_Alojamiento_Utilizado();
            List<Obj_Alojamiento_Utilizado> alojamientos = daoAlojamiento.getAll();
            jLabel28.setText("Modificar Alojamiento");

            for (Obj_Alojamiento_Utilizado alojamiento : alojamientos) {
                if (alojamiento.getActividad().getId() == activityId) {
                    model.addRow(new Object[]{alojamiento.getAlojamiento().getNombre(), alojamiento.getImporte(), alojamiento.getComentario()});
                }
            }
        } else {
            jLabel28.setText("Alojamiento");
        }
    }

    private void restoreTable4() {
        JComboBox<String> comboBox = new JComboBox<>();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable4.getColumnCount(); i++) {
            jTable4.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        try {
            DAO_Profesor daoProfesor = new DAO_Profesor();
            List<Obj_Profesor> profesores = daoProfesor.getAll();

            for (Obj_Profesor profesor : profesores) {
                comboBox.addItem(profesor.getNombre() + " " + profesor.getApellidos());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        jTable4.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);

        if (activityId > 0) {
            DAO_Profesor_Participante daoProfesor = new DAO_Profesor_Participante();
            List<Obj_Profesor_Participante> profesores = daoProfesor.getAll();
            jLabel34.setText("Modificar Profesores Participantes");

            for (Obj_Profesor_Participante profesor : profesores) {
                if (profesor.getActividad().getId() == activityId) {
                    model.addRow(new Object[]{profesor.getProfesor().getNombre() + " " + profesor.getProfesor().getApellidos()});
                }
            }
        } else {
            jLabel34.setText("Profesores Participantes");
        }
    }

    private void restoreTable5() {
        JComboBox<String> comboBox = new JComboBox<>();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable5.getColumnCount(); i++) {
            jTable5.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        try {
            DAO_Profesor daoProfesor = new DAO_Profesor();
            List<Obj_Profesor> profesores = daoProfesor.getAll();

            for (Obj_Profesor profesor : profesores) {
                comboBox.addItem(profesor.getNombre() + " " + profesor.getApellidos());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        jTable5.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);

        if (activityId > 0) {
            DAO_Profesor_Responsable daoProfesor = new DAO_Profesor_Responsable();
            List<Obj_Profesor_Responsable> profesores = daoProfesor.getAll();
            jLabel41.setText("Modificar Profesores Responsables");

            for (Obj_Profesor_Responsable profesor : profesores) {
                if (profesor.getActividad().getId() == activityId) {
                    model.addRow(new Object[]{profesor.getProfesor().getNombre() + " " + profesor.getProfesor().getApellidos()});
                }
            }
        } else {
            jLabel41.setText("Profesores Responsables");
        }
    }

    private void restoreTable6() {
        JComboBox<String> comboBox = new JComboBox<>();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable6.getColumnCount(); i++) {
            jTable6.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        try {
            DAO_Curso daoCurso = new DAO_Curso();
            List<Obj_Curso> cursos = daoCurso.getAll();

            for (Obj_Curso curso : cursos) {
                comboBox.addItem(curso.getCodigo());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        jTable6.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));

        if (activityId > 0) {
            jLabel49.setText("Modificar Cursos Participantes");
        } else {
            jLabel49.setText("Cursos Participantes");
        }

        jTable6.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.setRowCount(0);

        if (activityId > 0) {
            DAO_Curso_Participante daoCurso = new DAO_Curso_Participante();
            List<Obj_Curso_Participante> cursos = daoCurso.getAll();
            jLabel49.setText("Modificar Cursos Participantes");

            for (Obj_Curso_Participante curso : cursos) {
                if (curso.getActividad().getId() == activityId) {
                    model.addRow(new Object[]{curso.getCurso().getCodigo(), curso.getNumAlumnos()});
                }
            }
        } else {
            jLabel49.setText("Cursos Participantes");
        }
    }

    private void restoreTable7() {
        JComboBox<String> comboBox = new JComboBox<>();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable7.getColumnCount(); i++) {
            jTable7.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        try {
            DAO_Grupo daoGrupo = new DAO_Grupo();
            List<Obj_Grupo> grupos = daoGrupo.getAll();

            for (Obj_Grupo grupo : grupos) {
                comboBox.addItem(grupo.getCodigo());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con el servidor.\nPor favor, inténtelo de nuevo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        jTable7.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.setRowCount(0);

        if (activityId > 0) {
            DAO_Grupo_Participante daoGrupo = new DAO_Grupo_Participante();
            List<Obj_Grupo_Participante> grupos = daoGrupo.getAll();
            jLabel58.setText("Modificar Grupos Participantes");

            for (Obj_Grupo_Participante grupo : grupos) {
                if (grupo.getActividad().getId() == activityId) {
                    model.addRow(new Object[]{grupo.getGrupo().getCodigo(), grupo.getNumAlumnos()});
                }
            }
        } else {
            jLabel58.setText("Grupos Participantes");
        }
    }

    private void clearAllInfo() {
        jTextField5.setText("");
        jTextArea1.setText("");
        jCheckBox1.setSelected(false);

        datePicker1.clearSelectedDate();
        jFormattedTextField1.setValue(null);
        jFormattedTextField2.setValue(null);

        ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
        ((DefaultTableModel) jTable3.getModel()).setRowCount(0);
        ((DefaultTableModel) jTable4.getModel()).setRowCount(0);
        ((DefaultTableModel) jTable5.getModel()).setRowCount(0);
        ((DefaultTableModel) jTable6.getModel()).setRowCount(0);
        ((DefaultTableModel) jTable7.getModel()).setRowCount(0);
    }

    private void saveAllInfo() {
        // Comprobar campos vacíos
        if (jTextField5.getText().isEmpty() || jComboBox1.getSelectedItem().toString().isEmpty() || datePicker1.getSelectedDateAsString() == null || jFormattedTextField1.getText().isEmpty() || jFormattedTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Antes de finalizar, completa todos los campos obligarios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            {
                Enum_Estado estado = null;
                estado = Enum_Estado.valueOf(jComboBox2.getSelectedItem().toString().toUpperCase());

                String comentarioEstado = "";
                String comboString = jComboBox1.getSelectedItem().toString().toUpperCase();
                Enum_Tipo tipoActividad = Enum_Tipo.valueOf(comboString);

                boolean transporte = jTable2.getRowCount() > 0;
                boolean alojamiento = jTable3.getRowCount() > 0;

                LocalDate[] fechas = datePicker1.getSelectedDateRange();
                LocalTime hora1 = obtenerHoraDesdeTextField(jFormattedTextField1);
                LocalTime hora2 = obtenerHoraDesdeTextField(jFormattedTextField2);

                int idSolicitante = 0;
                if (activityId > 0) {
                    DAO_Actividad_Solicitada daoActividad = new DAO_Actividad_Solicitada();
                    Obj_Actividad_Solicitada actividad = daoActividad.getById(activityId);
                    idSolicitante = actividad.getSolicitante().getId();
                } else {
                    idSolicitante = currentUser.getId();
                }
                DAO_Actividad_Solicitada daoActividad = new DAO_Actividad_Solicitada();
                Obj_Actividad_Solicitada actividadObj = new Obj_Actividad_Solicitada(activityId, idSolicitante, jTextField5.getText(), jTextArea1.getText(), tipoActividad, jCheckBox1.isSelected(), estado, comentarioEstado, transporte, alojamiento, hora1, hora2, fechas[0], fechas[1]);
                daoActividad.update(actividadObj);
            }

            {
                DAO_Transporte_Utilizado daoTransporteUtilizado = new DAO_Transporte_Utilizado();
                List<Obj_Transporte_Utilizado> objTransportesUtilizados = daoTransporteUtilizado.getAll();
                for (Obj_Transporte_Utilizado objTransporteUtilizado : objTransportesUtilizados) {
                    if (objTransporteUtilizado.getActividad().getId() == activityId) {
                        daoTransporteUtilizado.delete(objTransporteUtilizado.getId());
                    }
                }

                String tipo = null;
                int idTransporte = 0;
                double importe = 0;
                String comentario = null;
                DAO_Transporte daoTransporte = new DAO_Transporte();
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    tipo = (String) model.getValueAt(i, 0);
                    importe = (double) model.getValueAt(i, 1);
                    comentario = (String) model.getValueAt(i, 2);

                    List<Obj_Transporte> objTransportes = daoTransporte.getAll();
                    for (Obj_Transporte objTransporte : objTransportes) {
                        if (objTransporte.getNombre().equals(tipo)) {
                            idTransporte = objTransporte.getId();
                        }
                    }

                    Obj_Transporte_Utilizado objTransporteUtilizado = new Obj_Transporte_Utilizado(0, idTransporte, activityId, importe, comentario);
                    daoTransporteUtilizado.update(objTransporteUtilizado);
                }
            }

            {
                DAO_Alojamiento_Utilizado daoAlojamientoUtilizado = new DAO_Alojamiento_Utilizado();
                List<Obj_Alojamiento_Utilizado> objAlojamientosUtilizados = daoAlojamientoUtilizado.getAll();
                for (Obj_Alojamiento_Utilizado objAlojamientoUtilizado : objAlojamientosUtilizados) {
                    if (objAlojamientoUtilizado.getActividad().getId() == activityId && objAlojamientoUtilizado.getAlojamiento() != null) {
                        daoAlojamientoUtilizado.delete(objAlojamientoUtilizado.getId());
                    }
                }

                String nombre = null;
                int idAlojamiento = 0;
                double importe = 0;
                String comentario = null;
                boolean encontrado = false;
                DAO_Alojamiento daoAlojamiento = new DAO_Alojamiento();
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    nombre = (String) model.getValueAt(i, 0);
                    importe = (double) model.getValueAt(i, 1);
                    comentario = (String) model.getValueAt(i, 2);

                    List<Obj_Alojamiento> objAlojamientos = daoAlojamiento.getAll();
                    for (Obj_Alojamiento objAlojamiento : objAlojamientos) {
                        if (objAlojamiento.getNombre().equals(nombre)) {
                            idAlojamiento = objAlojamiento.getId();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        Obj_Alojamiento nuevoAlojamiento = new Obj_Alojamiento(0, nombre);
                        daoAlojamiento.update(nuevoAlojamiento);

                        objAlojamientos = daoAlojamiento.getAll();
                        for (Obj_Alojamiento objAlojamiento : objAlojamientos) {
                            if (objAlojamiento.getNombre().equals(nombre)) {
                                idAlojamiento = objAlojamiento.getId();
                                encontrado = true;
                            }
                        }
                    }

                    Obj_Alojamiento_Utilizado objAlojamientoUtilizado = new Obj_Alojamiento_Utilizado(0, idAlojamiento, activityId, importe, comentario);
                    daoAlojamientoUtilizado.update(objAlojamientoUtilizado);
                }
            }

            {
                DAO_Profesor_Participante daoProfesorParticipante = new DAO_Profesor_Participante();
                List<Obj_Profesor_Participante> objProfesoresParticipantes = daoProfesorParticipante.getAll();
                for (Obj_Profesor_Participante objProfesoreParticipante : objProfesoresParticipantes) {
                    if (objProfesoreParticipante.getActividad().getId() == activityId && objProfesoreParticipante.getProfesor() != null) {
                        daoProfesorParticipante.delete(objProfesoreParticipante.getId());
                    }
                }

                String nombreApellidos = null;
                int idProfesor = 0;
                DAO_Profesor daoProfesor = new DAO_Profesor();
                DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    nombreApellidos = (String) model.getValueAt(i, 0);

                    List<Obj_Profesor> objProfesores = daoProfesor.getAll();
                    for (Obj_Profesor objProfesor : objProfesores) {
                        if ((objProfesor.getNombre() + " " + objProfesor.getApellidos()).equals(nombreApellidos)) {
                            idProfesor = objProfesor.getId();
                        }
                    }

                    Obj_Profesor_Participante objProfesorParticipante = new Obj_Profesor_Participante(0, idProfesor, activityId);
                    daoProfesorParticipante.update(objProfesorParticipante);
                }
            }

            {
                DAO_Profesor_Responsable daoProfesorResponsable = new DAO_Profesor_Responsable();
                List<Obj_Profesor_Responsable> objProfesoresResponsables = daoProfesorResponsable.getAll();
                for (Obj_Profesor_Responsable objProfesorResponsable : objProfesoresResponsables) {
                    if (objProfesorResponsable.getActividad().getId() == activityId && objProfesorResponsable.getProfesor() != null) {
                        daoProfesorResponsable.delete(objProfesorResponsable.getId());
                    }
                }

                String nombreApellidos = null;
                int idProfesor = 0;
                DAO_Profesor daoProfesor = new DAO_Profesor();
                DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    nombreApellidos = (String) model.getValueAt(i, 0);

                    List<Obj_Profesor> objProfesores = daoProfesor.getAll();
                    for (Obj_Profesor objProfesor : objProfesores) {
                        if ((objProfesor.getNombre() + " " + objProfesor.getApellidos()).equals(nombreApellidos)) {
                            idProfesor = objProfesor.getId();
                        }
                    }

                    Obj_Profesor_Responsable objProfesorResponsable = new Obj_Profesor_Responsable(0, idProfesor, activityId);
                    daoProfesorResponsable.update(objProfesorResponsable);
                }
            }

            {
                DAO_Curso_Participante daoCursoParticipante = new DAO_Curso_Participante();
                List<Obj_Curso_Participante> objCursosParticipantes = daoCursoParticipante.getAll();
                for (Obj_Curso_Participante objCursoParticipante : objCursosParticipantes) {
                    if (objCursoParticipante.getActividad().getId() == activityId && objCursoParticipante.getCurso() != null) {
                        daoCursoParticipante.delete(objCursoParticipante.getId());
                    }
                }

                String codigo = null;
                int numAlumnos = 0;
                int idCurso = 0;
                DAO_Curso daoCurso = new DAO_Curso();
                DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    codigo = (String) model.getValueAt(i, 0);
                    numAlumnos = (int) model.getValueAt(i, 1);

                    List<Obj_Curso> objCursos = daoCurso.getAll();
                    for (Obj_Curso objCurso : objCursos) {
                        if (objCurso.getCodigo().equals(codigo)) {
                            idCurso = objCurso.getId();
                        }
                    }

                    Obj_Curso_Participante objCursoResponsable = new Obj_Curso_Participante(0, idCurso, activityId, numAlumnos);
                    daoCursoParticipante.update(objCursoResponsable);
                }
            }

            {
                DAO_Grupo_Participante daoGrupoParticipante = new DAO_Grupo_Participante();
                List<Obj_Grupo_Participante> objGruposParticipantes = daoGrupoParticipante.getAll();
                for (Obj_Grupo_Participante objGrupoParticipante : objGruposParticipantes) {
                    if (objGrupoParticipante.getActividad().getId() == activityId && objGrupoParticipante.getGrupo() != null) {
                        daoGrupoParticipante.delete(objGrupoParticipante.getId());
                    }
                }

                String codigo = null;
                int numAlumnos = 0;
                int idGrupo = 0;
                DAO_Grupo daoGrupo = new DAO_Grupo();
                DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    codigo = (String) model.getValueAt(i, 0);
                    numAlumnos = (int) model.getValueAt(i, 1);

                    List<Obj_Grupo> objGrupos = daoGrupo.getAll();
                    for (Obj_Grupo objGrupo : objGrupos) {
                        if (objGrupo.getCodigo().equals(codigo)) {
                            idGrupo = objGrupo.getId();
                        }
                    }

                    Obj_Grupo_Participante objGrupoResponsable = new Obj_Grupo_Participante(0, idGrupo, activityId, numAlumnos);
                    daoGrupoParticipante.update(objGrupoResponsable);
                }
            }

            if (activityId > 0) {
                JOptionPane.showMessageDialog(this, "Actividad modificada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Actividad creada con exito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            showPanel(jPanel2);
        }
    }

    private LocalTime obtenerHoraDesdeTextField(JFormattedTextField textField) {
        String horaTexto = textField.getText();
        try {
            return LocalTime.parse(horaTexto, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // Evento: Al mostrar panel -> 4
    private void jPanel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel4AncestorAdded
        setLayout(null);
        jPanel4.setBounds(0, 0, 750, 516);

        jButton11.setEnabled(false);
        jButton13.setEnabled(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);

        DAO_Actividad_Solicitada daoActividad = new DAO_Actividad_Solicitada();
        Obj_Actividad_Solicitada actividad = daoActividad.getById(activityId);

        jTextField3.setText(actividad.getSolicitante().getNombre() + " " + actividad.getSolicitante().getApellidos());
        jTextField4.setText("[" + actividad.getSolicitante().getDepartamento().getCodigo() + "] " + actividad.getSolicitante().getDepartamento().getNombre());

        jTextField5.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Asígnale un nombre a la actividad");

        if (currentUser.getPerfil() == Enum_Perfil.PROFESOR) {
            jComboBox2.setEnabled(false);
            jTextField6.setEditable(false);
        } else {
            jComboBox2.setEnabled(true);
            jTextField6.setEditable(true);
        }
    }//GEN-LAST:event_jPanel4AncestorAdded

    // Evento: Al pulsar botón -> Siguiente
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        showPanel(jPanel5);
    }//GEN-LAST:event_jButton12ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    // Evento: Al mostrar panel -> 5
    private void jPanel5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel5AncestorAdded
        setLayout(null);
        jPanel5.setBounds(0, 0, 750, 516);

        jButton17.setEnabled(false);
        jFormattedTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "08:30");
        jFormattedTextField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "18:30");
    }//GEN-LAST:event_jPanel5AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        showPanel(jPanel4);
    }//GEN-LAST:event_jButton15ActionPerformed

    // Evento: Al pulsar botón -> Siguiente
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        showPanel(jPanel6);
    }//GEN-LAST:event_jButton16ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    // Evento: Al mostrar panel -> 6
    private void jPanel6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel6AncestorAdded
        setLayout(null);
        jPanel6.setBounds(0, 0, 750, 516);
        jButton21.setEnabled(false);

    }//GEN-LAST:event_jPanel6AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        showPanel(jPanel5);
    }//GEN-LAST:event_jButton19ActionPerformed

    // Evento: Al pulsar botón -> Siguiente
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        showPanel(jPanel7);
    }//GEN-LAST:event_jButton20ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    // Evento: Al pulsar botón -> Añadir fila
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.addRow(new Object[]{"...", 0.0, null});
    }//GEN-LAST:event_jButton23ActionPerformed

    // Evento: Al pulsar botón -> Eliminar fila
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();

        if (selectedRowIndex != -1 && selectedRowIndex < model.getRowCount()) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    // Evento: Al mostrar panel -> 7
    private void jPanel7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel7AncestorAdded
        setLayout(null);
        jPanel7.setBounds(0, 0, 750, 516);
        jButton27.setEnabled(false);
    }//GEN-LAST:event_jPanel7AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        showPanel(jPanel6);
    }//GEN-LAST:event_jButton25ActionPerformed

    // Evento: Al pulsar botón -> Siguiente
    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        showPanel(jPanel8);
    }//GEN-LAST:event_jButton26ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    // Evento: Al pulsar botón -> Añadir fila
    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.addRow(new Object[]{"...", 0.0, null});
    }//GEN-LAST:event_jButton29ActionPerformed

    // Evento: Al pulsar botón -> Eliminar fila
    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int selectedRowIndex = jTable3.getSelectedRow();

        if (selectedRowIndex != -1 && selectedRowIndex < model.getRowCount()) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    // Evento: Al mostrar panel -> 8
    private void jPanel8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel8AncestorAdded
        setLayout(null);
        jPanel8.setBounds(0, 0, 750, 516);
        jButton33.setEnabled(false);
    }//GEN-LAST:event_jPanel8AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        showPanel(jPanel7);
    }//GEN-LAST:event_jButton31ActionPerformed

    // Evento: Al pulsar botón -> Siguiente
    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        showPanel(jPanel9);
    }//GEN-LAST:event_jButton32ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    // Evento: Al pulsar botón -> Añadir fila
    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.addRow(new Object[]{"..."});
    }//GEN-LAST:event_jButton35ActionPerformed

    // Evento: Al pulsar botón -> Eliminar fila
    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        int selectedRowIndex = jTable4.getSelectedRow();

        if (selectedRowIndex != -1 && selectedRowIndex < model.getRowCount()) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    // Evento: Al mostrar panel -> 9
    private void jPanel9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel9AncestorAdded
        setLayout(null);
        jPanel9.setBounds(0, 0, 750, 516);
        jButton39.setEnabled(false);
    }//GEN-LAST:event_jPanel9AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        showPanel(jPanel8);
    }//GEN-LAST:event_jButton37ActionPerformed

    // Evento: Al pulsar botón -> Siguiente
    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        showPanel(jPanel10);
    }//GEN-LAST:event_jButton38ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton40ActionPerformed

    // Evento: Al pulsar botón -> Añadir fila
    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.addRow(new Object[]{"..."});
    }//GEN-LAST:event_jButton41ActionPerformed

    // Evento: Al pulsar botón -> Eliminar fila
    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        int selectedRowIndex = jTable5.getSelectedRow();

        if (selectedRowIndex != -1 && selectedRowIndex < model.getRowCount()) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    // Evento: Al mostrar panel -> 10
    private void jPanel10AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel10AncestorAdded
        setLayout(null);
        jPanel10.setBounds(0, 0, 750, 516);
        jButton45.setEnabled(false);
    }//GEN-LAST:event_jPanel10AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        showPanel(jPanel9);
    }//GEN-LAST:event_jButton43ActionPerformed

    // Evento: Al pulsar botón -> Siguiente
    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        showPanel(jPanel11);
    }//GEN-LAST:event_jButton44ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton46ActionPerformed

    // Evento: Al pulsar botón -> Añadir fila
    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.addRow(new Object[]{"...", "0"});
    }//GEN-LAST:event_jButton47ActionPerformed

    // Evento: Al pulsar botón -> Eliminar fila
    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        int selectedRowIndex = jTable6.getSelectedRow();

        if (selectedRowIndex != -1 && selectedRowIndex < model.getRowCount()) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    // Evento: Al mostrar panel -> 11
    private void jPanel11AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel11AncestorAdded
        setLayout(null);
        jPanel11.setBounds(0, 0, 750, 516);
        jButton50.setEnabled(false);
    }//GEN-LAST:event_jPanel11AncestorAdded

    // Evento: Al pulsar botón -> Anterior
    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        showPanel(jPanel10);
    }//GEN-LAST:event_jButton49ActionPerformed

    // Evento: Al pulsar botón -> Finalizar
    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        saveAllInfo();
    }//GEN-LAST:event_jButton51ActionPerformed

    // Evento: Al pulsar botón -> Cancelar
    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro seguro de que quieres cancelar la creación de la solicitud?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            showPanel(jPanel2);
            clearAllInfo();
        }
    }//GEN-LAST:event_jButton52ActionPerformed

    // Evento: Al pulsar botón -> Añadir fila
    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.addRow(new Object[]{"...", "0"});
    }//GEN-LAST:event_jButton53ActionPerformed

    // Evento: Al pulsar botón -> Eliminar fila
    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        int selectedRowIndex = jTable7.getSelectedRow();

        if (selectedRowIndex != -1 && selectedRowIndex < model.getRowCount()) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.datetime.component.date.DatePicker datePicker1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
