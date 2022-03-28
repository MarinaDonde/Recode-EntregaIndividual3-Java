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
		<h1>Editar Destino</h1>
		<form name="frmDestino" action="updatedtn">
			<table>
				<tr>
					<td><input type="text" name="idDestino" class="caixa" readonly value="<%out.print(request.getAttribute("idDestino")); %>" ></td>
				</tr>
				<tr>
					<td><input type="text" name="cidade" class="caixa" value="<%out.print(request.getAttribute("cidade")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="hotel" class="caixa" value="<%out.print(request.getAttribute("hotel")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="dias" class="caixa" value="<%out.print(request.getAttribute("dias")); %>"></td>
				</tr>
				<tr>
					<td><input type="text" name="valor" class="caixa" value="<%out.print(request.getAttribute("valor")); %>"></td>
				</tr>
	
			</table>
			<input type="button" value="Salvar" class="btn" onclick="validarDestino()">
			<a href="destino">Voltar</a>
		</form>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>