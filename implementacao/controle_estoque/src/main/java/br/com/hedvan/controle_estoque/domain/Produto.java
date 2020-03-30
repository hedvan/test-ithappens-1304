package br.com.hedvan.controle_estoque.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name="tab_cad_produto")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tcp_codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@NaturalId
	@Column(name="tcp_codigo_barras")
	private String codigoBarra;
	
	@Column(name="tcp_descricao")
	private String descricao;
	
	@Column(name="tcp_quantidade")
	private Integer quantidade;
	
	@Column(name="tcp_valor")
	private Double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Filial filial;
	
	@OneToMany(
	        mappedBy = "pedido",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<PedidoProduto> pedidos; 
	
	public Produto () {
		
	}

	public Produto(Integer codigo, String codigoBarra, String descricao, Integer quantidade, Double valor) {
		super();
		this.codigo = codigo;
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public List<PedidoProduto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoProduto> pedidos) {
		this.pedidos = pedidos;
	}

}
