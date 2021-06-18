/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Auxiliar.Consts;
import Modelo.*;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author guigu
 */
public class Fase extends ArrayList<Elemento>{
    Fase(int iSize) {
        super(iSize);
    }
    int iNfase;

    public int getiNfase() {
        return iNfase;
    }
    
    public void setiNfase(int iNfase) {
        this.iNfase = iNfase;
    }
    
    
    public void proximaFase(Hero umHero){
        if(iNfase < 3)
            iNfase++;
        renderizaFase(umHero);
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
        
        
        this.add(new Robo(new Posicao(2,0)));
        this.add(new Robo(new Posicao(0,9)));
        this.add(new Robo(new Posicao(10,1)));
        this.add(new Robo(new Posicao(10,9)));
        
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
        
        this.add(new Robo(new Posicao(1,1)));
        this.add(new Robo(new Posicao(1,9)));
        this.add(new Robo(new Posicao(9,1)));
        this.add(new Robo(new Posicao(9,9)));

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
        
        this.add(new Robo(new Posicao(0,5)));
        this.add(new Robo(new Posicao(2,5)));
        this.add(new Robo(new Posicao(8,5)));
        this.add(new Robo(new Posicao(10,5)));
        
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
        
        this.add(new Robo(new Posicao(0,5)));
        this.add(new Robo(new Posicao(5,0)));
        this.add(new Robo(new Posicao(5,10)));
        this.add(new Robo(new Posicao(10,5)));
        
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
}
