package Controller;

import java.awt.event.KeyEvent;

/**
 *
 * @author Cleu1
 */
public class Validacoes {

    public int contador = 0;

    /**
     * Garante que um determinado campo contenha apenas letras do alfabeto
     *
     * @param evt
     */
    public void So_letras(java.awt.event.KeyEvent evt) {
        char input = evt.getKeyChar();
        if ((input < 'a' || input > 'z') && (input < 'A' || input > 'Z') && !(input == ' ')) {
            evt.consume();
        }

    }

    /**
     * Garante que um determinado campo contenha apenas numeros
     *
     * @param evt
     */
    public void So_Nrs(java.awt.event.KeyEvent evt) {
        char input = evt.getKeyChar();
//        if (contador < 9) {
            if (!(Character.isDigit(input))) 
                evt.consume();
//            }else
//            contador++;
//        }else
//            evt.consume();

    }

    public void Email(java.awt.event.KeyEvent evt) {
        char input = evt.getKeyChar();
        if ((input < 'a' || input > 'z') && (input < 'A' || input > 'Z') && !(input == '@') && !(input == '.') && !(input == '_')) {
            evt.consume();
        }

    }

}
