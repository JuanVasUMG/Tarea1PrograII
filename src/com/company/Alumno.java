package com.company;

//Importamos libreria para randomizar el numero de carne
import java.util.Random;

//Declaramos la clase Alumno
public class Alumno {
    private String apellido;
    private String carne;
    private String nombre;
    private String correo;
    private String telefono;
    private String dpi;
    private int indice;

    //Constructor #1: Es un método especial de la clase, que se encarga de inicializar los valores de la clase
    public Alumno(){
        this.indice = 1;
    }
    //Constructor #2
    public Alumno(String nombre, String apellido, String correo, String telefono, String dpi, String carne){
        this.nombre = nombre;
        this.apellido = apellido;
        this.carne = carne;
        this.correo = correo;
        this.telefono = telefono;
        this.dpi = dpi;
    }

    //Lista publica para mover los datos de los alumnos
    public String[] moveData(){
        String[] lista = new String[6];
        lista[0] = this.nombre;
        lista[1] = this.apellido;
        lista[2] = this.carne;
        lista[3] = this.correo;
        lista[4] = this.telefono;
        lista[5] = this.dpi;
        return lista;
    }

    //Se muestra el carne generado
    public String watchCarne(){
        return this.carne;
    }

    //Generacion de Carne para alumno "carrera-anio-secuencia-random
    public String generateCarne(RegistAlumno registro){
        String carrera = "0909";
        String anio = "21";
        Random  rnd = new Random();
        int n_random = rnd.nextInt(5000);
        String random = Integer.toString(n_random);
        String carne = carrera + "-" + anio + "-" + random;
        while(registro.existenceRegisteredStudent(carne)){
            n_random = rnd.nextInt(5000);
            random = Integer.toString(n_random);
            carne = carrera + "-" + anio + "-" + random;
            if (!(registro.existenceRegisteredStudent(carne))){
                break;
            }else{

            }
        }
        this.carne = carne;

        return "";
    }

}
