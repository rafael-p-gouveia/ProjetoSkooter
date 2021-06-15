package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Hero extends ElementoDinamico implements Serializable{
   
    public Hero() {
        super("protag_baixo.png","protag_esquerda.png","protag_cima.png","protag_direita.png");
        this.bTransponivel = false;
        bInterativo = true;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
