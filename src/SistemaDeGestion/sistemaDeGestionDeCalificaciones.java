package SistemaDeGestion;

import java.util.Scanner;
import java.util.Random;

public class SistemaDeGestionDeCalificaciones {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
	Random random = new Random();

        // VARIABLES
        int totalAsignaturas = 0;
	int totalEstudiantes = 0;

        // VECTORES
        String[] asignaturas = new String[10];
	String[] estudiantes = new String[30];

        // MATRIZ     
	int[][] notas = new int[30][10];        
        

	
        // Mensaje de bienvenida
        System.out.println(
                "************************************************************\n"
              + "<<<<<BIENVENIDO AL SISTEMA DE GESTION DE CALIFICACIONES>>>>>\n"
              + "************************************************************\n"
        );

        // Enter para continuar...
        System.out.println("Por favor, presione ENTER para continuar...");
        scanner.nextLine();

        System.out.println("Por favor, ingrese la cantidad de asignaturas. No deben superar el maximo de 10: ");
        totalAsignaturas = scanner.nextInt();
        
        
	
	// Valida la cantidad de asignaturas que se ingresaron
        if (totalAsignaturas < 1 || totalAsignaturas > 10) {
            System.out.println(" ----ERROR: el numero de asignaturas debe ser entre 1 y 10.----");
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
        System.out.println("*** ASIGNATURAS INGRESADAS ***");
        for (String asignatura : asignaturas) {
            if (asignatura != null) {
                System.out.println(asignatura);
            }
        }
        System.out.println("==================================================================\n"
                         + "==================================================================\n");
	
	
	
	
	System.out.println("Por favor, ingrese la cantidad de estudiantes. No debe superar el maximo de 30.");
	totalEstudiantes = scanner.nextInt();
	scanner.nextLine();
	
	// Valida la cantidad de estudiantes que se ingresaron
	if (totalEstudiantes < 1 || totalEstudiantes > 30) {
	    System.out.println("----ERROR: el numero de estudiantes debe ser entre 1 y 30.----");
	    return;	
	}
	
	System.out.println("==================================================================\n"
                         + "==================================================================\n");
	
	// Ingresar cada estudiantes
	for (int i = 0; i < totalEstudiantes; i++) {
	    System.out.println("Ingrese el nombre completo del estudiante " + (i + 1) + ": ");
	    estudiantes[i] = scanner.nextLine();
	}
	
	System.out.println("==================================================================\n"
                         + "==================================================================\n");
        
	// Listado de estudiantes ingresados
	System.out.println("*** ESTUDIANTES INGRESADOS ***");
	for (String estudiante : estudiantes) {
	    if(estudiante != null) {
		System.out.println(estudiante);
	    }
	}
	
	System.out.println("==================================================================\n"
                         + "==================================================================\n");
	
	
	
	// Genera notas aleatorias
	for (int i = 0; i < estudiantes.length; i++) {
	    for (int j = 0; j < asignaturas.length; j++) {
		notas[i][j] = random.nextInt(10) + 1;
		
	    }
	}
	
	// Listado de notas generadas
	System.out.println("*** NOTAS INGRESADAS ***");
	for (int i = 0; i < totalEstudiantes; i++) {
	    System.out.println(estudiantes[i] + ": ");
	    for (int j = 0; j < totalAsignaturas; j++) {
		System.out.println(asignaturas[j] + " = " + notas[i][j] + " ");
	    }
	    System.out.println();
	}
    }

}