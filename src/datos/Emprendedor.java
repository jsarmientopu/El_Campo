package datos;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.TreeMap;

public class Emprendedor extends Persona implements Serializable{

	private String ubicacion;
	private String descripcionSituacion;
	private TreeMap<String, Producto> productos;
	private ArrayList<String> contactoAdicional;
	private ArrayList<Venta> ventas;
	
	public Emprendedor(String nombre, String usuario, String contrasenia, Date fechaNacimiento, long numeroContacto,
			String ubicacion, String descripcionSituacion, TreeMap<String, Producto> productos,
			ArrayList<String> contactoAdicional, ArrayList<Venta> ventas) {
		super(nombre, usuario, contrasenia, fechaNacimiento, numeroContacto);
		this.ubicacion = ubicacion;
		this.descripcionSituacion = descripcionSituacion;
		this.productos = productos;
		this.contactoAdicional = contactoAdicional;
		this.ventas = ventas;
	}

	public Emprendedor(String nombre, String usuario, String contrasenia, Date fechaNacimiento, long numeroContacto,
			String ubicacion, String descripcionSituacion, ArrayList<String> contactoAdicional) {
		super(nombre, usuario, contrasenia, fechaNacimiento, numeroContacto);
		this.ubicacion = ubicacion;
		this.descripcionSituacion = descripcionSituacion;
		this.contactoAdicional = contactoAdicional;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDescripcionSituacion() {
		return descripcionSituacion;
	}
	public void setDescripcionSituacion(String descripcionSituacion) {
		this.descripcionSituacion = descripcionSituacion;
	}
	public TreeMap<String, Producto> getProductos() {
		return productos;
	}
	public void setProductos(TreeMap<String, Producto> productos) {
		this.productos = productos;
	}
	public ArrayList<String> getContactoAdicional() {
		return contactoAdicional;
	}
	public void setContactoAdicional(ArrayList<String> contactoAdicional) {
		this.contactoAdicional = contactoAdicional;
	}
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	
	
}
