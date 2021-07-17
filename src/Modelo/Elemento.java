package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

public abstract class Elemento implements Serializable {

    protected int iIndexOfImage;
    protected ImageIcon[] iImage;
    protected Posicao pPosicao;
    protected boolean bColecionavel; // é um item colecionável?
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bInterativo; //interage com blocos do mapa
    protected boolean bDestrutivel; //bloco pode ser destruido pelo hero?
    protected boolean bBlocoSeta; // o elemento é um bloco seta?
    protected boolean bHostil; // o elemento causa dano no jogador?
       
    public Elemento(Auxiliar.Posicao p){
        pPosicao = p;
    }
    
    public Elemento(String caminho1, String caminho2, String caminho3, String caminho4) {
        
        String[] sNomeImagePNG = new String[4];
        sNomeImagePNG[0] = caminho1;
        sNomeImagePNG[1] = caminho2;
        sNomeImagePNG[2] = caminho3;
        sNomeImagePNG[3] = caminho4;
        
        this.bInterativo = false;
        this.bDestrutivel = false;
        this.bBlocoSeta = false;
        this.bHostil = false;
        this.iIndexOfImage = 0;
        this.iImage = new ImageIcon[5];
        this.pPosicao = new Posicao(1, 1);
        this.bColecionavel = false;
        this.bTransponivel = true;
        try {
            for(int i = 0; i < sNomeImagePNG.length; i++) {
                iImage[i] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG[i]);
                Image img = iImage[i].getImage();
                BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                iImage[i] = new ImageIcon(bi);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    protected Elemento(String sUmaImagem) {
        iIndexOfImage = 0;
        String[] sNomeImagePNG = new String[1];
        sNomeImagePNG[0] = sUmaImagem;
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bDestrutivel = false;
        this.bBlocoSeta = false;
        this.bHostil = false;
        iImage = new ImageIcon[5];
        try {
            iImage[0] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG[0]);
            Image img = iImage[0].getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage[0] = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Retorna a posição de um elemento
    public Posicao getPosicao() {
        return pPosicao;
    }
    
    // Verifica se o elemento é interativo
    public boolean isbInterativo(){
        return bInterativo;
    }
    
    public void setbInterativo(boolean bInterativo) {
        this.bInterativo = bInterativo;
    }
    
    // Verifica se o elemento é transponível
    public boolean isbTransponivel() {
        return bTransponivel;
    }
    
    // Define se um elemento é transponível ou não
    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }
    
    // Verifica se um elemento é colecionável
    public boolean isColecionavel() {
        return bColecionavel;
    }
    
    // Define se um elemento é colecionável ou não
    public void setbColecionavel(boolean bColecionavel) {
        this.bColecionavel = bColecionavel;
    }
    
    // Verifica se um elemento é um bloco seta
    public boolean isbBlocoSeta() {
        return bBlocoSeta;
    }
    
    // Define se um elemento é bloco seta ou não
    public void setbBlocoSeta(boolean bBlocoSeta) {
        this.bBlocoSeta = bBlocoSeta;
    }
    
    // Verifica se um elemento é hostil
    public boolean isbHostil() {
        return bHostil;
    }
    
    // Define se um elemento é hostil ou não
    public void setbHostil(boolean bHostil) {
        this.bHostil = bHostil;
    }
    
    // Verifica se um elemento é destrutível
    public boolean isbDestrutivel() {
        return bDestrutivel;
    }
    
    // Define se um elemento é destrutível ou não
    public void setbDestrutivel(boolean bDestrutivel) {
        this.bDestrutivel = bDestrutivel;
    }
    
    // Seta a posição de um elemento passando a linha e a coluna da posição
    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }
    
    // Seta a posição de um elemento passando o próprio objeto de posição
    public boolean setPosicao(Posicao umaPosicao) {
        return pPosicao.copia(umaPosicao);
    }
    
    // Métodos que movem um elemento
    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
    
    // Define a imagem de um elemento com base no índice da imagem
    public void setImagemCorrente(int iIndex) {
        iIndexOfImage = iIndex;
    }
    
    // Desenha o elemento
    public void autoDesenho(){
        Desenhador.desenhar(this.iImage[iIndexOfImage], pPosicao.getColuna(), pPosicao.getLinha());        
    }
   
    public void interage(){
       //Método vazio na classe mãe, mas é definido em algumas classes filhas que usam esse método
    }
}
