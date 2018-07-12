package br.com.caelum.estoque.estoquews;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.AutenticacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWs {

	private ItemDao itemDao = new ItemDao();
	
	@RequestWrapper(localName="listaItens")
	@ResponseWrapper(localName="itens")
	@WebMethod(operationName="pegarTodosOsItens")
	@WebResult(name="item")
	public List<Item> getItens(@WebParam(name="filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = itemDao.todosItens(lista);
		return itensResultado;
	}
	
	@WebMethod(operationName="cadastrarItem")
	@WebResult(name="cadastroItem")
	public Item cadastrarItem(@WebParam(name="tokenUsuario", header=true) TokenUsuario tokenUsuario 
			,@WebParam(name="item")Item item) throws AutenticacaoException {
		boolean valido = new TokenDao().ehValido(tokenUsuario);
		if(valido == false) {
			throw new AutenticacaoException("O token é inválido!");
		}
		
		new ItemValidador(item).validate();
		
		
		itemDao.cadastrar(item);
		System.out.println("Cadastrando um item " + item);
		return item;
		
	}
}
