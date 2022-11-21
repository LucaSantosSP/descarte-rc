package br.com.reciclavel.descarterc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_materialobj")
public class MaterialObj extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_material", length = 60)
	private String nmMaterial;
	
	@Column(name = "tx_descricao", length = 120)
	private String txDescricao;
	
	@ManyToOne
	private CategoriaObj categoriaObj;
	
	public MaterialObj(){
	}

	public String getNmMaterial() {
		return nmMaterial;
	}

	public void setNmMaterial(String nmMaterial) {
		this.nmMaterial = nmMaterial;
	}

	public String getTxDescricao() {
		return txDescricao;
	}

	public void setTxDescricao(String txDescricao) {
		this.txDescricao = txDescricao;
	}

	public CategoriaObj getCategoriaObj() {
		return categoriaObj;
	}

	public void setCategoriaObj(CategoriaObj categoriaObj) {
		this.categoriaObj = categoriaObj;
	}

}
