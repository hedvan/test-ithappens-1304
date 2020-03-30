package br.com.hedvan.controle_estoque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pedido_produto")
public class PedidoProduto implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private PedidoProdutoId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pedidoId")
    private Pedido pedido;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("produtoId")
    private Produto produto;
 
    @Column(name = "tpp_status_item")
    private Integer statusPedidoProduto;
    
    public PedidoProduto() {}

	public PedidoProduto(Pedido pedido, Produto produto, Integer statusItem) {
		super();
		this.pedido = pedido;
		this.produto = produto;
		this.id = new PedidoProdutoId(pedido.getId(), produto.getCodigo());
		this.statusPedidoProduto = statusItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getStatusPedidoProduto() {
		return statusPedidoProduto;
	}

	public void setStatusPedidoProduto(Integer statusPedidoProduto) {
		this.statusPedidoProduto = statusPedidoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		PedidoProduto other = (PedidoProduto) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
}
