package acex.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import acex.objects.Profesor;
import acex.database.DAO_Profesor;


public class UI_Login extends javax.swing.JFrame {
    
    public UI_Login() {
        initComponents();
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
        profesor_panel = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        login_panel.setMaximumSize(new java.awt.Dimension(360, 280));
        login_panel.setMinimumSize(new java.awt.Dimension(360, 280));
        login_panel.setPreferredSize(new java.awt.Dimension(360, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Iniciar Sesión en ACEX");

        jLabel2.setText("Correo Electrónico:");

        jLabel3.setText("Contraseña:");

        jButton1.setText("Iniciar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        login_panel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        login_panel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        login_panel.setLayer(login_email_field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        login_panel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        login_panel.setLayer(login_password_field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        login_panel.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout login_panelLayout = new javax.swing.GroupLayout(login_panel);
        login_panel.setLayout(login_panelLayout);
        login_panelLayout.setHorizontalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(login_password_field, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(login_email_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        login_panelLayout.setVerticalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACEX");
        setMaximumSize(new java.awt.Dimension(370, 318));
        setMinimumSize(new java.awt.Dimension(370, 318));
        setPreferredSize(new java.awt.Dimension(370, 318));
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Solicitar", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Visaulizar", jPanel2);

        profesor_panel.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout profesor_panelLayout = new javax.swing.GroupLayout(profesor_panel);
        profesor_panel.setLayout(profesor_panelLayout);
        profesor_panelLayout.setHorizontalGroup(
            profesor_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        profesor_panelLayout.setVerticalGroup(
            profesor_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profesor_panelLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profesor_panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profesor_panel)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = login_email_field.getText();
        char[] charPassword = login_password_field.getPassword();
        String password = new String(charPassword);
        DAO_Profesor profesor = new DAO_Profesor();
        List<Profesor> profesores = profesor.getAll();
                    
        for (Profesor p : profesores) {
            if (p.getEmail().equals(email) && p.getPassword().equals(password)) {
                if (p.isActivo()) {
                    JOptionPane.showMessageDialog(this, "Entra en: " + p.getPerfil());
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField login_email_field;
    private javax.swing.JDesktopPane login_panel;
    private javax.swing.JPasswordField login_password_field;
    private javax.swing.JDesktopPane profesor_panel;
    // End of variables declaration//GEN-END:variables
}
