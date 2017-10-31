/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Jay
 */
public final class TelaMensagem extends javax.swing.JFrame {

     private final String msg;
    private final boolean sucesso;
    /**
     * Creates new form Mensagem
     */
    public TelaMensagem(String msg, boolean sucesso) {
        initComponents();
        
        this.sucesso = sucesso;
        this.msg = msg;
        mensagem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jlMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlMsg.setText("msg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMsg)
                .addContainerGap(371, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMsg)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

   

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jlMsg;
    // End of variables declaration                   

     public void mensagem() {
        if (sucesso == true) {
            jlMsg.setForeground(new Color(0, 154, 244));
        } else {
            jlMsg.setForeground(Color.red);
        }
        jlMsg.setText(this.msg);
        jlMsg.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 14));
    }
}