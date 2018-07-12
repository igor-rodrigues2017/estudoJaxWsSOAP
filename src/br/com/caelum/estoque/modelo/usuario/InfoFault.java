package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
	
	private String msg;
	private Date dateError;
	
	public InfoFault(String msg, Date dateError) {
		this.msg = msg;
		this.dateError = dateError;
	}
	
	//JAX-B precisa
	public InfoFault() {
		
	}

}
