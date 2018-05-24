package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print-table")
public class PrintTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// CONTROLLER'S TASK
		// 1. read the inputs from the request
		String strNum = request.getParameter("num");

		// MODEL'S TASK
		// 2. process the input to generate an output (resultant html)
		String out = "";
		
		try {
			int num = Integer.parseInt(strNum);
			out += "<h3>Multiplication table for " + num + " is: </h3>";
			for(int i=1; i<=10; i++){
				out += num + " X " + i + " = " + (num*i) + " <br />";
			}
		} catch (NumberFormatException | NullPointerException e) {
			out += "<h3 style='color:red'>Invalid/Missing input!</h3>";
		}

		// VIEW'S TASK
		// 3. write the output to the response
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/ex01.html");
		
		rd.include(request, response);
		writer.write(out);
		
		
		writer.close();
	}

}
