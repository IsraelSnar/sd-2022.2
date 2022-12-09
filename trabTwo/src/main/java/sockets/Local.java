package sockets;

import entidades.Aluno;
import java.net.*;
import java.io.*;
import entidades.Curso;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author israel
 */
public class Local implements Serializable {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        // arguments supply message and hostname
        Scanner leitor = new Scanner(System.in);
//        Aluno aluno = new Aluno();
//        aluno.setNome("Moacir");
//        aluno.setCurso("Redes de Computadores");
//        aluno.setSem(4);
//        aluno.setSenha("Pagodeiro");
//
//        Aluno alg = new AlunoGrad();
//        alg.setCurso("Engenharia de software");
//        alg.setNome("Cleiton");
//        alg.setSem(2);

        Curso c = new Curso("2021.1");
//        c.addAluno(aluno);
//        c.addAluno(alg);
//        c.createAluno("Junim");
//        c.showAll();

        if (c.getNome().isEmpty()) {
            System.out.println("Informe nome do curso, informe com cuidado pois não será possível renomear posteriormente");
            c.setNome(leitor.nextLine());
        }

        ArrayList<Object> arrAl = new ArrayList<>();

        while (true) {
            String a = menu();
            String b[] = a.split(" ");
            int p = -1;
            int s = 0;
            try {
                p = Integer.parseInt(b[0]);
            } catch (NumberFormatException e) {
                System.err.println("Erro na escrita dos números o formato é: * *\ncada * representa número, não informe por extenso\ninforme o número com espaço");
            }

            switch (p) {
                case -1 -> {
                    break;
                }
                case 0 -> {
                    System.out.println("");
                    System.exit(0);
                }
                case 1 -> {
                    try {
                        s = Integer.parseInt(b[1]);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro na escrita dos números, informe apenas números, não informe por extenso ou adicione alguma letra");
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Erro, você só informou um número");
                        System.out.println("Informe no seguinte formato: * *\nCada * representa um número, informe a opção de criar aluno e depois qual aluno");
                        break;
                    }
                    switch (s) {
                        case 0 -> {
                            System.out.println("Informe nome do aluno");
                            String nome = leitor.nextLine();
                            c.createAluno(nome);
                        }
                        case 1 -> {
                            System.out.println("Informe nome do aluno");
                            String nome = leitor.nextLine();
                            System.out.println("Informe semestre do aluno");
                            int ss = leitor.nextInt();
                            System.out.println("Aluno de iniciação cientifica?\n1 - SIM\n2 - NÃO");
                            ss = leitor.nextInt();
                            c.createAlunoGrad(nome, ss, ((ss == 1)));
                        }
                        case 2 -> {
                            System.out.println("Informe nome do aluno");
                            String nome = leitor.nextLine();
                            System.out.println("Informe semestre do aluno");
                            int ss = leitor.nextInt();
                            c.createAlunoPosGrad(nome, ss);
                        }
                        default -> {
                            System.err.println("Você informou número errado");
                        }
                    }
                }
                case 2 -> {
                    enviar(c.retAll(), ((args.length) >= 1 ? args[0] : "localhost"));
                }
                case 3 ->
                    c.showAll();
                case 4 ->
                    readBack();
                default ->
                    /*throw new AssertionError()*/ System.err.println("");
            }
        }

        /*
            arrAl.add(aluno.toString());
            arrAl.add(alg.toString());
            System.out.println(Arrays.toString(arrAl.toArray()));
            System.out.println("Valores: " + arrAl.toString());
            ArrayList<Aluno> lista = new ArrayList();
            lista = (ArrayList<Object>) (Object) aluno;
            Desempacotamento ds = new Desempacotamento();
            Empacotamento em = new Empacotamento();
            em.gravarArquivoBinario(arrAl, "emdes.dat");
            enviar(arrAl, ((args.length) >= 1 ? args[0] : "localhost"));
            arrAl = ds.lerArquivoBinario("emdes.dat");
            System.out.println(arrAl.toString());
         */
    }

    /**
     * Funcao menu
     *
     * @return opcao
     */
    public static String menu() {
        /**
         * System.out.println("Informe número da operação: " + "\n0 - Sair\n1 -
         * Adicionar aluno\n0: Aluno\n1: Aluno de graduação\n2: Aluno de
         * Pós-graduação \n 2 - Backup (serializar)");
         */

        System.out.println("""
                           Informe n\u00famero da opera\u00e7\u00e3o:
                           0 - Sair
                           1 - Adicionar aluno
                            (utilize espa\u00e7o para separar que tipo de aluno est\u00e1 adicionando)
                            0: Aluno
                            1: Aluno de gradua\u00e7\u00e3o
                            2: Aluno de P\u00f3s-gradua\u00e7\u00e3o
                           2 - Backup
                           3 - Mostrar alunos
                           4 - Recuperar backup""");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }

    /**
     *
     * @param arrAl
     * @param ipDns
     */
    public static void enviar(ArrayList<Object> arrAl, String ipDns) {
        Socket s = null;
        try {
            int serverPort = 7896;

            s = new Socket(ipDns, serverPort); // se o arquivo for executado no terminal, pega o IP do servidor como parametro
            
            try (ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
                out.writeObject(arrAl);
                System.out.println("Enviado com sucesso");
            }
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
            System.out.println(e);
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {
                System.out.println("close:" + e.getMessage());
            }
        }
    }
    
    public static void readBack() {
        File fi;
        try {
            fi = new File("object.dat");

            if (fi.exists()) {
                ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fi));

                System.out.println((Object) objIn.readObject());
//                System.out.println(objIn.read());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
