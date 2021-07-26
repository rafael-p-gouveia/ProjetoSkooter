/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author R
 */
import static Auxiliar.Consts.*;
import Auxiliar.Posicao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; // cano pra sair
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Posicao pStep = new Posicao(0,0);
        
        criaArquivo(new BlocoSeta(pStep,UP),"blocoCima.dat");
        criaArquivo(new BlocoSeta(pStep,DOWN),"blocoBaixo.dat");
        criaArquivo(new BlocoSeta(pStep,LEFT),"blocoEsquerda.dat");
        criaArquivo(new BlocoSeta(pStep,RIGHT),"blocoDireita.dat");
        criaArquivo(new RoboRosa(pStep),"roboRosa.dat");
        criaArquivo(new PacMan(),"pacMan.dat");
        
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }
        
 }
    static void criaArquivo(Elemento eElemento, String nome){
        try { //cria arquivo compactado, se ja nao existir
            
            File fArquivo = new File(nome);
            if (!fArquivo.exists()) {
                fArquivo.createNewFile();
            }
            FileOutputStream saida = new FileOutputStream(fArquivo);
            GZIPOutputStream compactador = new GZIPOutputStream(saida);
            ObjectOutputStream serializador = new ObjectOutputStream(compactador);

            serializador.writeObject(eElemento);

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
}
