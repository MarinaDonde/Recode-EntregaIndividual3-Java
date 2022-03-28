

function confirmarDestino(idDestino){
	let resposta = confirm('Confirma a exclusão deste destino?');
	
	if (resposta === true) {
		window.location.href = "deletedtn?idDestino=" + idDestino;
	}
};