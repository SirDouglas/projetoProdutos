package br.com.caelum.produto.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private Double preco;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataInicioVenda;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Calendar getDataInicioVenda() {
		return dataInicioVenda;
	}

	public void setDataInicioVenda(Calendar dataInicioVenda) {
		this.dataInicioVenda = dataInicioVenda;
	}


	
}
