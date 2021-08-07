package com.company;

//Importacion de Libreria
import java.util.Scanner;

public class RegistAlumno {
    //{ Area de declaraciones}
    Scanner entradaDeTeclado = new Scanner(System.in);
    private String[][] registeredStudent;// solo se declara el vector multidimensional para los alumnos registrados
    private int indiceVector;

    //{ Area de métodos de clase}
    public RegistAlumno(int numberRecords) {
        //se inicializan los valores
        this.registeredStudent = new String[numberRecords][6];
        this.indiceVector = 0;
    }

    //Verificamos si esta inscrito o no el alumno
    public boolean registerStudent(Alumno alumno) {
        String[] studentData = alumno.moveData();
        if (!(this.existenceRegisteredStudent(studentData[2]))) {
            this.registeredStudent[this.indiceVector][0] = studentData[0];
            this.registeredStudent[this.indiceVector][1] = studentData[1];
            this.registeredStudent[this.indiceVector][2] = studentData[2];
            this.registeredStudent[this.indiceVector][3] = studentData[3];
            this.registeredStudent[this.indiceVector][4] = studentData[4];
            this.registeredStudent[this.indiceVector][5] = studentData[5];
            this.incrementarIndice();
            return true;
        } else {
            return false;
        }
    }

    //Incrementamos el indice
    private void incrementarIndice() {
        this.indiceVector = this.indiceVector + 1;
    }

    //Obtenemos el registro del alumno
    public String[][] getRegisteredStudent(){
        return this.registeredStudent;
    }


    public boolean existenceRegisteredStudent(String carneAlumno){
        for(int i=0; i<this.registeredStudent.length; i++){//length devuelve el tamaño del vector
            if(this.registeredStudent[i][2]!=null){
                if(carneAlumno.equals(this.registeredStudent[i][2])){
                    return true;
                }
            }
        }
        return false;
    }

    //Modificacion del alumno
    public void modifyStudent(String carneAlumno){
        for(int i=0; i<this.registeredStudent.length; i++){//length devuelve el tamaño del vector
            if(this.registeredStudent[i][2]!=null){
                if(carneAlumno.equals(this.registeredStudent[i][2])){
                    System.out.println("\nInformacion de alumno: ");
                    for(int j=0; j<this.registeredStudent[0].length; j++){
                        if(!(this.registeredStudent[i]==null)){//se valida si el registro no es nulo
                            System.out.println("\nNombre: " + this.registeredStudent[i][0]);
                            System.out.println("Apellidos: " + this.registeredStudent[i][1]);
                            System.out.println("Carne: " + this.registeredStudent[i][2]);
                            System.out.println("Correo: " + this.registeredStudent[i][3]);
                            System.out.println("Telefono: " + this.registeredStudent[i][4]);
                            System.out.println("Dpi: " + this.registeredStudent[i][5]);
                            //Se modifican los datos
                            System.out.println("\nNuevo nombre: ");
                            this.registeredStudent[i][0] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo apellido: ");
                            this.registeredStudent[i][1] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo correo: ");
                            this.registeredStudent[i][3] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo telefono: ");
                            this.registeredStudent[i][4] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo dpi: ");
                            this.registeredStudent[i][5] = entradaDeTeclado.nextLine();
                            break;
                        }
                    }
                }
            }
        }
    }
}