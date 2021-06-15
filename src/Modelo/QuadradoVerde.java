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
public class QuadradoVerde extends Elemento {
    
    public QuadradoVerde(Posicao umaPosicao) {
        super("bloco_losango_verde.png");
        this.setPosicao(umaPosicao);
        bTransponivel = false;
    }
    
}
