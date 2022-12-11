/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package trabthree;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author israel
 */
public class Server {

    public static void main(String[] args) {
        try {
            ICurso curso = new Curso("2022.2");
            String objName = "//localhost/three";
            
//            LocateRegistry.createRegistry(5651);
            Naming.rebind(objName, curso);

            System.out.println("Hello World!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
