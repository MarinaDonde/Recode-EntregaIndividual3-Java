function validarContato() {
	let nome = frmContato.nome.value;
	let telefone = frmContato.telefone.value;
	
	if (nome === '') {
		alert('Preencha o Campo Nome')
		frmContato.nome.focus()
		return false
	} else if (telefone === '') {
		alert('Preencha o Campo Telefone')
		frmContato.telefone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
};

function validarCliente() {
	let nome = frmCliente.nome.value;
	let CPF = frmCliente.CPF.value;
	let telefone = frmCliente.telefone.value;
	
	if (nome === '') {
		alert('Preencha o Campo Nome')
		frmCliente.nome.focus()
		return false
	} else if (CPF === '') {
		alert('Preencha o Campo CPF')
		frmCliente.CPF.focus()
		return false
	} else if (telefone === '') {
		alert('Preencha o Campo Telefone')
		frmCliente.telefone.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
};


function validarDestino() {
	let cidade = frmDestino.cidade.value;
	let hotel = frmDestino.hotel.value;
	let dias = frmDestino.dias.value;
	let valor = frmDestino.valor.value;
	
	if (cidade === '') {
		alert('Preencha o Campo Cidade')
		frmDestino.cidade.focus()
		return false
	} else if (hotel === '') {
		alert('Preencha o Campo Hotel')
		frmDestino.hotel.focus()
		return false
	} else if (dias === '') {
		alert('Preencha o Campo Dias')
		frmDestino.dias.focus()
		return false
	} else if (valor === '') {
		alert('Preencha o Campo Valor')
		frmDestino.valor.focus()
		return false
	} else {
		document.forms["frmDestino"].submit()
	}
};