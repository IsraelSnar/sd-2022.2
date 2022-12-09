/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author israel
 */
public class Curso {

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
     */
    public Curso(String nome, String semInicio, String semAtual) {
        this.nome = nome;
        this.semAtual = semAtual;
        this.semInicio = semInicio;
    }

    /**
     *
     * @param nome do curso
     * @param semInicio do curso Criação do curso, e começou agora
     */
    public Curso(String nome, String semInicio) {
        this.nome = nome;
        this.semAtual = semInicio;
        this.semInicio = semInicio;
    }
    
    /**
     *
     * @param semInicio do curso Criação do curso, e começou agora
     */
    public Curso(String semInicio) {
        this.nome = "";
        this.semAtual = semInicio;
        this.semInicio = semInicio;
    }

    /**
     * Apenas adiciona um aluno que já existe
     * @param aluno
     */
    public void addAluno(Aluno aluno) {
        if (aluno.getCurso().toUpperCase().equals(this.getNome().toUpperCase())) {
            this.alunos.add(aluno);
            System.out.println("Aluno adicionado");
        } else {
            System.out.println("Não possível adicionar esse aluno, os cursos são diferentes");
        }
    }

    /**
     * Cria um novo aluno
     * @param nome do aluno
     */
    public void createAluno(String nome) {
        Aluno aluno = new Aluno();
        aluno.setCurso(this.getNome());
        aluno.setNome(nome);
        aluno.setSem(1);
        this.addAluno(aluno);
    }

    /**
     * Cria um aluno de graduação
     * @param nome do aluno
     * @param semestre do aluno
     * @param iniCient se ele é da iniciação cientifica
     */
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
     * @param nome do aluno
     * @param semestre do aluno
     */
    public void createAlunoPosGrad(String nome, int semestre) {
        AlunoPosGrad aluno = new AlunoPosGrad();
        aluno.setCurso(this.getNome());
        aluno.setNome(nome);
        aluno.setSem(semestre);
        this.addAluno(aluno);
    }
    
    /**
     *
     * @return array de objetos
     */
    public ArrayList<Object> retAll() {
        return this.alunos;
    }

    /**
     * Mostra todos alunos desse curso
     */
    public void showAll() {
        this.alunos.forEach((n) -> System.out.println(n));
    }

    /**
     * @return the nome
     */
    public String getNome() {
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

    /**
     *
     * @return nem sei oq era pra fazer
     */
    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
