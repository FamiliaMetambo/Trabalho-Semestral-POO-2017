package View;

/**
 *
 * @author Jay
 * @author Gomez
 */
public class GrafRendimentos extends java.awt.Dialog {

    /**
     * Creates new form GrafRendimentos
     */
    public GrafRendimentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        pack();
    }// </editor-fold>   
    
    
    
    
    private void closeDialog(java.awt.event.WindowEvent evt) {                             
        setVisible(false);
        dispose();
    }                            

}
