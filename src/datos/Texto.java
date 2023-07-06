package datos;

import java.io.Serializable;

public class Texto implements Serializable{

	private Persona persona;
	private String texto;
	private boolean enviado;
	
	public Texto(Persona persona, String texto, boolean enviado) {
		super();
		this.persona = persona;
		this.texto = texto;
		this.enviado = enviado;
	}
	public Texto(Persona persona, String texto) {
		super();
		this.persona = persona;
		this.texto = texto;
	}

	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isEnviado() {
		return enviado;
	}
	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}
	
	
	
}
