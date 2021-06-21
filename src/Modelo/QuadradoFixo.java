package Modelo;

import Auxiliar.Posicao;

public class QuadradoFixo extends Elemento{
    public QuadradoFixo(Posicao umaPosicao, boolean bDestrutivel, String sPath) {
        super(sPath);
        this.setPosicao(umaPosicao);
        this.setbTransponivel(false);
        this.setbDestrutivel(bDestrutivel);
    }
    
}
