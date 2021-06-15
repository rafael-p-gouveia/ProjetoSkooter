/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Controler.Tela;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
/**
 *
 * @author R
 */
public class ElementoDinamico extends Elemento implements Serializable {
    ElementoDinamico(String caminho1, String caminho2, String caminho3, String caminho4){
        super(caminho1,caminho2,caminho3,caminho4);
    }
    
    public boolean moveDown() {
        iIndexOfImage = 0;
        return this.pPosicao.moveDown();
    }
    public boolean moveLeft() {
        iIndexOfImage = 1;
        return this.pPosicao.moveLeft();
    }
    public boolean moveUp() {
        iIndexOfImage = 2;
        return this.pPosicao.moveUp();
    }
    public boolean moveRight() {
        iIndexOfImage = 3;
        return this.pPosicao.moveRight();
    }
}
