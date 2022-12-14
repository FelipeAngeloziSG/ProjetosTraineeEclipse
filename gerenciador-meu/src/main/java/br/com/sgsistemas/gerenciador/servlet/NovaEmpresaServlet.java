package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/nova-empresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando empresa");
		
		PrintWriter out = response.getWriter();
		Empresa empresa = new Empresa();
		
		empresa.setNome(request.getParameter("razaosocial"));
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		requestDispatcher.forward(request, response);
	}

}
