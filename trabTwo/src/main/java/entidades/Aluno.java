/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author israel
 */
public class Aluno implements Serializable{

    private String nome;
    private String senha;
    private String curso;
    private String id;
    private int sem;

    /**
     * remover ´bolsa´ 'iniciacao cientifica' é um atributo de aluno de graducao
     * 'bolsa' "" 'bolsa' depende de aluno de graducao, se ele for da iniciacao
     * ele pode ter bolsa
     */
    private enum tipo {
        GRADUACAO, POS_GRADUACAO
    };

    /**
     * Construtor da classe
     */
    public Aluno() {
        Random r = new Random();
        this.id = r.nextInt(999999) + "";

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int n = r.nextInt(8, 12);
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        this.senha = sb.toString();
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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the sem
     */
    public int getSem() {
        return sem;
    }

    /**
     * @param sem the sem to set
     */
    public void setSem(int sem) {
        this.sem = sem;
    }

    /**
     *
     * @return Informações do aluno
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCurso: " + this.getCurso() + "\n"
                + "Semestre: " + this.getSem() + "\nID: " + this.getId() + "\n";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
