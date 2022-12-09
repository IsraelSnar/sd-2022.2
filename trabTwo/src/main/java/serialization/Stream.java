//https://www.devmedia.com.br/introducao-a-serializacao-de-objetos/3050
package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entidades.*;

public class Stream {

//    /*public static void main(String[] args) {
//        // Cria o objeto serializado
////        Aluno aluno = new Aluno();
////        aluno.setNome("Joaquim");
////        aluno.setCurso("Redes de Computadores");
////        aluno.setSem(4);
////        aluno.setSenha("rolezeiro");
//    }*/

    public void serializar(Aluno aluno) {
        try {
            // Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav = new FileOutputStream("stream.dat");
            // Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            // Grava o objeto cliente no arquivo
            objGravar.writeObject(aluno);
            // Fecha streams ObjectOutputStream
            objGravar.flush();
            objGravar.close();
            // Fecha streams FileOutputStream	
            arquivoGrav.flush();
            arquivoGrav.close();
            System.out.println("Objeto gravado com sucesso!");
        } catch (Exception e) {
            System.out.println("Deu ruim 1");
            e.printStackTrace();
        }
    }

    public Aluno desSerializacao() {
        System.out.println("Recuperando objeto: ");
        try {
            // Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("stream.dat");
            // Recupera os objetos do arquivo
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            // Imprime os objetos
            System.out.println(objLeitura.readObject());

            /*Aluno aluno_novo = (Aluno) objLeitura.readObject();
            System.out.println(aluno_novo);

            objLeitura.close();
            arquivoLeitura.close();
            return aluno_novo;*/
        } catch (Exception e) {
            System.out.println("Deu ruim 2");
            e.printStackTrace();
        }
        return null;
    }

}
