<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Viaje!</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<h1>Editar Cliente</h1>
		<form name="frmCliente" action="updateclt">
			<table>
				<tr>
					<td><input type="text" name="idCliente" class="caixa" readonly value="<%out.print(request.getAttribute("idCliente")); %>" ></td>
				</tr>
				<tr>
					<td><input type="text" name="nome" class="caixa" value="<%out.print(request.getAttribute("nome")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="CPF" class="caixa" value="<%out.print(request.getAttribute("CPF")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="telefone" class="caixa" value="<%out.print(request.getAttribute("telefone")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="endereco" class="caixa" value="<%out.print(request.getAttribute("endereco")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="email" class="caixa" value="<%out.print(request.getAttribute("email")); %>"></td>
				</tr>
				<tr>
					<td><input type="number" name="idDestino" class="caixa" value="<%out.print(request.getAttribute("idDestino")); %>"></td>
				</tr>
			</table>
			<input type="button" value="Salvar" class="btn" onclick="validarCliente()">
			<a href="cliente">Voltar</a>
		</form>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>