package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;
/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
    String[] backgroundFases;
    Fase minhaFase;
    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(100);
        
        backgroundFases = new String[5];
        backgroundFases[0] = "background_fase_1.png";
        backgroundFases[1] = "background_fase_2.png";
        backgroundFases[2] = "background_fase_3.png";
        backgroundFases[3] = "background_fase_4.png";
        backgroundFases[4] = "background_fase_5.png";
        
    
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        hHero = new Hero(); /* https://www.online-image-editor.com/ */
        hHero.setPosicao(0, 7);
        minhaFase = new Fase(100);
        eElementos = minhaFase.setFase1(hHero);
        /*
        CoronaVirus cTeste = new CoronaVirus("robo_azul.png");
        cTeste.setPosicao(5, 5);
        this.addElemento(cTeste);     

        CoronaVirus cCorona = new CoronaVirus("robo.png");
        cCorona.setPosicao(3, 3);
        this.addElemento(cCorona);

        CoronaVirus cRobo = new CoronaVirus("robo_azul.png");
        cCorona.setPosicao(10, 5);        
        this.addElemento(cRobo);
        
        Caveira cCaveira = new Caveira("caveira.png");
        cCaveira.setPosicao(10, 9);
        this.addElemento(cCaveira);  
        */
    }

/*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + this.backgroundFases[minhaFase.getiNfase()]);
                    g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        eElementos = minhaFase;
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
            if(!this.cControle.haColecionaveisAinda(eElementos)) {
                this.minhaFase.proximaFase(hHero);
            }
        }
        

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hHero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hHero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hHero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hHero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            minhaFase.resetFase(hHero);
        } else if (e.getKeyCode() == KeyEvent.VK_X){
            int iStep;
            ElementoDinamico eStep = new ElementoDinamico(hHero.getPosicaoQueOlha());
            iStep = cControle.getIndiceElementoColidindo(eElementos, eStep);
            if(iStep != -1){
                if(eElementos.get(iStep).isbDestrutivel()){
                    eElementos.remove(iStep);
                }
            }
        }
        
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            while(!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
                Elemento eColidido = eElementos.get(cControle.getIndiceElementoColidindo(this.eElementos, hHero));
                eColidido.interage(hHero);
                if(!eColidido.isbBlocoSeta())
                    hHero.voltaAUltimaPosicao();
            }
        }

        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }

    public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        /*if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            Elemento eColidido = cControle.getElementoColidindo(this.eElementos, hHero);
            eColidido.interage(hHero);
            if(!cControle.ehPosicaoValidaParaItens(eElementos, eColidido.getPosicao()))
                hHero.voltaAUltimaPosicao();
        }*/       
         
        repaint();
    }
    
    public boolean ehPosicaoValida(Posicao umaPosicao) {
        return cControle.ehPosicaoValida(this.eElementos, umaPosicao);
    }
    
    public boolean ehPosicaoValidaParaItens(Posicao umaPosicao) {
        return cControle.ehPosicaoValidaParaItens(this.eElementos, umaPosicao);
    }
    
    public boolean ehPosicaoValidaRelativaAUmPersonagem(Elemento umPersonagem) {
        return cControle.ehPosicaoValidaRelativaAUmPersonagem(this.eElementos, umPersonagem);
    }
    
    public ControleDeJogo getControle() {
        return this.cControle;
    }
    
    public int getIndiceElementoColidindo(Elemento umPersonagem){
        return cControle.getIndiceElementoColidindo(this.eElementos, umPersonagem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public Fase getMinhaFase() {
        return minhaFase;
    }
    
}
