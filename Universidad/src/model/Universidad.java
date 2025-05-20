package model;

import java.util.ArrayList;

public class Universidad {
	private String nombreU;
	private String ubicacion;
	private ArrayList<Estudiante> listaEstudiantes;
	
	public Universidad(String nombre, String ubicacion) {
		this.nombreU= nombre;
		this.ubicacion= ubicacion;
		this.listaEstudiantes= new ArrayList<Estudiante>();
	}
	
	public String getNombreU() {
		return this.nombreU;}
	
	public String getUbicacion() {
		return this.ubicacion;}
	
	public void setNombreU(String newNameU) {
		this.nombreU= newNameU;}
	
	public void setUbicacion(String newUbicacion) {
		this.ubicacion= newUbicacion;}
	
	public String registrarEstudiantes(Estudiante estudiante) {
		String mensaje= "";
		for (short i=0; i<listaEstudiantes.size(); i++) {
			if(listaEstudiantes.get(i).getIdentificacion().equals(estudiante.getIdentificacion())) {
				return mensaje= "Este estudiante ya está registrado a la universidad";
			}		
		}listaEstudiantes.add(estudiante);
		mensaje= "Estudiante registrado con exito\n";
		return mensaje;
	}
	
	public Estudiante getEstudiante(String id) {
		for (short i=0; i<listaEstudiantes.size(); i++) {
			if (listaEstudiantes.get(i).getIdentificacion().equals(id)) {
				return listaEstudiantes.get(i);
			}
		}return null;
	}
	
	public String getPromedioEstudiantes() {
		String mensaje= "";
		for(short i=0; i<listaEstudiantes.size(); i++){
			mensaje+= i + ") " + "Estudiante: " + listaEstudiantes.get(i).getNombre() + "\n"
					+ "Identificación: " + listaEstudiantes.get(i).getIdentificacion() + "\n"
					+ "Promedio: " + listaEstudiantes.get(i).getPromedio() + "\n";}
		return mensaje;
	}
	
	public Estudiante getEstudianteMayorPromedio() {
		Estudiante estudiante1= listaEstudiantes.get(0);
		Estudiante estudiante2= listaEstudiantes.get(0);
		for (short i=0; i<listaEstudiantes.size(); i++) {
			estudiante1= listaEstudiantes.get(i);
			if (estudiante2.getPromedio() < estudiante1.getPromedio()) {
				estudiante2= estudiante1;}
		}return estudiante2;
	}
	
	public String mostrarNotasPromedioEstudiante() {
		String mensaje= "";
		for (short i=0; i<listaEstudiantes.size(); i++) {
			mensaje+= (i+1) + ") " + "*Estudiante: " + listaEstudiantes.get(i).getNombre() + "\n"
					+ "*Identificación: " + listaEstudiantes.get(i).getIdentificacion() + "\n"
					+ "*Notas: " + listaEstudiantes.get(i).verNotasTotales() + "\n"
					+ "*Promedio: " + listaEstudiantes.get(i).getPromedio() + "\n\n";
		}return mensaje;
	}

	
	
}
