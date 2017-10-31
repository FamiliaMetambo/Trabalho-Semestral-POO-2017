package View;

import ADO.Conexao;
import Controller.CMensagensDoSistema;
import Controller.Persistencia1;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Persistencia1 p = new Persistencia1("");
    boolean op = false;

    public static Conexao cn;
    public CMensagensDoSistema msg = new CMensagensDoSistema();

    public frmLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seja Bem Vindo");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tela de Login");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Usuario");

        tfUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfUserFocusGained(evt);
            }
        });

        jLabel2.setText("Senha");

        pfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfSenhaFocusGained(evt);
            }
        });
        pfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfSenhaKeyPressed(evt);
            }
        });

        btLogin.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        btLogin.setText("Aceder");
        btLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLoginMouseClicked(evt);
            }
        });
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        JbCancelar.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        JbCancelar.setText("Cancelar");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbCancelar)
                        .addGap(24, 24, 24))
                    .addComponent(pfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(tfUser))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(JbCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pfSenha, tfUser});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void tfUserFocusGained(java.awt.event.FocusEvent evt) {                                   
        tfUser.setText("");
        pfSenha.setText("");
        tfUser.setBackground(Color.WHITE);
        pfSenha.setBackground(Color.WHITE);
    }                                  

    private void pfSenhaFocusGained(java.awt.event.FocusEvent evt) {                                    
        tfUser.setBackground(Color.WHITE);
        pfSenha.setBackground(Color.WHITE);
    }                                   

    private void pfSenhaKeyPressed(java.awt.event.KeyEvent evt) {                                   

    }                                  

    private void btLoginMouseClicked(java.awt.event.MouseEvent evt) {                                     

    }                                    

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (tfUser.getText().equalsIgnoreCase("")) {
            tfUser.setBackground(Color.YELLOW);
            pfSenha.setBackground(Color.YELLOW);
            tfUser.setText("Campo Obrigatório");
            pfSenha.setText("****");
            return;
        } else //Intrução pra o Botao Aceder 
         {
            if (evt.getSource() == btLogin) {

                String senha = new String(pfSenha.getPassword());

                //Verifica nome de usuario e a senha
                if (tfUser.getText().equalsIgnoreCase("user") && senha.equalsIgnoreCase("user")) {
                    dispose();
                    //Caso seja Usuario Caixa  chama o formulario frmFrontOffice  
                    frmFrontOffice of = new frmFrontOffice();
                    of.setVisible(true);
                } //Caso contrario Chama o formulario Administrador
                else {

                    if (evt.getSource() == btLogin) {

                        if (tfUser.getText().equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
                            dispose();
                            frmAdmin ad = new frmAdmin();
                            ad.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Usuario ou Senha incorrecto!", null, JOptionPane.ERROR_MESSAGE);
                            tfUser.setText(null);
                            pfSenha.setText(null);
                        }
                    }

                    //Instrucao do Botao para Sair
                    if (evt.getSource() == JbCancelar) {
                        System.exit(0);
                    }
                }
            }
        }
    }                                       

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int m = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do Sistema?", "SGPS Software", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (m == 1) {
        } else {
            System.exit(0);
        }
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

                  
    private javax.swing.JButton JbCancelar;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfUser;
                  

}
