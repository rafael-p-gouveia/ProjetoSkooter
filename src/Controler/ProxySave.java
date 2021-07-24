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
    
    public boolean roda(long lIntervalo) {
        if(lIntervalo <= 0){
            System.out.println("INTERVALO INVÁLIDO");
            return false;
        }
        else
            thread.roda(lIntervalo);
            return true;
    }
}
