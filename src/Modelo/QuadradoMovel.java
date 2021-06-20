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
public class QuadradoMovel extends Elemento {
    
    public QuadradoMovel(Posicao umaPosicao, boolean bDestrutivel, String sPath) {
        super(sPath);
        this.setPosicao(umaPosicao);
        bTransponivel = false;
        setbDestrutivel(bDestrutivel);
    }
    
    @Override
    public void interage(Hero h){
        
        switch(h.iIndexOfImage){
            case Consts.DOWN:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() + 1, getPosicao().getColuna()))){
                    
                    this.moveDown();
                    h.moveDown();
                }
                break;
            case Consts.LEFT:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() - 1))){
                    
                    this.moveLeft();
                    h.moveLeft();
                }
                break;
            case Consts.UP:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() - 1, getPosicao().getColuna()))){
                    
                    this.moveUp();
                    h.moveUp();
                }
                break;
            case Consts.RIGHT:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() + 1))){
                    
                    this.moveRight();
                    h.moveRight();
                }
                break;
        }
    }
}
