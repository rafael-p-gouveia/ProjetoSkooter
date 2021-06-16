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
        //bMovel = true;
        setbDestrutivel(true);
    }
    
    @Override
    public boolean interage(Hero h){
        
        switch(h.iIndexOfImage){
            case 0:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() + 1, getPosicao().getColuna()))){
                    //h.setPosicao(pPosicao);
                    this.moveDown();
                    return true;
                }
                break;
            case 1:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() - 1))){
                    //h.setPosicao(pPosicao);
                    this.moveLeft();
                    return true;
                }
                break;
            case 2:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() - 1, getPosicao().getColuna()))){
                    //h.setPosicao(pPosicao);
                    this.moveUp();
                    return true;
                    
                }
                break;
            case 3:
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() + 1))){
                    //h.setPosicao(pPosicao);
                    this.moveRight();
                    return true;
                   
                }
                break;
        }
        
        return false;
    }
    
}
