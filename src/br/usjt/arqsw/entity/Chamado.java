package br.usjt.arqsw.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author RA816124368 Pedro Gallon Alves CCP3AN-MCA1
 *
 */
@Entity
public class Chamado{

	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHAMADO")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_FILA")
	private Fila fila;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private String status;
	
	@NotNull
	@Column(name = "DT_ABERTURA")
	private Date dataAbertura;
	
	@Column(name = "DT_FECHAMENTO")
	private Date dataFechamento;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Chamado() {
		super();
	}
	
	public int getTempoDias(){
		//getTime e currentTimeMillis retornam o tempo em milisegundos
		//dividir por 1000 * 60 * 60 * 24 converte para dias
		int dias;
		if(dataFechamento == null){
			//considera o momento atual para calcular o tempo aberto
			dias =  (int)(System.currentTimeMillis() - dataAbertura.getTime())/(1000 * 60 * 60 * 24);
		} else {
			//considera a data de fechamento para calcular o tempo aberto
			dias = (int)(dataFechamento.getTime() - dataAbertura.getTime())/(1000 * 60 * 60 * 24);
		}
		return dias;
	}

	@Override
	public String toString() {
		return "Chamado [id=" + id + ", fila=" + fila + ", descricao=" + descricao + ", status=" + status
				+ ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + "]";
	}

}
