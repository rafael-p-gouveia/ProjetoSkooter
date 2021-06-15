/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

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
    
    public void setFase1(Hero umHero) {
        this.clear();
        this.add(umHero);
        this.add(new QuadradoVermelho(new Posicao(1,1)));
        
        this.add(new QuadradoVermelho(new Posicao(1,7)));
        
        this.add(new QuadradoVermelho(new Posicao(4,7)));

        this.add(new QuadradoVermelho(new Posicao(6,7)));
        
        
        this.add(new QuadradoVermelho(new Posicao(9,7)));
        
        this.add(new RoboVermelho(new Posicao(1,8)));
        
        this.add(new QuadradoVermelho(new Posicao(1,4)));
        this.add(new QuadradoVerde(new Posicao(0,1)));
        this.add(new QuadradoVerde(new Posicao(1,2)));
        this.add(new RoboVermelho(new Posicao(5,5)));
        this.add(new RoboVermelho(new Posicao(3,3)));
        this.add(new RoboVermelho(new Posicao(0,10)));
        this.add(new ItemColecionavel(new Posicao(10,10)));
        this.add(new ItemColecionavel(new Posicao(10,1)));
    }
    
    public void setFase2(Hero umHero) {
        this.clear();
        this.add(umHero);

        this.add(new QuadradoVermelho(new Posicao(10,7)));
        this.add(new QuadradoVermelho(new Posicao(7,7)));
        
        this.add(new QuadradoVermelho(new Posicao(9,7)));
        
        this.add(new RoboVermelho(new Posicao(0,8)));
        
        this.add(new QuadradoVermelho(new Posicao(1,4)));
        this.add(new QuadradoVerde(new Posicao(0,1)));
        this.add(new QuadradoVerde(new Posicao(1,2)));

        this.add(new ItemColecionavel(new Posicao(0,0)));
        this.add(new ItemColecionavel(new Posicao(10,1)));
    }
}
