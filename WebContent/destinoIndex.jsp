<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Destinos" %> 
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Destinos> lista = (ArrayList<Destinos>) request.getAttribute("listaDestinos");
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
		<h1>Lista de Destinos</h1>
		<div class="btnsIndex">
			<a href="destinoNovo.html">Novo Destino</a>
			<a href="reportdtn">Relatório</a>
			<a href="index.html">Voltar</a>
		</div>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Cidade</th>
					<th>Hotel</th>
					<th>Dias</th>
					<th>Valor</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < lista.size(); i++) { %>
					<tr>
						<td><%=lista.get(i).getIdDestino() %></td>
						<td><%=lista.get(i).getCidade() %></td>
						<td><%=lista.get(i).getHotel() %></td>
						<td><%=lista.get(i).getDias() %></td>
						<td><%=lista.get(i).getValor() %></td>	
						<td>
							<a href="selectdtn?idDestino=<%=lista.get(i).getIdDestino() %>">Editar</a>
							<a href="javascript: confirmarDestino(<%=lista.get(i).getIdDestino() %>)">Excluir</a>
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
<script src="scripts/confirmDestino.js"></script>
</body>
</html>