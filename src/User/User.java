/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * Esta clase es para los usuarios donde contiene su name y id
 *
 * @author: Jesus
 *
 * @version4/6/2023
 *
 *
 *
 */
public class User {
    //Campos de la clase

    private int id;
    private String name;
 /**

     * Constructor para user

     * @param id es un numero entero unico donde se puede diferenciar un usario de otro
     * @param name es un string que le asigna un nombre al user

     */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
//Asignar y pedir los valores de los atributos de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
