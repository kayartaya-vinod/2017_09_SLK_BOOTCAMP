package com.slk.training.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.service.ContactsManager;

@WebServlet("/delete-contact")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String strId = request.getParameter("id");
			int id = Integer.parseInt(strId);
			ContactsManager mgr = new ContactsManager();
			mgr.deleteContact(id);
			response.sendRedirect("./view-all");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
