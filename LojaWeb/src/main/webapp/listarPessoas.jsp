<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Pessoas - Lista</title>

</head>
<body>
     <br>
     <br>
      <h1>Lista DE Pessoas</h1>
     <br> 
     <br>
     <form name="buscarPessoa" action="PessoaController" method="GET">
     <table >
     <tr>
         <td>ID</td>
         <td><input type="hidden" name="acao" value="buscarPorId" /></td>
         <td><input type="text" name="id_pessoa" size="10"
         maxlength="10" /></td>
         <td><input type="submit" value="Buscar" /></td>
         </tr>


     </table>
     </form>
     
     <h1>Manter Pessoas</h1>
     
     <form name="ListarPessoas" action="PessoaController" method="get">
     <table style="width: 90%" border="1">
     	<thead>
				<tr>
					<td>ID</td>
					<td>Nome</td>
					<td>Data Nascimento</td>
					<td colspan="3">Ação</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${listaPessoas}" var="pessoa" >
				<tr>
					<td><c:out value="${pessoa.id}"/></td>
					<td><c:out value="${pessoa.nome}"/></td>
					<td><fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy"/></td>
					
					<td>
					<a href="PessoaController?acao=atualizar&id_pessoa=<c:out value="${pessoa.id}"/>&nome=<c:out value="${pessoa.nome}"/> 
					&dataNascimento=<c:out value="${pessoa.dataNascimento}"/>">
					Alterar </a>
					</td>
					
					<td>
						<a href="PessoaController?acao=remover&id_pessoa=<c:out value="${pessoa.id}"/>"
						onclick="return confirm('Confirmar a exclusão?')">
						Excluir
						</a>
					</td>
				</tr>
				
			</c:forEach>
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="5"><a href="PessoaController?acao=criar">Incluir Nova Pessoa</a></td>
				</tr>
			</tfoot>
     
     
     </form>
     </table>
</body>
<p>
	<a href="../LojaWeb/index.html">VOLTAR MENU</a>
</p>
</html>