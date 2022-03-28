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

import model.Contatos;
import model.DAO;



@WebServlet(urlPatterns = {"/ContatosController", "/contato", "/insertcnt", "/selectcnt", "/updatecnt", "/deletecnt", "/reportcnt"})
public class ContatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Contatos contato = new Contatos();

	public ContatosController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/contato")) {
			contatos(request, response);
		} else if (action.equals("/insertcnt")) {
			novoContato(request, response);
		} else if (action.equals("/selectcnt")) {
			listarContato(request, response);
		} else if (action.equals("/updatecnt")) {
			editarContato(request, response);
		} else if (action.equals("/deletecnt")) {
			removerContato(request, response);
		} else if (action.equals("/reportcnt")) {
			gerarRelatorioContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Contatos> lista = dao.listarContatos();

		request.setAttribute("listaContatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("contatoIndex.jsp");
		rd.forward(request, response);
	}
	
	// Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		contato.setIdDestino(request.getParameter("idDestino"));

		dao.inserirContato(contato);

		response.sendRedirect("contato");
	}

	// Editar Contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idContato = request.getParameter("idContato");

		contato.setIdContato(idContato);

		dao.selecionarContato(contato);

		request.setAttribute("idContato", contato.getIdContato());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("idDestino", contato.getIdDestino());

		RequestDispatcher rd = request.getRequestDispatcher("contatoEditar.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setIdContato(request.getParameter("idContato"));
		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		contato.setIdDestino(request.getParameter("idDestino"));

		dao.alterarContato(contato);

		response.sendRedirect("contato");
	}

	// Remover Contato
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idContato = request.getParameter("idContato");

		contato.setIdContato(idContato);

		dao.deletarContato(contato);

		response.sendRedirect("contato");
	}
	
	//Relatorio em PDF
	protected void gerarRelatorioContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf" );
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Contatos"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
			PdfPCell col4 = new PdfPCell(new Paragraph("IdDestino"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			ArrayList<Contatos> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getTelefone());
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
