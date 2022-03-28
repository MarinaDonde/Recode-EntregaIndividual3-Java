package model;

public class Destinos {
	private String idDestino;
	private String cidade;
	private String hotel;
	private String dias;
	private String valor;
		
	
	public Destinos(String idDestino, String cidade, String hotel, String dias, String valor) {
		super();
		this.idDestino = idDestino;
		this.cidade = cidade;
		this.hotel = hotel;
		this.dias = dias;
		this.valor = valor;
	}

	public Destinos() {
		super();
	}

	public String getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(String idDestino) {
		this.idDestino = idDestino;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}

