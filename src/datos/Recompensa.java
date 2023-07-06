package datos;
import java.util.ArrayList;
import java.io.Serializable;
import datos.Producto;
import datos.Usuario;

public class Recompensa implements Serializable{

	private Producto producto;
	private boolean usado;
	private Usuario usuario;
	
	public Recompensa(Producto producto, boolean usado, Usuario usuario) {
		super();
		this.producto = producto;
		this.usado = usado;
		this.usuario = usuario;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public boolean isUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
