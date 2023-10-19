package ifg.urutai.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifg.urutai.dao.PessoaDAO;
import ifg.urutai.model.Pessoa;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/PessoaController")
public class PessoaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PessoaDAO pessoaDAO;
	private static final String MANTER_PESSOA = "manterPessoa.jsp";
	private static final String LISTAR_PESSOAS = "listarPessoas.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PessoaController() {
		super();
		pessoaDAO = new PessoaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String avancar = "";

		if (acao.equalsIgnoreCase("criar")) {
			avancar = MANTER_PESSOA;
		}

		else if (acao.equalsIgnoreCase("buscarPorId")) {
			int id_pessoa = Integer.parseInt(request.getParameter("id_pessoa"));
			Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);

			List<Pessoa> listaPessoas = new ArrayList<>();
			listaPessoas.add(pessoa);
			request.setAttribute("listaPessoas", listaPessoas);

			avancar = LISTAR_PESSOAS;

		} else if (acao.equalsIgnoreCase("atualizar")) {

			String id_pessoa = request.getParameter("id_pessoa");
			String nome = request.getParameter("nome");
			String dataNascimento = request.getParameter("dataNascimento");

			Pessoa pessoa = new Pessoa();
			pessoa.setId(Integer.parseInt(id_pessoa));
			pessoa.setNome(nome);
			pessoa.setDataNascimento(Date.valueOf(dataNascimento));

			request.setAttribute("pessoa", pessoa);

			avancar = MANTER_PESSOA;

		} else if (acao.equalsIgnoreCase("remover")) {

			int id_pessoa = Integer.parseInt(request.getParameter("id_pessoa"));
			Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);
			pessoaDAO.deleteByname(pessoa);

			List<Pessoa> listaPessoas = pessoaDAO.findAll();
			request.setAttribute("listaPessoas", listaPessoas);

			avancar = LISTAR_PESSOAS;

		} else if (acao.equalsIgnoreCase("listarTodos")) {

			List<Pessoa> listaPessoas = pessoaDAO.findAll();
			request.setAttribute("listaPessoas", listaPessoas);

			avancar = LISTAR_PESSOAS;
		}

		else {
			avancar = LISTAR_PESSOAS;
		}

		RequestDispatcher pagina = request.getRequestDispatcher(avancar);
		pagina.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_pessoa = request.getParameter("id_pessoa");
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");

		// Se o id_pessoa e vazio, criamos. Senao, atualizamos uma pessoa existente
		if (id_pessoa.isEmpty()) {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(nome);

			// Formatar data antes de salvar
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(dataNascimento, formato);
			pessoa.setDataNascimento(Date.valueOf(localDate));

			pessoaDAO.add(pessoa);

			request.setAttribute("listaPessoas", pessoaDAO.findAll());

			RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_PESSOAS);
			pagina.forward(request, response);
			
		} else {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(Integer.parseInt(id_pessoa));
			pessoa.setNome(nome);

			pessoaDAO.updateNameById(pessoa);

			request.setAttribute("listaPessoas", pessoaDAO.findAll());

			RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_PESSOAS);
			pagina.forward(request, response);
		}

	}

}