package com.company;

//Importacion de Libreria
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Declaramos las variables
        Scanner entradaDeTeclado = new Scanner(System.in);
        boolean key = true;
        int option = 0;

        //Ingreso de N cantidad de alumnos
        System.out.println(
                "Bienvenido al sistema de registro de Alumnos " +
                "\n\t\t\t\t\t\t\t\tBY: JuanVas" +
                "\n\nPor favor ingrese el numero de Alumnos a Registar: ");
        RegistAlumno registros = new RegistAlumno(Integer.parseInt(entradaDeTeclado.nextLine()));

        //Ciclo hasta que el usuario elija salir
        while(key) {
            //Mostramos el Menu
            System.out.println(
                    "\n----Menu Principal----" +
                    "\n1.- Registrar Alumnos" +
                    "\n2.- Mostrar Alumnos" +
                    "\n3.- Modificar Alumnos" +
                    "\n4.- Salir\n");
            option = Integer.parseInt(entradaDeTeclado.nextLine()); //

            //Segun las opciones
            switch (option){
                //Registramos Alumnos
                case 1: {
                    String[][] vector = registros.getRegisteredStudent();
                    for (int i = 0; i < vector.length; i++) {
                        //Peticion de datos de cada Alumno
                        System.out.println("\nIngresar nombres del alumno " + (i + 1) + ": ");
                        String nombreAlumno = entradaDeTeclado.nextLine();
                        System.out.println("Ingresar apellidos del alumno " + (i + 1) + ": ");
                        String apellidoAlumno = entradaDeTeclado.nextLine();
                        System.out.println("Ingresar correo del alumno " + (i + 1) + ": ");
                        String correoAlumno = entradaDeTeclado.nextLine();
                        System.out.println("Ingresar telefono del alumno " + (i + 1) + ": ");
                        String telefonoAlumno = entradaDeTeclado.nextLine();
                        System.out.println("Ingresar DPI del encargado del alumno " + (i + 1) + ": ");
                        String dpiAlumno = entradaDeTeclado.nextLine();
                        Alumno student = new Alumno(nombreAlumno, apellidoAlumno, correoAlumno, telefonoAlumno, dpiAlumno, "");
                        //Generacion de Carbene
                        student.generateCarne(registros);
                        System.out.println("\nSe ha generado el carne: " + student.watchCarne() + "para el alumno");
                        if (registros.registerStudent(student)) {
                            System.out.println("\nAlumno registrado exitosamente");
                        } else {
                            System.out.println("\nEl alumno ingresado ya está registrado");
                            i--;
                        }
                    }
                    break;
                }
                //Mostramos Alumnos
                case 2: {
                    String[][] vector = registros.getRegisteredStudent();
                    System.out.println("\nLista de Alumnos Registrados ");
                    for (int i = 0; i < vector.length; i++) {
                        //if(vector[i]!=null) // otra forma de escribirlo
                        if (!(vector[i] == null)) {//se valida si el registro no es nulo
                            System.out.println("\nNombre: " + vector[i][0]);
                            System.out.println("Apellidos: " + vector[i][1]);
                            System.out.println("Carne: " + vector[i][2]);
                            System.out.println("Correo: " + vector[i][3]);
                            System.out.println("Telefono: " + vector[i][4]);
                            System.out.println("Dpi: " + vector[i][5]);
                        }
                    }
                    break;
                }
                //Modificamos Alumnos
                case 3:{
                    System.out.println("\nIngrese numero de carne: ");
                    String n_carne = entradaDeTeclado.nextLine();
                    registros.modifyStudent(n_carne);
                    break;
                }
                //Salimos del programa
                case 4:{
                    System.out.println("\nSalinendo del programa....");
                    key = false;
                    break;
                }
                //Opcion Incorrecta
                default: System.out.println("\nEsta Opcion no existe.");

            }
        }

    }
}