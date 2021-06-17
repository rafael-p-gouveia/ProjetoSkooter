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
public class QuadradoFixo extends Elemento{
    
    public QuadradoFixo(Posicao umaPosicao, boolean bDestrutivel, String sPath) {
        super(sPath);
        this.setPosicao(umaPosicao);
        bTransponivel = false;
        setbDestrutivel(bDestrutivel);
    }
    
}
