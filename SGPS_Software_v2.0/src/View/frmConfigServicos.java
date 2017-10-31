package View;

import Controller.ControllerServico;
import Model.Servicos;
import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author Jay
 */

public class frmConfigServicos extends JFrame {

    
     private Servicos servicos;
      private final ControllerServico controllerServico;
    /**
     * Creates new form frmCliente
     */
    public frmConfigServicos() {
        initComponents();
        setLocationRelativeTo(null);
        controllerServico = new ControllerServico();
        
    }

    private Servicos salvarServicos()throws NumberFormatException {
        
        String serv=JtDesc.getText();
         if (this.servicos == null) {
            this.servicos = new Servicos(serv);
        } else {
            this.servicos.setNomeDoServico(serv);
        }
        return this.servicos;
    }
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jxBtSave = new org.jdesktop.swingx.JXButton();
        jxBtSave1 = new org.jdesktop.swingx.JXButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        JtDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Configuracao de Servicos");

        jxBtSave.setBackground(new java.awt.Color(255, 255, 255));
        jxBtSave.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.orange));
        jxBtSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/glyphicons-444-floppy-disk.png"))); // NOI18N
        jxBtSave.setToolTipText("Gravar registo...");
        jxBtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxBtSaveActionPerformed(evt);
            }
        });

        jxBtSave1.setBackground(new java.awt.Color(255, 255, 255));
        jxBtSave1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.orange));
        jxBtSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/glyphicons-436-undo.png"))); // NOI18N
        jxBtSave1.setToolTipText("Gravar registo...");
        jxBtSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxBtSave1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Principais", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jxBtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jxBtSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jxBtSave, jxBtSave1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jxBtSave, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jxBtSave1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jxBtSave, jxBtSave1});

        pack();
    }// </editor-fold>                        

    private void jxBtSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        controllerServico.save(salvarServicos());
    }                                        

    private void jxBtSave1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

                     
    private javax.swing.JTextField JtDesc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXButton jxBtSave;
    private org.jdesktop.swingx.JXButton jxBtSave1;
                    

}
