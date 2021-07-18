/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Modelo.Elemento;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author R
 */
public class SaveState implements Serializable {
    
    private ArrayList<Elemento> eElementos;
    Fase minhaFase;

    public SaveState(ArrayList<Elemento> eElementos, Fase minhaFase) {
        this.eElementos = eElementos;
        this.minhaFase = minhaFase;
    }

    public ArrayList<Elemento> geteElementos() {
        return eElementos;
    }

    public Fase getMinhaFase() {
        return minhaFase;
    }

    public void seteElementos(ArrayList<Elemento> eElementos) {
        this.eElementos = eElementos;
    }

    public void setMinhaFase(Fase minhaFase) {
        this.minhaFase = minhaFase;
    }
    
    
    
    public void print(){
        System.out.println(minhaFase.getiNfase());
    }
}
