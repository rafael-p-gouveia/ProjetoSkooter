package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
//import java.util.zip.*;

import java.io.File; // arquivo em si
import java.io.FileNotFoundException;
import java.io.IOException; // resolve os erros jogados
import java.io.FileOutputStream; // cano pra sair
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.FileInputStream; // cano pra entrar
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;


public class Tela extends javax.swing.JFrame implements KeyListener {
    
    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    //private ControleDeJogo cControle = ControleDeJogo.getInstance();
    private Graphics g2;
    String[] backgroundFases;
    Fase minhaFase;
    
    SaveState sSave = new SaveState(eElementos, minhaFase, hHero);
    File fArquivoSave = new File("save.dat");
    
     //cria arquivo compactado, se ja nao existir
    
    
    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
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
    }

/*--------------------------------------------------*/
    private void gravaSave(){
        try { //cria arquivo compactado, se ja nao existir
            sSave.setHero(hHero);
            sSave.setMinhaFase(minhaFase);
            sSave.seteElementos(eElementos);
            
            if (!fArquivoSave.exists()) {
                fArquivoSave.createNewFile();
            }
            FileOutputStream saida = new FileOutputStream(fArquivoSave);
            GZIPOutputStream compactador = new GZIPOutputStream(saida);
            ObjectOutputStream serializador = new ObjectOutputStream(compactador);

            serializador.writeObject(sSave);

            serializador.flush();
            serializador.close();
            compactador.close();
            saida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void carregaSave(){
        try { //le arquivo compactado

            FileInputStream entrada = new FileInputStream(fArquivoSave);
            GZIPInputStream descompactador = new GZIPInputStream(entrada);
            ObjectInputStream deserializador = new ObjectInputStream(descompactador);

            sSave = (SaveState)deserializador.readObject();

            deserializador.close();
            descompactador.close();
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //sSave.print();
        minhaFase = sSave.getMinhaFase();
        //minhaFase.resetFase();
        hHero = sSave.getHero();
        eElementos = sSave.geteElementos();
        //Hero.getInstance().setPosicao(eElementos.get(0).getPosicao());
        
        
    }
    
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
            ControleDeJogo.getInstance().desenhaTudo(eElementos);
            ControleDeJogo.getInstance().processaTudo(eElementos);
            if(!ControleDeJogo.getInstance().haColecionaveisAinda(eElementos)) {
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
            iStep = ControleDeJogo.getInstance().getIndiceElementoColidindo(eElementos, eStep);
            if(iStep != -1){
                if(eElementos.get(iStep).isbDestrutivel()){
                    eElementos.remove(iStep);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_Q){
            gravaSave();
        } else if (e.getKeyCode() == KeyEvent.VK_W){
            carregaSave();
        }
        
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!ControleDeJogo.getInstance().ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            while(!ControleDeJogo.getInstance().ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
                Elemento eColidido = eElementos.get(ControleDeJogo.getInstance().getIndiceElementoColidindo(this.eElementos, hHero));
                eColidido.interage(hHero);
                if(!eColidido.isbBlocoSeta())
                    hHero.voltaAUltimaPosicao();
            }
        }

        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }
    
    public boolean ehPosicaoValida(Posicao umaPosicao) {
        return ControleDeJogo.getInstance().ehPosicaoValida(this.eElementos, umaPosicao);
    }
    
    public boolean ehPosicaoValidaParaItens(Posicao umaPosicao) {
        return ControleDeJogo.getInstance().ehPosicaoValidaParaItens(this.eElementos, umaPosicao);
    }
    
    public boolean ehPosicaoValidaRelativaAUmPersonagem(Elemento umPersonagem) {
        return ControleDeJogo.getInstance().ehPosicaoValidaRelativaAUmPersonagem(this.eElementos, umPersonagem);
    }
    
    public int getIndiceElementoColidindo(Elemento umPersonagem){
        return ControleDeJogo.getInstance().getIndiceElementoColidindo(this.eElementos, umPersonagem);
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

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public Fase getMinhaFase() {
        return minhaFase;
    }
    
    public Hero getHero() {
        return hHero;
    }
}