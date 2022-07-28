package br.com.api.ankbrindes.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_pedido")
public class Pedido {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	

	@Column(nullable = false)
	private Cliente cliente;
	
	@OneToMany
	@Column(nullable = false)
	private List<Produto> produtos;
	
	@Column(nullable = false)
	private BigDecimal total;
	
	@Column(nullable = false)
	private LocalDate prazoDeEntrega;
	
	@Column(nullable = false)
	private LocalDate dataPedido;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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
