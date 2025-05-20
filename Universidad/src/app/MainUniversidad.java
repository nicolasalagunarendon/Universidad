package app;

import java.util.Scanner;

import model.Estudiante;
import model.Nota;
import model.Universidad;

public class MainUniversidad {

	public static void main(String[] args) {
		Universidad Uniquindio= new Universidad("UQ", "Armenia");
		String nombreN= null, nombre= null, identificacion= null;
		float valor= 0;
		boolean repetir1= true, repetir2= true, repetir3= true, repetir0= true, decision= true;
		byte opcion= 0;
		System.out.print("Bienvenido al Gestor de estudiantes de la Universidad del Quindio\n");
		while (repetir1) {
			repetir0= true;
			while(repetir0) {
			opcion= ingresarByte("Qué acción le gustaría hacer?:\n"
					+ "1) Registrar un Estudiante\n2) Agregar una Nota a un Estudiante\n3) Obtener el Estudiante con Mayor promedio"
					+ "\n4) Actualizar una Nota a un Estudiante\n5) Calcular Promedio de cada Estudiante\n"
					+ "6) Mostrar las Notas y el Promedio de cada Estudiante\n7) Mostrar una Lista de cada Estudiante\n"
					+ "0) Finalizar Programa");
			if (opcion<0 || opcion>7) {
				System.out.println("Opción fuera de rango, debes ingresar uno de los numeros disponibles de la lista\nde acciones,"
						+ " intenta de nuevo...\n");
			}else {repetir0= false;}
			}
			if (opcion == 0) {
				decision= decision("¿Estás seguro de querer finalizar el programa? Si(y) o No(n): ");
				if (decision == true) {
					repetir1= false;
					System.out.println("Entendido, Cerrando el programa...");
					System.exit(0);}
				else {System.out.println("Entendido, continue con el programa");}
			}else if(opcion == 1) {
				repetir2= true;
				while(repetir2) {
					nombre= ingresarTexto("Ingresa el Nombre del nuevo estudiante: ");
					identificacion= ingresarTexto("Ingresa la Identificacion del estudiante: ");
					if (nombre.isBlank() || identificacion.isBlank()) {
						System.out.print("No puedes dejar espacios vacios, intenta de nuevo");
					}else {repetir2= false;
						Estudiante estudiante1= new Estudiante(nombre, identificacion);
						Uniquindio.registrarEstudiantes(estudiante1);
						System.out.println("Estudiante registrado con exito");}
				}
			}else if(opcion == 2) {
				repetir3= true;
				while(repetir3) {
					identificacion= ingresarTexto("ingresa la Identificación del estudiante que desea agregar una nota: ");
					if (Uniquindio.getEstudiante(identificacion)== null) {
						System.out.println("No se encontró a ningun estudiante con aquella identificacion...");
					}else {repetir3= false;}
				}
				nombreN= ingresarTexto("Ingrese el nombre de la actividad que da la nota: ");
				valor= ingresarFloat("Ingresa el valor de la nota: ");
				Nota nota1= new Nota(nombreN, valor);
				Uniquindio.getEstudiante(identificacion).agregarNota(nota1);
			}else if(opcion == 3) {
				identificacion= Uniquindio.getEstudianteMayorPromedio().getIdentificacion();
				System.out.println(Uniquindio.getEstudiante(identificacion).toString());
				System.out.println("Promedio: " + Uniquindio.getEstudiante(identificacion).getPromedio() + "\n");
				}else if(opcion == 4) {
				identificacion= ingresarTexto("Ingresa la identificación del estudiante que quieres cambiar una nota: ");
				nombreN= ingresarTexto("Ingresa el nombre de la actividad que dió la nota a cambiar: ");
				valor= ingresarFloat("Ingresa la nueva nota que quieres que tenga el estudiante: ");
				Uniquindio.getEstudiante(identificacion).getNota(nombreN).setNotaC(valor);
				System.out.println("Nota actualizada con exito");
			}else if(opcion == 5) {
				System.out.println(Uniquindio.getPromedioEstudiantes());
			}else if(opcion == 6) {
				System.out.println(Uniquindio.mostrarNotasPromedioEstudiante());
			}else if(opcion == 7) {
				System.out.println(Uniquindio.mostrarNotasPromedioEstudiante());
			}
		}
	}
	
	public static Scanner input= new Scanner(System.in);
	
	public static String ingresarTexto(String texto) {
		System.out.print(texto);
		String mensaje= input.nextLine();
		return mensaje;}
	
	public static byte ingresarByte(String texto) {
		System.out.print(texto);
		String mensaje= "";
		byte numero= 0;
		boolean repetir= true;
		while (repetir) {
			mensaje= input.nextLine();
			try {
				numero= Byte.parseByte(mensaje);
				repetir= false;
			}catch(NumberFormatException e) {
				System.out.print("Error: Caracteres incompatibles, intenta de nuevo...");}
		}return numero;
	}
	
	public static float ingresarFloat(String texto) {
		System.out.print(texto);
		String mensaje= "";
		float numero= 0;
		boolean repetir= true;
		while (repetir){
			mensaje= input.nextLine();
			try {
				numero= Float.parseFloat(mensaje);
				repetir= false;
			}catch(NumberFormatException e){
				System.out.print("Error: caracteres incompatibles, intenta de nuevo...");}
		}return numero;
	}
	
	public static boolean decision(String texto) {
		System.out.print(texto);
		String mensaje= "";
		boolean repetir= true, respuesta;
		while (repetir) {
			mensaje= input.nextLine();
			if (!mensaje.equalsIgnoreCase("y") && !mensaje.equalsIgnoreCase("n")) {
				System.out.print("Error: debes ingresar una de las 2 opciones, Si(y) o No(n)...");
			}else {
				repetir= false;
				if (mensaje.equalsIgnoreCase("y")) {
					return respuesta= true;}}
		}return respuesta= false;
	}
	

}
