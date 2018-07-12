package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name="autrizacaoFault", messageName="autrizacaoFault")
public class AutenticacaoException extends Exception {
	private static final long serialVersionUID = 1L;

	public AutenticacaoException(String msg) {
		super(msg);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Token invalido" , new Date());
	}
}
