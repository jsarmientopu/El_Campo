package datos;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;

public class Venta implements Serializable{

	private Producto productos;
	private Emprendedor vendedor;
	private Persona comprador;
	private int precio;
	private Date fecha;
	
	public Venta(Producto productos, Emprendedor vendedor, Persona comprador, int precio, Date fecha) {
		super();
		this.productos = productos;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	public Producto getProductos() {
		return productos;
	}
	public void setProductos(Producto productos) {
		this.productos = productos;
	}
	public Emprendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Emprendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Persona getComprador() {
		return comprador;
	}
	public void setComprador(Persona comprador) {
		this.comprador = comprador;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int cantidad) {
		this.precio = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
