
function confirmarContato(idContato){
	let resposta = confirm('Confirma a exclusão deste contato?');
	
	if (resposta === true) {
		window.location.href = "deletecnt?idContato=" + idContato;
	}
};