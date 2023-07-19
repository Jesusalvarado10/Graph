/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Grafo.Arco;
import Grafo.Vertice;
import Lista.Lista;
import Lista.Nodo;
import User.User;
import javax.swing.JOptionPane;

/**
 *
 * Esta clase es para usar funciones en todo el archivo
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class Funciones {

    /**
     *
     * Método Transformar un string a int
     *
     * @param id es un string que deseamos pasarlo a entero
     * @return te regresa un entero
     *
     */
    static public int stringToInt(String id) {
        int num = 0;
        try {
            num = Integer.parseInt(id);
            if (num < 0) {
                throw new Error();
            }
        } catch (Exception e) {

        }
        return num;
    }

    /**
     *
     * Método Valida un usario, si tiene o no espacios, si tiene o no @
     *
     * @param name es un string nombre
     * @return el nombre con todos las caracterisitcas necesarias para trabajar
     *
     */
    static public String validateUsername(String name) {

        String nameWithOutSpa = name.replace(" ", "");
        char arroba = nameWithOutSpa.charAt(0);
        if (arroba == '@') {
            return nameWithOutSpa;
        }
        nameWithOutSpa = "@" + nameWithOutSpa;
        return nameWithOutSpa;
    }

    /**
     *
     * Método Hace listas de listas donde almacena los usuarios que pertenecen
     * en un grafo (ejem (13525) ((13)(525)))
     *
     * @param relaciones es un arreglo de string donde estan las relaciones del
     * programa
     * @param num es el numero de usuarios que hay
     * @return una lista de lista donde estan cuantos grafos hay y cuales son
     * los usuarios que pertenecen a ese grafo
     *
     */
    static public Lista groupsGraph(String[] relaciones, int num) {
        //Crea varias listas dependiendo de los grafos que hayan y regresa una lista
        boolean iteraciones = true;
        Lista total = new Lista();
        Lista nums = new Lista();

        while (iteraciones) {
            boolean iteraccion = true;
//            System.out.println(nums.size());
            for (String x : relaciones) {
                String valores[] = x.split(",");
                int a = Integer.parseInt(valores[0]);
                int b = Integer.parseInt(valores[1]);
//                System.out.println(valores[0] + " " + valores[1] + " " + valores[2]);
//                System.out.println(b);
                if (nums.isEmpty() == true) {
                    if (total.search(a) == false && total.search(a) == false) {
                        nums.addLast(a);
                        nums.addLast(b);
                        iteraccion = false;
                    }

                } else {
                    if (nums.search(a) == false && nums.search(b) == false) {
                        continue;
                    } else if (nums.search(a) == false) {
                        nums.addLast(a);
                        iteraccion = false;
//                        System.out.println("No existe a");
                    } else if (nums.search(b) == false) {
                        nums.addLast(b);
                        iteraccion = false;
//                        System.out.println("No existe b");
                    } else {
                        continue;
                    }

                }
            }
//            for (String x : relaciones) {
//                String valores[] = x.split(",");
//                int a = Integer.parseInt(valores[0]);
//                int b = Integer.parseInt(valores[1]);
//                if (nums.search(a) == false && nums.search(b) == false) {
//                    continue;
//                } else if (nums.search(a) == false) {
//                    nums.addLast(a);
////                        System.out.println("No existe a");
//                } else if (nums.search(b) == false) {
//                    nums.addLast(b);
////                        System.out.println("No existe b");
//                } else {
//                    continue;
//                }
//            }
//             nums.show();
            if (iteraccion) {
                if (nums.size() == num) {
                    iteraciones = false;
                    total.addLast(nums);
                } else {
                    if (total.isEmpty()) {
//                nums.show()

                        total.addLast(nums);
                        nums = new Lista();

                    } else {
                        total.addLast(nums);
                        Nodo aux = total.getHead();
//                nums.show();
                        int count = 0;
                        while (aux != null) {
                            Lista d = (Lista) aux.getData();
                            count = count + d.size();
//                    System.out.println(count);
                            aux = aux.getNext();
                        }
//                System.out.println( count);
//                System.out.println( num);
                        if (count == num) {
                            iteraciones = false;
                        } else {
                            nums = new Lista();
                        }
                    }
                }
            }

        }
        return total;

    }

    /**
     *
     * Método Quita los espacios en blanco y tambien hace un arreglo de string
     *
     * @param x es un string
     * @return un arreglo de string
     *
     */
    static public String[] relationshipsVir(String x) {
        String relationshipsWithOutSpa = x.replace(" ", "");
        String relationshipsSplit[] = relationshipsWithOutSpa.split("-");
        return relationshipsSplit;

    }

    /**
     *
     * Método Encuentra los puentes
     *
     * @param vertice es un entero para indicar el vertice
     * @param visitado es una arreglo booleano
     * @param tiempoDescubrimiento es un arreglo de enteros 
     * @param tiempoMinimo es un arreglo de enteros
     * @param padre es una arreglo de entero
     * @param nums es una lista de numeros
     * @param listAdy es una lista de vertice
     * @param tiempo es un entero
     *
     * @return te regresa el objeto
     *
     */
    static public void encontrarPuentesFun(int vertice, boolean[] visitado, int[] tiempoDescubrimiento,
            int[] tiempoMinimo, int[] padre, Lista nums, Lista listAdy, int tiempo) {
        visitado[vertice] = true;
        tiempoDescubrimiento[vertice] = tiempo;
        tiempoMinimo[vertice] = tiempo;
        tiempo++;
        Vertice v = (Vertice) listAdy.getValuePosition(vertice);
        Lista arcos = (Lista) v.getListEdges();
        int numHijos = 0;
        for (int x = 0; x < arcos.size(); x++) {
            Arco a = (Arco) arcos.getValuePosition(x);
            int index = nums.getPosicion(a.getPointer());
            if (!visitado[index]) {
                padre[index] = vertice;
                numHijos++;
                encontrarPuentesFun(index, visitado, tiempoDescubrimiento, tiempoMinimo, padre, nums, listAdy, tiempo);

                tiempoMinimo[vertice] = Math.min(tiempoMinimo[vertice], tiempoMinimo[index]);

                if (padre[vertice] == -1 && numHijos > 1) {

                    JOptionPane.showMessageDialog(null, "Puente encontrado: " + nums.getValuePosition(vertice) + " - " + nums.getValuePosition(index));

                }

                if (padre[vertice] != -1 && tiempoDescubrimiento[vertice] <= tiempoMinimo[index]) {
                    JOptionPane.showMessageDialog(null, "Puente encontrado: " + nums.getValuePosition(vertice) + " - " + nums.getValuePosition(index));
                }
            } else if (index != padre[vertice]) {
                tiempoMinimo[vertice] = Math.min(tiempoMinimo[vertice], tiempoDescubrimiento[index]);
            }

        }

    }
/**
     *
     * Método Encuentra los puentes
     *
     * @param vertice es un entero para indicar el vertice
     * @param visitado es una arreglo booleano
     * @param resultado es un string con los datos
     * @param nums es una lista de numeros
     * @param listAdy es una lista de vertice
     *
     * @return un string con todo el recorrido
     *
     */
    static public String recorridoProfundidadUtil(int vertice, boolean[] visitado, Lista nums, String resultado, Lista listAdy) {
        visitado[vertice] = true;
        Vertice v = (Vertice) listAdy.getValuePosition(vertice);
        resultado += v.getName() + " - ";
        Lista arcos = (Lista) v.getListEdges();
        for (int x = 0; x < arcos.size(); x++) {
            Arco a = (Arco) arcos.getValuePosition(x);
            int index = nums.getPosicion(a.getPointer());
            if (!visitado[index]) {
                resultado = recorridoProfundidadUtil(index, visitado, nums, resultado, listAdy);
            }
        }
        return resultado;
    }

    /**
     *
     * Método Una lista de arreglos la transformas en un string donde
     * almacenaras toods lo valores del programa
     *
     * @param nums es una lista de arreglo
     * @return un string de los datos
     */
    static public String mostrarString(Lista nums) {
        String palabra = "";
        for (int x = 0; x < nums.size(); x++) {
            int[] numeros = (int[]) nums.getValuePosition(x);
            palabra += numeros[0] + "," + numeros[1] + "," + numeros[2] + "\n";
        }
        return palabra;

    }

    /**
     *
     * Método Generas un id aleatorio que no exista
     *
     * @param users lista de usuarios
     * @return un entero id
     *
     */
    static public int generarId(Lista users) {
        int id;
        while (true) {
            id = (int) (Math.random() * (999 - 100 + 1)) + 100;
            if (String.valueOf(id).length() == 3) {
                if (users.search(id) != true) {
                    return id;
                }

            }

        }
    }

    /**
     *
     * Método Pasas la lista de usuarios en un string
     *
     * @param users es una lista de usarios
     * @return un string con los datos
     *
     */
    static public String mostrarUsuarios(Lista users) {
        String usuarios = "";
        for (int i = 0; i < users.size(); i++) {
            User u = (User) users.getValuePosition(i);
            usuarios += u.getId() + "," + u.getName() + "\n";
        }
        return usuarios;
    }

}
