

function confirmarCliente(idCliente){
	let resposta = confirm('Confirma a exclusão deste cliente?');
	
	if (resposta === true) {
		window.location.href = "deleteclt?idCliente=" + idCliente;
	}
};