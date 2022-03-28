package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Clientes;
import model.Contatos;
import model.DAO;



@WebServlet(urlPatterns = {"/ClientesController", "/cliente", "/insertclt", "/selectclt", "/updateclt", "/deleteclt", "/reportclt"})
public class ClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Clientes cliente = new Clientes();

	public ClientesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/cliente")) {
			clientes(request, response);
		} else if (action.equals("/insertclt")) {
			novoCliente(request, response);
		} else if (action.equals("/selectclt")) {
			listarCliente(request, response);
		} else if (action.equals("/updateclt")) {
			editarCliente(request, response);
		} else if (action.equals("/deleteclt")) {
			removerCliente(request, response);
		} else if (action.equals("/reportclt")) {
			gerarRelatorioCliente(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	// Listar clientes
	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Clientes> lista = dao.listarClientes();

		request.setAttribute("listaClientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clienteIndex.jsp");
		rd.forward(request, response);
	}
	
	// Novo cliente
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		cliente.setNome(request.getParameter("nome"));
		cliente.setCPF(request.getParameter("CPF"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setIdDestino(request.getParameter("idDestino"));

		dao.inserirCliente(cliente);

		response.sendRedirect("cliente");
	}

	// Editar Cliente
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idCliente = request.getParameter("idCliente");

		cliente.setIdCliente(idCliente);

		dao.selecionarCliente(cliente);

		request.setAttribute("idCliente", cliente.getIdCliente());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("CPF", cliente.getCPF());
		request.setAttribute("telefone", cliente.getTelefone());
		request.setAttribute("endereco", cliente.getEndereco());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("idDestino", cliente.getIdDestino());

		RequestDispatcher rd = request.getRequestDispatcher("clienteEditar.jsp");
		rd.forward(request, response);
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cliente.setIdCliente(request.getParameter("idCliente"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCPF(request.getParameter("CPF"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setIdDestino(request.getParameter("idDestino"));

		dao.alterarCliente(cliente);

		response.sendRedirect("cliente");
	}

	// Remover Cliente
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCliente = request.getParameter("idCliente");

		cliente.setIdCliente(idCliente);

		dao.deletarCliente(cliente);

		response.sendRedirect("cliente");
	}
	
	//Relatorio em PDF
	protected void gerarRelatorioCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "clientes.pdf" );
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Clientes"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(6);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Endereço"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Email"));
			PdfPCell col6 = new PdfPCell(new Paragraph("IdDestino"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			ArrayList<Clientes> lista = dao.listarClientes();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getCPF());
				tabela.addCell(lista.get(i).getTelefone());
				tabela.addCell(lista.get(i).getEndereco());
				tabela.addCell(lista.get(i).getEmail());
				tabela.addCell(lista.get(i).getIdDestino());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	
	}
	
}
