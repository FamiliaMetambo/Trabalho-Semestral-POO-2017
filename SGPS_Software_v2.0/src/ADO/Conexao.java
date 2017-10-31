package ADO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author User1
 */
public class Conexao {

    Configuration cfg;
    public Session session;
    public Transaction tx;
    public SessionFactory sf;
    static String DB = "sgps", USER = "root", PASS = "";
    static public Statement stat;
    static Connection con = null;

    public Conexao() {
    }

    public String getDB() {
        return DB;
    }

    //Metodo que abre a conexao com a base de dados
    public void openConnection() {
        cfg = new Configuration();
        cfg.configure("/hibernate.cfg.xml");
        //Cria uma fábrica de sessões.  
        //Deve existir apenas uma instância na aplicação 
        sf = cfg.buildSessionFactory();
    }

    //Comeca a transacao de dados entre o programa e a base de dados
    public void startTransaction() {
        // Abre sessão com o Hibernate 
        if (session == null) {
            session = sf.openSession();
        }
        //Cria uma transação 
        tx = session.beginTransaction();
    }

    //Termina  a sessao com a base de dados
    public void closeSession() {
        session.close(); // Fecha sessão 
        session = null;
        tx = null;
    }

    
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection openChartConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + DB, USER, PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void openDirectConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + DB, USER, PASS);
            stat = con.createStatement();
            //System.out.println(getDB());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
