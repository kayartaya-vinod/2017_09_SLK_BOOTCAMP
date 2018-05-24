package com.slk.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.entity.Contact;
import com.slk.training.service.ContactsManager;

@WebServlet("/view-all")
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// 1. get request parameters (not required in this use case)
			
			// 2. use the model (business logic/data access logic) to get the model data
			ContactsManager mgr = new ContactsManager();
			List<Contact> list = mgr.getContacts("john"); 
			
			// 3. store the model in the request scope
			request.setAttribute("contacts", list);
			
			// 4. forward the control to the view (for presentation logic)
			String view = "/WEB-INF/views/contact-list.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
