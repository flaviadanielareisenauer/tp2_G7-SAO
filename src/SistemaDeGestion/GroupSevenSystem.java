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

	// INGRESAR CALIFICACIONES 
    public static int[][] cargarCalificaciones(String[] alumnos, String[] asignaturas) {
		int totalAlumnos = alumnos.length;
		int totalAsignaturas = asignaturas.length;
		int[][] calificaciones = new int[totalAlumnos][totalAsignaturas];
		Random rand = new Random();

		for (int i = 0; i < totalAlumnos; i++) {
	    	for (int j = 0; j < totalAsignaturas; j++) {
				calificaciones[i][j] = rand.nextInt(10) + 1; // genera un numero aleatorio que va del 0 al 10. 
	    	}
		}

		System.out.println();
		System.out.println("==================================\n"
			 			 + "    CALIFICACIONES INGRESADAS\n     "
						 + "==================================\n");

		// LISTA DE CALIFICACIONES INGRESADAS
		for (int i = 0; i < totalAlumnos; i++) {
	    	System.out.println("CALIFICACIONES DE " + alumnos[i] + ":");

	    	System.out.printf("%-15s%-15s\n", "Asignatura", "Calificacion"); // las columnas van a tener un ancho de 15 caracteres

	    	for (int j = 0; j < totalAsignaturas; j++) {
			System.out.printf("%-15s%-15s\n", asignaturas[j], calificaciones[i][j]);
	    	}
	    	System.out.println();
		}

		return calificaciones;
    }
    // MENU PRINCIPAL
    public static void mostrarMenu(String[] alumnos, String[] asignaturas, int[][] calificaciones) {
	Scanner scanner = new Scanner(System.in);
	char opciones;

	do {
	    System.out.println("==================================\n");
	    System.out.println("	    MENU PRINCIPAL");
	    System.out.println("==================================\n");
	    System.out.println("1 - Calcular promedios");
	    System.out.println("2 - Ver estadisticas");
	    System.out.println("3 - Buscar estudiantes");
	    System.out.println("4 - Estudiantes destacados");
	    System.out.println("5 - Salir del programa");

	    System.out.println("\nSeleccione una de las opciones: ");

	    opciones = scanner.next().charAt(0);

	    switch (opciones) {
		case '1':
		    calcularPromedios(alumnos, asignaturas, calificaciones);
		    break;
		case '2':
		    mostrarEstadisticas(asignaturas, calificaciones);
		    break;
		case '3':
		    buscarEstudiante(alumnos, asignaturas, calificaciones);
		    break;
		case '4':
		    estudiantesDestacados(alumnos, calificaciones);
		    break;
		case '5':
		    System.out.println("Gracias por haber elegido a GROUP SEVEN SYSTEM!!");
		    break;
		default:
		    System.out.println("Opcion no valida. Por favor, seleccione de nuevo.");
	    }

	} while (opciones != '5');
    }
  
    // CALCULA EL PROMEDIO DE CALIFICACIONES DE UN ESTUDIANTE
    public static void calcularPromedios(String[] alumnos, String[] asignaturas, int[][] calificaciones) {
	System.out.println("==================================\n"
			 + "      PROMEDIO DE CALFICACIONES\n"
			 + "==================================\n");

	for (int i = 0; i < alumnos.length; i++) {
	    double promedio = 0.0;

	    for (int j = 0; j < asignaturas.length; j++) {
		promedio += calificaciones[i][j];
	    }
	    promedio /= asignaturas.length;

	    System.out.println(alumnos[i] + ": Promedio = " + promedio);
	}
    }



}