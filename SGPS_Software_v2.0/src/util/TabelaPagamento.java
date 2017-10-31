package util;

import Model.Pagamento;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Locale;

/**
* @author Jay
 */
public class TabelaPagamento extends AbstractTableModel {

    private static final int NR_COLUNAS = 5;
    private static final String[] colunasNomes = {"Nome", "Data de Pagamento", "Servico", "Pacote", "Valor Pago"};
    private static List<Pagamento> list;
    private final Class<?>[] colunaTipos = {String.class, Date.class, String.class, String.class, Integer.class};
    
    private static NumberFormat nfVal = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public TabelaPagamento(List<Pagamento> list) {
        TabelaPagamento.list = list;
    }

    public static Pagamento getPagamento(int index) {
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
        Pagamento c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                 return c.getCliente();
            case 1:
                return c.getDatapag();
            case 2:
                return c.getServico();
            case 3:
                return c.getPacote();
            case 4:
                return nfVal.format(c.getValorpago());
        }
        return null;
    }
}
