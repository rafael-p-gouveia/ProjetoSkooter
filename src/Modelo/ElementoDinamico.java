package Modelo;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import java.io.Serializable;

public class ElementoDinamico extends Elemento implements Serializable {
    ElementoDinamico(String caminho1, String caminho2, String caminho3, String caminho4){
        super(caminho1,caminho2,caminho3,caminho4);
    }
    
    public ElementoDinamico(Posicao p){
        super(p);
    }
    
    // Métodos que movem um elemento dinâmico
    public boolean moveDown() {
        if(!this.isbAnimado()) // verificação extra para não atrapalhar a animação de personagens animados, como o Pac Man
            iIndexOfImage = Consts.DOWN;
        return this.pPosicao.moveDown();
    }
    public boolean moveLeft() {
        if(!this.isbAnimado())
            iIndexOfImage = Consts.LEFT;
        return this.pPosicao.moveLeft();
    }
    public boolean moveUp() {
        if(!this.isbAnimado())
            iIndexOfImage = Consts.UP;
        return this.pPosicao.moveUp();
    }
    public boolean moveRight() {
        if(!this.isbAnimado())
            iIndexOfImage = Consts.RIGHT;
        return this.pPosicao.moveRight();
    }
    
    // Retorna a posição que o elemento dinâmico está "olhando"
    public Posicao getPosicaoQueOlha(){
        switch (iIndexOfImage) {
            case Consts.DOWN:
                return new Posicao(getPosicao().getLinha() + 1,getPosicao().getColuna());
            case Consts.LEFT:
                return new Posicao(getPosicao().getLinha(),getPosicao().getColuna() - 1);
            case Consts.UP:
                return new Posicao(getPosicao().getLinha() - 1,getPosicao().getColuna());
            case Consts.RIGHT:
                return new Posicao(getPosicao().getLinha(),getPosicao().getColuna() + 1);
            default:
                break;
        }
         return new Posicao(0,0);
    }
}
