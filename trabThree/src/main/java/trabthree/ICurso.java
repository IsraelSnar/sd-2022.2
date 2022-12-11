/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabthree;

import entidades.*;
import java.rmi.*;
import java.util.ArrayList;

/**
 *
 * @author israel
 */
public interface ICurso extends Remote {

    public void addAluno(Aluno aluno) throws RemoteException;

    public void createAluno(String nome) throws RemoteException;

    public void createAlunoGrad(String nome, int semestre, boolean iniCient) throws RemoteException;

    public void createAlunoPosGrad(String nome, int semestre) throws RemoteException;

    public ArrayList<Object> retAll() throws RemoteException;

    public void showAll() throws RemoteException;
}
