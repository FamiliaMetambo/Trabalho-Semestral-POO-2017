package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import View.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factura {

    static Statement stm;
    static Connection con = null;
    static ResultSet rs;
    static Conexao_BancoDeDados con_pag;

    public static void main(String[] args) throws Exception {
        Document doc = null;
        OutputStream os = null;

        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 30, 30, 50, 20);
            //cria a stream de saÃ­da
            os = new FileOutputStream("PagamentoServico.pdf");
            try {
                //associa a stream de saÃ­da ao 
                PdfWriter.getInstance(doc, os);

                //abre o documento
                doc.open();
                Paragraph p = new Paragraph("Factura");
                p.setAlignment(Element.ALIGN_TOP);
                doc.add(p);
                //adiciona o texto ao PDF
                PdfPTable tabela = new PdfPTable(6);

//          Criacao dos campos na Factura 
                tabela.addCell("Cod.Pag");
                tabela.addCell("Nome");
                tabela.addCell("Servico");
                tabela.addCell("Pacote");
                tabela.addCell("Data");
                tabela.addCell("Total ");

                con_pag = new Conexao_BancoDeDados();
                con_pag.conecta();
                stm = con_pag.con.createStatement();
                rs = stm.executeQuery("SELECT * FROM pagamento ORDER BY idPagamento desc limit 1");

                while (rs.next()) {
                    tabela.addCell(rs.getString("idPagamento"));
                    tabela.addCell(rs.getString("cliente_idCliente"));
                    tabela.addCell(rs.getString("Servico"));
                    tabela.addCell(rs.getString("Pacote"));
                    tabela.addCell(rs.getString("datapag"));
                    tabela.addCell(rs.getString("valorpago"));
                }

                doc.add(tabela);

            } catch (DocumentException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
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
}
