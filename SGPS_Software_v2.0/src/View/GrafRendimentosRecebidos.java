
package View;

import ADO.Conexao;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Jay
 */
public class GrafRendimentosRecebidos extends javax.swing.JDialog {


    public GrafRendimentosRecebidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        spAno.setValue(2017);
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btListar = new javax.swing.JButton();
        cbMesInicial = new javax.swing.JComboBox<>();
        cbMesFinal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spAno = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gráfico de Rendimentos Recebidos");

        jLabel1.setText("Mês Inicial");

        jLabel2.setText("Mês Final");

        btListar.setText("Visualizar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        cbMesInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        cbMesFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel3.setText("Ano");

        spAno.setEditor(new javax.swing.JSpinner.NumberEditor(spAno, "####"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 181, Short.MAX_VALUE)
                                .addComponent(btListar))
                            .addComponent(cbMesFinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMesInicial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spAno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(spAno, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        gerarGrafico();
    }                                        

    private void gerarGrafico() {
        String mesinicio="", mesfinal="";
        switch(cbMesInicial.getSelectedItem().toString()){
            case "Janeiro":
                mesinicio="1";
                break;
            case "Fevereiro":
                mesinicio="2";
                break;
            case "Março":
                mesinicio="3";
                break;
            case "Abril":
                mesinicio="4";
                break;
            case "Maio":
                mesinicio="5";
                break;
            case "Junho":
                mesinicio="6";
                break;
            case "Julho":
                mesinicio="7";
                break;
            case "Agosto":
                mesinicio="8";
                break;
            case "Setembro":
                mesinicio="9";
                break;
            case "Outubro":
                mesinicio="10";
                break;
            case "Novembro":
                mesinicio="11";
                break;
            case "Dezembro":
                mesinicio="12";
                break;
        }
        
        switch(cbMesFinal.getSelectedItem().toString()){
            case "Janeiro":
                mesfinal="1";
                break;
            case "Fevereiro":
                mesfinal="2";
                break;
            case "Março":
                mesfinal="3";
                break;
            case "Abril":
                mesfinal="4";
                break;
            case "Maio":
                mesfinal="5";
                break;
            case "Junho":
                mesfinal="6";
                break;
            case "Julho":
                mesfinal="7";
                break;
            case "Agosto":
                mesfinal="8";
                break;
            case "Setembro":
                mesfinal="9";
                break;
            case "Outubro":
                mesfinal="10";
                break;
            case "Novembro":
                mesfinal="11";
                break;
            case "Dezembro":
                mesfinal="12";
                break;
        }
        String query = null;
        try {
query= "select servico, valorpago from\n"+
        " pagamento where idPagamento and month(datapag) between '"+mesinicio+"' and '"+mesfinal+"' and year(datapag)="+spAno.getValue()+" group by idPagamento";           

            JDBCCategoryDataset dataset;
            dataset = new JDBCCategoryDataset(Conexao.openChartConnection(), query);
JFreeChart chart = ChartFactory.createBarChart3D("Gráfico de Rendimentos Recebidos de "+cbMesInicial.getSelectedItem().toString()+" "
                    + "a "+cbMesFinal.getSelectedItem().toString()+" de "+spAno.getValue(), "Descrição do Rendimento", "Valor Total", dataset, PlotOrientation.VERTICAL, false, true, false);
            
            chart.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.GREEN);   
            chart.setBackgroundPaint(Color.WHITE);
            ChartFrame frame = new ChartFrame("Gráfico de Rendimentos Recebidos", chart);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); 
            frame.setAlwaysOnTop(true);
            frame.setVisible(true);
            this.dispose();
            
            frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                frmAdmin p = null;
                GrafRendimentosRecebidos g = new GrafRendimentosRecebidos(p, true);
                frame.dispose();
                g.setVisible(true);
            }
        });
           // System.out.println("query: " + query);
        } catch (SQLException | SecurityException e) {
           // System.out.println("query de erro: " + e.getMessage());
        }
    }

    private javax.swing.JButton btListar;
    private javax.swing.JComboBox<String> cbMesFinal;
    private javax.swing.JComboBox<String> cbMesInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner spAno;
}

