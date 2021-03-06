package br.usjt.arqsw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Entity
public class Usuario {
	@NotNull
	@Id
	@Column(name="ID_USUARIO")
	private String id;
	@NotNull
	@Column(name="PW_USUARIO")
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Usuario() {
		super();
	}
	public Usuario(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	

}
