/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;

/**
 *
 * @author guigu
 */
public class QuadradoVerde extends Elemento {
    
    public QuadradoVerde(Posicao umaPosicao) {
        super("bloco_losango_verde.png");
        this.setPosicao(umaPosicao);
        bTransponivel = false;
    }
    
    @Override
    public void interage(Hero h){
        
        switch(h.iIndexOfImage){
            case 0:
                if(Desenhador.getTelaDoJogo().ehPosicaoValida(new Posicao(getPosicao().getLinha() + 1, getPosicao().getColuna()))){
                    this.moveDown();
                    h.setPosicao(pPosicao);
                }
                break;
            case 1:
                if(Desenhador.getTelaDoJogo().ehPosicaoValida(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() - 1))){
                    this.moveLeft();
                    h.setPosicao(pPosicao);
                }
                break;
            case 2:
                if(Desenhador.getTelaDoJogo().ehPosicaoValida(new Posicao(getPosicao().getLinha() - 1, getPosicao().getColuna()))){
                    this.moveUp();
                    h.setPosicao(pPosicao);
                }
                break;
            case 3:
                if(Desenhador.getTelaDoJogo().ehPosicaoValida(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() + 1))){
                    this.moveRight();
                    h.setPosicao(pPosicao);
                }
                break;
        }
        
    }
    
}
