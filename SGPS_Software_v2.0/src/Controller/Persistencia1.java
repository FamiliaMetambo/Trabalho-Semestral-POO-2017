package Controller;

import ADO.Conexao;
import Model.Pagamento;
import View.frmFrontOffice;
import static View.frmFrontOffice.table;
import static View.frmFrontOffice.tablePag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.hibernate.Query;

public class Persistencia1 {

    private static ControllerPagamento controlePagamento;
    private Pagamento pagamento;
    public static Conexao cn;
    //Instancia a classe de mensagens do sistema.
    public CMensagensDoSistema msg = new CMensagensDoSistema();
    public String entradaID, DATABASE = "", masterUsername;

    public Persistencia1() {
        cn = new Conexao();
        cn.openConnection();
        DATABASE = cn.getDB();
    }

    public Persistencia1(String t) {
        cn = new Conexao();
        DATABASE = cn.getDB();
    }

    public boolean ActualizarCliente(String nome, String morada, String celular, String email, String tipoCliente, Date datareg, String tipodoc) {
        boolean rs = false;
        try {
            cn.startTransaction();
            Query query = cn.session.createQuery("UPDATE Cliente SET nome='" + nome + "', morada='" + morada + "',celular='" + celular + "',email='" + email + "',tipocliente='" + tipoCliente + "',datareg='" + formatDate(datareg) + "',tipodoc='" + tipodoc + "' WHERE nome='" + nome + "'");
//Query query = cn.session.createQuery("UPDATE Cliente SET morada='" + morada + "' WHERE nome='" + nome + "'");
            query.executeUpdate();
            cn.tx.commit(); // Finaliza transação 
            cn.closeSession();// Fecha sessão 
            msg.msgSucessoAtualizarUser();
        } catch (Exception e) {
            msg.msgErroAtualizarCliente();
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }

    public boolean cadastrarCliente(String nome, String morada, String celular, String email, String tipoCliente, Date datareg, String tipodoc) {
        boolean rs = false;
        try {
            cn.startTransaction();
            Query query = cn.session.createSQLQuery("INSERT INTO cliente ( nome,  morada,celular, email, tipocliente, datareg,  tipodoc) values ('" + nome + "','" + morada + "','" + celular + "','" + email + "','" + tipoCliente + "','" + formatDate(datareg) + "','" + tipodoc + "')");
            System.out.println("query: " + query);
            query.executeUpdate();
            cn.tx.commit(); // Finaliza transação 
            cn.closeSession();// Fecha sessão 
            msg.msgSucessoGravar();
        } catch (Exception e) {
            msg.msgErroGravar();
        }
        return rs;
    }

       public void update() {
        DefaultTableModel modelo = (DefaultTableModel) tablePag.getModel();
        modelo.setNumRows(0);

        for (Pagamento c : this.controlePagamento.findAll()) {

            Object[] linha = new Object[]{c.getCliente(), c.getDatapag(), c.getServico(), c.getPacote(), c.getValorpago()};
            modelo.addRow(linha);
            
        }
        this.pagamento = null;
    }
       
       
    public boolean PagarContas(String nomeCliente, String Servico, String Pacote, Date dpaga, Integer valor) {
        boolean rs = false;
        try {
            cn.startTransaction();
            Query query = cn.session.createSQLQuery("INSERT INTO pagamento ( nomeCliente,  Servico, Pacote, datapag,valorpago) values ('" + nomeCliente + "','" + Servico + "','" + Pacote + "','" + formatDate(dpaga) + "','" + valor + "')");
            System.out.println("query: " + query);
            query.executeUpdate();
            cn.tx.commit(); // Finaliza transação 
            cn.closeSession();// Fecha sessão 
            msg.msgSucessoGravar();
        } catch (Exception e) {
            msg.msgErroGravar();
        }
        return rs;
    }

 

    public boolean ApagarCliente(String nome, String morada, String celular, String email, String tipoCliente, Date datareg, String tipodoc) {
        boolean rs = false;
        try {
            cn.startTransaction();
            Query query = cn.session.createSQLQuery("DELETE FROM cliente WHERE nome='" + nome + "'");
            System.out.println("query: " + query);
            query.executeUpdate();
            cn.tx.commit(); // Finaliza transação 
            cn.closeSession();// Fecha sessão 
            msg.msgSucessoApagar();
        } catch (Exception e) {
            msg.msgErroApagar();
        }
        return rs;
    }

    public String formatDate(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date;
        String dateformat = "";
        sdf.applyPattern("yyyy-MM-dd");
        dateformat = sdf.format(data);
        return dateformat;
    }

    public void popularTabela() {
        try {
            cn.openDirectConnection();
            ResultSet rs = cn.stat.executeQuery("SELECT * from pagamento order by idPagamento");
            while (rs.next()) {
                tablePag.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            cn.closeConnection();
        }
    }

    public Object[][] pesquisar(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) tablePag.getModel();
        modelo.setNumRows(0);
        Object obj[][] = new Object[1][6];
        obj[0][0] = 0;

        try {
            cn.openDirectConnection();
            ResultSet rs = cn.stat.executeQuery("SELECT  idPagamento, nomeCliente, Servico, Pacote , datapag, valorpago from pagamento where idPagamento like '" + nome + "%'");
            cn.openDirectConnection();
            while (rs.next()) {
                obj[0][0] = rs.getInt(1);
                obj[0][1] = rs.getString(2);
                obj[0][2] = rs.getString(3);
                obj[0][3] = rs.getString(4);
                obj[0][4] = rs.getString(5);
                obj[0][5] = rs.getInt(6);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            cn.closeConnection();
        }
        return obj;
    }

    public void pesquisar2(String nome) {
        try {

            cn.openDirectConnection();
            ResultSet rs = cn.stat.executeQuery("SELECT  * from cliente where nome like '" + nome + "%'");
            while (rs.next()) {
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            cn.closeConnection();
        }
    }

//public double calculaDivida() {
//        long dias = (new Date().getTime() - datapag.getTime())/(24 * 60 * 60 *1000);
//        System.out.println(""+dias);
//        return dias > 0 ? dias * 200 : 0.0;
//    }
}
