/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Lista.Lista;
import User.User;
import javax.swing.JOptionPane;

/**
 *
 * Esta clase es para almacenar los grafos y hacer pequeñas funciones
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Isla<T> {
    //Campos de la clase

    Lista graph;
    Lista users;
    int numGraph;

    /**
     * Constructor para Isla
     *
     * @param n es un entero que se le asigna al numero de grafos que tiene el
     * programa
     */
    public Isla(int n) {
        // Los indices de los arrays de grafo y usuarios representa la similitud que hay entre ellos, que quiere decri en el grafo 1 tendra la lista de usuarios 1 (graph[0]==users[0])
        this.graph = new Lista();
        this.users = new Lista();
        this.numGraph = n;
    }

    /**
     *
     * Método Agrega grafos en la lista
     *
     *
     */
    public void addGraph() {
        Grafo graphnew;
        for (int i = 0; i < numGraph; i++) {
            graphnew = new Grafo();
            graph.addLast(graphnew);
        }
//        System.out.println(graph.size());
    }

    /**
     *
     * Método Agrega vertices al grafo
     *
     * @param index es un entero para saber en que grafo trabajamos
     * @param a es una lista de los usuarios que se encuentran en ese grafo
     * @return te regresa el objeto
     *
     */
    public void addVertex(int index, Lista a) {
        Grafo graphIndex = (Grafo) graph.getValuePosition(index);
        graphIndex.addVertex(a);
    }
  /**
     *
     * Método Agrega los arcos
     *
     * @param aux es una lista de usuarios que estan agrupados por grafo
     *  @param index es un entero para saber en que grafo trabajamos
     * @param relaciones es un arreglo de string donde esta todas las informaciones del grafo 
     * @return te regresa el objeto
     *
     */
    public void passEdges(Lista aux, String[] relaciones, int index) {
        Grafo graphIndex = (Grafo) graph.getValuePosition(index);
//        aux.show();
        for (String j : relaciones) {
            String valores[] = j.split(",");
            int a = Integer.parseInt(valores[0]);
            int b = Integer.parseInt(valores[1]);
            int c = Integer.parseInt(valores[2]);
            if (graphIndex.getListAdy().search(a) && graphIndex.getListAdy().search(b)) {
                graphIndex.insertarArco(a, b, c);
            }
        }
//        graphIndex.showGrafo();
    }
 /**
     *
     * Método Buscas el grafo en el que se encuentra el valor a
     *
     * @param a es una entero que necesitamos saber en que grafo se encuentra
     * @return T El vertice
     *
     */
    public T geatGraphSearch(int a) {
        for (int x = 0; x < graph.size(); x++) {
            Grafo graphIndex = (Grafo) graph.getValuePosition(x);
            if (graphIndex.search(a)) {
                return (T) graph.getValuePosition(x);

            }
        }
        return null;
    }

    public Lista getGraph() {
        return graph;
    }
 /**
     *
     * Método Busca los usuarios por id y nombre 
     *
     * @param name es un string y define el nombre del usuario
     *  @param id es un entero que define el codigo del usuario
     * @return verdadero o falso
     *
     */
    public boolean searchUsersId(String name, int id) {
        if (users.search(id)) {
            User u = (User) users.getDato(id);
//            System.out.println(u.getName());
            if (u.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
 /**
     *
     * Método Busca si el nombre de un usuario existe o no
     *
     * @param name es un string que define el nombre del usuario
     * @return te regresa un usuario
     *
     */
    public User searchUsersName(String name) {
        User aux = null;
        for (int x = 0; x < users.size(); x++) {
            aux = (User) users.getValuePosition(x);
            if (aux.getName() == name) {
                return aux;
            }
        }

        return null;
    }
 /**
     *
     * Método Devuelve el usuario
     *
     * @param id es un entero que se busca en la lista de usuarios
     *  @param name no se usa
     * @return usuario
     *
     */
    public User getUsers(String name, int id) {
        User user = (User) users.getDato(id);
        return user;
    }

    public void setGraph(Lista graph) {
        this.graph = graph;
    }

    public Lista getUsers() {
        return users;
    }

    public void setUsers(Lista users) {
        this.users = users;
    }

    public int getNumGraph() {
        return numGraph;
    }

    public void setNumGraph(int numGraph) {
        this.numGraph = numGraph;
    }

//    public String strinData() {
//
//        String data = "";
//        for (int x = 0; x < graph.size(); x++) {
//            Grafo graphIndex = (Grafo) graph.getValuePosition(x);
//            data += graphIndex.stringData();
//        }
//        return data;
//    }
     /**
     *
     * Método Busca los puentes en todos los grafos
     *
     */
    public void encontrarPuentes() {
        String puentes = "";
        for (int x = 0; x < graph.size(); x++) {
            Grafo graphIndex = (Grafo) graph.getValuePosition(x);
            graphIndex.encontrarPuentes();

        }

    }
 /**
     *
     * Método Recorre el grafo por BFS
     *@return String del recorrido 
     */
    public String mostrarGrafoBFS() {
        String resultado = "";

        for (int x = 0; x < graph.size(); x++) {
            Grafo graphIndex = (Grafo) graph.getValuePosition(x);
            resultado += "\n" + (x + 1) + ". " + "Amplitud \n";
            resultado += graphIndex.recorridoAmplitud(0);
        }
        return resultado;
    }

     /**
     *
     * Método Recorre el grafo por DFS
     *@return String del recorrido 
     */
    public String mostrarGrafoDFS() {
        String resultado = "";
        for (int x = 0; x < graph.size(); x++) {
            resultado += "\n" + (x + 1) + ". " + "Profundidad \n";
            Grafo graphIndex = (Grafo) graph.getValuePosition(x);
            resultado += graphIndex.recorridoProfundidad(0);

        }
        return resultado;
    }
 /**
     *
     * Método Hace una lista de arreglos con los valores de los grafos
     * @return una lista de los enlaces de todos los grafos
     *
     */
    public Lista grafosConexos() {
        Lista nums = new Lista();
        for (int x = 0; x < graph.size(); x++) {
            Grafo graphIndex = (Grafo) graph.getValuePosition(x);
            nums = graphIndex.listEnlaces(nums);
        }
        return nums;
    }
}
