package datos;

import java.io.Serializable;

public class Producto implements Serializable{

	private String nombre;
	private Emprendedor vendedor;
	private double peso;
	private int precioPeso;
	private boolean posibilidadMediosPago;
	private String seccion;
	
	public Producto(String nombre, Emprendedor vendedor, double peso, int precioPeso, String seccion) {
		super();
		this.nombre = nombre;
		this.vendedor = vendedor;
		this.peso = peso;
		this.precioPeso = precioPeso;
		this.seccion= seccion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Emprendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Emprendedor vendedor) {
		this.vendedor = vendedor;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getPrecioPeso() {
		return precioPeso;
	}
	public void setPrecioPeso(int precioPeso) {
		this.precioPeso = precioPeso;
	}
	public boolean isPosibilidadMediosPago() {
		return posibilidadMediosPago;
	}
	public void setPosibilidadMediosPago(boolean posibilidadMediosPago) {
		this.posibilidadMediosPago = posibilidadMediosPago;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
}
