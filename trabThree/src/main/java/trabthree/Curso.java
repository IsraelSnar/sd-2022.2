/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabthree;

import entidades.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author israel
 */
public class Curso extends UnicastRemoteObject implements ICurso {

    private String nome;
    private String semInicio;
    private String semAtual;
    private ArrayList<Object> alunos = new ArrayList<>();

    /**
     * Atualização do curso já existente
     *
     * @param nome do curso
     * @param semInicio
     * @param semAtual
     * @throws java.rmi.RemoteException
     */
    public Curso(String nome, String semInicio, String semAtual) throws RemoteException {
        this.nome = nome;
        this.semAtual = semAtual;
        this.semInicio = semInicio;
    }

    /**
     *
     * @param nome do curso
     * @param semInicio do curso Criação do curso, e começou agora
     * @throws java.rmi.RemoteException
     */
    public Curso(String nome, String semInicio) throws RemoteException {
        this.nome = nome;
        this.semAtual = semInicio;
        this.semInicio = semInicio;
    }

    /**
     *
     * @param semInicio do curso Criação do curso, e começou agora
     * @throws java.rmi.RemoteException
     */
    public Curso(String semInicio) throws RemoteException {
        this.nome = "";
        this.semAtual = semInicio;
        this.semInicio = semInicio;
    }

    /**
     * Apenas adiciona um aluno que já existe
     *
     * @param aluno
     */
    @Override
    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
        System.out.println("Aluno adicionado");
        System.out.println("Aluno: " + aluno.toString());
    }

    /**
     * Cria um novo aluno
     *
     * @param nome do aluno
     */
    @Override
    public void createAluno(String nome) {
        entidades.Aluno aluno = new entidades.Aluno();
        aluno.setCurso(this.getNome());
        aluno.setNome(nome);
        aluno.setSem(1);
        this.addAluno(aluno);
    }

    /**
     * Cria um aluno de graduação
     *
     * @param nome do aluno
     * @param semestre do aluno
     * @param iniCient se ele é da iniciação cientifica
     */
    @Override
    public void createAlunoGrad(String nome, int semestre, boolean iniCient) {
        AlunoGrad aluno = new AlunoGrad();
        aluno.setCurso(this.getNome());
        aluno.setNome(nome);
        aluno.setSem(semestre);
        aluno.setIniCient(iniCient);
        this.addAluno(aluno);
    }

    /**
     * Cria um aluno da pós graduação
     *
     * @param nome do aluno
     * @param semestre do aluno
     */
    @Override
    public void createAlunoPosGrad(String nome, int semestre) {
        AlunoPosGrad aluno = new AlunoPosGrad();
        aluno.setCurso(this.getNome());
        aluno.setNome(nome);
        aluno.setSem(semestre);
        this.addAluno(aluno);
    } 

    /**
     * Retornar todos os alunos para o usuário
     *
     * @return array de objetos
     */
    @Override
    public ArrayList<Object> retAll() {
        System.out.println("Retornando todos os alunos");
        this.alunos.forEach((n) -> System.out.println(n));
        return this.alunos;
    }

    /**
     * @return the nome
     */
    private String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the semInicio
     */
    public String getSemInicio() {
        return semInicio;
    }

    /**
     * @param semInicio the semInicio to set
     */
    public void setSemInicio(String semInicio) {
        this.semInicio = semInicio;
    }

    /**
     * @return the semAtual
     */
    public String getSemAtual() {
        return semAtual;
    }

    /**
     * @param semAtual the semAtual to set
     */
    public void setSemAtual(String semAtual) {
        this.semAtual = semAtual;
    }
}
