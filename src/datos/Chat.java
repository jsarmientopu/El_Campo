package datos;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;

public class Chat implements Serializable{

	private Emprendedor vendedor;
	private Usuario comprador;
	private boolean acuerdo;
	private ArrayList<Texto> texto;
	private Date fecha;
	
	public Chat(Emprendedor vendedor, Usuario comprador, boolean acuerdo, ArrayList<Texto> texto, Date fecha) {
		super();
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.acuerdo = acuerdo;
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public Chat(Emprendedor vendedor, Usuario comprador, boolean acuerdo, ArrayList<Texto> texto) {
		super();
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.acuerdo = acuerdo;
		this.texto=texto;
	}



	public Emprendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Emprendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Usuario getComprador() {
		return comprador;
	}
	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}
	public boolean isAcuerdo() {
		return acuerdo;
	}
	public void setAcuerdo(boolean acuerdo) {
		this.acuerdo = acuerdo;
	}
	public ArrayList<Texto> getTexto() {
		return texto;
	}
	public void setTexto(ArrayList<Texto> texto) {
		this.texto = texto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
