package Modelo;
import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;

public class QuadradoMovel extends Elemento {
    public QuadradoMovel(Posicao umaPosicao, boolean bDestrutivel, String sPath) {
        super(sPath);
        this.setPosicao(umaPosicao);
        this.setbTransponivel(false);
        setbDestrutivel(bDestrutivel);
    }
    
    @Override
    // Método que representa a interação do bloco com o herói
    public void interage(){
        switch(Hero.getInstance().iIndexOfImage){ // O índice da imagem do herói representa também a orientação do herói
            case Consts.DOWN: // Se o herói estiver indo para baixo
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() + 1, getPosicao().getColuna()))){
                    this.moveDown();
                    Hero.getInstance().moveDown();
                }
                break;
            case Consts.LEFT: // Se o herói estiver indo para esquerda
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() - 1))){
                    this.moveLeft();
                    Hero.getInstance().moveLeft();
                }
                break;
            case Consts.UP: // Se o herói estiver indo para cima
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha() - 1, getPosicao().getColuna()))){
                    this.moveUp();
                    Hero.getInstance().moveUp();
                }
                break;
            case Consts.RIGHT: // Se o herói estiver indo para direita
                if(Desenhador.getTelaDoJogo().ehPosicaoValidaParaItens(new Posicao(getPosicao().getLinha(), getPosicao().getColuna() + 1))){
                    this.moveRight();
                    Hero.getInstance().moveRight();
                }
                break;
        }
    }
}
