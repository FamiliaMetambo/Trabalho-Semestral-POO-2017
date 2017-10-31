package View;

import Controller.ControllerCliente;
import Controller.ControllerPagamento;
import Controller.Validacoes;
import Model.Cliente;
import Model.Pagamento;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import util.TabelaCliente;
import util.TabelaPagamento;
import util.Util;

/**
 *
 * @author User
 */
public final class frmFrontOffice extends javax.swing.JFrame {

    //Variaveis para gerar o pdf
    static Statement stm;
    static Connection con = null;
    static ResultSet rs;
    static BancoDeDados con_pag;

    //Metodo para listar nas Tabelas
    private List<Cliente> list;
    private List<Pagamento> list2;

    //Modelo das Tabelas
    private TabelaCliente modelTable;
    private TabelaPagamento modelTable2;

    //Instacia das Classes Modelos
    private Cliente cliente;
    private Pagamento pagamento;

    //Controladores das Classes Modelos
    private final ControllerPagamento controlePagamento;
    private final ControllerCliente controllerCliente;

    private static NumberFormat nfVal = NumberFormat.getCurrencyInstance(Locale.getDefault());

    /**
     * Criar o Painel frontal
     */
    public frmFrontOffice() {
        initComponents();
        Util.showButton(jbSalvar, jbAtualizar, jbApagar, true);
        Util.showButton(jbPagar, jbAtualizarP, jbImprimirFactura, true);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Inicializacao dos Controladores
        controlePagamento = new ControllerPagamento();
        controllerCliente = new ControllerCliente();

        //Listagem dos Servicos para ComboBoxes Dependentes
        ListarServicos();

        //Actualizacao das Tabelas
        updateTableCliente();
        updateTablePag();
        updateTableCliente();

        //Metodo para preencher ComboBox dos Clientes
        Util.setAutoComplete(cmbxCliente, controllerCliente.findNames());

    }

    //Metodo para Salvar os Clientes, este metodo retorna um objecto do tipo Cliente
    private Cliente salvarCliente() throws NumberFormatException {

        
        
        String nome = jTNome.getText();
        String morada = jTMorada.getText();
        String cel = jTCelular.getText();
        String email = jTEmail.getText();
        String TCliente = jCTipoCliente.getSelectedItem() + "";
        Date dreg = jXDateReg.getDate();
        String tdoc = cmbxTipoDoc.getSelectedItem() + "";

        if (this.cliente == null) {
            this.cliente = new Cliente(nome, morada, cel, email, TCliente, dreg, tdoc);
        } else {
            this.cliente.setNome(nome);
            this.cliente.setMorada(morada);
            this.cliente.setCelular(cel);
            this.cliente.setEmail(email);
            this.cliente.setTipocliente(TCliente);
            this.cliente.setDatareg(dreg);
            this.cliente.setTipodoc(tdoc);
        }
        return this.cliente;
       
    }

    //Metodo para Pagar as Contas
    private Pagamento PagarContas() throws NumberFormatException {

        String nomeCliente = cmbxCliente.getSelectedItem() + "";
        Date dataDePagamento = jXDPagamento.getDate();
        String servico = cmbxServico.getSelectedItem() + "";
        String pacote = cmbxPacote.getSelectedItem() + "";
        int valorPago = Integer.parseInt(JtfValor.getText());

        if (this.pagamento == null) {
            this.pagamento = new Pagamento(nomeCliente, dataDePagamento, servico, pacote, valorPago);
        } else {
            this.pagamento.setCliente(nomeCliente);
            this.pagamento.setDatapag(dataDePagamento);
            this.pagamento.setServico(servico);
            this.pagamento.setPacote(pacote);
            this.pagamento.setValorpago(valorPago);
        }
        return this.pagamento;
    }

    /*
    *Metodo que efectua a busca em uma tabela filtrando os dados a cada carracter introduzido no campor de pesquisa
    *@param string
     */
    private void findText(String text) {
        TableRowSorter<TableModel> tr = new TableRowSorter<>(modelTable);
        tr.setRowFilter(RowFilter.regexFilter(text, 0, 1, 2));
        table.setRowSorter(tr);
        table.updateUI();
    }

    /*
    *Metodo que efectua a busca em uma tabela filtrando os dados a cada carracter introduzido no campor de pesquisa
    *@param string
     */
    private void findText2(String text) {
        TableRowSorter<TableModel> tr = new TableRowSorter<>(modelTable2);
        tr.setRowFilter(RowFilter.regexFilter(text, 0, 1, 2));
        tablePag.setRowSorter(tr);
        tablePag.updateUI();
    }

    //Metodo que Actualiza a Tabela de Clientes
    private void updateTableCliente() {
        this.list = controllerCliente.findAll();
        modelTable = new TabelaCliente(list);
        table.setModel(new TabelaCliente(this.list));
    }

    //Metodo que Actualiza a Tabela de Pagamentos
    private void updateTablePag() {
        this.list2 = controlePagamento.findAll();
        modelTable2 = new TabelaPagamento(list2);
        tablePag.setModel(new TabelaPagamento(this.list2));
    }

    //Metodo que Limpa os Campos dos Clientes
    private void clearFields() {
        jTNome.setText("");
        jTMorada.setText("");
        jTCelular.setText("");
        jTEmail.setText("");
        jCTipoCliente.setSelectedItem("");
        cmbxTipoDoc.setSelectedItem("");
        Util.showButton(jbSalvar, jbAtualizar, jbApagar, true);

    }

    //Metodo que Limpa os Campos dos Pagamentos
    private void clearFields2() {
        cmbxCliente.setSelectedItem("");
        cmbxServico.setSelectedItem("Selecione");
        cmbxPacote.setSelectedItem("Selecione");
        JtfValor.setText("");
        Util.showButton(jbPagar, jbAtualizarP, jbImprimirFactura, true);
    }

    //Metodo que preenche os Campos do Cliente
    private void FillFields() {
        this.cliente = this.list.get(table.getSelectedRow());
        jTNome.setText(this.cliente.getNome());
        jTMorada.setText(this.cliente.getMorada());
        jTCelular.setText(this.cliente.getCelular());
        jTEmail.setText(this.cliente.getEmail());
        jCTipoCliente.setSelectedItem(this.cliente.getTipocliente());
        jXDateReg.setDate(this.cliente.getDatareg());
        cmbxTipoDoc.setSelectedItem(this.cliente.getTipodoc());
        Util.showButton(jbSalvar, jbAtualizar, jbApagar, false);
    }

    //Metodo que preenche os Campos do Pagamento
    private void FillFields2() {
        this.pagamento = this.list2.get(tablePag.getSelectedRow());
        cmbxCliente.setSelectedItem(this.pagamento.getCliente());
        jXDPagamento.setDate(this.pagamento.getDatapag());
        cmbxServico.setSelectedItem(this.pagamento.getServico());
        cmbxPacote.setSelectedItem(this.pagamento.getPacote());
        //JtfValor.setText(this.pagamento.getValorpago().toString());
        Util.showButton(jbPagar, jbAtualizarP, jbImprimirFactura, false);
    }

    //Metodo que Lista os Servicos em uma combo box
    private void ListarServicos() {
        try {
            //String com o usuario do banco de dados
            String usuario = "root";
            //String com o caminho do banco de daods
            String url = "jdbc:mysql://localhost:3306/sgps";
            //String com a senha do banco de daods
            String senha = "";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            //Query que traz os dados do banco de dados
            String sql = "SELECT * FROM servicos";

            //Prepara para executar um comando
            PreparedStatement pst = conexao.prepareStatement(sql);

            //Armazena o resultado da consulta
            ResultSet rs = pst.executeQuery();

            //Enquanto existirem dados executa o laco de repeticao
            while (rs.next()) {
                cmbxServico.addItem(String.valueOf(rs.getInt("idServicos")) + "-" + rs.getString("NomeDoServico"));
            }

        } catch (SQLException e) {
            //Rastreia o erro
            e.printStackTrace();
        }

    }

    //Metodo que Lista os Pacotes atraves do id exclusivo para ComboBoxes Dependentes
    private void ListarPacotes(String idServicos) {
        try {
            //String com o usuario do banco de dados
            String usuario = "root";
            //String com o caminho do banco de daods
            String url = "jdbc:mysql://localhost:3306/sgps";
            //String com a senha do banco de daods
            String senha = "";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            //Query que traz os dados do banco de dados
            String sql = "SELECT * FROM pacote where servicos_idServicos=?";

            //Prepara para executar um comando
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(idServicos));
            //Armazena o resultado da consulta
            ResultSet rs = pst.executeQuery();

            //Enquanto existirem dados executa o laco de repeticao
            while (rs.next()) {
                cmbxPacote.addItem(String.valueOf(rs.getInt("idPacote")) + "-" + rs.getString("NomeDoPacote"));
            }

        } catch (SQLException e) {
            //Rastreia o erro
            e.printStackTrace();
        }
    }

    //Metodo que Gera a Factura do Cliente
    public static void gerarpdf(Integer idPagamento) throws IOException, SQLException {
        Document doc = null;
        OutputStream os = null;

        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 30, 30, 50, 20);
            //cria a stream de saÃ­da
            os = new FileOutputStream("Pagamento de Servico.pdf");
            try {
                //associa a stream de saÃ­da ao 
                PdfWriter.getInstance(doc, os);

                //abre o documento
                doc.open();
                Paragraph p = new Paragraph("Factura");
                Paragraph p1 = new Paragraph("SGPS");

                p.setAlignment(Element.ALIGN_TOP);
                p1.setAlignment(Element.HEADER);
                doc.add(p);
                doc.add(p1);

                //adiciona o texto ao PDF
                PdfPTable tabela = new PdfPTable(6);

//          Criacao dos campos na Factura 
                tabela.addCell("Cod.Pag");
                tabela.addCell("Nome");
                tabela.addCell("Servico");
                tabela.addCell("Pacote");
                tabela.addCell("Data");
                tabela.addCell("Total ");

                con_pag = new BancoDeDados();
                con_pag.conecta();
                stm = con_pag.con.createStatement();
                rs = stm.executeQuery("SELECT * FROM pagamento where idPagamento='" + idPagamento + "'  ORDER BY idPagamento desc limit 1");
//                rs = stm.executeQuery("SELECT * FROM pagamento ORDER BY idPagamento desc limit 1");

                while (rs.next()) {
                    tabela.addCell(rs.getString("idPagamento"));
                    tabela.addCell(rs.getString("nomeCliente"));
                    tabela.addCell(rs.getString("Servico"));
                    tabela.addCell(rs.getString("Pacote"));
                    tabela.addCell(rs.getString("datapag"));
                    tabela.addCell(rs.getString("valorpago"));
                }

                doc.add(tabela);
                JOptionPane.showMessageDialog(null, "Factura emitida com Sucesso");

            } catch (DocumentException ex) {
                Logger.getLogger(frmFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {

            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                //fechamento da stream de saÃ­da
                os.close();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedCaixa = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTMorada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTCelular = new javax.swing.JTextField();
        jTEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbxTipoDoc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jCTipoCliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jXDateReg = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jbSalvar = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbApagar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        txtProcura1 = new org.jdesktop.swingx.JXSearchField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbxServico = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbxPacote = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbxCliente = new javax.swing.JComboBox<>();
        JtfValor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jXDPagamento = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jbPagar = new javax.swing.JButton();
        jbAtualizarP = new javax.swing.JButton();
        jbImprimirFactura = new javax.swing.JButton();
        jbCancelarP = new javax.swing.JButton();
        txtProcura = new org.jdesktop.swingx.JXSearchField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePag = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedCaixaFocusGained(evt);
            }
        });
        jTabbedCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedCaixaMouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setText("Nome");

        jLabel2.setText("Morada");

        jLabel5.setText("Celular");

        jLabel6.setText("Email");

        cmbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"B.I.", "Passaporte", "Cedula Pessoal", "Dire", "Cartao de Eleitor"}));

        jLabel7.setText("Tipo de Documento");

        jCTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Contrato Mensal", "Contrato Diario "}));

        jLabel8.setText("Tipo de Contrato");

        jLabel9.setText("Data de Registo");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTNome, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2)
                                                .addComponent(jTMorada, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addComponent(jTCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addComponent(jTEmail)
                                                .addComponent(jLabel7)
                                                .addComponent(cmbxTipoDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addComponent(jCTipoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jXDateReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel9))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{jTCelular, jTMorada, jTNome});

        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXDateReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{jTCelular, jTMorada, jTNome});

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jbSalvar.setText("Salvar");
        jbSalvar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbSalvarFocusGained(evt);
            }
        });
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Actualizar");
        jbAtualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbAtualizarFocusGained(evt);
            }
        });
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbApagar.setText("Apagar");
        jbApagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbApagarFocusGained(evt);
            }
        });
        jbApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApagarActionPerformed(evt);
            }
        });

        JbCancelar.setText("Cancelar");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        txtProcura1.setToolTipText("");
        txtProcura1.setName(""); // NOI18N
        txtProcura1.setPrompt("Pesquisar por nome");
        txtProcura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcura1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jbAtualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbApagar)
                                .addGap(18, 18, 18)
                                .addComponent(JbCancelar)
                                .addGap(10, 10, 10)
                                .addComponent(txtProcura1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{JbCancelar, jbApagar, jbAtualizar, jbSalvar});

        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbSalvar)
                                        .addComponent(jbAtualizar)
                                        .addComponent(jbApagar)
                                        .addComponent(JbCancelar)
                                        .addComponent(txtProcura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{JbCancelar, jbApagar, jbAtualizar, jbSalvar});

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome", "Morada", "Celular", "Email", "Tipo de Contrato", "Data de Registo", "Documento"
                }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setHeaderValue("Morada");
            table.getColumnModel().getColumn(2).setHeaderValue("Celular");
            table.getColumnModel().getColumn(3).setHeaderValue("Email");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        jButton5.setText("Sair do Sistema");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton5)
                                                .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedCaixa.addTab("Entrada", jPanel4);

        jPanel6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel6FocusGained(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel10.setText("Nome");

        cmbxServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxServicoItemStateChanged(evt);
            }
        });
        cmbxServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxServicoActionPerformed(evt);
            }
        });

        jLabel12.setText("Servico");

        cmbxPacote.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxPacoteItemStateChanged(evt);
            }
        });

        jLabel13.setText("Pacote");

        cmbxCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbxClienteFocusGained(evt);
            }
        });
        cmbxCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbxClienteMouseClicked(evt);
            }
        });
        cmbxCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbxClienteKeyPressed(evt);
            }
        });

        jLabel11.setText("Valor");

        jLabel3.setText("Data de Pagamento");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel10)
                                                .addComponent(cmbxServico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12)
                                                .addComponent(cmbxPacote, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13)
                                                .addComponent(cmbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JtfValor)
                                                .addComponent(jLabel11)
                                                .addComponent(jXDPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                                        .addComponent(jLabel3))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cmbxServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbxPacote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jbPagar.setText("Pagar");
        jbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarActionPerformed(evt);
            }
        });

        jbAtualizarP.setText("Actualizar");
        jbAtualizarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarPActionPerformed(evt);
            }
        });

        jbImprimirFactura.setText("Gerar Factura");
        jbImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirFacturaActionPerformed(evt);
            }
        });

        jbCancelarP.setText("Cancelar");
        jbCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarPActionPerformed(evt);
            }
        });

        txtProcura.setToolTipText("");
        txtProcura.setName(""); // NOI18N
        txtProcura.setPrompt("Pesquisar por nome");
        txtProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcuraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbPagar)
                                .addGap(18, 18, 18)
                                .addComponent(jbAtualizarP)
                                .addGap(18, 18, 18)
                                .addComponent(jbImprimirFactura)
                                .addGap(18, 18, 18)
                                .addComponent(jbCancelarP)
                                .addGap(18, 18, 18)
                                .addComponent(txtProcura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbPagar)
                                        .addComponent(jbAtualizarP)
                                        .addComponent(jbImprimirFactura)
                                        .addComponent(jbCancelarP)
                                        .addComponent(txtProcura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        txtProcura.getAccessibleContext().setAccessibleDescription("Pesquisar por nome");

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        tablePag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        tablePag.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome", "Data de Pagamento", "Servico", "Pacote", "Valor Pago"
                }
        ));
        tablePag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePagMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePag);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        jButton7.setText("Sair do Sistema");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton7)
                                                .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedCaixa.addTab("Saida", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedCaixa)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedCaixa)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTNome.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNomeKeyTyped(evt);
            }
        });

        jTCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCelularKeyTyped(evt);
            }

        });
        
        jTEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEmailKeyTyped(evt);
            }

        });
        
        JtfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtfValorKeyTyped(evt);
            }

        });


        pack();
    }// </editor-fold>                        

    private void jTabbedCaixaMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void jTabbedCaixaFocusGained(java.awt.event.FocusEvent evt) {
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja Realmente sair?", "SGPS Software", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 1) {
        }else{
            dispose();
            frmLogin p = new frmLogin();
            p.setVisible(true);
        }
    }

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTNome.getText().equals("") || jTMorada.getText().equals("")
                || jTCelular.getText().equals("") || jTEmail.getText().equals("")
                || jCTipoCliente.getSelectedItem().toString().equals("")
                || cmbxTipoDoc.getSelectedItem().toString().equals(""))
        JOptionPane.showMessageDialog(null, "Ainda ha dados por preencher");
        
        else{  
        this.controllerCliente.save(salvarCliente());
            updateTableCliente();
            Util.setAutoComplete(cmbxCliente, controllerCliente.findNames());
            clearFields();
        }
    }

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        this.controllerCliente.update(salvarCliente());
        updateTableCliente();
        clearFields();
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        FillFields();
    }

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        updateTableCliente();
        clearFields();
    }

    private void jbApagarActionPerformed(java.awt.event.ActionEvent evt) {
        int m = JOptionPane.showConfirmDialog(this, "Deseja Realmente Eliminar?", "SGPS Software", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (m == 1) {
        } else {
            this.controllerCliente.delete(salvarCliente());
            updateTableCliente();
            clearFields();
        }
    }

    private void cmbxServicoItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
    }

    private void cmbxServicoActionPerformed(java.awt.event.ActionEvent evt) {
        String dados[] = String.valueOf(cmbxServico.getSelectedItem()).split("-");
        if (!dados[0].equalsIgnoreCase("Seleciona")) {
            cmbxPacote.removeAllItems();
            cmbxPacote.addItem("Seleciona");
            ListarPacotes(dados[0]);
        }

    }

    private void cmbxPacoteItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
    }

    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {
        this.controlePagamento.save(PagarContas());
        clearFields2();
        updateTablePag();
    }

    private void jbAtualizarPActionPerformed(java.awt.event.ActionEvent evt) {
        this.controlePagamento.update(PagarContas());
        clearFields2();
        updateTablePag();
    }

    //Metod que gera factura de um dado cliente com base em uma linha selecionada na tabela
    private void jbImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {
        this.pagamento = this.list2.get(tablePag.getSelectedRow());
        try {
            gerarpdf(this.pagamento.getIdPagamento());
        } catch (IOException ex) {
            Logger.getLogger(frmFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jbCancelarPActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields2();
    }

    private void tablePagMouseClicked(java.awt.event.MouseEvent evt) {
        FillFields2();
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        frmLogin p = new frmLogin();
        p.setVisible(true);
    }

    private void cmbxClienteFocusGained(java.awt.event.FocusEvent evt) {
    }

    private void cmbxClienteMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void cmbxClienteKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void jPanel6FocusGained(java.awt.event.FocusEvent evt) {
    }

    private void jbSalvarFocusGained(java.awt.event.FocusEvent evt) {
        updateTableCliente();
    }

    private void jbAtualizarFocusGained(java.awt.event.FocusEvent evt) {
        updateTableCliente();
    }

    private void jbApagarFocusGained(java.awt.event.FocusEvent evt) {
        updateTableCliente();
    }

    private void txtProcuraActionPerformed(java.awt.event.ActionEvent evt) {
        findText2(txtProcura.getText());
    }

    private void txtProcura1ActionPerformed(java.awt.event.ActionEvent evt) {
        findText(txtProcura1.getText());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmFrontOffice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFrontOffice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFrontOffice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFrontOffice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFrontOffice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton JbCancelar;
    private javax.swing.JTextField JtfValor;
    private javax.swing.JComboBox<String> cmbxCliente;
    public static javax.swing.JComboBox<String> cmbxPacote;
    public static javax.swing.JComboBox<String> cmbxServico;
    private javax.swing.JComboBox<String> cmbxTipoDoc;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jCTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCelular;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTMorada;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTabbedPane jTabbedCaixa;
    private org.jdesktop.swingx.JXDatePicker jXDPagamento;
    private org.jdesktop.swingx.JXDatePicker jXDateReg;
    private javax.swing.JButton jbApagar;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbAtualizarP;
    private javax.swing.JButton jbCancelarP;
    private javax.swing.JButton jbImprimirFactura;
    private javax.swing.JButton jbPagar;
    private javax.swing.JButton jbSalvar;
    public static javax.swing.JTable table;
    public static javax.swing.JTable tablePag;
    private org.jdesktop.swingx.JXSearchField txtProcura;
    private org.jdesktop.swingx.JXSearchField txtProcura1;

    // End of variables declaration 
    //Instancia da classe que valida os campos 
    Validacoes validacoes = new Validacoes();

    //Metodo que valida a text field do nome
    public void jTNomeKeyTyped(java.awt.event.KeyEvent evt) {
       validacoes.So_letras(evt);
    }
    
    //Metodo que valida a text field do email
    public void jTEmailKeyTyped(java.awt.event.KeyEvent evt) {
       validacoes.Email(evt);
    }
    
    //Metodo que valida a text field do valor a pagar por determinado servico
    public void JtfValorKeyTyped(java.awt.event.KeyEvent evt) {
       validacoes.So_Nrs(evt);
    }

    //Metodo que valida a text field do contacto
    public void jTCelularKeyTyped(java.awt.event.KeyEvent evt) {
        validacoes.So_Nrs(evt);
       
    }

}
