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
public class Robo extends ElementoDinamico {
    
    int iFlagSleep;
    
    public Robo(Posicao umaPosicao, String[] cor) {
        super(cor[0],cor[1],cor[2],cor[3]);
        this.setPosicao(umaPosicao);
        this.bTransponivel = true;
        this.setbHostil(true);
    }
    
    public void autoDesenho() {
        Random r = new Random();
        
        int iBiasHorizontal = Desenhador.getTelaDoJogo().getHero().getPosicao().direcaoRelativaHorizontal(pPosicao);
        int iBiasVertical = Desenhador.getTelaDoJogo().getHero().getPosicao().direcaoRelativaVertical(pPosicao);
        
        if (iFlagSleep == 4){ //Aumente para diminuir a velocidade do robô
            int iDirecao = r.nextInt(6); //gera numero de 0 a 5
            if (iDirecao == 4){
                iDirecao = iBiasHorizontal;
            }
            if (iDirecao == 5){
                iDirecao = iBiasVertical;
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
               iFlagSleep = 4;
            }
            else{
                iFlagSleep = 0;
            }
        }
        else{
            iFlagSleep++;
        }
        super.autoDesenho();
    }
    
    public void interage(Hero hHero){
       //Desenhador.getTelaDoJogo().getMinhaFase().resetFase(hHero); Tá causando congelamento do game isso aqui na segunda fase, além de só funcionar
       //quando o Hero que pisa no robô mas não o contrário
    }
}
