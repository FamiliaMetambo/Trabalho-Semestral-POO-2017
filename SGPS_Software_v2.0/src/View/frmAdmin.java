package View;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay
 */
public class frmAdmin extends javax.swing.JFrame {

    /**
     * Método que cria um novo form PainelPrincipal
     */
    public frmAdmin() {
        initComponents();
        ImageIcon imagemTituloJanela = new ImageIcon("/View/img/car.ico");
        this.setIconImage(imagemTituloJanela.getImage());
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jXStatusBar1 = new org.jdesktop.swingx.JXStatusBar();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        lbBD = new org.jdesktop.swingx.JXLabel();
        lbUtilizador = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        btFactura = new org.jdesktop.swingx.JXButton();
        btOcupacao = new org.jdesktop.swingx.JXButton();
        jLabel1 = new javax.swing.JLabel();
        btPagamento = new org.jdesktop.swingx.JXButton();
        btOcupacao1 = new org.jdesktop.swingx.JXButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAplicacao = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMIPassword = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMISair = new javax.swing.JMenuItem();
        jMGestaoClientes = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMIFactura = new javax.swing.JMenuItem();
        jMIRecibo = new javax.swing.JMenuItem();
        jMRelatorios = new javax.swing.JMenu();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMIRPagamento = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMFerramentas = new javax.swing.JMenu();
        jMISectores = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMIConfigParqueamento = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMAbout = new javax.swing.JMenu();
        jMIAutor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPS - Sistema de Gestão de  Pagamentos de Serviços");
        setBackground(new java.awt.Color(68, 68, 68));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 102));

        jXStatusBar1.setForeground(new java.awt.Color(0, 153, 153));

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel1.setLabelFor(jXStatusBar1);
        jXLabel1.setText("SGPS Software v1.0");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXStatusBar1.add(jXLabel1);

        lbBD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbBD.setLabelFor(jXStatusBar1);
        lbBD.setText("Base de Dados: SGPS");
        lbBD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXStatusBar1.add(lbBD);

        lbUtilizador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUtilizador.setLabelFor(jXStatusBar1);
        lbUtilizador.setText("Utilizador: Admin");
        lbUtilizador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXStatusBar1.add(lbUtilizador);

        jXPanel1.setBackground(java.awt.SystemColor.controlLtHighlight);
        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atalhos"));

        btFactura.setBackground(java.awt.SystemColor.text);
        btFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/documents12.png"))); // NOI18N
        btFactura.setText("Facturas");

        btOcupacao.setBackground(java.awt.SystemColor.controlLtHighlight);
        btOcupacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btOcupacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/hand32.png"))); // NOI18N
        btOcupacao.setText("Serviços");
        btOcupacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOcupacaoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 11)); // NOI18N
        jLabel1.setText("Ferramentas");

        btPagamento.setBackground(java.awt.SystemColor.controlLtHighlight);
        btPagamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/businessman32.png"))); // NOI18N
        btPagamento.setText("Pagamentos");
        btPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagamentoActionPerformed(evt);
            }
        });

        btOcupacao1.setBackground(java.awt.SystemColor.controlLtHighlight);
        btOcupacao1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btOcupacao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/add32.png"))); // NOI18N
        btOcupacao1.setText("Pacotes");
        btOcupacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOcupacao1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 11)); // NOI18N
        jLabel2.setText("Relatórios");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btOcupacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
            .addComponent(btOcupacao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addComponent(btFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOcupacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jXStatusBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jXPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXStatusBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXStatusBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMAplicacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/realestate16.png"))); // NOI18N
        jMAplicacao.setText("Aplicação");
        jMAplicacao.add(jSeparator3);

        jMIPassword.setText("Mudar Password");
        jMIPassword.setName("smPassword"); // NOI18N
        jMIPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPasswordActionPerformed(evt);
            }
        });
        jMAplicacao.add(jMIPassword);
        jMIPassword.getAccessibleContext().setAccessibleName("smPassword");

        jMenuItem2.setText("Actualizar dados do Utilizador");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMAplicacao.add(jMenuItem2);
        jMAplicacao.add(jSeparator9);

        jMISair.setText("Sair do Sistema");
        jMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISairActionPerformed(evt);
            }
        });
        jMAplicacao.add(jMISair);

        jMenuBar1.add(jMAplicacao);

        jMGestaoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/butler.png"))); // NOI18N
        jMGestaoClientes.setText("Gestão de Finanças");
        jMGestaoClientes.add(jSeparator1);

        jMIFactura.setText("Recargas");
        jMGestaoClientes.add(jMIFactura);

        jMIRecibo.setText("Recibos de Clientes");
        jMGestaoClientes.add(jMIRecibo);

        jMenuBar1.add(jMGestaoClientes);

        jMRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/tasks16.png"))); // NOI18N
        jMRelatorios.setText("Relatórios");
        jMRelatorios.add(jSeparator8);

        jMIRPagamento.setText("Relatório de Pagamentos");
        jMIRPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRPagamentoActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMIRPagamento);

        jMenuItem4.setText("Gráfico de Rendimentos Recebidos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem4);
        jMRelatorios.add(jSeparator2);

        jMenuBar1.add(jMRelatorios);

        jMFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/settings16.png"))); // NOI18N
        jMFerramentas.setText("Ferramentas");

        jMISectores.setText("Usuarios");
        jMISectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISectoresActionPerformed(evt);
            }
        });
        jMFerramentas.add(jMISectores);
        jMFerramentas.add(jSeparator4);

        jMIConfigParqueamento.setText("Configuração de Serviços");
        jMIConfigParqueamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIConfigParqueamentoActionPerformed(evt);
            }
        });
        jMFerramentas.add(jMIConfigParqueamento);

        jMenuItem1.setText("Configuração de Pacotes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMFerramentas.add(jMenuItem1);
        jMFerramentas.add(jSeparator5);

        jMenuBar1.add(jMFerramentas);

        jMAbout.setText("Ajuda");

        jMIAutor.setText("Sobre o Sistema");
        jMIAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAutorActionPerformed(evt);
            }
        });
        jMAbout.add(jMIAutor);

        jMenuBar1.add(jMAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>                        

    private void jMISairActionPerformed(java.awt.event.ActionEvent evt) {                                        

        int m = JOptionPane.showConfirmDialog(this, "Deseja Realmente Sair do Sistema?", "SGPS Software", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (m == 1) {
        } else {
            dispose();
            frmLogin p = new frmLogin();
                     p.setVisible(true);
        }
    }                                       

    // Tela de configuracao de Servico
    private void jMIConfigParqueamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        frmConfigServicos Sv = new frmConfigServicos();
                          Sv.setVisible(true);
    }                                                     
 
    // Tela dos graficos de rendimento
    private void btPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        GrafRendimentosRecebidos g = new GrafRendimentosRecebidos(this, true);
                                 g.setVisible(true);
    }                                           

    private void btOcupacaoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        frmConfigServicos serv = new frmConfigServicos();
                          serv.setVisible(true);

    }                                          

    // Tela de configuracao de Pacotes
    private void btOcupacao1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        frmConfigPacotes pt = new frmConfigPacotes();
                         pt.setVisible(true);
    }                                           

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        frmConfigPacotes pt = new frmConfigPacotes();
                         pt.setVisible(true);
    }                                          

    private void jMIPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                            

    }                                           

    // Tela  do sobre Autor ou Ajuda
    private void jMIAutorActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Author a = new Author(this, true);
               a.setVisible(true);
    }                                        

    //Tela de  criacao de Usuario
    private void jMISectoresActionPerformed(java.awt.event.ActionEvent evt) {                                            
                   frmUser f = new frmUser(this, true);
                           f.setVisible(true);
    }                                           

      // Tela dos graficos de rendimento
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        GrafRendimentosRecebidos g = new GrafRendimentosRecebidos(this, true);
                                 g.setVisible(true);
    }                                          

    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
            //
    }                                          

    private void jMIRPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
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
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Cria e exibe o form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private org.jdesktop.swingx.JXButton btFactura;
    private org.jdesktop.swingx.JXButton btOcupacao;
    private org.jdesktop.swingx.JXButton btOcupacao1;
    private org.jdesktop.swingx.JXButton btPagamento;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMAbout;
    private javax.swing.JMenu jMAplicacao;
    private javax.swing.JMenu jMFerramentas;
    private javax.swing.JMenu jMGestaoClientes;
    private javax.swing.JMenuItem jMIAutor;
    private javax.swing.JMenuItem jMIConfigParqueamento;
    private javax.swing.JMenuItem jMIFactura;
    private javax.swing.JMenuItem jMIPassword;
    private javax.swing.JMenuItem jMIRPagamento;
    private javax.swing.JMenuItem jMIRecibo;
    private javax.swing.JMenuItem jMISair;
    private javax.swing.JMenuItem jMISectores;
    private javax.swing.JMenu jMRelatorios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXStatusBar jXStatusBar1;
    private org.jdesktop.swingx.JXLabel lbBD;
    private org.jdesktop.swingx.JXLabel lbUtilizador;
                    
}
