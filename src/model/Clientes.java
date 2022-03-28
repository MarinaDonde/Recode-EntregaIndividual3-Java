package model;

public class Clientes {
	private String idCliente;
	private String nome;
	private String CPF;
	private String telefone;
	private String endereco;
	private String email;
	private String idDestino;
	
	public Clientes(String idCliente, String nome, String cPF, String telefone, String endereco, String email, String idDestino) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.idDestino = idDestino;
	}

	public Clientes() {
		super();
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(String idDestino) {
		this.idDestino = idDestino;
	}
	
}
