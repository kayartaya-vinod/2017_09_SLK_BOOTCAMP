package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-contacts")
public class GetContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String output = "";
		
		// step 1: read inputs from request
		String userId = request.getParameter("user_id");
		if(userId==null){
			output = "<h3 style='color:red'>User id is required, but missing!</h3>";
		}
		else {
			// step 2: process the input to generate output (html table)
			try {
				String sql = "select * from contacts where user_id = ?";
				Class.forName("org.h2.Driver");
				String url = "jdbc:h2:tcp://localhost/~/slk", user="sa", password = "";
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, userId);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					output += "<table class='table table-striped table-bordered'>";
					do {
						output += "<tr><td>" + rs.getString("name") + "</td><td>" 
								+ rs.getString("phone") + "</td></tr>";
					}while(rs.next());
					output += "</table>";
				}
				else {
					output += "<h3 style='color:red'>No contacts for you :-(</h3>";
				}
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		// step 3: write the output
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/ex02.html");
		
		rd.include(request, response);
		out.write(output);
		
		
		out.close();
	}

}
