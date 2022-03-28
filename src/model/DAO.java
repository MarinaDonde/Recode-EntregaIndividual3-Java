package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agviaje?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "ma1631mo";
	
	
	private Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD Create Contato
	public void inserirContato(Contatos contato) {
		String create = "insert into contato (nome,telefone,email,idDestino) values (?,?,?,?)";
		try {
			
			Connection conn = conectar();
			
			PreparedStatement pst = conn.prepareStatement(create);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdDestino());
			
			pst.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD READ Contato
	public ArrayList<Contatos> listarContatos() {
		ArrayList<Contatos> arrContatos = new ArrayList<>();
		
		String read = "select * from contato order by idContato";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String idContato = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				String idDestino = rs.getString(5);
				
				arrContatos.add(new Contatos(idContato,nome,telefone,email,idDestino));
			}
			conn.close();
			return arrContatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD Update Contato
	public void selecionarContato(Contatos contato) {
		String read2 = "select * from contato where idContato = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setString(1, contato.getIdContato());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdContato(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setTelefone(rs.getString(3));
				contato.setEmail(rs.getString(4));
				contato.setIdDestino(rs.getString(5));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Edit Contato
	public void alterarContato(Contatos contato) {
		String create = "update contato set nome=?,telefone=?,email=?,idDestino=? where idContato=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdDestino());
			pst.setString(5, contato.getIdContato());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Delete Contato
	public void deletarContato(Contatos contato) {
		String delete = "delete from contato where idContato=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setString(1, contato.getIdContato());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Create Destino
	public void inserirDestino(Destinos destino) {
		String create = "insert into destino (cidade,hotel,dias,valor) values (?,?,?,?)";
		try {
			
			Connection conn = conectar();
			
			PreparedStatement pst = conn.prepareStatement(create);
			
			pst.setString(1, destino.getCidade());
			pst.setString(2, destino.getHotel());
			pst.setString(3, destino.getDias());
			pst.setString(4, destino.getValor());
			
			pst.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD READ Destino
	public ArrayList<Destinos> listarDestinos() {
		ArrayList<Destinos> arrDestinos = new ArrayList<>();
		
		String read = "select * from destino order by idDestino";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String idDestino = rs.getString(1);
				String cidade = rs.getString(2);
				String hotel = rs.getString(3);
				String dias = rs.getString(4);
				String valor = rs.getString(5);
				
				arrDestinos.add(new Destinos(idDestino,cidade,hotel,dias,valor));
			}
			conn.close();
			return arrDestinos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD Update Destino
	public void selecionarDestino(Destinos destino) {
		String read2 = "select * from destino where idDestino = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setString(1, destino.getIdDestino());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				destino.setIdDestino(rs.getString(1));
				destino.setCidade(rs.getString(2));
				destino.setHotel(rs.getString(3));
				destino.setDias(rs.getString(4));
				destino.setValor(rs.getString(5));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Edit Destino
	public void alterarDestino(Destinos destino) {
		String create = "update destino set cidade=?,hotel=?,dias=?,valor=? where idDestino=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, destino.getCidade());
			pst.setString(2, destino.getHotel());
			pst.setString(3, destino.getDias());
			pst.setString(4, destino.getValor());
			pst.setString(5, destino.getIdDestino());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Delete Destino
	public void deletarDestino(Destinos destino) {
		String delete = "delete from destino where idDestino=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setString(1, destino.getIdDestino());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Create Cliente
	public void inserirCliente(Clientes cliente) {
		String create = "insert into cliente (nome,CPF,telefone,endereco,email,idDestino) values (?,?,?,?,?,?)";
		try {
			
			Connection conn = conectar();
			
			PreparedStatement pst = conn.prepareStatement(create);
			
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCPF());
			pst.setString(3, cliente.getTelefone());
			pst.setString(4, cliente.getEndereco());
			pst.setString(5, cliente.getEmail());
			pst.setString(6, cliente.getIdDestino());
			
			pst.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD READ Cliente
	public ArrayList<Clientes> listarClientes() {
		ArrayList<Clientes> arrClientes = new ArrayList<>();
		
		String read = "select * from cliente order by Nome";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String idCliente = rs.getString(1);
				String nome = rs.getString(2);
				String CPF = rs.getString(3);
				String telefone = rs.getString(4);
				String endereco = rs.getString(5);
				String email = rs.getString(6);
				String idDestino = rs.getString(7);
				
				
				arrClientes.add(new Clientes(idCliente,nome,CPF,telefone,endereco,email,idDestino));
			}
			conn.close();
			return arrClientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CRUD Update Cliente
	public void selecionarCliente(Clientes cliente) {
		String read2 = "select * from cliente where idCliente = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setString(1, cliente.getIdCliente());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cliente.setIdCliente(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setCPF(rs.getString(3));
				cliente.setTelefone(rs.getString(4));
				cliente.setEndereco(rs.getString(5));
				cliente.setEmail(rs.getString(6));
				cliente.setIdDestino(rs.getString(7));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Edit Cliente
	public void alterarCliente(Clientes cliente) {
		String create = "update cliente set nome=?,CPF=?,telefone=?,endereco=?,email=?,idDestino=? where idCliente=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCPF());
			pst.setString(3, cliente.getTelefone());
			pst.setString(4, cliente.getEndereco());
			pst.setString(5, cliente.getEmail());
			pst.setString(6, cliente.getIdDestino());
			pst.setString(7, cliente.getIdCliente());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD Delete Cliente
	public void deletarCliente(Clientes cliente) {
		String delete = "delete from cliente where idCliente=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setString(1, cliente.getIdCliente());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

