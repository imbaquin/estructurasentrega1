/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiantes;

import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Estudiantes {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here:
        //creacion de la consola para poder ingresar datos
        Scanner consola = new Scanner(System.in);
        int opcion;  
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(); //Creacion de una lista para guardar los datos de estudiantes
        leerReporte(listaAlumnos);
        //Creacion de un menu principal
        do {            
            menu();
            opcion = consola.nextInt();
            
            switch (opcion) {
                case 1:
                    ingresarAlumno(listaAlumnos);
                    break;
                case 2:
                    if(listaAlumnos.isEmpty()){
                        System.out.println("No hay estudiantes registrados para eliminar");
                    }else{
                       eliminarAlumno(listaAlumnos);
                    }
                    
                    break;
                case 3:
                    if(listaAlumnos.isEmpty()){
                        System.out.println("No hay estudiantes registrados para modificar");
                    }else{
                       modificarAlumno(listaAlumnos);
                    }
                    break;
                case 4:
                    
                    if(listaAlumnos.isEmpty()){
                        System.out.println("No hay estudiantes registrados");
                    }else{
                        mostrarAlumno(listaAlumnos);
                    }    
                    break;
                case 5:
                    crearReporte(listaAlumnos, consola);
                    break;
                case 6:
                    eliminarReporte(listaAlumnos);
                    crearReporte(listaAlumnos, consola);
                default:
                    System.out.println("Ingresa una opcion correcta");
                break;    
            }
            
        } while (opcion!=7);
       
    }
    
    public static void menu(){
            System.out.println("         Menu de opciones         ");
            System.out.println("Ingresa una opcion");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Consultar alumnos");
            System.out.println("5. Generar reporte en TXT");
            System.out.println("6. Eliminar reporte de estudiantes");
            System.out.println("7. Salir"); 
    
    }
    //metodo para ignresar alumno
    public static void ingresarAlumno(ArrayList<Alumno> listaAlumnos){
           Scanner consola = new Scanner(System.in);
           Alumno miAlumno = new Alumno();//creacion de un objeto tipo Alumno para poder llamar los atributos de la clase alumno
           System.out.println("Ingresa la cedula del estudiante:");
           String cedula = consola.nextLine();
           miAlumno.setCedula(cedula);
           
           System.out.println("Ingresa el nombre del estudiante:");
           String nombre = consola.nextLine();
           miAlumno.setNombre(nombre);
           
           System.out.println("Ingresa el apellido del estudiante:");
           String apellido = consola.nextLine();
           miAlumno.setApellido(apellido);
           
           System.out.println("Ingresa el semestre del estudiante:");
           String semestre = consola.nextLine();
           miAlumno.setSemestre(semestre);
           
           System.out.println("Ingresa el correo del estudiante:");
           String correo = consola.next();
           miAlumno.setCorreo(correo);
           
           System.out.println("Ingresa el celular del estudiante:");
           String celular = consola.next();
           miAlumno.setCelular(celular);
           
           listaAlumnos.add(miAlumno);
           
     }
    //metoido para mostrar alumno
    public static void mostrarAlumno(ArrayList<Alumno> listaAlumnos){
        //recorre la lista con un for y muestra los datos guardados en el ArrayList
         for(Alumno alumno : listaAlumnos){
            
                    System.out.println("------------------------------");
                    System.out.println("Datos del alumno:");
                    System.out.println("Nombre: " + alumno.getNombre());
                    System.out.println("Apellido: " + alumno.getApellido());
                    System.out.println("Cédula: " + alumno.getCedula());
                    System.out.println("Semestre: " + alumno.getSemestre());
                    System.out.println("Correo: " + alumno.getCorreo());
                    System.out.println("Celular: " + alumno.getCelular());
                    System.out.println("------------------------------");
   
         }
    }
    //metoido para modificar alumno
    public static void modificarAlumno(ArrayList<Alumno> listaAlumnos){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresa el numero de cedula del estudiante para modificarlo");
        String id = consola.next();
        int opcion;
        //recorre la lista y da al usuario la opcion de que dato quiere modificar 
        for(Alumno alumno: listaAlumnos){
            if(alumno.getCedula().equals(id)){

                       
                            System.out.print("Ingrese el nombre a modificar: ");
                            String nombreModificado = consola.next(); 
                        
                            if(!nombreModificado.isEmpty()){
                                alumno.setNombre(nombreModificado);
                            }   
                
                     
                            System.out.print("Ingrese el apellido a modificar: ");
                            String apellidoModificado = consola.next();
                        
                            if(!apellidoModificado.isEmpty()){
                                alumno.setApellido(apellidoModificado);
                            }
                       
                     
                            System.out.print("Ingrese el semestre a modificar: ");
                            String semestreModificado = consola.nextLine();
                        
                            if(semestreModificado != null){
                                alumno.setSemestre(semestreModificado);
                            }
                      
                       
                            System.out.print("Ingrese el correo a modificar: ");
                            String correoModificado = consola.next();
                        
                            if(!correoModificado.isEmpty()){
                                alumno.setCorreo(correoModificado);
                            }
                  
                            System.out.print("Ingrese el celular a modificar: ");
                            String celularModificado = consola.next();
                        
                            if(!celularModificado.isEmpty()){
                                alumno.setCelular(celularModificado);
                            }

            }else{
                System.out.println("El numero de documento no se encuentra registrado");
            }
        
        
        }
        
    }
    //metodo para eliminar alumno
    public static void eliminarAlumno(ArrayList<Alumno> listaAlumnos){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresa el numero de cedula a eliminar");
        String idBorrar = consola.next();
        Alumno miAlumno = new Alumno();
        int opcion=0;
        for(Alumno alumno: listaAlumnos){
            if(alumno.getCedula().equals(idBorrar)){
                listaAlumnos.remove(miAlumno);
                System.out.println("Estudiante con cedula: " + alumno.getCedula() + " eliminado");
            }else{
                System.out.println("El numero de documento ingresado no existe");   
            } 
        }
    }
    
      public static void crearReporte(ArrayList<Alumno> listaAlumnos , Scanner consola)throws FileNotFoundException{
        File archivo = new File("./data/reporteEstudiantes.txt");
        
        PrintWriter pluma = new PrintWriter(archivo);
        
        if(!listaAlumnos.isEmpty()){
            System.out.println("Ingrese el semestre para generar el reporte");
            String semestreCreado = consola.next();
        
            pluma.println("Reporte de estudiantes");
            pluma.println("-----------------------");
            System.out.println("Reporte creado");
            for(Alumno alumno: listaAlumnos){
            if(alumno.getSemestre().equals(semestreCreado))
                pluma.println("----------------------");
                pluma.println("Datos del alumno: ");
                pluma.println("Nombre: " + alumno.getNombre());
                pluma.println("Apellido: " + alumno.getCedula());
                pluma.println("Cedula: " + alumno.getCedula());
                pluma.println("Semestre: " + alumno.getSemestre());
                pluma.println("Correo: " + alumno.getCorreo());
                pluma.println("Celular: " + alumno.getCelular());

          }  
             pluma.close();
        }else{
            System.out.println("No hay estudiantes de dicho semestre registrados");
        }
    
       
    }
    
    public static void leerReporte(ArrayList<Alumno> listaAlumnos)throws IOException{
        File archivo = new File("./data/reporte.txt");
       
       
        try(FileReader fail = new FileReader(archivo)){
            BufferedReader cx = new BufferedReader(fail);
            String linea;
            while((linea = cx.readLine()) != null){
                String[] datos = linea.split("");
                
                String cedula = datos[0].trim();
                String nombre = datos [1].trim();
                String apellido = datos [2].trim();
                String semestre = datos [3].trim();
                String correo = datos [4].trim();
                String celular = datos [5].trim();
                
            
                Alumno miAlumno = new Alumno(nombre, apellido, semestre, correo, celular, cedula);
                listaAlumnos.add(miAlumno);
            
            }
        }catch(FileNotFoundException e){
            System.out.println("No existe ningun archivo");
        }
    }
    public static void eliminarReporte(ArrayList<Alumno> listaAlumnos){
        if(!listaAlumnos.isEmpty()){
            listaAlumnos.clear();
            System.out.println("Se ha eliminado el reporte");
        }else{
            System.out.println("No hay datos que eliminar");
        }
        
    
    } 
}
