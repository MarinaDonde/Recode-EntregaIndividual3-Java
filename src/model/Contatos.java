package model;

public class Contatos {
	private String idContato;
	private String nome;
	private String telefone;
	private String email;
	private String idDestino;
	
	public Contatos(String idContato, String nome, String telefone, String email, String idDestino) {
		super();
		this.idContato = idContato;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.idDestino = idDestino;
	}
	public Contatos() {
		super();
	}
	public String getIdContato() {
		return idContato;
	}
	public void setIdContato(String idContato) {
		this.idContato = idContato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
