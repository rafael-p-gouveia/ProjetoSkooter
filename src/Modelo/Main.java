package Modelo;

import Controler.Tela;
import Controler.ProxySave;
import java.util.Scanner;

//Jogo por Guilherme Cremasco Gulmini 11816077 e Rafael Pereira de Gouveia 11800820
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
            }
        });
        
        Scanner s = new Scanner(System.in);
        System.out.println("Qual será o intervalo do auto-save?\nInsira o valor em segundos: ");
        int intervalo = s.nextInt() * 1000;
        ProxySave salvamentoAutomatico = new ProxySave();
        salvamentoAutomatico.roda(intervalo);
    }
}

