package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//---> http://localhost:8080/mywebapp/hello
//---> http://localhost:8080/mywebapp/welcome

//@WebServlet(urlPatterns = { "/hello", "/welcome" }, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		System.out.println(">>>> from HelloServlet.init() function...");
		System.out.println("Servlet name is " + config.getServletName());
		System.out.printf("This servlet is created by %s (%s)\n", 
				config.getInitParameter("CREATED_BY"),
				config.getInitParameter("EMAIL"));
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println(">>>> from HelloServlet.destroy() function...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Someone called HelloServlet.doGet() method");

		// SET THE MIME TYPE
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.close();
	}

}
