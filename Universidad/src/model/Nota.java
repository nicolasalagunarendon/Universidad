package model;

public class Nota {
	private String nombreN;
	private float valor;
	
	public Nota(String nombreN, float notac) {
		this.nombreN= nombreN;
		this.valor= notac;
	}
	
	public String getNombreN() {
		return this.nombreN;}
	
	public float getNotac() {
		return this.valor;}
	
	public void setNombreN(String newNameN){
		this.nombreN= newNameN;}
	
	public void setNotaC(float newNoteC){
		this.valor= newNoteC;}
	
	public String toStringN() {
		String mensaje= "";
		try {
		mensaje= this.nombreN + ": " + this.valor;
		}catch(NullPointerException e) {
			mensaje= "Espacio Vacio";
		}
		return mensaje;
	}
	
	
}
