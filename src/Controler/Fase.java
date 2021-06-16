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

        this.add(new ItemColecionavel(new Posicao(0,0),"uva.jpg"));
        this.add(new ItemColecionavel(new Posicao(10,1),"uva.jpg"));
    }
}
