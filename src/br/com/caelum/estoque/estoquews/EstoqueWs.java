package br.com.caelum.estoque.estoquews;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

@WebService
public class EstoqueWs {

	private ItemDao itemDao = new ItemDao();
	
	@WebMethod(operationName="pegarTodosOsItens")
	@WebResult(name="itens")
	public ListaItens getItens() {
		System.out.println("Chamando getItens()");
		ArrayList<Item> lista = itemDao.todosItens();
		return new ListaItens(lista);
	}

}
