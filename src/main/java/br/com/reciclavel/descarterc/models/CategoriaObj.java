package br.com.reciclavel.descarterc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class CategoriaObj extends AbstractEntity{
private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_categoria", length = 60)
	private String nmCategoria;
	
	@Column(name = "tx_descricao", length = 120)
	private String txDescricao;
	
	public CategoriaObj(){
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	public String getTxDescricao() {
		return txDescricao;
	}

	public void setTxDescricao(String txDescricao) {
		this.txDescricao = txDescricao;
	}
	
}
