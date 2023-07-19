/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectografo;

import MainUI.MainUI;

/**
 * Esta clase es donde el programa inicio (main)
 *
 * @author Jesus
 * @version 4/6.2023
 *
 */
public class ProyectoGrafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("org.graphstream.ui", "swing");
        MainUI main = new MainUI();  //Llama la interfaz main del programa
        main.setVisible(true);
    }
    //Fin de la clase
}
