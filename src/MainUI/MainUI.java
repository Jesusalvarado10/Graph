/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MainUI;

import App.App;
import Lista.Lista;
import User.User;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Esta clase es por donde bascula el programa (una interfaz)
 *
 * @author Jesus
 * @version 4/6.2023
 */
public class MainUI extends javax.swing.JFrame {
//Campos de la clase 

    App app = null; //Donde corre todas las funciones logicas del programa
    File file = null; //Archivo que abre el usuario JFilechooser

    private final String titleUI = "Project EDD - Graphs";
    private final boolean resizableUI = false;
    private final Dimension minimunUI = new Dimension(260, 190);
    private final Dimension maximunUI = new Dimension(260, 190);

    // <editor-fold defaultstate="collapsed" desc="Constructor">       

     /**

     * Constructor de la clase 

     */
    
    public MainUI() {
//Configuraciones de la interfaz
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle(this.titleUI);
        this.setMinimumSize(this.minimunUI);
        this.setMaximumSize(this.maximunUI);
        this.setResizable(this.resizableUI);
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFiles = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        openFiles.setBackground(new java.awt.Color(255, 255, 255));
        openFiles.setText("Abrir Archivo");
        openFiles.setFocusPainted(false);
        openFiles.setFocusable(false);
        openFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFilesActionPerformed(evt);
            }
        });
        getContentPane().add(openFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 260, 50));

        jButton1.setText("Programa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton2.setText("Guardar");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 260, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Funciòn: Abrir un archivo txt para extraer los datos
    private void openFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFilesActionPerformed
        //Valida si el programa no tiene ningun archivo cargado 
        if (this.app == null) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            }
            //Variables
            Lista<User> users = new Lista();
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Seleccionar un archivo de texto (TXT)");//Filtrar archivos solamente salgan TXT
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
            fc.addChoosableFileFilter(filter);
            int seleccion = fc.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                //Abre el archivo seleccionado
                this.file = fc.getSelectedFile();

            //Variables
                String usersTXT;
                String relationships = "";
                String bfRead;
                boolean usersBool = false;
                boolean relationshipsBool = false;

                    //Empieza a leer cada linea del TXT
                try {
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    while ((bfRead = bf.readLine()) != null) {
                        //Separa los campos del archivo
                        switch (bfRead) {
                            case "Usuarios":
                                usersBool = true;
                                break;
                            case "Relaciones":
                                usersBool = false;
                                relationshipsBool = true;
                                break;
                        }

                        //Crea los usuarios y los añade a una lista
                        if (usersBool == true) {
                            try {
//                                  System.out.println(bfRead);
                                String[] person = bfRead.split(",");
                                String nombre = person[1].replace(" ", "");
                                int id = Integer.parseInt(person[0].replace(" ", ""));
                                User newuser = new User(id, nombre);
                                users.addLast(newuser);
                            } catch (Exception e) {
//                
                            }
                        } //Empieza a concatenar las relaciones
                        else if (relationshipsBool = true) {
                            try {
                                String line[] = bfRead.split(",");
                                int a = Integer.parseInt(line[0].replace(" ", ""));
                                int b = Integer.parseInt(line[1].replace(" ", ""));
                                int c = Integer.parseInt(line[2].replace(" ", ""));

                                relationships += bfRead + "-";

                            } catch (Exception e) {

                            }
                        }
                    }

                } catch (Exception e) {
//          
                }
                //Crea el objeto app
                if (users.size() != 0) {
                    this.app = new App();
                    this.app.setFile(file);  //Pasa file para poder guardar el archivo en el mismo url del archivo abierto anteriormente
                    this.app.organizarDatos(users, relationships); //Corre organizar datos
                }
            }
            // Si el programa ya tiene un archivo abierto te pregunta para seguir o abrir otro
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea abrir otro archivo?", "Confirmacion", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == 0) {
                guardarTxt();
                this.app = null;
                //Guradar archivo...
                JOptionPane.showMessageDialog(null, "Se guardo exitosamente.");
            }

        }

    }//GEN-LAST:event_openFilesActionPerformed
    //FIn del metodo
    /**
 * Metodo que te permite volver a asignar la variable app, para poder bascular en las otras interfacez
 *
 * @param app contiene todo los datos que se corren en el programa 
 * @version 4/6.2023
 */

    public void setApp(App app) {
        this.app = app;
    }
    //Boton que al accionar abre la interfaz principal (Login)
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Validacion por si no hay archivos cargados en el programa
        if (this.app == null) {
            JOptionPane.showMessageDialog(null, "Primero debe subir algun archivo para poder acceder.");
        } else {
            //Abre el login pasandole la clase app para que los datos se mantengan
            LoginUI login = new LoginUI();
            login.setApp(app);
            this.setVisible(false);
            login.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    //FIn del metodo
    
    //Boton para guardar los cambios que hiciste en el archivo
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       //Valida que exista algun archivo
        if (app != null) {
            guardarTxt();//Metodo guardar
            this.app = null;
            //Guradar archivo...
            JOptionPane.showMessageDialog(null, "Se guardo exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede guardar nada, debes subir un archivo");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
  /**
 * Metodo que te permite guardar los cambios realizados en un txt
 *
 * @param 
 * @version 4/6.2023
 */
    public void guardarTxt() {
        String contenido = app.guardarArchivo();//Se le pasan todos los datos en formato String y con el modelo establecido
//        System.out.println(contenido);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(app.getFile()))) {//Abre el archivo que anteriormente se selecciono para sobre escribir la informacion
            bw.write(contenido);//Escribe los nuevos valores

            System.out.println("Contenido guardado en el archivo.");
        } catch (Exception e) {
        }

    }
    //FIn del metodo
    // <editor-fold defaultstate="collapsed" desc="Main function">   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Variable declaration">       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openFiles;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>   
    //FIn de la clase
}
