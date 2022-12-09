package util;

import entidades.Aluno;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exportacao {

    public static void main(String[] args) throws IOException {
        // desserializa��o: recuperando os objetos gravados no arquivo bin�rio "dados.dat"
        Aluno aluno = new Aluno();
        ArrayList<Object> pessoa = Desempacotamento.lerArquivoBinario("dados.dat");

        FileWriter arq = new FileWriter("export.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        int i = 1;
        int n = pessoa.size();

        for (Object item : pessoa) {
            //System.out.printf("Exportando %do. registro de %d: %s\n", i++, n, ((Pessoa) item).getNome());
            System.out.printf("Exportando . registro de : \n");

            //gravarArq.printf("Nome|%s;Peso Corporal|%.2f;Altura|%.2f;IMC|%.2f;Interpreta��o|%s%n");
            gravarArq.printf("Nome|;Peso Corporal|;Altura|;IMC|;Interpretacao|");
        }

        gravarArq.close();

        System.out.printf("\nExporta��o realizada com sucesso.\n");
    }

}
