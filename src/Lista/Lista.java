/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Grafo.Arco;
import Grafo.Vertice;
import User.User;

/**
 *
 * Esta clase es para las listas
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Lista<T> {
     //Campos de la clase

    Nodo head;
 /**
     * Constructor para Lista al crear la lista se coloca null la cabeza ya que esta vacia
     * 
     */
    public Lista() {
        this.head = null;
    }
    //Elimina el ultimo elemento de la lista
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }

        if (head.getNext() == null) {
            head = null;
            return;
        }

        Nodo Aux = head;
        while (Aux.getNext().getNext() != null) {
            Aux = Aux.getNext();
        }

        Aux.setNext(null);
    }
//Elimina el primer elemento de la lista
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.getNext();
    }
/**

     * Método si el valor es igual al dato te regresa el dato
     * @param  data es un valor x 

     * @return  te regresa el objeto

     */
    public T getDato(T data) {

        Nodo aux = head;
        while (aux != null) {
            String x = String.valueOf(aux.getData().getClass());
            switch (x) {
                case "class Grafo.Arco":
                    Arco arco = (Arco) aux.getData();
                    if (arco.getPointer() == data) {
                        return (T) aux.getData();
                    }
                case "class User.User":
                    User usuario = (User) aux.getData();
                    if (usuario.getId() == (int) data) {
                        return (T) aux.getData();
                    }
                    break;
                case "class Grafo.Vertice":
                    Vertice vertex = (Vertice) aux.getData();
                    if (vertex.getName() == (int) data) {
                        return (T) aux.getData();
                    }

                default:
                    if (aux.getData() == data) {
                        return (T) aux.getData();
                    }

            }
            aux = aux.getNext();
        }
        return null;
    }

    /**

     * Método Te dice en que posicion se encuentra tu dato
     * @param  dat0 es un valor x que desas saber la posicion

     * @return  te regresa la posicion del objeto empezando de 0

     */
    public int getPosicion(T dato) {

        Nodo aux = head;
        String x;
        int i = 0;
        while (aux != null) {
            x = String.valueOf(aux.getData().getClass());
            switch (x) {
                case "class User.User":
                    User j = (User) aux.getData();
                    if (j.getId() == (int) dato) {
                        return i;
                    }
                    break;
                case "class Grafo.Arco":
                    Arco a = (Arco) aux.getData();
                    if (a.getPointer() == dato) {
                        return i;
                    }
                    break;
                case "class Grafo.Vertice":
                    Vertice n = (Vertice) aux.getData();
                    if (n.getName() == (int) dato) {
                        return i;
                    }
                    break;

                default:
                    if ((int) aux.getData() == (int) dato) {
                        return i;
                    }
                    break;
            }
            i++;
            aux = aux.getNext();
        }
        return -1;
    }
/**

     * Método Te regresa el valor dependiendo la posicion que se encuentre
     * @param  d es un entero que indica la posicion del dato

     * @return  te regresa el objeto

     */
    public T getValuePosition(int d) {
        Nodo aux = head;
        int i = 0;
        while (aux != null) {
            if (i == d) {
                return (T) aux.getData();
            }
            i++;
            aux = aux.getNext();
        }
        return null;
    }
/**

     * Método si la lista esta vacio te lo dice

     * @return  falso o verdadero

     */
    public boolean isEmpty() {
        return head == null;
    }
/**

     * Método te indica el tamaño de la lista

     * @return  el tamaño entero de la lista

     */
    public int size() {
        Nodo aux = head;
        int i = 0;
        while (aux != null) {
            i++;
            aux = aux.getNext();
        }
        return i;
    }
/**

     * Método Muestra los valores  no se usa, esta unicamente para ver que los valores se guarden bien.

     */
    public void show() {

        int i = 0;
        Nodo aux = head;
        while (aux != null) {
            String x = String.valueOf(aux.getData().getClass());
            switch (x) {
                case "class Grafo.Arco":
                    Arco a = (Arco) aux.getData();
                    System.out.println("Destino: " + a.getPointer() + " " + a.getValue());
                    System.out.println();
                    break;

                case "class User.User":
                    User c = (User) aux.getData();
                    System.out.println(i + " " + c.getId() + " . " + c.getName());
                    i++;
                    break;

                case "class Grafo.Vertice":
                    Vertice vertex = (Vertice) aux.getData();
                    System.out.println("Vertice: " + vertex.getName());
                    vertex.show();
                    break;

                default:
                    System.out.println(aux.getData());
                    break;
            }
            aux = aux.getNext();
        }
    }
/**

     * Método Busca si el valor data se encuentra en la lista
     * @param data es un objeto o valor 

     * @return  verdadero o falso

     */
    public boolean search(T data) {
        Nodo aux = head;
        while (aux != null) {
            String x = String.valueOf(aux.getData().getClass());
            switch (x) {
                case "class Grafo.Arco":
                    Arco arco = (Arco) aux.getData();
                    System.out.println(arco.getPointer());
                    if ((int) arco.getPointer() == (int) data) {
                        return true;
                    }
                    break;
                case "class User.User":
                    User usuario = (User) aux.getData();
                    if (usuario.getId() == (int) data) {
                        return true;
                    }
                    break;
                case "class Lista.Lista":

                    Lista lista = (Lista) aux.getData();

                    if (lista.search(data) == true) {

                        return true;
                    }
                    break;
                case "class Grafo.Vertice":
                    Vertice vertex = (Vertice) aux.getData();
                    if (vertex.getName() == (int) data) {

                        return true;

                    }
                    break;
                default:
                    if ((int) aux.getData() == (int) data) {
                        return true;
                    }
                    break;
            }
            aux = aux.getNext();
        }
        return false;
    }
/**

     * Método elimina un elemento de la lista
     * @param  valor es un entero que al ser verdadero lo elimina de la lista

     * @return  El valor del dato que se elimino

     */
    public T eliminarElemento(int valor) {
        if (isEmpty()) {
            System.out.println("Esta vacio.");
        } else {
            Nodo aux = head;
            Nodo prev = null;
            while (aux != null) {
                String x = String.valueOf(aux.getData().getClass());
                switch (x) {
                    case "class Grafo.Vertice":
                        Vertice vertex = (Vertice) aux.getData();
                        if (vertex.getName() == valor) {
                            if (head == aux && size() == 1) {
                                head = null;
                                return (T) aux.getData();
                            } else if (head == aux && size() > 1) {
                                head = aux.getNext();
                                return (T) aux.getData();
                            } else {
                                if (aux.getNext() != null) {
                                    prev.setNext(aux.getNext());
                                    aux.setNext(null);
                                    return (T) aux.getData();
                                } else {
                                    prev.setNext(null);
                                    return (T) aux.getData();
                                }
                            }
                        }
                        break;
                    case "class Grafo.Arco":
                        Arco arco = (Arco) aux.getData();
                        if ((int) arco.getPointer() == valor) {
                            if (head == aux && size() == 1) {
                                head = null;
                                return (T) aux.getData();
                            } else if (head == aux && size() > 1) {
                                head = aux.getNext();
                                return (T) aux.getData();
                            } else {
                                if (aux.getNext() != null) {
                                    prev.setNext(aux.getNext());
                                    aux.setNext(null);
                                    return (T) aux.getData();
                                } else {
                                    prev.setNext(null);
                                    return (T) aux.getData();
                                }
                            }
                        }
                        break;
                    case "class User.User":
                        User usuario = (User) aux.getData();
                        if ((int) usuario.getId() == valor) {
                            if (head == aux && size() == 1) {
                                head = null;
                                return (T) aux.getData();
                            } else if (head == aux && size() > 1) {
                                head = aux.getNext();
                                return (T) aux.getData();
                            } else {
                                if (aux.getNext() != null) {
                                    prev.setNext(aux.getNext());
                                    aux.setNext(null);
                                    return (T) aux.getData();
                                } else {
                                    prev.setNext(null);
                                    return (T) aux.getData();
                                }
                            }
                        }
                        break;
                }
                prev = aux;
                aux = aux.getNext();
            }

        }
        return null;
    }
/**

     * Método Añade de ultimo un valor en la lista
     * @param value es un valor cualquiera que se añadera en la lista

     */
    public void addLast(T value) {
        Nodo aux = head;
        Nodo add = new Nodo(value);
        if (isEmpty() == true) {
            head = add;
        } else {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(add);
        }
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getLast() {
        Nodo aux = head;
        if (isEmpty() == true) {
        } else {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            return aux;
        }
        return null;
    }
/**

     * Método Busca dos valores de un arreglo para saber si se encuentra ahi
     * @param  data es un entero para comparar
     * @param  data2 es un entero para comparar

     * @return  verdadero o falso

     */
    public boolean search2(T data, T data2) {
        Nodo aux = head;
        while (aux != null) {
            int[] numeros = (int[]) aux.getData();
            if ((int) data == numeros[0] || (int) data == numeros[1]) {
                if ((int) data2 == numeros[0] || (int) data2 == numeros[1]) {
                    return true;
                }
            }

            aux = aux.getNext();
        }
        return false;
    }
}
