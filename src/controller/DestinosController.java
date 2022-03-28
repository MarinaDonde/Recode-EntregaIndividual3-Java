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
import model.Destinos;



@WebServlet(urlPatterns = {"/DestinosController", "/destino", "/insertdtn", "/selectdtn", "/updatedtn", "/deletedtn", "/reportdtn"})
public class DestinosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Destinos destino = new Destinos();

	public DestinosController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/destino")) {
			destinos(request, response);
		} else if (action.equals("/insertdtn")) {
			novoDestino(request, response);
		} else if (action.equals("/selectdtn")) {
			listarDestino(request, response);
		} else if (action.equals("/updatedtn")) {
			editarDestino(request, response);
		} else if (action.equals("/deletedtn")) {
			removerDestino(request, response);
		} else if (action.equals("/reportdtn")) {
			gerarRelatorioDestino(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar destinos
	protected void destinos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Destinos> lista = dao.listarDestinos();

		request.setAttribute("listaDestinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("destinoIndex.jsp");
		rd.forward(request, response);
	}
	
	// Novo destino
	protected void novoDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		destino.setCidade(request.getParameter("cidade"));
		destino.setHotel(request.getParameter("hotel"));
		destino.setDias(request.getParameter("dias"));
		destino.setValor(request.getParameter("valor"));

		dao.inserirDestino(destino);

		response.sendRedirect("destino");
	}

	// Editar Destino
	protected void listarDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idDestino = request.getParameter("idDestino");

		destino.setIdDestino(idDestino);

		dao.selecionarDestino(destino);

		request.setAttribute("idDestino", destino.getIdDestino());
		request.setAttribute("cidade", destino.getCidade());
		request.setAttribute("hotel", destino.getHotel());
		request.setAttribute("dias", destino.getDias());
		request.setAttribute("valor", destino.getValor());

		RequestDispatcher rd = request.getRequestDispatcher("destinoEditar.jsp");
		rd.forward(request, response);
	}

	protected void editarDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setIdDestino(request.getParameter("idDestino"));
		destino.setCidade(request.getParameter("cidade"));
		destino.setHotel(request.getParameter("hotel"));
		destino.setDias(request.getParameter("dias"));
		destino.setValor(request.getParameter("valor"));

		dao.alterarDestino(destino);

		response.sendRedirect("destino");
	}

	// Remover Destino
	protected void removerDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idDestino = request.getParameter("idDestino");

		destino.setIdDestino(idDestino);

		dao.deletarDestino(destino);

		response.sendRedirect("destino");
	}
	
	//Relatorio em PDF
	protected void gerarRelatorioDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "destinos.pdf" );
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Destinos"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Cidade"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Hotel"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Dias"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Valor"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			ArrayList<Destinos> lista = dao.listarDestinos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getCidade());
				tabela.addCell(lista.get(i).getHotel());
				tabela.addCell(lista.get(i).getDias());
				tabela.addCell(lista.get(i).getValor());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	
	}
		
}
