package com.slk.training.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.entity.Contact;
import com.slk.training.service.ContactsManager;

@WebServlet("/save-contact")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String userId = request.getParameter("user_id");
			int id = Integer.parseInt(request.getParameter("id"));

			Contact c = new Contact();
			c.setId(id);
			c.setName(name);
			c.setEmail(email);
			c.setPhone(phone);
			c.setGender(gender);
			c.setAddress(address);
			c.setCity(city);
			c.setState(state);
			c.setCountry(country);
			c.setUserId(userId);

			ContactsManager mgr = new ContactsManager();

			if (c.getId() == 0) {
				mgr.addContact(c);
				c = mgr.getContactByEmail(c.getEmail());
			} else {
				mgr.updateContact(c);
			}

			response.sendRedirect("./view-contact?id=" + c.getId());

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
