/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Funciones.Funciones;
import Lista.Lista;

/**
 *
 * Esta clase es para los grafos donde se almacenaran los vertices
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Grafo<T> {
      //Campos de la clase

    private int numVertices;
    private Lista listAdy;
    private int tiempo;

 /**
     * Constructor para el grafo
     *
     */
    public Grafo() {

        this.numVertices = 0;
        this.listAdy = new Lista();
        this.tiempo = 0;

    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public Lista getListAdy() {
        return listAdy;
    }

    public void setListAdy(Lista listAdy) {
        this.listAdy = listAdy;
    }
   /**
     *
     * Método Inserta arcos en los respectivos vertices
     *
     * @param a es un entero del id 
     * @param b es un entero del id 
     *    @param c es un entero del valor de la relacion
     *
     */
    public void insertarArco(int a, int b, int c) {
        Vertice vertexA = (Vertice) listAdy.getDato(a);
        Vertice vertexB = (Vertice) listAdy.getDato(b);
        vertexA.addEdges(b, c);
        vertexB.addEdges(a, c);

    }
 /**
     *
     * Método Agrega en la listaAdy los respectivos vertices 
     *
     * @param a es una Lista con los usuarios de ese grafo
     */
    public void addVertex(Lista a) {
        for (int i = 0; i < a.size(); i++) {
            int num = (int) a.getValuePosition(i);
            Vertice vertex = new Vertice(num);
//            vertex.show();
            listAdy.addLast(vertex);
            numVertices++;
        }
    }
 /**
     *
     * Método Muestra el grafo pero no se usa es para usos practicos de visualizacion de la edd
     */
    public void showGrafo() {
        listAdy.show();

    }
 /**
     *
     * Método Inserta un nuevo vertice en la listaAdy
     *
     * @param a es el id de un usuario
  
     */
    public void newVertex(int a) {
        Vertice vertex = new Vertice(a);
        listAdy.addLast(vertex);

    }
 /**
     *
     * Método Inserta arcos en diferentes grafos
     *
     * @param a es un entero del id 
     * @param b es un entero del id 
     *    @param c es un entero del valor de la relacion
     *
     */
    public void edgesDiffGraph(int a, int b, int value) {
        Vertice vertexA = (Vertice) listAdy.getDato(a);
        vertexA.addEdges(b, value);
        numVertices++;
    }

//    public String stringData() {
//        String data = "";
//        Lista rep = new Lista();
//        for (int x = 0; x < listAdy.size(); x++) {
//            Vertice v = (Vertice) listAdy.getValuePosition(x);
//            rep.show();
//            data += v.stringData(rep);
//            rep.addLast(v.getName());
//        }
//        return data;
//    }

 /**
     *
     * Método Visita todos lo vertices de la lista para ver cuales vertices son puentes y cuales no
     */
    public void encontrarPuentes() {
        Lista nums = new Lista();
        boolean[] visitado = new boolean[numVertices];
        int[] tiempoDescubrimiento = new int[numVertices];
        int[] tiempoMinimo = new int[numVertices];
        int[] padre = new int[numVertices];
        for (int x = 0; x < numVertices; x++) {
            Vertice v = (Vertice) listAdy.getValuePosition(x);
            nums.addLast(v.getName());
        }

        for (int i = 0; i < numVertices; i++) {
            padre[i] = -1;
            visitado[i] = false;
        }

        tiempo = 0;

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
              Funciones.encontrarPuentesFun(i, visitado, tiempoDescubrimiento, tiempoMinimo, padre, nums, listAdy, this.tiempo);

            }
        }

        

    }

    public String recorridoProfundidad(int verticeInicial) {
        Lista nums = new Lista();
        for (int x = 0; x < numVertices; x++) {
            Vertice v = (Vertice) listAdy.getValuePosition(x);
            nums.addLast(v.getName());
        }
        boolean[] visitado = new boolean[numVertices];
        String resultado = "";
        resultado = Funciones.recorridoProfundidadUtil(verticeInicial, visitado, nums, resultado, listAdy);
        return resultado;
    }

    public String recorridoAmplitud(int verticeInicial) {
        boolean[] visitado = new boolean[numVertices];
        Lista cola = new Lista();
        Lista nums = new Lista();
        String resultado = "";
        for (int x = 0; x < numVertices; x++) {
            Vertice v = (Vertice) listAdy.getValuePosition(x);
            nums.addLast(v.getName());
        }

        visitado[verticeInicial] = true;
        Vertice v = (Vertice) listAdy.getValuePosition(verticeInicial);
        cola.addLast(v);

        while (!cola.isEmpty()) {
            v = (Vertice) cola.getValuePosition(0);
            cola.deleteFirst();
            resultado += v.getName() + " - ";
            Lista arcos = (Lista) v.getListEdges();
            for (int x = 0; x < arcos.size(); x++) {
                Arco arco = (Arco) arcos.getValuePosition(x);
                int arcoIndex = nums.getPosicion((int) arco.getPointer());
                if (!visitado[arcoIndex]) {
                    visitado[arcoIndex] = true;

                    v = (Vertice) listAdy.getValuePosition(arcoIndex);
                    cola.addLast(v);
                }
            }
        }
        return resultado;
    }

    public boolean search(int a) {
        return listAdy.search(a);
    }

    public Lista listEnlaces(Lista nums) {
        
        for (int x = 0; x < listAdy.size(); x++) {
            Vertice v = (Vertice) listAdy.getValuePosition(x);
            nums = v.listEnlaces(v.getName(), nums);

        }
        return nums;
    }
    public void eliminarVerte(int id){
        listAdy.eliminarElemento(id);
       
    }
}
