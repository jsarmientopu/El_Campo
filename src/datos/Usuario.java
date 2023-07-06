package datos;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.TreeMap;

public class Usuario extends Persona implements Serializable{
	
	private ArrayList<Venta> registroCompras;
	private int puntos;
	private ArrayList<Recompensa> recompensa;
	
	public Usuario(String nombre, String usuario, String contrasenia, Date fechaNacimiento, long numeroContacto) {
		super(nombre, usuario, contrasenia, fechaNacimiento, numeroContacto);
	}
	
	public Usuario(String nombre, String usuario, String contrasenia, Date fechaNacimiento, long numeroContacto, int puntos) {
		super(nombre, usuario, contrasenia, fechaNacimiento, numeroContacto);
		this.puntos = puntos;
	}
	
	public Usuario(String nombre, String usuario, String contrasenia, Date fechaNacimiento, long numeroContacto,
			ArrayList<Venta> registroCompras, int puntos) {
		super(nombre, usuario, contrasenia, fechaNacimiento, numeroContacto);
		this.registroCompras = registroCompras;
		this.puntos = puntos;
	}
	
	

	public ArrayList<Venta> getRegistroCompras() {
		return registroCompras;
	}
	public void setRegistroCompras(ArrayList<Venta> registroCompras) {
		this.registroCompras = registroCompras;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public ArrayList<Recompensa> getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(ArrayList<Recompensa> recompensa) {
		this.recompensa = recompensa;
	}

	@Override
	public String toString() {
		return "Usuario [registroCompras=" + registroCompras + ", puntos=" + puntos + "]";
	}
	
	
	
	
	
}
