/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.util.Random;

/**
 *
 * @author guigu
 */
public class PacMan extends ElementoDinamico {
    int iFlagSleep; // variável que ajuda na simulação da animação do Pac Man
    public PacMan() {
        super("pacman1.png", "pacman2.png", "pacman1.png", "pacman2.png");
        iFlagSleep = 0;
        this.setbTransponivel(true);
        this.setbDestrutivel(true);
        this.setbAnimado(true);
        this.setbInterativo(true);
    }
    
    public void autoDesenho() {
        Random r = new Random();
        int iDirecao = r.nextInt(6);
        if(Desenhador.getTelaDoJogo().haRobosAinda()) { // caso tenha robôs na fase, o Pac Man vai atrás deles
            int iBiasHorizontal = Desenhador.getTelaDoJogo().getUmRobo().getPosicao().direcaoRelativaHorizontal(pPosicao);
            int iBiasVertical = Desenhador.getTelaDoJogo().getUmRobo().getPosicao().direcaoRelativaVertical(pPosicao);
            
            if (iDirecao == 4){
                iDirecao = iBiasHorizontal;
            }
            if (iDirecao == 5){
                iDirecao = iBiasVertical;
            }
        }
        else {
            iDirecao = r.nextInt(4);
        }
        
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
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this)){
           this.getPosicao().volta();
        }
        
        if(Desenhador.getTelaDoJogo().getIndiceElementoColidindo(this) != -1)
            Desenhador.getTelaDoJogo().PacManColidiuComUmRobo(this); // verifica se o Pac Man colidiu com um robô
        
        if(iFlagSleep == 0) {
            iFlagSleep = 1;
        }
        else {
            iFlagSleep = 0;
        }
        this.setImagemCorrente(iFlagSleep);
        super.autoDesenho();
    }
}
