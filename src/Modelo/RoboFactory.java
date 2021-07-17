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
public class RoboFactory {
    public static Robo criaRobo(String cor, Posicao umaPosicao) {
        if(cor.equals("amarelo"))
            return new RoboAmarelo(umaPosicao);
        
        else if(cor.equals("azul"))
            return new RoboAzul(umaPosicao);
        
        else if(cor.equals("verde"))
            return new RoboVerde(umaPosicao);
        
        else if(cor.equals("rosa"))
            return new RoboRosa(umaPosicao);
        
        throw new IllegalArgumentException("ERRO - Cor inválida");
    }
}
