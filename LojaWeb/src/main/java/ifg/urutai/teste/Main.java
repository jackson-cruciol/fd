package ifg.urutai.teste;

import java.sql.Date;
import java.util.List;

import ifg.urutai.dao.ItemPedidoDAO;
import ifg.urutai.dao.PedidoDAO;
import ifg.urutai.dao.PessoaDAO;
import ifg.urutai.dao.ProdutoDAO;
import ifg.urutai.model.ItemPedido;
import ifg.urutai.model.Pedido;
import ifg.urutai.model.Pessoa;
import ifg.urutai.model.Produto;

public class Main {

	public static void main(String[] args) {

		// PESSOA

		/*
		 * Pessoa pessoa = new Pessoa(); pessoa.setNome("cod");
		 * pessoa.setDataNascimento(Date.valueOf("2002-08-6"));
		 * 
		 * PessoaDAO pDAO = new PessoaDAO();
		 * 
		 * pDAO.add(pessoa);
		 */

		/*
		 * Pessoa pessoa = new Pessoa();
		 * 
		 * PessoaDAO pDAO = new PessoaDAO(); pessoa = pDAO.findbyId(2);
		 * 
		 * System.out.println("Id: "+ pessoa.getId()); System.out.println("Nome: "+
		 * pessoa.getNome()); System.out.println("Data de nascimento: "+
		 * pessoa.getDataNascimento());
		 */

		/*
		 * PessoaDAO pDAO = new PessoaDAO();
		 *  Pessoa pessoa = pDAO.findbyId(3);
		 * 
		 * pessoa.setNome("Gabriel");
		 *  pDAO.updateNameById(pessoa);
		 */

		
		/*
		 * PessoaDAO pDAO = new PessoaDAO(); Pessoa pessoa = pDAO.findbyId(2);
		 * 
		 * pDAO.deleteByname(pessoa);
		 */
		 

		/*
		 * PessoaDAO pDAO = new PessoaDAO(); List<Pessoa> listaPessoa = pDAO.findAll();
		 * 
		 * System.out.println("                      Pessoa");
		 * System.out.println("----------------------------------------------->");
		 * listaPessoa.forEach(p -> { System.out.println("Código: "+p.getId());
		 * System.out.println("Nome: "+p.getNome());
		 * System.out.println("------------------------------------------->"); });
		 */

		// PRODUTO

		// Add
		/*
		 * Produto produto = new Produto();
		 * produto.setNome("Mouse pad para jogos RGB, UtechSmart");
		 * 
		 * ProdutoDAO pDAO = new ProdutoDAO();
		 * 
		 * pDAO.addProduto(produto);
		 */

		// Buscar por id
		/*
		 * Produto produto = new Produto();
		 * 
		 * ProdutoDAO pDAO = new ProdutoDAO(); produto = pDAO.findbyIdProduto(2);
		 * 
		 * System.out.println("Id: "+ produto.getId()); System.out.println("Nome: "+
		 * produto.getNome());
		 */

		// update

//		 ProdutoDAO pDAO = new ProdutoDAO();
		// Produto produto = pDAO.findbyIdProduto(5);
//		  
//		  produto.setNome("CELL");
//		  pDAO.updateNameByIdProduto(produto);

		// find all

		/*
		 * ProdutoDAO pDAO = new ProdutoDAO(); List<Produto> listaProduto =
		 * pDAO.findAllProduto();
		 * 
		 * System.out.println("                      Produto:");
		 * System.out.println("----------------------------------------------->");
		 * listaProduto.forEach(p -> { System.out.println("Código: "+p.getId());
		 * System.out.println("Nome: "+p.getNome());
		 * System.out.println("------------------------------------------->"); });
		 */

		// delete
//			  ProdutoDAO pDAO = new ProdutoDAO(); Produto produto =
//			  pDAO.findbyIdProduto(7);
//			  
//			  pDAO.deleteByNameProduto(produto);

		// Add Pedido

//		 Pedido pedido = new Pedido();
//		 
//		 pedido.setDataPedido(Date.valueOf("2023-08-6"));
//
//		 PessoaDAO pessoaDAO = new PessoaDAO();
//		 
//		 Pessoa pessoa = pessoaDAO.findbyId(2);
//	     pedido.setPessoa(pessoa);
//		  
//		  PedidoDAO pDAO = new PedidoDAO();
//		  
//		  pDAO.add(pedido);

		// findByID

//		Pedido pedido = new Pedido();
//
//		PedidoDAO pedidoDAO = new PedidoDAO();
//
//		pedido = pedidoDAO.findbyIdPedido(2);
//
//		System.out.println("Id: " + pedido.getId());
//		System.out.println("Data: " + pedido.getDataPedido());
//		System.out.println("Destinatário: " + pedido.getPessoa().getNome());
		
		//update data pedido

//		PedidoDAO pedidoDAO = new PedidoDAO();
//		Pedido pedido = pedidoDAO.findbyIdPedido(2);
//		
//		pedido.setDataPedido(Date.valueOf("2022-03-01"));
//		
//		pedidoDAO.updateDataById(pedido);
		
		// delete 
		
		
//		PedidoDAO pedidoDAO = new PedidoDAO();
//		Pedido pedido = pedidoDAO.findbyIdPedido(4);
//
//		pedidoDAO.deleteById(pedido);
		
		// findAll
		
//		 PedidoDAO pedidoDAO = new PedidoDAO(); List<Pedido> listaPedido =
//				  pedidoDAO.findByAll();
//				  
//				  System.out.println(" \n                     Pedidos:");
//				  System.out.println("----------------------------------------------->");
//				  listaPedido.forEach(p -> { System.out.println("Código: "+p.getId());
//				  System.out.println("Data: "+p.getDataPedido());
//				  System.out.println("Destinatário: "+ p.getPessoa().getNome());
//				  System.out.println("------------------------------------------->"); });
		
		// Item Pedido
		
		// add
		
//		ItemPedido itemPedido = new ItemPedido();
//		 
//		 itemPedido.setQuantidade(5);
//
//		 PedidoDAO pedidoDAO = new PedidoDAO();
//		 
//		 Pedido pedido = pedidoDAO.findbyIdPedido(3);
//		 itemPedido.setPedido(pedido);
//		 
//		 ProdutoDAO produtoDAO = new ProdutoDAO();
//		 
//		 Produto produto = produtoDAO.findbyIdProduto(4);
//		 itemPedido.setProduto(produto);
//		  
//		  ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
//		  
//		  itemPedidoDAO.add(itemPedido);
//		
		
		
		// findbyid
		
//		ItemPedido itemPedido = new ItemPedido();
//		
//		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
//
//				itemPedido = itemPedidoDAO.findbyIdItemPedido(1);
//
//				System.out.println("Id: " + itemPedido.getIdItemPedido());
//				System.out.println("Quantidade: " + itemPedido.getQuantidade());
//				System.out.println("Data do pedido: " + itemPedido.getPedido().getDataPedido());
//				System.out.println("Produto: " + itemPedido.getProduto().getNome());

	// update da quantidade de pedido
		
//		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
//		ItemPedido itemPedido = itemPedidoDAO.findbyIdItemPedido(1);
//		
//		itemPedido.setQuantidade(11);
//		
//		itemPedidoDAO.updateAmountById(itemPedido);
		
		// delete id
		
//		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
//		ItemPedido itemPedido = itemPedidoDAO.findbyIdItemPedido(4);
//
//		itemPedidoDAO.deleteByIdItemPedido(itemPedido);
		
		// findAll
		
		/*
		 * ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(); List<ItemPedido>
		 * listaItemPedido = itemPedidoDAO.findByAll();
		 * 
		 * System.out.println(" \n                  Itens e Pedidos:");
		 * System.out.println("----------------------------------------------->");
		 * listaItemPedido.forEach(p -> {
		 * System.out.println("Código: "+p.getIdItemPedido());
		 * System.out.println("Quantidade: "+p.getQuantidade());
		 * System.out.println("Data do pedido: " + p.getPedido().getDataPedido());
		 * System.out.println("Produto: "+ p.getProduto().getNome());
		 * System.out.println("------------------------------------------->"); });
		 */
		
	}

}
