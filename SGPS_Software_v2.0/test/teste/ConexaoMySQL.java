package teste;

import java.sql.*;
import javax.swing.*;

public class ConexaoMySQL {

    public static void main(String args[]) {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost/sgps";
        String usuario = "root";
        String senha = "";
        Connection conexao;
        Statement statement;
        ResultSet resultset;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "conectou legal com o MySQL");
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery("select * from pagamento");
            String lista_dados = "";
            while (resultset.next()) {
                lista_dados = lista_dados + "Codigo do cliente .: " + resultset.getInt("idPagamento");
                lista_dados = lista_dados + "\nNome do cliente .: " + resultset.getString("servico") + "\n";
            }
            JOptionPane.showMessageDialog(null, lista_dados);

        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver nÃ£o localizado: " + Driver);
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexÃ£o "
                    + "com a fonte de dados: " + Fonte);
        }

    }
}
