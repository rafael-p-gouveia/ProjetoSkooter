package Modelo;

import Controler.Tela;

/**
 *
 * @author junio
 */

//Jogo por Guilherme Cremasco Gulmini 11816077 e Rafael Pereira de Gouveia 11800820
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
            }
        });
    }
}

