/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabthree;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author israel
 */
public class Cliente {

    public static void main(String[] args) throws RemoteException {
        String objName = "//localhost/three";
        Scanner leitor = new Scanner(System.in);
        String nome;
        int ss;
        int in;
        ICurso three = null;
        int p = (-1);
        int s = (-1);

        try {
            three = (ICurso) Naming.lookup(objName);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Erro: " + e.getMessage());
            System.exit(1);
        }

        while (true) {
            System.out.println("Informe número da operação:\n"
                    + "0 - Sair\n"
                    + "1 - Adicionar aluno\n"
                    + "(utilize espaço para separar que tipo de aluno está adicionando)\n"
                    + " 0: Aluno\n"
                    + " 1: Aluno de graduação\n"
                    + " 2: Aluno de Pós-graduação\n"
                    + "2 - Mostrar alunos");
            String a = leitor.nextLine();
            String b[] = a.split(" ");

            try {
                p = Integer.parseInt(b[0]);
            } catch (NumberFormatException e) {
                System.err.println("Erro na escrita dos números o formato é: * *\ncada * representa número, não informe por extenso\ninforme o número com espaço");
            }

            switch (p) {
                case -1:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                case 1:
                    try {
                    s = Integer.parseInt(b[1]);
                } catch (NumberFormatException e) {
                    System.err.println("Erro na escrita dos números, informe apenas números, não informe por extenso ou adicione alguma letra");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Erro, você só informou um número\nInforme no seguinte formato: * *\nCada * representa um número, informe a opção de criar aluno e depois qual aluno");
                }
                switch (s) {
                    case 0:
                        // Aluno 
                        System.out.println("Informe nome do aluno");
                        nome = leitor.nextLine();
                        three.createAluno(nome);
                        break;
                    case 1:
                        try {
                        System.out.println("Informe nome do aluno");
                        nome = leitor.nextLine();
                        System.out.println("Informe semestre do aluno");
                        ss = leitor.nextInt();
                        System.out.println("Aluno de iniciação cientifica?\n1 - SIM\n2 - NÃO");
                        in = leitor.nextInt();
                        three.createAlunoGrad(nome, ss, ((in == 1)));
                    } catch (InputMismatchException e) {
                        System.out.println("Você não informou número");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    case 2:
                        try {
                        System.out.println("Informe nome do aluno");
                        nome = leitor.nextLine();
                        System.out.println("Informe semestre do aluno");
                        ss = leitor.nextInt();
                        three.createAlunoPosGrad(nome, ss);
                    } catch (InputMismatchException e) {
                        System.out.println("Você não informou número");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    default:
                        System.err.println("Você informou número errado");
                        three.showAll();
                        break;
                }
                break;
                case 2:
                    three.retAll().forEach(n -> System.out.println(n));
                    if (three.retAll().isEmpty()) {
                        System.out.println("Vazio");
                        three.showAll();
                    }
                    break;
                default:
                    System.err.println("ALgo de errado não está certo");
                    break;
            }
        }
    }
}
