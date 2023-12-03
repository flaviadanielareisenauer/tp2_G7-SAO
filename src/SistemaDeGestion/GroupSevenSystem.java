package SistemaDeGestion;

import java.util.Scanner;
import java.util.Random;

public class GroupSevenSystem {

    public static void main(String[] args) {
		// MENSAJE DE BIENVENIDA
		System.out.println("******* || GROUP SEVEN SYSTEM || *******");
		bienvenida("Bienvenido a su Sistema De Gestion preferido!\n");

		// Cargar asignaturas y alumnos
		String[] asignaturas = cargarAsignaturas();
		String[] alumnos = cargarAlumnos();
		int[][] calificaciones = cargarCalificaciones(alumnos, asignaturas);

		mostrarMenu(alumnos, asignaturas, calificaciones);
    }

    public static void bienvenida(String mensaje) {
		System.out.println(mensaje);
		System.out.println("Presiona ENTER para continuar...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
    }

    // INGRESAR CANTIDAD DE MATERIAS - no mas de 10.  
    public static String[] cargarAsignaturas() {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
	    	System.out.println("Por favor, ingrese la cantidad de asignaturas. No deben superar el maximo de 10: ");
	    	num = scanner.nextInt();
	    	scanner.nextLine();

	   		 // VALIDAR - MENSAJE DE ERROR
	    	if (num > 10) {
			System.out.println("=====================================================================\n"
				 			 + "     ERROR! el numero ingresado es mayor a 10, intente de nuevo!\n"
				 			 + "=====================================================================\n");
	    	}

		} while (num > 10);

		String[] asignaturas = new String[num];
		System.out.println("Ingrese el nombre de cada una de las asignaturas");
		System.out.println();

		for (int i = 0; i < num; i++) {
	    	System.out.print("Asignatura " + (i + 1) + ": ");
	    	asignaturas[i] = scanner.nextLine();
		}

		// LISTA DE MATERIAS INGRESADAS - devuelve un array de Strings con los nombres de las asignaturas.
		System.out.println();
		System.out.println("==================================\n"
		         		 + "     ASIGNATURAS INGRESADAS\n"
		        		 + "==================================\n");

		for (String asignatura : asignaturas) {
	   		if (asignatura != null) {
				System.out.println(asignatura);
	    	}
		}
		return asignaturas;
    	}

	    // INGRESAR CANTIDAD DE ALUMNOS - no mas de 30
  	public static String[] cargarAlumnos() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();

		int num;
		do {
	    	System.out.println("Por favor, ingrese la cantidad de alumnos. No deben superar el maximo de 30: ");
	    	num = scanner.nextInt();
	    	scanner.nextLine();

	    	// VALIDAR - MENSAJE DE ERROR
	    	if (num > 30) {
				System.out.println("=====================================================================\n"
				 				 + "     ERROR! el numero ingresado es mayor a 30, intente de nuevo!\n"
				 				 + "=====================================================================\n");
			}

		} while (num > 30);

		String[] alumnos = new String[num];
		System.out.println("Ingrese el nombre de cada uno de los alumnos en este formato: <apellido, nombre1 nombre2>");

		// VALIDAR FORMATO INGRESADO
		for (int i = 0; i < num; i++) {
	    	boolean formatoCorrecto;

	    	do {
			System.out.print("Alumno " + (i + 1) + ": ");
			String nombreAlumno = scanner.nextLine();

			formatoCorrecto = nombreAlumno.matches("[a-zA-Z]+, [a-zA-Z]+ [a-zA-Z]+");

			if (!formatoCorrecto) {
		   		System.out.println("Formato de nombre incorrecto. Debe ser <apellido, nombre1 nombre2>. Intenta de nuevo.");
			} else {
				alumnos[i] = nombreAlumno;
			}

			} while (!formatoCorrecto);
		}

		System.out.println();
		System.out.println("==================================\n"
		        		 + "        ALUMNOS INGRESADOS\n"
					     + "==================================\n");

		// LISTA DE ALUMNOS  - devuelve un array de Strings con los nombres de los alumnos
		for (String alumno : alumnos) {
	   		if (alumno != null) {
			System.out.println(alumno);
	    	}
		}
		return alumnos;
   	}

    
}