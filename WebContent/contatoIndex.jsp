<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Contatos" %> 
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Contatos> lista = (ArrayList<Contatos>) request.getAttribute("listaContatos");
%>
   
<!DOCTYPE html>
<html lang="pt-br" >
<head>
<meta charset="utf-8">
<title>Viaje!</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<h1>Contatos Recebidos</h1>
		<div class="btnsIndex">
			<a href="contatoNovo.html">Novo Contato</a>
			<a href="reportcnt">Relatório</a>
			<a href="index.html">Voltar</a>
		</div>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>IdDestino</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < lista.size(); i++) { %>
					<tr>
						<td><%=lista.get(i).getIdContato() %></td>
						<td><%=lista.get(i).getNome() %></td>
						<td><%=lista.get(i).getTelefone() %></td>
						<td><%=lista.get(i).getEmail() %></td>
						<td><%=lista.get(i).getIdDestino() %></td>
						<td>
							<a href="selectcnt?idContato=<%=lista.get(i).getIdContato() %>">Editar</a>
							<a href="javascript: confirmarContato(<%=lista.get(i).getIdContato() %>)" >Excluir</a>
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
<script src="scripts/confirmContato.js"></script>
</body>
</html>