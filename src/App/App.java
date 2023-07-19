/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Funciones.Funciones;
import Grafo.Grafo;
import Grafo.Isla;
import Grafo.Vertice;
import Lista.Lista;
import User.User;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * Esta clase es para correr la mayoria de las funcionalidades del programa
 *
 * @author: Jesus
 *
 * @version:4/6/2023
 *
 *
 *
 */
public class App {

    //Campos de la clase
    Isla isla;
    File file;

    /**
     * Constructor para la app
     */
    public App() {
        this.isla = null;
        this.file = null;
    }

    /**
     *
     * Método Organiza los datos de las islas
     *
     * @param users es un lista de usuarios
     * @param relationships es un string de las relaciones
     *
     */
    public void organizarDatos(Lista users, String relationships) {
//        System.out.println(relationships);
        //Aqui se van pasando los datos para despues crear la isla
        String relationshipsSplit[] = Funciones.relationshipsVir(relationships);
//        for (int i = 0; i <relationshipsSplit.length; i++) {
//             System.out.println(relationshipsSplit[i]);
//        }
        int num = users.size();
        Lista x = Funciones.groupsGraph(relationshipsSplit, num);
        int i = x.size();
        this.isla = new Isla(i);
        this.isla.addGraph();
        this.isla.setUsers(users);

        for (int a = 0; a < i; a++) {
            Lista aux = (Lista) x.getValuePosition(a);
            this.isla.addVertex(a, aux);

            this.isla.passEdges(aux, relationshipsSplit, a);
        }
//        this.isla.getUsers().show();

    }

    /**
     *
     * Método Se le pasan los vertices provenientes del usuario
     *
     * @param a es un entero de un id
     * @param b es un entero de un id
     * @param value es un entero valor del arco
     *@return null para terminar el metodo y no siga
     */

    public User edgeUser(int a, int b, int value) {
        if (isla.getUsers().search(b)) {
            Grafo graphA = (Grafo) isla.geatGraphSearch(a);
            Grafo graphB = (Grafo) isla.geatGraphSearch(b);
            if (graphA == null) {
                graphB.newVertex(a);
                graphB.insertarArco(a, b, value);

            } else if (graphA != graphB) {
                graphA.edgesDiffGraph(a, b, value);
                graphB.edgesDiffGraph(b, a, value);

            } else if (graphB == null) {
                graphA.newVertex(b);
                graphA.insertarArco(a, b, value);
//                System.out.println(a);
//                System.out.println(b);
//                graphA.showGrafo();

            } else {
                graphA.insertarArco(a, b, value);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario que usted ingreso no existe :(");
            return null;
        }
        arreglar();
        return null;
    }

    public void mostrarTodo() {
//        System.out.println(isla.strinData());
    }
 /**
     *
     * Método Se busca un nombre y un id para buscar el usuario
     *
     * @param name string nombre del usuario
     * @param id string id del usuario
     * @return  regresa el usuario con esos parametros que se dieron
     *
     */
    public User getUser(String name, String id) {
        String namefinal = Funciones.validateUsername(name);
        int nId = Funciones.stringToInt(id);

        return this.isla.getUsers(namefinal, nId);
    }
 /**
     *
     * Método Se busca un nombre y un id para buscar el usuario
     *
     * @param name string nombre del usuario
     * @param id string id del usuario
     * @return  verdadero o falso 
     *
     */
    public boolean userOld(String name, String id) {
        String namefinal = Funciones.validateUsername(name);
        int nId = Funciones.stringToInt(id);
        if (nId == 0) {
            return false;
        } else {
            System.out.println(namefinal);
            if (this.isla.searchUsersId(namefinal, nId)) {
                System.out.println("paso");
                return true;
            }
        }
        return false;
    }
 /**
     *
     * Método Se recorre el grafo BFS
     *
     * @return  String del recorrido
     *
     */
    public String mostrarGrafoBFS() {
        return isla.mostrarGrafoBFS();
    }
/**
     *
     * Método Se recorre el grafo DFS
     *
     * @return  String del recorrido
     *
     */
    public String mostrarGrafoDFS() {
        return isla.mostrarGrafoDFS();
    }
/**
     *
     * Método Recorre el grafo buscand los puentes
     */
    public void puentes() {
        Lista num;
        isla.encontrarPuentes();

        num = isla.grafosConexos();
        Funciones.mostrarString(num);
    }
/**
     *
     * Método crea una lista de arreglos
     *
     * @return  una lista de arreglos para que la libreria pueda leer los datos y dibujar el grafo
     *
     */
    public Lista mostrarInterfaz() {
        Lista num;
        num = isla.grafosConexos();
        return num;

    }
/**
     *
     * Método Eimina un arco del vertice
     *@param  idA es un entero id de un usuario
     * @param idB es un entero id de un usuario
     *
     */
    public void eliminarArco(int idA, int idB) {
        Grafo grafo = (Grafo) isla.geatGraphSearch(idA);
        Vertice v = (Vertice) grafo.getListAdy().getDato(idA);
        Lista x = (Lista) v.getListEdges();
        if (x.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes eliminar, porque no tienes amigos.");

        } else {
//            x.show();
            if (x.search(idB) == true) {
                grafo = (Grafo) isla.geatGraphSearch(idB);
                Vertice v2 = (Vertice) grafo.getListAdy().getDato(idB);
//                System.out.println("Original111");
//                v.show();
                v.eliminarArco(idB);
//                System.out.println("Borrado 11");
//                v.show();
//                System.out.println("Original2222");
//                v2.show();
                v2.eliminarArco(idA);
//                System.out.println("Borrado 222");
////                v2.show();

                if (v2.getListEdges().isEmpty()) {
                    grafo.eliminarVerte(idB);
                    isla.getUsers().eliminarElemento(idB);
                }
                if (v.getListEdges().isEmpty()) {
                    grafo.eliminarVerte(idB);
                    isla.getUsers().eliminarElemento(idA);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No encuentra esa relacion.");

            }
            arreglar();

        }

    }
/**
     *
     * Método Busca si los vertice del usuario esta vacio
     *@param  user es un usuario 
     * @return falso o verdadero
     *
     */
    public void validarUserVacio(User user) {
        Grafo grafo = (Grafo) isla.geatGraphSearch(user.getId());
        Vertice v = (Vertice) grafo.getListAdy().getDato(user.getId());
        if (v.getListEdges().isEmpty()) {
            grafo.eliminarVerte(user.getId());
            isla.getUsers().eliminarElemento(user.getId());
        }

    }
/**
     *
     * Método Lista de usuarios
     * @return Una lista de usuarios
     */
    public Lista getList() {
        return isla.getUsers();
    }
/**
     *
     * Método Lista de los grafos
     *@return Lista de grafos
     *
     */
    public Lista getGraph() {
        return isla.getGraph();
    }
/**
     *
     * Método Busca si el nombre del nuevo usuario existe ya
     *@param  name es un string nombre de un usuario
     * @return falso o verdadero
     *
     */
    public boolean newUserSearch(String name) {
        String nameFin = Funciones.validateUsername(name);
        if (isla.searchUsersName(nameFin) != null) {
            JOptionPane.showInputDialog("Ya existe este nombre.");
            return true;
        }

        return false;

    }
/**
     *
     * Método Crea un nuevo usuario
     *@param  name es un string de un usuario
     * @return un Usuario nuevo con un id random 
     *
     */
    public User getUserNew(String name) {
        String nameFin = Funciones.validateUsername(name);
        int id = Funciones.generarId(isla.getUsers());
        User user = new User(id, nameFin);
        return user;
    }
/**
     *
     * Método Revisa si un usuario no esta en la lista de usuarios
     */
    public void validateUserin(User user) {
        if (isla.getUsers().search(user.getId()) != true) {
            isla.getUsers().addLast(user);
        }
    }
/**
     *
     * Método hacer un string de todos los datos para escribirlos en un txt
     *@return un string de los valores que se guardaran
     *
     */
    public String guardarArchivo() {
        String contenido = "";
        Lista nums = isla.grafosConexos();
        contenido += "Usuarios\n";
        contenido += Funciones.mostrarUsuarios(isla.getUsers());
        contenido += "\n";
        contenido += "Relaciones\n";
        contenido += Funciones.mostrarString(nums).replace("-", ",");
        return contenido;
    }
/**
     *
     * Método Crea de nuevo las islas por cada arco nuevo y eliminado, para actualizar los valores del programa
     */
    public void arreglar() {
        Lista num = isla.grafosConexos();
        String contenido = Funciones.mostrarString(num);
        organizarDatos(isla.getUsers(), contenido.replace("\n", "-"));

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
