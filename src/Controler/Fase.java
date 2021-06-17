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
                setFase2(umHero);
                break;
            case 3:
                setFase2(umHero);
                break;
        }
    }
    public Fase setFase1(Hero umHero) {
        this.clear();
        
        umHero.setPosicao(6, 4);
        this.add(umHero);
        
        this.add(new QuadradoVermelho(new Posicao(1,1)));
        this.add(new QuadradoVermelho(new Posicao(1,3)));
        this.add(new QuadradoVermelho(new Posicao(1,5)));
        this.add(new QuadradoVermelho(new Posicao(1,7)));
        this.add(new QuadradoVermelho(new Posicao(1,9)));
        this.add(new QuadradoVermelho(new Posicao(3,1)));
        this.add(new QuadradoVermelho(new Posicao(3,3)));
        this.add(new QuadradoVermelho(new Posicao(3,5)));
        this.add(new QuadradoVermelho(new Posicao(3,7)));
        this.add(new QuadradoVermelho(new Posicao(3,9)));
        this.add(new QuadradoVermelho(new Posicao(5,1)));
        this.add(new QuadradoVermelho(new Posicao(5,3)));
        this.add(new QuadradoVermelho(new Posicao(5,5)));
        this.add(new QuadradoVermelho(new Posicao(5,7)));
        this.add(new QuadradoVermelho(new Posicao(5,9)));
        this.add(new QuadradoVermelho(new Posicao(7,1)));
        this.add(new QuadradoVermelho(new Posicao(7,3)));
        this.add(new QuadradoVermelho(new Posicao(7,5)));
        this.add(new QuadradoVermelho(new Posicao(7,7)));
        this.add(new QuadradoVermelho(new Posicao(7,9)));
        this.add(new QuadradoVermelho(new Posicao(9,1)));
        this.add(new QuadradoVermelho(new Posicao(9,3)));
        this.add(new QuadradoVermelho(new Posicao(9,5)));
        this.add(new QuadradoVermelho(new Posicao(9,7)));
        this.add(new QuadradoVermelho(new Posicao(9,9)));
        
        this.add(new QuadradoVerde(new Posicao(0,1)));
        this.add(new QuadradoVerde(new Posicao(0,5)));
        this.add(new QuadradoVerde(new Posicao(1,2)));
        this.add(new QuadradoVerde(new Posicao(1,8)));
        this.add(new QuadradoVerde(new Posicao(1,10)));
        this.add(new QuadradoVerde(new Posicao(2,1)));
        this.add(new QuadradoVerde(new Posicao(2,5)));
        this.add(new QuadradoVerde(new Posicao(3,0)));
        this.add(new QuadradoVerde(new Posicao(3,8)));
        this.add(new QuadradoVerde(new Posicao(4,1)));
        this.add(new QuadradoVerde(new Posicao(4,9)));
        this.add(new QuadradoVerde(new Posicao(5,2)));
        this.add(new QuadradoVerde(new Posicao(5,6)));
        this.add(new QuadradoVerde(new Posicao(6,5)));
        this.add(new QuadradoVerde(new Posicao(6,7)));
        this.add(new QuadradoVerde(new Posicao(7,8)));
        this.add(new QuadradoVerde(new Posicao(7,10)));
        this.add(new QuadradoVerde(new Posicao(8,3)));
        this.add(new QuadradoVerde(new Posicao(8,9)));
        this.add(new QuadradoVerde(new Posicao(9,0)));
        this.add(new QuadradoVerde(new Posicao(9,2)));
        this.add(new QuadradoVerde(new Posicao(9,6)));
        this.add(new QuadradoVerde(new Posicao(9,8)));
        this.add(new QuadradoVerde(new Posicao(10,7)));
        
        
        this.add(new RoboVermelho(new Posicao(2,0)));
        this.add(new RoboVermelho(new Posicao(0,9)));
        this.add(new RoboVermelho(new Posicao(10,1)));
        this.add(new RoboVermelho(new Posicao(10,9)));
        
        this.add(new ItemColecionavel(new Posicao(0,0),"uva.jpg"));
        this.add(new ItemColecionavel(new Posicao(10,0),"morango.jpg"));
        this.add(new ItemColecionavel(new Posicao(0,10),"limao.jpg"));
        this.add(new ItemColecionavel(new Posicao(10,10),"cereja.jpg"));
        
        return this;
    }
    
    public Fase setFase2(Hero umHero) {
        this.clear();
        
        umHero.setPosicao(5, 5);
        this.add(umHero);

        this.add(new QuadradoVermelho(new Posicao(1,3)));
        this.add(new QuadradoVermelho(new Posicao(1,7)));
        this.add(new QuadradoVermelho(new Posicao(3,1)));
        this.add(new QuadradoVermelho(new Posicao(3,3)));
        this.add(new QuadradoVermelho(new Posicao(3,5)));
        this.add(new QuadradoVermelho(new Posicao(3,7)));
        this.add(new QuadradoVermelho(new Posicao(3,9)));
        this.add(new QuadradoVermelho(new Posicao(5,3)));
        this.add(new QuadradoVermelho(new Posicao(5,7)));
        this.add(new QuadradoVermelho(new Posicao(7,1)));
        this.add(new QuadradoVermelho(new Posicao(7,3)));
        this.add(new QuadradoVermelho(new Posicao(7,5)));
        this.add(new QuadradoVermelho(new Posicao(7,7)));
        this.add(new QuadradoVermelho(new Posicao(7,9)));
        this.add(new QuadradoVermelho(new Posicao(9,3)));
        this.add(new QuadradoVermelho(new Posicao(9,7)));
        
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
        
        this.add(new RoboVermelho(new Posicao(1,1)));
        this.add(new RoboVermelho(new Posicao(1,9)));
        this.add(new RoboVermelho(new Posicao(9,1)));
        this.add(new RoboVermelho(new Posicao(9,9)));

        this.add(new ItemColecionavel(new Posicao(1,5),"uva.jpg"));
        this.add(new ItemColecionavel(new Posicao(5,9),"morango.jpg"));
        this.add(new ItemColecionavel(new Posicao(5,1),"limao.jpg"));
        this.add(new ItemColecionavel(new Posicao(9,5),"cereja.jpg"));
        
        return this;
    }
}
