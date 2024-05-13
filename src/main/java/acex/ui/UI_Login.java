package acex.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import acex.objects.Profesor;
import acex.database.DAO_Profesor;
import java.awt.Cursor;


public class UI_Login extends javax.swing.JFrame {
    
    public UI_Login() {
        initComponents();
        
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_panel = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_email_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        login_password_field = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACEX");
        setBackground(new java.awt.Color(21, 221, 21));
        setMaximumSize(new java.awt.Dimension(1019, 540));
        setMinimumSize(new java.awt.Dimension(1019, 540));
        setPreferredSize(new java.awt.Dimension(366, 314));
        setResizable(false);

        login_panel.setBackground(new java.awt.Color(255, 231, 173));
        login_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 104, 112), 4));
        login_panel.setForeground(new java.awt.Color(21, 221, 21));
        login_panel.setToolTipText("");
        login_panel.setMaximumSize(new java.awt.Dimension(360, 280));
        login_panel.setMinimumSize(new java.awt.Dimension(360, 280));
        login_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(21, 221, 21));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Iniciar Sesión en ACEX");
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(300, 40));
        login_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 260, 40));

        jLabel2.setBackground(new java.awt.Color(21, 221, 21));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Correo Electrónico:");
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 16));
        login_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 170, 20));

        login_email_field.setBackground(new java.awt.Color(255, 203, 191));
        login_email_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 118, 93), 2));
        login_email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_email_fieldActionPerformed(evt);
            }
        });
        login_panel.add(login_email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 390, 30));

        jLabel3.setBackground(new java.awt.Color(21, 221, 21));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Contraseña:");
        login_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        login_password_field.setBackground(new java.awt.Color(255, 203, 191));
        login_password_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 118, 93), 2));
        login_panel.add(login_password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 390, 30));

        jButton1.setBackground(new java.awt.Color(255, 203, 191));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar Sesión");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 118, 93), 2));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        login_panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 160, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/autobusBanner_Login.png"))); // NOI18N
        login_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Decorado2_Swing_Login.png"))); // NOI18N
        login_panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/decorado_swing_login.png"))); // NOI18N
        login_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Login_icono.png"))); // NOI18N
        login_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imgen_login.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        login_panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 0, 499, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Banner_Swing_Login.png"))); // NOI18N
        login_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 510, 110));
        login_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(login_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = login_email_field.getText();
        char[] charPassword = login_password_field.getPassword();
        String password = new String(charPassword);
        DAO_Profesor profesor = new DAO_Profesor();
        List<Profesor> profesores = profesor.consultar();

        for (Profesor p : profesores) {
            if (p.getCorreo().equals(email) && p.getPassword().equals(password)) {
                if (p.isProfesorActivo()) {
                    JOptionPane.showMessageDialog(this, "Entra en: " + p.getTipo_perfil());
                    login_panel.setVisible(false);
                    setMaximumSize(new java.awt.Dimension(1000, 1000));
                    setMinimumSize(new java.awt.Dimension(1000, 1000));
                    setPreferredSize(new java.awt.Dimension(1000, 1000));
                } else {
                    JOptionPane.showMessageDialog(this, "Este usuario está inactivo.\nPor favor, contacte con un administrador.");
                    login_password_field.setText("");
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Los datos introducidos son incorrectos.");
        login_password_field.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void login_email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_email_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_email_fieldActionPerformed

    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Login().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField login_email_field;
    private javax.swing.JDesktopPane login_panel;
    private javax.swing.JPasswordField login_password_field;
    // End of variables declaration//GEN-END:variables
}
