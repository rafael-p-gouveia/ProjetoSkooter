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
public class QuadradoVermelho extends Elemento{
    
    public QuadradoVermelho(Posicao umaPosicao) {
        super("bloco_liso_vermelho.jpg");
        this.setPosicao(umaPosicao);
        bTransponivel = false;
    }
    
}
