package br.com.api.ankbrindes.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.api.ankbrindes.models.Cliente;
import br.com.api.ankbrindes.models.Produto;

public class PedidoRequest {
	
	@NotBlank(message = "Preencha o cliente")
	private Cliente cliente;	
	
	@NotEmpty(message = "Preencha os produtos")
	private List<Produto> produtos;

	@NotBlank(message = "Preencha o prazo")
	private LocalDate prazoDeEntrega;	

	@NotBlank(message = "Preencha a data")
	private LocalDate dataPedido;
	
	public PedidoRequest() {
		// TODO Auto-generated constructor stub
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public LocalDate getPrazoDeEntrega() {
		return prazoDeEntrega;
	}

	public void setPrazoDeEntrega(LocalDate prazoDeEntrega) {
		this.prazoDeEntrega = prazoDeEntrega;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	

}
