package br.com.reciclavel.descarterc.models;

import javax.persistence.Column;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "tab_Localizaoobj")
public class LocalizacaoObj extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "qt_numero", length = 10)
	private Integer qtNumero;
	
	@Column(name = "tx_rua", length = 60)
	private String txRua;
	
	@Column(name = "tx_bairro", length = 60)
	private String txBairro;
	
	@Column(name = "tx_cidade", length = 60)
	private String txCidade;
	
	@Column(name = "tx_estado", length = 60)
	private String txEstado;
	
	@Column(name = "tx_pais", length = 60)
	private String txPais;

	public Integer getQtNumero() {
		return qtNumero;
	}

	public void setQtNumero(Integer qtNumero) {
		this.qtNumero = qtNumero;
	}

	public String getTxRua() {
		return txRua;
	}

	public void setTxRua(String txRua) {
		this.txRua = txRua;
	}

	public String getTxBairro() {
		return txBairro;
	}

	public void setTxBairro(String txBairro) {
		this.txBairro = txBairro;
	}

	public String getTxCidade() {
		return txCidade;
	}

	public void setTxCidade(String txCidade) {
		this.txCidade = txCidade;
	}

	public String getTxEstado() {
		return txEstado;
	}

	public void setTxEstado(String txEstado) {
		this.txEstado = txEstado;
	}

	public String getTxPais() {
		return txPais;
	}

	public void setTxPais(String txPais) {
		this.txPais = txPais;
	}
	
}
