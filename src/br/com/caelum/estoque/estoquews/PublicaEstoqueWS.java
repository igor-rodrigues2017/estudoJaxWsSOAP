package br.com.caelum.estoque.estoquews;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		EstoqueWs estoqueWs = new EstoqueWs();
		String URL = "http://localhost:8080/estoquews";
		
		System.out.println("EstoqueWS rodando: " + URL + "?wsdl");
		
		Endpoint.publish(URL, estoqueWs);

	}

}
