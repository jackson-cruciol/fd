package ifg.urutai.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifg.urutai.dao.ProdutoDAO;
import ifg.urutai.model.Produto;

@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private ProdutoDAO produtoDAO;
	private static final String MANTER_PRODUTO = "manterProduto.jsp";
	private static final String LISTAR_PRODUTO = "listarProduto.jsp";

	
	public ProdutoController() {
		super();
		produtoDAO = new ProdutoDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String avancar = "";
		
		if (acao.equalsIgnoreCase("criar")) {
			avancar = MANTER_PRODUTO;
		}
		
		else if (acao.equalsIgnoreCase("buscarPorId")) {
			int id_produto = Integer.parseInt(request.getParameter("id_produto"));
			Produto produto = produtoDAO.findbyIdProduto(id_produto);

			List<Produto> listarProdutos = new ArrayList<>();
			listarProdutos.add(produto);
			request.setAttribute("listarProdutos", listarProdutos);

			avancar = LISTAR_PRODUTO;

		}
		
		else if (acao.equalsIgnoreCase("atualizar")) {

			String id_produto = request.getParameter("id_produto");
			String nome = request.getParameter("nome");
			

			Produto produto = new Produto();
			produto.setId(Integer.parseInt(id_produto));
			produto.setNome(nome);

			request.setAttribute("produto", produto);

			avancar = MANTER_PRODUTO;

		}
		
		else if (acao.equalsIgnoreCase("remover")) {

			int id_produto = Integer.parseInt(request.getParameter("id_produto"));
			Produto produto = produtoDAO.findbyIdProduto(id_produto);
			produtoDAO.deleteByNameProduto(produto);

			List<Produto> listarProduto = produtoDAO.findAllProduto();
			request.setAttribute("listarProduto", listarProduto);

			avancar = LISTAR_PRODUTO;

		}
		
		else if (acao.equalsIgnoreCase("listarTodos")) {

			List<Produto> listarProduto = produtoDAO.findAllProduto();
			request.setAttribute("listarProduto", listarProduto);

			avancar = LISTAR_PRODUTO;
		}
		
		else {
			avancar = LISTAR_PRODUTO;
		}

		RequestDispatcher pagina = request.getRequestDispatcher(avancar);
		pagina.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_produto = request.getParameter("id_produto");
		String nome = request.getParameter("nome");

		if (id_produto.isEmpty()) {

			Produto produto = new Produto();
			produto.setNome(nome);

			produtoDAO.addProduto(produto);

			request.setAttribute("listarProduto", produtoDAO.findAllProduto());

			RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_PRODUTO);
			pagina.forward(request, response);
			
		} else {
			
			Produto produto = new Produto();
			produto.setId(Integer.parseInt(id_produto));
			produto.setNome(nome);

			produtoDAO.updateNameByIdProduto(produto);

			request.setAttribute("listarProduto", produtoDAO.findAllProduto());

			RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_PRODUTO);
			pagina.forward(request, response);
		}

	}
}
