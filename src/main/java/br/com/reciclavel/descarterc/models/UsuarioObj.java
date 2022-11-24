package br.com.reciclavel.descarterc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuarioobj")
public class UsuarioObj extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_usuario", length = 60)
	private String nmUsuario;
	
	@Column(name = "tx_email", length = 120, unique=true)
	private String txEmail;
	
	@Column(name = "cd_senha", length = 120)
	private String cdSenha;
	
	public UsuarioObj() {
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getTxEmail() {
		return txEmail;
	}

	public void setTxEmail(String txEmail) {
		this.txEmail = txEmail;
	}

	public String getCdSenha() {
		return cdSenha;
	}

	public void setCdSenha(String cdSenha) {
		this.cdSenha = cdSenha;
	}
	
}
