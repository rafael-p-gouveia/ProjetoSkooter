/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;

/**
 *
 * @author guigu
 */
public class BlocoSeta extends Elemento {
    protected int iOrientacao;
    
    public BlocoSeta(Posicao umaPosicao, int iIndiceImagem) {
        super("bloco_seta_down.png", "bloco_seta_left.png", "bloco_seta_up.png", "bloco_seta_right.png");
        this.setPosicao(umaPosicao);
        this.setImagemCorrente(iIndiceImagem);
        iOrientacao = iIndiceImagem;
        this.setbTransponivel(false);
        this.setbBlocoSeta(true);
    }
    
    public void interage(Hero h) {
        switch(iOrientacao){
            case Consts.DOWN:
                h.moveDown();
                break;
            case Consts.LEFT:
                h.moveLeft();
                break;
            case Consts.UP:
                h.moveUp();
                break;
            case Consts.RIGHT:
                h.moveRight();
                break;
        }
    }
}
