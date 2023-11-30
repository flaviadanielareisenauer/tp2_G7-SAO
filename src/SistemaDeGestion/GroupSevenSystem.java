package SistemaDeGestion;

import java.util.Scanner;
import java.util.Random;

public class GroupSevenSystem {

    public static void main(String[] args) {

	// Mensaje de bienvenida
	System.out.println("******* || GROUP SEVEN SYSTEM || *******");
	bienvenida("Bienvenido a su Sistema De Gestion preferido!\n");
	String[] asignaturas = cargarAsignaturas();
	String[] alumnos = cargarAlumnos();
	cargarCalificaciones(alumnos, asignaturas);
    }

    public static void bienvenida(String mensaje) {
	System.out.println(mensaje);
	System.out.println("Presiona ENTER para continuar...");
	Scanner scanner = new Scanner(System.in);
	scanner.nextLine();
    }

    // INGRESAR CANTIDAD DE MATERIAS 
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

	// LISTAR MATERIAS INGRESADAS
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

    // INGRESAR CANTIDAD DE ALUMNOS
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

	// LISTAR ALUMNOS INGRESADOS
	for (String alumno : alumnos) {
	    if (alumno != null) {
		System.out.println(alumno);
	    }
	}
	return alumnos;
    }

    public static int[][] cargarCalificaciones(String[] alumnos, String[] asignaturas) {
	Scanner scanner = new Scanner(System.in);
	int numAlumnos = alumnos.length;
	int numAsignaturas = asignaturas.length;
	int[][] calificaciones = new int[numAlumnos][numAsignaturas];

	System.out.println();
	System.out.println("Ahora que deseas: ");
	System.out.println("1 - Cargar calificaciones manualmente. ");
	System.out.println("2 - Generar calificaciones automaticamente. ");

	int opcion = scanner.nextInt();
	scanner.nextLine();

	if (opcion == 1) {
	    for (int i = 0; i < numAlumnos; i++) {
		for (int j = 0; j < numAsignaturas; j++) {
		    System.out.println("Calificación para " + alumnos[i] + " en " + asignaturas[j] + ": ");
		    calificaciones[i][j] = scanner.nextInt();
		}
	    }
	} else if (opcion == 2) {
	    Random random = new Random();
	    for (int i = 0; i < numAlumnos; i++) {
		for (int j = 0; j < numAsignaturas; j++) {
		    calificaciones[i][j] = random.nextInt(10) + 1;
		}
	    }
	}
	for (int i = 0; i < numAlumnos; i++) {
	    System.out.println("Calificaciones para " + alumnos[i] + ":");
	    for (int j = 0; j < numAsignaturas; j++) {
		System.out.println("Calificación en " + asignaturas[j] + ": " + calificaciones[i][j]);
	    }
	}
	return calificaciones;
    }
}
