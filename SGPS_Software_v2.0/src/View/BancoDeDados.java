package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jay
 * @author Gomez
 */
public class BancoDeDados {

      static String DB = "sgps", USER = "root", PASS = "";
    static public Statement stat;
    static Connection con = null;

    public void conecta() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + DB, USER, PASS);
            stat = con.createStatement();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

}
