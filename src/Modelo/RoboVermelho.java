/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Auxiliar.*;
import Controler.Tela;
import java.util.Random;

/**
 *
 * @author guigu
 */
public class RoboVermelho extends Elemento {
    public RoboVermelho(Posicao umaPosicao) {
        super("robo_rosa.jpg");
        this.setPosicao(umaPosicao);
        this.bTransponivel = false;
    }
    
    public void autoDesenho() {
        Random r = new Random();
        int iDirecao = r.nextInt(4);
        switch(iDirecao) {
            case 0:
                this.moveUp();
                break;
            case 1:
                this.moveRight();
                break;
            case 2:
                this.moveDown();
                break;
            case 3:
                this.moveLeft();
                break;
        }
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this))
            this.getPosicao().volta();
        super.autoDesenho();
    }
    
}
