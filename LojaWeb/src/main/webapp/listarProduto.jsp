<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar - Produtos</title>
</head>
<body>
	<br>
     <br>
      <h1>Lista de Produto</h1>
     <br> 
     <br>
     
     <form name="buscarProduto" action="ProdutoController" method="GET">
     <table >
     <tr>
         <td>ID</td>
         <td><input type="hidden" name="acao" value="buscarPorId" /></td>
         <td><input type="text" name="id_produto" size="10"
         maxlength="10" /></td>
         <td><input type="submit" value="Buscar" /></td>
         </tr>


     </table>
     </form>
     
<h1>Manter Produto</h1>
     
     <form name="ListarProduto" action="ProdutoController" method="get">
     <table style="width: 90%" border="1">
     	<thead>
				<tr>
					<td>ID</td>
					<td>Nome</td>
					<td colspan="2">Ação</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${listarProduto}" var="produto" >
				<tr>
					<td><c:out value="${produto.id}"/></td>
					<td><c:out value="${produto.nome}"/></td>
					
					<td>
					<a href="ProdutoController?acao=atualizar&id_produto=<c:out value="${produto.id}"/>&nome=<c:out value="${produto.nome}"/> 
					">
					Alterar </a>
					</td>
					
					<td>
						<a href="ProdutoController?acao=remover&id_produto=<c:out value="${produto.id}"/>"
						onclick="return confirm('Confirmar a exclusão?')">
						Excluir
						</a>
					</td>
				</tr>
				
			</c:forEach>
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="5"><a href="ProdutoController?acao=criar">Incluir Novo Produto</a></td>
				</tr>
			</tfoot>
     </form>
     </table>
</body>
<p>
	<a href="../LojaWeb/index.html">VOLTAR MENU</a>
</p>
</html>