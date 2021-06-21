package Auxiliar;

import java.io.File;

/**
 *
 * @author Junio
 */ 
public class Consts {
    // Constantes inteiras que representam a orientação de alguns elementos
    public static final int DOWN = 0;
    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    
    // Outras constantes usadas no jogo
    public static final int CELL_SIDE = 85;
    public static final int RES = 11;
    public static final int FRAME_INTERVAL = 100;   
    public static final int TIMER_DISPARO = 200; /*Em numero de frames (redesenhos)*/
    public static final String PATH = File.separator+"imgs"+File.separator;
}
