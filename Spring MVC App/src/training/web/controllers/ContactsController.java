package training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

@Controller
public class ContactsController {

	@Autowired
	private ContactsDao dao;

	public ContactsController() {
		System.out.println("ContactsController instantiated...");
	}

	@RequestMapping(value = "/contacts-count", method = RequestMethod.GET)
	public ModelAndView getContactsCount() throws DaoException {
		int cc = dao.contactsCount();
		ModelAndView mav = new ModelAndView();
		mav.addObject("cc", cc);
		mav.setViewName("/WEB-INF/views/count.jsp");
		return mav;
	}
	
	@RequestMapping("/view-all")
	public ModelAndView getAllContacts() throws DaoException{
		ModelAndView mav = new ModelAndView();
		mav.addObject("contacts", dao.getAll());
		mav.setViewName("/WEB-INF/views/contact-list.jsp");
		return mav;
	}
	
	@RequestMapping("/view-contact")
	public ModelAndView getContactForViewing(@RequestParam int id) throws DaoException{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("contact", dao.getContact(id));
		mav.addObject("pageTitle", "Contact Details");
		
		mav.setViewName("/WEB-INF/views/contact-details.jsp");
		return mav;
	}


	@RequestMapping("/add-contact")
	public ModelAndView contactForadding() throws DaoException{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("contact", new Contact());
		mav.addObject("pageTitle", "Add a new contact details");
		
		mav.setViewName("/WEB-INF/views/contact-form.jsp");
		return mav;
	}

	@RequestMapping("/edit-contact")
	public ModelAndView getContactForEditing(@RequestParam int id) throws DaoException{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("contact", dao.getContact(id));
		mav.addObject("pageTitle", "Edit Contact Details");
		
		mav.setViewName("/WEB-INF/views/contact-form.jsp");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/save-contact")
	public String saveContact(@ModelAttribute Contact contact) throws DaoException{
		if(contact.getId()==0){
			dao.createContact(contact);
			return "redirect:view-all.action";
		}
		else{
			dao.updateContact(contact);
			return "redirect:view-contact.action?id=" + contact.getId();
		}
		
	}

	@RequestMapping("/delete-contact")
	public String deleteContact(@RequestParam int id) throws DaoException{
		dao.deleteContact(id);
		return "redirect:view-all.action";
	}
	
	
}










