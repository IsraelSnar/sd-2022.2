/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author israel
 */
public class AlunoGrad extends Aluno {

    private boolean iniCient;
    private String bolsa;

    /**
     * @return the iniCient
     */
    public boolean isIniCient() {
        return iniCient;
    }

    /**
     * @param iniCient the iniCient to set
     */
    public void setIniCient(boolean iniCient) {
        this.iniCient = iniCient;
    }

    /**
     *
     * @return Informações de cada aluno
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCurso de Graduação: " + this.getCurso() + "\n"
                + "Semestre: " + this.getSem() + "\nID: " + this.getId() + "\nIniciação Científica: "
                + this.isIniCient() + "\n";
    }

    /**
     * @return the bolsa
     */
    public String getBolsa() {
        return bolsa;
    }

    /**
     * @param bolsa the bolsa to set
     */
    public void setBolsa(String bolsa) {
        this.bolsa = bolsa;
    }
}
