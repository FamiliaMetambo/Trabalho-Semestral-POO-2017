package util;


import Model.Cliente;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Jay
 */
public class TabelaCliente extends AbstractTableModel {

    private static final int NR_COLUNAS = 7;
    private static final String[] colunasNomes = {"Nome", "Morada", "Celular", "Email", "Tipo de Cliente","Data de Registo","Tipo de Documento"};
    private static List<Cliente> list;
    private final Class<?>[] colunaTipos = {String.class, String.class, String.class, String.class, String.class,Date.class,String.class};

    public TabelaCliente(List<Cliente> list) {
        TabelaCliente.list = list;
    }

    public static Cliente getLivroAt(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return NR_COLUNAS;
    }

    @Override
    public String getColumnName(int column) {
        return colunasNomes[column];
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        return colunaTipos[coluna];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getNome();
            case 1:
                return c.getMorada();
            case 2:
                return c.getCelular();
            case 3:
                return c.getEmail();
            case 4:
                return c.getTipocliente();
            case 5:
                return c.getDatareg();
            case 6:
                return c.getTipodoc();
        }
        return null;
    }
}

