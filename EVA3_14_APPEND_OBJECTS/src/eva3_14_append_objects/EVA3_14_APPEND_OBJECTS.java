/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eva3_14_append_objects;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Invitado
 */
public class EVA3_14_APPEND_OBJECTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            guardarObjetos(new Persona("Ruben","Acosta",18));
            guardarObjetos(new Persona("Pedro","deded",158));
            guardarObjetos(new Persona("Ernesto","deded",138));
            guardarObjetos(new Persona("Juan","gfd",28));
            
            leerObjetos();
        } catch (IOException ex) {
            Logger.getLogger(EVA3_14_APPEND_OBJECTS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EVA3_14_APPEND_OBJECTS.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    
    
        public static void guardarObjetos(Persona perso) throws FileNotFoundException, IOException{
        //abrir archivo
        //guarda en binario??
        FileOutputStream abrirArc=new FileOutputStream("C:\\apps\\variaspersonas.per",true);
        ObjectOutputStream outputStream=new ObjectOutputStream(abrirArc);
        
        outputStream.writeObject(perso);
        outputStream.close();
    }
        
        
        
    public static void leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        Persona perso=null;
        
        FileInputStream abrirArc=new FileInputStream("C:\\apps\\variaspersonas.per");
        ObjectInputStream oiStream=new ObjectInputStream(abrirArc);
        
        //casting: de object a persona
        //lee uno por uno readObject
        

        try {
            Object obj=oiStream.readObject();
            while((obj)!=null){
                if(obj instanceof Persona){
                    perso=(Persona)obj;
                    System.out.println("Nombre: "+perso.getNombre());
                    System.out.println("Apellido: "+perso.getApellido());
                    System.out.println("Edad: "+perso.getEdad());
                }
                obj=oiStream.readObject();

        }
        } catch (EOFException e) {
            e.printStackTrace();
        }
        

    }
    
}


class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private int edad;
    
    
    
    

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
        public Persona() {
        this.nombre = "Juan";
        this.apellido = "Garcia";
        this.edad = 20;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
