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
public class RoboVermelho extends ElementoDinamico {
    public RoboVermelho(Posicao umaPosicao) {
        super("r_rosa_baixo.png","r_rosa_esquerda.png","r_rosa_cima.png","r_rosa_direita.png");
        this.setPosicao(umaPosicao);
        this.bTransponivel = true;
    }
    
    public void autoDesenho() {
        Random r = new Random();
        int iDirecao = r.nextInt(4);
        switch(iDirecao) {
            case Consts.DOWN:
                this.moveDown();
                break;
            case Consts.LEFT:
                this.moveLeft();
                break;
            case Consts.UP:
                this.moveUp();
                break;
            case Consts.RIGHT:
                this.moveRight();
                break;
        }
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this))
            this.getPosicao().volta();
        super.autoDesenho();
    }
    
}
