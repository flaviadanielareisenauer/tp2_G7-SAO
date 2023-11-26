package SistemaDeGestion;

import java.util.Scanner;

public class SistemaDeGestionDeCalificaciones {

    public static void main(String[] args) {
        // ENTRADA 
        Scanner scanner = new Scanner(System.in);

        // VARIABLES
        int totalAsignaturas = 0;
	int totalEstudiantes = 0;

        // VECTORES
        String[] asignaturas = new String[10];
	String[] estudiantes = new String[30];

        // MATRIZ     
        
        

        // Mensaje de bienvenida
        System.out.println(
                "************************************************************\n"
              + "<<<<<BIENVENIDO AL SISTEMA DE GESTION DE CALIFICACIONES>>>>>\n"
              + "************************************************************\n"
        );

        // Enter para continuar...
        System.out.println("Por favor, presione Enter para continuar...");
        scanner.nextLine();

        System.out.println("Por favor, ingrese la cantidad de asignaturas. No deben superar el maximo de 10: ");
        totalAsignaturas = scanner.nextInt();
        
        
	
	    // Valida la cantidad de asignaturas que se ingresaron
        if (totalAsignaturas < 1 || totalAsignaturas > 10) {
            System.out.println("ERROR: el numero de asignaturas debe ser entre 1 y 10.");
            return; // cierra el programa si hay un error
        }   
	
        // Ingresar cada materia
        for (int j = 0; j < totalAsignaturas; j++) {
            System.out.println("Ingrese el nombre de la asignatura " + (j + 1) + ": ");
            asignaturas[j] = scanner.next();
        }
	
        System.out.println("==================================================================\n"
                         + "==================================================================\n");
        
	    // Listado de asignaturas ingresadas
        System.out.println("**ASIGNATURAS INGRESADAS: **");
        for (String asignatura : asignaturas) {
            if (asignatura != null) {
                System.out.println(asignatura);
            }
        }
        System.out.println("==================================================================\n"
                         + "==================================================================\n");