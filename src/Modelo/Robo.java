package Modelo;
import Auxiliar.*;
import java.util.Random;

public class Robo extends ElementoDinamico {
    int iFlagSleep; // Controlador de velocidade dos robôs. Quanto maior, menor será a velocidade deles
    
    public Robo(Posicao umaPosicao, String[] cor) {
        super(cor[0],cor[1],cor[2],cor[3]);
        this.setPosicao(umaPosicao);
        this.setbTransponivel(true);
        this.setbHostil(true);
    }
    
    // Desenha o robô
    public void autoDesenho() {
        Random r = new Random(); // a direção que ele vai é aleatória0
        
        // Essas duas variáveis retornam a linha e a coluna da possível posição que o herói irá
        int iBiasHorizontal = Desenhador.getTelaDoJogo().getHero().getPosicao().direcaoRelativaHorizontal(pPosicao);
        int iBiasVertical = Desenhador.getTelaDoJogo().getHero().getPosicao().direcaoRelativaVertical(pPosicao);
        
        if (iFlagSleep == 4){
            int iDirecao = r.nextInt(6); //gera numero de 0 a 5
            // Caso o número acima seja 4 ou 5, o robô tentará se aproximar do herói "conscientemente". Caso contrário, ele seguirá uma direção aleatória
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
}
