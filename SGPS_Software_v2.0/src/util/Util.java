package util;


import javax.swing.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import View.TelaMensagem;
import static View.frmConfigPacotes.jCServicos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static View.frmFrontOffice.cmbxServico;
import static View.frmFrontOffice.cmbxPacote;

/**
 * @author Jay
 */
public class Util {

    private String msg;
    private boolean sucesso;

    public Util() {

    }

    public Util(String msg, boolean sucesso) {
        this.msg = msg;
        this.sucesso = sucesso;
    }

    public static void mensagemA(String msg, boolean sucesso) {
        Util u = new Util(msg, sucesso);
        u.strtMensagem();
    }

    private void strtMensagem() {
        Thread mensagem = new Thread(new Util.Mensagem());
        mensagem.start();
    }

    class Mensagem implements Runnable {

        @Override
        public void run() {
          TelaMensagem m=new TelaMensagem(msg, sucesso);
          m.setVisible(true);
            while (true) {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {

                } finally {
                    m.dispose();
                }
            }
        }

    }

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
    private static NumberFormat nfVal = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public static void radioButton(JRadioButton rb[]) {
        rb[0].setSelected(true);
        ButtonGroup grupo = new ButtonGroup();

        for (int i = 0; i < rb.length; i++) {
            grupo.add(rb[i]);
        }
    }

    public static void preencheComboBox(JComboBox combobox, List<String> dados) {
        if (dados.size() < 1) {
            return;
        }
        combobox.removeAllItems();
        dados.stream().forEach((alvo) -> {
            combobox.addItem(alvo);
        });
    }

    public static void setAutoComplete(JComboBox comboBox, List<String> dados) {
        if (dados.size() < 1) {
            return;
        }
        comboBox.removeAllItems();
        comboBox.setEditable(true);
        dados.stream().forEach((alvo) -> {
            comboBox.addItem(alvo);
        });
        AutoCompleteDecorator.decorate(comboBox);
    }

    public static void showButton(JButton jbSalvar, JButton jbAtualizar, JButton jbApagar, boolean showButtonSalvar) {
        jbSalvar.setVisible(showButtonSalvar);

        if (showButtonSalvar == true) {
            jbAtualizar.setVisible(false);
            jbApagar.setVisible(false);
        } else {
            jbAtualizar.setVisible(true);
            jbApagar.setVisible(true);
        }
    }

    public static String getDate() {
        Date d = new Date();
        Locale local = new Locale("PT");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
        return sdf.format(d);
    }

    public static String formatarMoeda(double valor) {
        return nfVal.format(valor);
    }

    public static double formatarMoeda(String valor) {
        if (valor.trim().length() > 0) {
            valor = valor.replace("MZN", "");
            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");
        }
        return Double.valueOf(valor);
    }

    public static int optionDialog() {
        Object op[] = new Object[]{"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, "Tem certeza, deseja apagar?", "Apagar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
    }

    
        
    
            
}
