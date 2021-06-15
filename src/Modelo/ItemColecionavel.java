/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Posicao;

/**
 *
 * @author guigu
 */
public class ItemColecionavel extends Elemento {
    public ItemColecionavel(Posicao umaPosicao) {
        super("uva.jpg");
        this.setPosicao(umaPosicao);
        this.setbColecionavel(true);
        bTransponivel = true;
    }
    
}
