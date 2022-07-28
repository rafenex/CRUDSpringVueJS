package br.com.api.ankbrindes.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class ProdutoRequest {

	@NotBlank(message = "Preencha o modelo")
	private String modelo;
	
	@NotBlank(message = "Preencha a cor")
	private String cor;
	
	@NotBlank(message = "Preencha o valor un")
	private BigDecimal valorUnitario;
	

	private String foto;
	
	@NotBlank(message = "Preencha a quantidade")
	private Integer quantidade;
	
	public ProdutoRequest() {
		// TODO Auto-generated constructor stub
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
