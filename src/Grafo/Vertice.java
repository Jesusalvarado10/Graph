/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Lista.Lista;

/**
 *
 * Esta clase es para almacenar los arcos del vertice
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Vertice {
    //Campos de la clase
    int name;
    Lista listEdges;
/**
     * Constructor para el vertice
     *
     * @param name es el nombre del vertice osea el id del usuario
     * 
     */
    public Vertice(int name) {
        this.name = name;
        this.listEdges = new Lista();

    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Lista getListEdges() {
        return listEdges;
    }

    public void setListEdges(Lista listEdges) {
        this.listEdges = listEdges;
    }
  /**
     *
     * Método Agrega arcos en la listEdges
     *
     * @param value es un entero para saber el valor del arco
     * @param pointer es un numero entero y es el id del usuario al que se enlaza el vertice
    
     *
     */
    public void addEdges(int pointer, int value) {
        Arco edges = new Arco(pointer, value);
        listEdges.addLast(edges);

    }

    public void show() {
        listEdges.show();

    }

//    public String stringData(Lista nums) {
//        String datos = "";
//        for (int x = 0; x < listEdges.size(); x++) {
//            Arco arco = (Arco) listEdges.getValuePosition(x);
//            if (nums.search(arco.getPointer()) != true) {
//                datos += this.name + "," + arco.stringData() + "\n";
//            }
//        }
//        return datos;
//
//    }
  /**
     *
     * Método Eliminar arco de un vertice
     *
     * @param a es un entero id del usuario 
     *
     */
    public void delete(int a) {
        for (int x = 0; x < listEdges.size(); x++) {
            Arco arco = (Arco) listEdges.getValuePosition(x);
            if ((int) arco.getPointer() == a) {
                listEdges.eliminarElemento(x);
            }
        }

    }
  /**
     *
     * Método Crea una lista de arreglos
     *
     * @param v es un entero id del vertice
     * @param nums es una lista de arreglos
     * @return te regresa una lista de arreglos
     *
     */
    public Lista listEnlaces(int v, Lista nums) {

        for (int x = 0; x < listEdges.size(); x++) {
            int nums2 []= new int [3];
            Arco arco = (Arco) listEdges.getValuePosition(x);
            if (!nums.search2(v, arco.getPointer())) {
                nums2[0]=(int)arco.getPointer();
                nums2[1]=(int)v;
                nums2[2]=arco.getValue();
                nums.addLast(nums2);
            }

        }
        return nums;
    }
    public void eliminarArco(int id){
  
        listEdges.eliminarElemento(id);
    }
}
