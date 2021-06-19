/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Auxiliar.Consts;
import java.lang.String;
import Modelo.*;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author guigu
 */
public class Fase extends ArrayList<Elemento>{
    int iNfase;
    String[] roboCorAzul;
    String[] roboCorAmarelo;
    String[] roboCorVerde;
    String[] roboCorRosa;
    
    Fase(int iSize) {
        super(iSize);
        roboCorAzul = new String[4];
        roboCorAmarelo = new String[4];
        roboCorVerde = new String[4];
        roboCorRosa = new String[4];
        
        roboCorAzul[0] = "robo_azul_down.png";
        roboCorAzul[1] = "robo_azul_left.png";
        roboCorAzul[2] = "robo_azul_up.png";
        roboCorAzul[3] = "robo_azul_right.png";
        
        roboCorAmarelo[0] = "robo_amarelo_down.png";
        roboCorAmarelo[1] = "robo_amarelo_left.png";
        roboCorAmarelo[2] = "robo_amarelo_up.png";
        roboCorAmarelo[3] = "robo_amarelo_right.png";
        
        roboCorVerde[0] = "robo_verde_down.png";
        roboCorVerde[1] = "robo_verde_left.png";
        roboCorVerde[2] = "robo_verde_up.png";
        roboCorVerde[3] = "robo_verde_right.png";
        
        roboCorRosa[0] = "robo_rosa_down.png";
        roboCorRosa[1] = "robo_rosa_left.png";
        roboCorRosa[2] = "robo_rosa_up.png";
        roboCorRosa[3] = "robo_rosa_right.png";
    }

    public int getiNfase() {
        return iNfase;
    }
    
    public void setiNfase(int iNfase) {
        this.iNfase = iNfase;
    }
    
    
    public void proximaFase(Hero umHero){
        if(iNfase < 4){
            iNfase++;
        renderizaFase(umHero);
        }
        else{
            iNfase = 0;
            umHero.ressucita();
            renderizaFase(umHero);
        }
    }
    
    public void resetFase(Hero umHero) {
        if(umHero.getiNumeroVidas() >= 0)
            renderizaFase(umHero);
        else {
            umHero.ressucita();
            iNfase = 0;
            renderizaFase(umHero);
        }
    }
    
    public void renderizaFase(Hero umHero){
        switch(iNfase){
            case 0:
                setFase1(umHero);
                break;
            case 1:
                setFase2(umHero);
                break;
            case 2:
                setFase3(umHero);
                break;
            case 3:
                setFase4(umHero);
                break;
            case 4:
                setFim(umHero);
                break;
        }
    }
    public Fase setFase1(Hero umHero) {
        this.clear();
        
        umHero.setPosicao(6, 4);
        this.add(umHero);
        
        this.add(new QuadradoFixo(new Posicao(1,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,9), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,9), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,9), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,9), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,9), false, "bloco_liso_vermelho.png"));
        
        this.add(new QuadradoMovel(new Posicao(0,1), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(0,5), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(1,2), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(1,8), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(1,10), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(2,1), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(2,5), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(3,0), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(3,8), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(4,1), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(4,9), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(5,2), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(5,6), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(6,5), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(6,7), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(7,8), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(7,10), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(8,3), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(8,9), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(9,0), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(9,2), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(9,6), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(9,8), true, "bloco_losango_verde.png"));
        this.add(new QuadradoMovel(new Posicao(10,7), true, "bloco_losango_verde.png"));
        
        
        this.add(new Robo(new Posicao(2,0), roboCorAmarelo));
        this.add(new Robo(new Posicao(0,9), roboCorRosa));
        this.add(new Robo(new Posicao(10,1), roboCorAzul));
        this.add(new Robo(new Posicao(10,9), roboCorVerde));
        
        this.add(new ItemColecionavel(new Posicao(0,0),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(10,0),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(0,10),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(10,10),"cereja.png"));
        
        return this;
    }
    
    public Fase setFase2(Hero umHero) {
        this.clear();
        
        umHero.setPosicao(5, 5);
        this.add(umHero);

        this.add(new QuadradoFixo(new Posicao(1,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,9), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,9), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(9,7), false, "bloco_liso_vermelho.png"));
        
        this.add(new BlocoSeta(new Posicao(0,3),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(0,7),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(2,3),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(2,4),Consts.DOWN));
        this.add(new BlocoSeta(new Posicao(2,5),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(2,6),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(2,7),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(3,0),Consts.UP));
        this.add(new BlocoSeta(new Posicao(3,2),Consts.DOWN));
        this.add(new BlocoSeta(new Posicao(3,4),Consts.DOWN));
        this.add(new BlocoSeta(new Posicao(3,6),Consts.UP));
        this.add(new BlocoSeta(new Posicao(3,8),Consts.UP));
        this.add(new BlocoSeta(new Posicao(3,10),Consts.DOWN));
        this.add(new BlocoSeta(new Posicao(4,0),Consts.UP));
        this.add(new BlocoSeta(new Posicao(4,3),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(4,7),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(4,8),Consts.UP));
        this.add(new BlocoSeta(new Posicao(4,9),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(4,10),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(5,0),Consts.UP));
        this.add(new BlocoSeta(new Posicao(6,0),Consts.UP));
        this.add(new BlocoSeta(new Posicao(6,3),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(6,7),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(7,0),Consts.UP));
        this.add(new BlocoSeta(new Posicao(7,2),Consts.DOWN));
        this.add(new BlocoSeta(new Posicao(7,4),Consts.DOWN));
        this.add(new BlocoSeta(new Posicao(7,6),Consts.UP));
        this.add(new BlocoSeta(new Posicao(7,8),Consts.UP));
        this.add(new BlocoSeta(new Posicao(7,10),Consts.UP));
        this.add(new BlocoSeta(new Posicao(8,3),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(8,7),Consts.RIGHT));
        this.add(new BlocoSeta(new Posicao(10,3),Consts.LEFT));
        this.add(new BlocoSeta(new Posicao(10,7),Consts.RIGHT));
        
        this.add(new Robo(new Posicao(1,1), roboCorAmarelo));
        this.add(new Robo(new Posicao(1,9), roboCorVerde));
        this.add(new Robo(new Posicao(9,1), roboCorRosa));
        this.add(new Robo(new Posicao(9,9), roboCorAzul));

        this.add(new ItemColecionavel(new Posicao(1,5),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(5,9),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(5,1),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(9,5),"cereja.png"));
        
        return this;
    }
    
    public Fase setFase3(Hero umHero) {
        this.clear();
        
        umHero.setPosicao(5, 5);
        this.add(umHero);
        
        this.add(new QuadradoMovel(new Posicao(1,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,2), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,3), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,4), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,5), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,6), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,8), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(1,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(2,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(3,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(4,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(5,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(6,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(8,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,9), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,8), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,6), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,5), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,4), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,3), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,2), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(9,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(8,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(6,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(5,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(4,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(3,1), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(2,1), false, "b_vermelho_losango.png"));
        
        this.add(new QuadradoMovel(new Posicao(3,3), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(3,4), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(3,5), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(3,6), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(3,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(4,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(5,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(6,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,7), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,6), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,5), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,4), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(7,3), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(6,3), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(5,3), false, "b_vermelho_losango.png"));
        this.add(new QuadradoMovel(new Posicao(4,3), false, "b_vermelho_losango.png"));
        
        this.add(new ItemColecionavel(new Posicao(5,0),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(5,2),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(5,10),"chave_inglesa.png"));
        this.add(new ItemColecionavel(new Posicao(5,8),"lampada.png"));
        
        this.add(new Robo(new Posicao(0,5), roboCorAmarelo));
        this.add(new Robo(new Posicao(2,5), roboCorRosa));
        this.add(new Robo(new Posicao(8,5), roboCorAzul));
        this.add(new Robo(new Posicao(10,5), roboCorVerde));
        
        return this;
    }
    
    public Fase setFase4(Hero umHero) {
        this.clear();
        
        umHero.setPosicao(4, 5);
        this.add(umHero);
        
        this.add(new QuadradoFixo(new Posicao(1,1), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(1,3), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(1,5), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(1,7), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(1,9), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(2,2), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(2,4), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(2,6), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(2,8), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(3,1), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(3,3), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(3,5), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(3,7), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(3,9), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(4,2), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(4,4), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(4,6), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(4,8), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(5,1), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(5,3), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(5,5), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(5,7), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(5,9), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(6,2), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(6,4), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(6,6), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(6,8), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(7,1), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(7,3), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(7,5), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(7,7), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(7,9), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(8,2), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(8,4), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(8,6), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(8,8), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(9,1), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(9,3), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(9,5), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(9,7), true, "b_verde_liso.png"));
        this.add(new QuadradoFixo(new Posicao(9,9), true, "b_verde_liso.png"));
        
        this.add(new ItemColecionavel(new Posicao(0,0),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(0,10),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(10,0),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(10,10),"chave_inglesa.png"));
        
        this.add(new Robo(new Posicao(0,5), roboCorAmarelo));
        this.add(new Robo(new Posicao(5,0), roboCorVerde));
        this.add(new Robo(new Posicao(5,10), roboCorAzul));
        this.add(new Robo(new Posicao(10,5), roboCorRosa));
        
        this.add(new QuadradoFixo(new Posicao(0,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(0,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,0), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(1,8), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(2,5), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,2), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(3,10), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,2), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(5,8), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(6,3), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(7,0), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(8,1), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(8,7), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(8,10), false, "bloco_liso_vermelho.png"));
        this.add(new QuadradoFixo(new Posicao(10,1), false, "bloco_liso_vermelho.png"));
        
        
        return this;
    }
    public Fase setFim(Hero umHero){
        this.clear();
        
        umHero.setPosicao(5, 5);
        this.add(umHero);
        
        this.add(new ItemColecionavel(new Posicao(0,0),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(0,1),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(0,2),"chave_inglesa.png"));
        this.add(new ItemColecionavel(new Posicao(0,4),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(0,9),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(1,1),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(1,4),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(1,8),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(1,10),"sol.png"));
        
        this.add(new ItemColecionavel(new Posicao(2,1),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(2,4),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(2,5),"chave_inglesa.png"));
        this.add(new ItemColecionavel(new Posicao(2,6),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(2,8),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(2,9),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(2,10),"limao.png"));
        
        this.add(new ItemColecionavel(new Posicao(3,1),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(3,4),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(3,6),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(3,8),"chave_inglesa.png"));
        
        this.add(new ItemColecionavel(new Posicao(4,1),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(4,4),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(4,6),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(4,8),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(4,9),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(4,10),"sol.png"));
        
        this.add(new ItemColecionavel(new Posicao(6,0),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(6,1),"chave_inglesa.png"));
        this.add(new ItemColecionavel(new Posicao(6,2),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(6,4),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(6,5),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(6,10),"limao.png"));
        
        this.add(new ItemColecionavel(new Posicao(7,0),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(7,4),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(7,6),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(7,10),"chave_inglesa.png"));
        
        this.add(new ItemColecionavel(new Posicao(8,0),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(8,1),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(8,2),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(8,4),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(8,6),"morango.png"));
        this.add(new ItemColecionavel(new Posicao(8,8),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(8,9),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(8,10),"chave_inglesa.png"));
        
        this.add(new ItemColecionavel(new Posicao(9,0),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(9,4),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(9,6),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(9,8),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(9,10),"morango.png"));
        
        this.add(new ItemColecionavel(new Posicao(10,0),"sol.png"));
        this.add(new ItemColecionavel(new Posicao(10,1),"cereja.png"));
        this.add(new ItemColecionavel(new Posicao(10,2),"chave_inglesa.png"));
        this.add(new ItemColecionavel(new Posicao(10,4),"vela.png"));
        this.add(new ItemColecionavel(new Posicao(10,6),"uva.png"));
        this.add(new ItemColecionavel(new Posicao(10,8),"lampada.png"));
        this.add(new ItemColecionavel(new Posicao(10,9),"limao.png"));
        this.add(new ItemColecionavel(new Posicao(10,10),"morango.png"));
        
        System.out.println("Parabéns! Você venceu o jogo!");
        System.out.println("Jogo por Guilherme Cremasco Gulmini 11816077 e Rafael Pereira de Gouveia 11800820");
        
        return this;
    }
}
