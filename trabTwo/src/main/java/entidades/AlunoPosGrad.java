/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author israel
 */
public class AlunoPosGrad extends Aluno {

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCurso de Pós: " + this.getCurso() + "\n"
                + "Semestre: " + this.getSem() + "\nID: " + this.getId() + "\n";
    }

}
