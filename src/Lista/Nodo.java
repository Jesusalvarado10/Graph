/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

/**
 *
 * Esta clase es para los nodos
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Nodo<T> {
    //Campos de la clase

    T data;
    Nodo next;

    /**
     * Constructor para el nodo
     *
     * @param data es un valor que se le asignara el nodo para enlazarlos
     */
    public Nodo(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
