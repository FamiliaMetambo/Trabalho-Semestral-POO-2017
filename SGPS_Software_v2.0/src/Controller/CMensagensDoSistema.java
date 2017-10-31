/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;


public class CMensagensDoSistema {
    // <editor-fold defaultstate="expanded" desc="Região de MENSAGENS DO SISTEMA">                          
    public final String erroGravar="Erro ao gravar os dados na Base de Dados.";
    public final String erroApagar="Erro ao apagar os dados na Base de Dados.";
    public final String alertaApagar="Deseja realmente apagar este registo?";
    public final String sucessoApagar="Registo eliminado com sucesso!";
    public final String sucessoGravar="Registo gravado com sucesso!";
    public final String sair="Deseja realmente sair do sistema?";
    public final String semDados="Registo não encontrado! Verifique se escreveu correctamente...";
    public final String copyRight="SGPS Software™";
    //</editor-fold>
    
    
    //Quando grava com sucesso os dados (porém neste caso não vamos implementar)
    public void msgSucessoGravar(){
        JOptionPane.showMessageDialog(null, sucessoGravar, copyRight,JOptionPane.INFORMATION_MESSAGE);
    }
    //Quando grava com sucesso os dados (porém neste caso não vamos implementar)
    public void msgSucessoApagar(){
        JOptionPane.showMessageDialog(null, sucessoApagar, copyRight,JOptionPane.INFORMATION_MESSAGE);
    }
    //Quando grava com sucesso os dados (porém neste caso não vamos implementar)
    public void msgSucessoActualizar(){
        JOptionPane.showMessageDialog(null, sucessoGravar, copyRight,JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    //Quando ocorre um erro ao tentar gravar dados
    public void msgErroGravar(){
        JOptionPane.showMessageDialog(null, erroGravar, copyRight, JOptionPane.ERROR_MESSAGE);
    }
    //Quando ocorre um erro ao tentar gravar dados
    public void msgErroApagar(){
        JOptionPane.showMessageDialog(null, erroApagar, copyRight, JOptionPane.ERROR_MESSAGE);
    }
    //Quando a pesquisa não retorna nenhum resultado
    public void msgSemDados(){
        JOptionPane.showMessageDialog(null, semDados, copyRight, JOptionPane.WARNING_MESSAGE);
    }
    //Quando clica no botão apagar do formulário
    public int msgAlertaApagar(){
        return JOptionPane.showConfirmDialog(null, alertaApagar, copyRight,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    //Quando introduz um email inválido
    public void msgEmailInvalido(){
        JOptionPane.showMessageDialog(null,"Email inválido. Preencha o campo corretamente",copyRight,JOptionPane.INFORMATION_MESSAGE);
    }
    public void msgSucessoAtualizarUser(){
        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", copyRight, JOptionPane.INFORMATION_MESSAGE);
    }
    public void msgErroAtualizarCliente(){
        JOptionPane.showMessageDialog(null, "Erro ao actualizar os dados!", copyRight, JOptionPane.INFORMATION_MESSAGE);
    }
}
