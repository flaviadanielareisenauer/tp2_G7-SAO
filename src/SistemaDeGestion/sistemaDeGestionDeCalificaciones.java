package SistemaDeGestion;

import java.util.Scanner;

public class SistemaDeGestionDeCalificaciones {

    public static void main(String[] args) {
        // ENTRADA 
        Scanner scanner = new Scanner(System.in);
        
        // VARIABLES
        int totalAsignaturas = 0;
        
        // CONSTANTES
        final int MAX_ASIGNATURAS = 10;
        
        // VECTORES
        String[] asignaturas = new String[MAX_ASIGNATURAS];
        
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
        
        // Ingresar la cantiad de asignaturas
        System.out.println("Por favor, ingresa la cantidad de asignaturas. Las mismas no pueden superar un maximo de 10: ");
        totalAsignaturas = scanner.nextInt();    
        
        

    }

}
