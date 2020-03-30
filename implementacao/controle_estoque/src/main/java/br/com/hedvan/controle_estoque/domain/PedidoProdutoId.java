package br.com.hedvan.controle_estoque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoProdutoId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "tcp_id")
    private Integer produtoId;
 
    @Column(name = "tpd_id")
    private Integer pedidoId;
 
    public PedidoProdutoId() {
	
	}
    
    public PedidoProdutoId( Integer pedidoId, Integer produtoId) {
		super();
		this.produtoId = produtoId;
		this.pedidoId = pedidoId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoId == null) ? 0 : pedidoId.hashCode());
		result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
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
		PedidoProdutoId other = (PedidoProdutoId) obj;
		if (pedidoId == null) {
			if (other.pedidoId != null)
				return false;
		} else if (!pedidoId.equals(other.pedidoId))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

}
