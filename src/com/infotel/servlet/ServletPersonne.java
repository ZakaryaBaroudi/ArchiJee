package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImp;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private Iservice service = new ServiceImp(); // commiunication avec couche Service
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonne() {
        super();
        // TODO Auto-generated constructor stub
        
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// RECUPERATION DONNEES
		   int id = Integer.parseInt(request.getParameter("id"));
	        String nom = request.getParameter("lastname");
			String prenom = request.getParameter("firstname");
			int age = Integer.parseInt(request.getParameter("age"));
			
			
			//ENVOI COUCHE SERVICE
			
			Personne p = new Personne ();  // creation instance personne 
			p.setId(id);   // Personne p prend l'attribut "id"
			p.setNom(nom);  // Personne p prend l'attribut "nom"
			p.setPrenom (prenom);
			p.setAge(age);
			
			
		String message = service.creerPersonne(p); // creation en base de données 
		
		
			// preparation à l'envoi 
		
		request.setAttribute("message", message);
		//ENVOI a la JSP
			
	request.getRequestDispatcher("resultat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
