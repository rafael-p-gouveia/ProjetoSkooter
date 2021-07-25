package Controler;

import Auxiliar.Desenhador;
import Modelo.Elemento;
import Modelo.Hero;
import Auxiliar.Posicao;
import Modelo.BlocoSeta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;



public class ControleDeJogo {
    private static ControleDeJogo instance = null;
    private ControleDeJogo(){
        // padrão singleton
    }
    
    public static ControleDeJogo getInstance() {
        if(instance == null)
            instance = new ControleDeJogo();
        
        return instance;
    }
    // Desenha todos os elementos do array
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    
    // Processa todos os elementos do array
    public void processaTudo(ArrayList<Elemento> e){
        Hero hHero = (Hero)e.get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        Fase fFase = Desenhador.getTelaDoJogo().getMinhaFase();
        /*Processa todos os demais em relacao ao heroi*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                /*Nem todos os elementos podem ser transpostos pelo heroi*/ 
                if(eTemp.isColecionavel()) {
                    e.remove(eTemp);
                }
                if(eTemp.isbHostil()) {
                    hHero.morre();
                    fFase.resetFase(hHero);
                }
            }
        }
    }
    
    // Verifica se uma posição é válida (para o herói)
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
       if(p.getLinha() == -1 || p.getLinha() == 11 || p.getColuna() == -1 || p.getColuna() == 11){
            return false;
        }
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp.getPosicao().estaNaMesmaPosicao(p)){
                if(!eTemp.isbTransponivel()){
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
                }
            }
        }
        return true;
    }
    
    // Verifica se uma posição é válida (para os demais itens) analisando uma posição
    public boolean ehPosicaoValidaParaItens(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        //Validacao da posicao de todos os elementos com relacao a Posicao p
       if(p.getLinha() == -1 || p.getLinha() == 11 || p.getColuna() == -1 || p.getColuna() == 11){
            return false;
        }
        for(int i = 1; i < e.size(); i++){ //Olha todos os elementos
            eTemp = e.get(i); //Pega o i-esimo elemento do jogo
            if(eTemp.getPosicao().estaNaMesmaPosicao(p))
                return false; //A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá
        }
        return true;
    }
    
    // Pega o índice de um elemento que colidiu com o elemento "p"
    public int getIndiceElementoColidindo(ArrayList<Elemento> e, Elemento p){
        Elemento eStep;
        for(int i = 0; i < e.size(); i++){
            eStep = e.get(i);
            if(eStep.getPosicao().estaNaMesmaPosicao(p.getPosicao())){
                if(eStep != p){
                    return i;
                }
            }
        }
        return -1;
    }
    
    // Verifica se uma posição é válida (para os demais itens) analisando o próprio elemento
    public boolean ehPosicaoValidaRelativaAUmPersonagem(ArrayList<Elemento> e, Elemento umElemento) {
        Elemento eTemp;
        for(int i = 1; i < e.size(); i++) {
            eTemp = e.get(i);
            if(eTemp == umElemento)
                continue;
            if(eTemp.getPosicao().estaNaMesmaPosicao(umElemento.getPosicao())){
                if(!eTemp.isbTransponivel() || !umElemento.isbInterativo()){
                    return false;
                }
            }
        }
        return true;
    }
    
    // Verifica se há itens colecionáveis numa fase
    public boolean haColecionaveisAinda(ArrayList<Elemento> e) {
        for(int i = 1; i < e.size(); i++) {
            if(e.get(i).isColecionavel()) {
                return true;
            }
        }
        return false;
    }
    
    public Elemento getElementoArquivo(Posicao pStep, Elemento eASerSub){
        Elemento eRetornar = new BlocoSeta(pStep,1);
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String sCaminho = selectedFile.getAbsolutePath();
            
            try { //le arquivo compactado
            File fObjetoLer = new File(sCaminho);
            FileInputStream entrada = new FileInputStream(fObjetoLer);
            GZIPInputStream descompactador = new GZIPInputStream(entrada);
            ObjectInputStream deserializador = new ObjectInputStream(descompactador);

             eRetornar = (Elemento)deserializador.readObject();
             eRetornar.setPosicao(pStep);

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
        }
        else{
            eRetornar = eASerSub;
        }
        
        return eRetornar;
    }
}