package br.com.hedvan.controle_estoque.domain;

public enum StatusPedidoProduto {
	ATIVO(1), CANCELADO(2), PROCESSADO(3);
	
	private final Integer status;
	StatusPedidoProduto(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return  status;
	}
}
