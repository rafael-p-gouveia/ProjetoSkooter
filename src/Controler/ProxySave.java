/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

/**
 *
 * @author guigu
 */
public class ProxySave {
    ThreadSave thread;
    
    public ProxySave() {
        thread = new ThreadSave();
    }
    
    public void roda(long lIntervalo) {
        if(lIntervalo <= 0)
            throw new Error("ERRO - intervalo inválido!");
        else
            thread.roda(lIntervalo);
    }
}
