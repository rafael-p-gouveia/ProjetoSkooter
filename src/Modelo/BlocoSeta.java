package Modelo;

import Auxiliar.*;

public class BlocoSeta extends Elemento {
    protected int iOrientacao;
    
    public BlocoSeta(Posicao umaPosicao, int iIndiceImagem) {
        super("bloco_seta_down.png", "bloco_seta_left.png", "bloco_seta_up.png", "bloco_seta_right.png");
        this.setPosicao(umaPosicao);
        this.setImagemCorrente(iIndiceImagem);
        this.setbTransponivel(false);
        this.setbBlocoSeta(true);
        iOrientacao = iIndiceImagem;
    }
    
    // Método que faz a lógica da interação entre o herói e um bloco seta
    public void interage(Hero h) {
        switch(iOrientacao){ // Dependendo da orientação da seta, o bloco move o herói para a próxima posição válida que a seta apontar
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
