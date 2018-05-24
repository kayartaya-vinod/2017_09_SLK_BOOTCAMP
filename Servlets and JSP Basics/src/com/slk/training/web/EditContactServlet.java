package com.slk.training.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.entity.Contact;
import com.slk.training.service.ContactsManager;

@WebServlet("/edit-contact")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String strId = request.getParameter("id");
			int id = Integer.parseInt(strId);
			ContactsManager mgr = new ContactsManager();
			Contact ct = mgr.getContact(id);
			
			request.setAttribute("pageTitle", "Edit contact details");
			request.setAttribute("contact", ct);
			request.getRequestDispatcher("/WEB-INF/views/contact-form.jsp")
				.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
