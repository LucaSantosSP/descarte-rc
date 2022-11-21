package br.com.reciclavel.descarterc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_postocoleta")
public class PostoColetaObj extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_posto", length = 60)
	private String nmPostoColeta;
	
	@Column(name = "tx_descricao", length = 120)
	private String txDescricao;
	
	@ManyToOne
	private MaterialObj materialObj;
	
	@ManyToOne
	private LocalizacaoObj localizacaoObj;
	
	public PostoColetaObj() {
	}

	public String getNmPostoColeta() {
		return nmPostoColeta;
	}

	public void setNmPostoColeta(String nmPostoColeta) {
		this.nmPostoColeta = nmPostoColeta;
	}

	public LocalizacaoObj getLocalizacaoObj() {
		return localizacaoObj;
	}

	public void setLocalizacaoObj(LocalizacaoObj localizacaoObj) {
		this.localizacaoObj = localizacaoObj;
	}

	public String getTxDescricao() {
		return txDescricao;
	}

	public void setTxDescricao(String txDescricao) {
		this.txDescricao = txDescricao;
	}

	public MaterialObj getMaterialObj() {
		return materialObj;
	}

	public void setMaterialObj(MaterialObj materialObj) {
		this.materialObj = materialObj;
	}
}
