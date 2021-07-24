/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Auxiliar.Desenhador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guigu
 */
public class ThreadSave extends Thread {
    long lIntervalo;
    
    public ThreadSave() {
        this.lIntervalo = 0;
    }
    
    public void roda(long lIntervalo) {
        this.lIntervalo = lIntervalo;
        this.run();
    }
    
    public void run() {
        try {
            while(true) {
                Thread.sleep(lIntervalo);
                Desenhador.getTelaDoJogo().gravaSave();
                System.out.println("---- JOGO SALVO ----");
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSave.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
