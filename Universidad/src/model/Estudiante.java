package model;

public class Estudiante {
	private String nombre;
	private String identificacion;
	private Nota[] listaNotas;
	private byte cupos;

	public Estudiante(String nombre, String identificacion) {
		this.nombre= nombre;
		this.identificacion= identificacion;
		this.listaNotas= new Nota[5];
		this.cupos= 0;
	}
	

	public String getNombre() {
		return this.nombre;}
	
	public String getIdentificacion() {
		return this.identificacion;}
	
	public String agregarNota(Nota nota1) {
		String mensaje= "";
		for (byte i=0; i< listaNotas.length; i++) {
			if (listaNotas[i] == null) {
				listaNotas[i]= nota1;
				cupos++;
				return mensaje= "Nota agregada con exito...";}}
		return mensaje= "No se pudo agregar esta nota, limite de notas alcanzado...";
	}
	
	
	public Nota getNota(String nombre) {
		for(byte i= 0; i< listaNotas.length; i++) {
			if (listaNotas[i].getNombreN() == nombre) {
				return listaNotas[i];}}
		return null;}
	
	public String toString() {
		String mensaje= "Nombre: " + this.nombre + "\nIdentificación: " + this.identificacion + "\nNotas:\n";
		for (byte i=0; i<listaNotas.length; i++) {
			try {
			mensaje+= "   " + listaNotas[i].toStringN() +  "\n";
			}catch(NullPointerException e) {
				mensaje+= "   Espacio vacio\n";
			}
		}
		return mensaje;
	}

	public void setNombre(String newName){
		this.nombre= newName;}
	
	public void setIdentificacion(String newID) {
		this.identificacion= newID;}
		
	public String verNotasTotales() {
		String mensaje= "";
		for (byte i= 0; i<listaNotas.length; i++) {
			try {
				mensaje+= "\nNombre de la Actividad: " + listaNotas[i].getNombreN() + "   Nota: " + listaNotas[i].getNotac() + "\n";
			}catch(NullPointerException e) {
				mensaje+= "   Espacio Vacio\n";
			}
				}
		return mensaje;}
	
	public float getPromedio() {
		float promedio= 0;
		byte divisor= 0;
		for (byte i= 0; i<listaNotas.length; i++) {
			if(listaNotas[i] != null) {
			promedio+= listaNotas[i].getNotac();
			divisor++;}}
		promedio= promedio/divisor;
		return promedio;}
	
	
}
