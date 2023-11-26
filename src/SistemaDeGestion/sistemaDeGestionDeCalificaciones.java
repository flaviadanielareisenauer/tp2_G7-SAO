package SistemaDeGestion;

import java.util.Scanner;

public class sistemaDeGestionDeCalificaciones {

    public static void main(String[] args) {
        System.out.println("|*|Bienvenido al Sistema de Gestion de Calificaciones|*|"); 
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione Enter para poder continuar...");
        scanner.nextLine();
        
        System.out.println("Ingrese las asignaturas");
        System.out.println("Ingrese el numero de asignaturas: ");
        int cantidadDeAsignaturas = scanner.nextInt();
        
        // Valida que la cantidad de asignaturas no sea mayor de 10
        if (cantidadDeAsignaturas < 1 || cantidadDeAsignaturas > 10) {
            System.out.println("ERROR: el numero de asignatura a ingresar debe estar entre 1 y 10.");
            return; // Sale del programa en caso de haber un error       
            
        } 
        
        // Vector para almacenar las asignaturas
        String[] asignaturas = new String[cantidadDeAsignaturas];
        
        // Ingresa los nombres de las asignaturas
        for (int j = 0; j < cantidadDeAsignaturas; j++) {
            System.out.println("Ingrese el nombre de la asignatura " + (j + 1) + ": ");
            asignaturas[j] = scanner.next();
        }
        
        // Asignaturas que se ingresaron
        System.out.println("Asignaturas ingresadas: ");
        for (String asignatura : asignaturas) {
            System.out.println(asignatura);
        }

    }
    
}