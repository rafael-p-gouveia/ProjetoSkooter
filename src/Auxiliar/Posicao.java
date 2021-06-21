package Auxiliar;

import java.io.Serializable;

public class Posicao implements Serializable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;

    public Posicao(int linha, int coluna){
        this.setPosicao(linha,coluna);
    }
    
    // Seta uma posição
    public boolean setPosicao(int linha, int coluna){       
        if(linha < 0 || linha >= Auxiliar.Consts.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < 0 || coluna >= Auxiliar.Consts.RES)
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        return true;
    }
    
    // Pega a linha de uma posição
    public int getLinha(){
        return linha;
    }
   
    // Pega a coluna de uma posição
    public int getColuna(){
        return coluna;
    }
    
    // Volta à posição anterior
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }
    
    // Verifica se duas posições são as mesmas
    public boolean estaNaMesmaPosicao(Posicao posicao){
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }
    
    // Copia uma posição
    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    
    // Métodos que mudam a posição de elementos através de movimentos direcionais
    public boolean moveUp(){
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
    public boolean moveDown(){
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
    public boolean moveRight(){
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
    public boolean moveLeft(){
        return this.setPosicao(this.getLinha(), this.getColuna()-1);        
    }
    
    // Retorna a posição que um objeto deve ir para chegar a this
    public int direcaoRelativaHorizontal(Posicao p){
        if(this.linha >= p.getLinha()){ //this está à direita de p
            return Consts.RIGHT;
        }
        else{ // this está à esquerda
            return Consts.LEFT;
        }
    }
    
    // Retorna a posição que um objeto deve ir para chegar a this
    public int direcaoRelativaVertical(Posicao p){
        if(this.coluna >= p.getColuna()){ //this está abaixo de p
            return Consts.DOWN;
        }
        else{ // this está acima
            return Consts.UP;
        }
    }
}
