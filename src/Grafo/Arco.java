/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;
/**
 *
 * Esta clase es para almacenar los valores del arco
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Arco<T> {
        //Campos de la clase

    private T pointer;
    private int value;
 /**
     * Constructor para arco
     *
     * @param pointer es un entero que se le asigna al numero que hace enlace el vertice
     * @param value es un entero y es el valor del arco
     */
    public Arco(T pointer, int value) {
        this.pointer = pointer;
        this.value = value;
    }

    public T getPointer() {
        return pointer;
    }

    public void setPointer(T pointer) {
        this.pointer = pointer;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
//    public String stringData(){
//    String x=this.pointer+" ,"+this.value;
//    return x;
//    }

}
