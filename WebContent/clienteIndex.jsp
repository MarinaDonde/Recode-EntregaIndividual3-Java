<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Clientes" %> 
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("listaClientes");
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
		<h1>Lista de Clientes</h1>
		<div class="btnsIndex">
			<a href="clienteNovo.html">Novo Cliente</a>
			<a href="reportclt">Relatório</a>
			<a href="index.html">Voltar</a>
		</div>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Endereço</th>
					<th>Email</th>
					<th>IdDestino</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < lista.size(); i++) { %>
					<tr>
						<td><%=lista.get(i).getIdCliente() %></td>
						<td><%=lista.get(i).getNome() %></td>
						<td><%=lista.get(i).getCPF() %></td>
						<td><%=lista.get(i).getTelefone() %></td>
						<td><%=lista.get(i).getEndereco() %></td>
						<td><%=lista.get(i).getEmail() %></td>
						<td><%=lista.get(i).getIdDestino() %></td>
						<td>
							<a href="selectclt?idCliente=<%=lista.get(i).getIdCliente() %>">Editar</a>
							<a href="javascript: confirmarCliente(<%=lista.get(i).getIdCliente() %>)">Excluir</a>
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
<script src="scripts/confirmCliente.js"></script>
</body>
</html>