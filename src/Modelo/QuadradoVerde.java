/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Auxiliar.Consts;
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
        setbDestrutivel(true);
    }
    
    @Override
    public void interage(Hero h){
        
        switch(h.iIndexOfImage){
            case Consts.DOWN:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() + 1, getPosicao().getColuna()))){
                    //h.setPosicao(pPosicao);
                    this.moveDown();
                }
                break;
            case Consts.LEFT:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() - 1))){
                    //h.setPosicao(pPosicao);
                    this.moveLeft();
                }
                break;
            case Consts.UP:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() - 1, getPosicao().getColuna()))){
                    //h.setPosicao(pPosicao);
                    this.moveUp();
                }
                break;
            case Consts.RIGHT:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() + 1))){
                    //h.setPosicao(pPosicao);
                    this.moveRight();
                }
                break;
        }
    }
}
