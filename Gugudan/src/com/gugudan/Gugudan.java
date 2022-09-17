package com.gugudan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET");
		for (int i = 1; i <= 9; i++) {
			System.out.println(Integer.parseInt(request.getParameter("inputnum")) * i);
		}
	}
}
