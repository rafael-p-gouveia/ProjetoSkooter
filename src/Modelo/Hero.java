package Modelo;

import java.io.Serializable;

public class Hero extends ElementoDinamico implements Serializable{
    private static Hero heroInstance = null;
    private int iNumeroVidas;
    private Hero() { // padrão singleton
        super("protag_baixo.png","protag_esquerda.png","protag_cima.png","protag_direita.png");
        this.setbTransponivel(false);
        this.setbInterativo(true);
        iNumeroVidas = 3;
    }
    
    public static Hero getInstance() {
        if(heroInstance == null)
            heroInstance = new Hero();
        
        return heroInstance;
    }
    
    // Método que faz o herói voltar à última posição
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    // Retorna o número de vidas do herói
    public int getiNumeroVidas() {
        return iNumeroVidas;
    }
    
    // Método que simula a morte do herói
    public void morre() {
        iNumeroVidas--;
        if(iNumeroVidas >= 0)
            System.out.println("Heroi morreu! Vidas restantes: " + iNumeroVidas);
        else
            System.out.println("Game Over!\n");
    }
    
    // Reinicia as vidas do herói
    public void ressucita() {
        iNumeroVidas = 3;
    }
}
