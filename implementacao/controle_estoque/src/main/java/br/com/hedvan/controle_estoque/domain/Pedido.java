package br.com.hedvan.controle_estoque.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="tpd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="tpd_tipo_pedido")
	private Integer tipoPedido;
	
	@Column(name="tpd_status_pedido")
	private Integer tipoStatusPedido;
	
	@Column(name="tpd_forma_pagamento")
	private Integer formaPagamento;

	@Column(name="tpd_cliente")
	private String cliente;
	
	@Column(name="tpd_observacao")
	private String observacao;
	
	@Column(name="tpd_hora_aberta")
	private Date horaAberto;
	
	@Column(name="tpd_hora_fechada")
	private Date horaFechada;
	
	@OneToMany(
	        mappedBy = "produto",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<PedidoProduto> produtos;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, Integer tipoPedido, Integer tipoStatusPedido, Integer formaPagamento, String cliente,
			String observacao, Date horaAberto, Date horaFechada) {
		super();
		this.id = id;
		this.tipoPedido = tipoPedido;
		this.tipoStatusPedido = tipoStatusPedido;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.observacao = observacao;
		this.horaAberto = horaAberto;
		this.horaFechada = horaFechada;
	}
	
	public void addProduto(Produto produto) {
		PedidoProduto pedidoProduto = new PedidoProduto(this, produto, StatusPedidoProduto.ATIVO.getStatus());
        produtos.add(pedidoProduto);
        produto.getPedidos().add(pedidoProduto);
    }
 
    public void cancelaProduto(Produto produto) {
        for (Iterator<PedidoProduto> iterator = produtos.iterator();
             iterator.hasNext(); ) {
            PedidoProduto pedidoProduto = iterator.next();
 
            if (pedidoProduto.getPedido().equals(this) &&
                    pedidoProduto.getProduto().equals(produto)) {
                pedidoProduto.setStatusPedidoProduto(StatusPedidoProduto.CANCELADO.getStatus());
            }
        }
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(Integer tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public Integer getTipoStatusPedido() {
		return tipoStatusPedido;
	}

	public void setTipoStatusPedido(Integer tipoStatusPedido) {
		this.tipoStatusPedido = tipoStatusPedido;
	}

	public Integer getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Integer formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getHoraAberto() {
		return horaAberto;
	}

	public void setHoraAberto(Date horaAberto) {
		this.horaAberto = horaAberto;
	}

	public Date getHoraFechada() {
		return horaFechada;
	}

	public void setHoraFechada(Date horaFechada) {
		this.horaFechada = horaFechada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<PedidoProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PedidoProduto> produtos) {
		this.produtos = produtos;
	}
	
}
