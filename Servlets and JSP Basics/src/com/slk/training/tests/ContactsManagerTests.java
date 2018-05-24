package com.slk.training.tests;

import java.util.List;

import com.slk.training.entity.Contact;
import com.slk.training.service.ContactsManager;
import com.slk.training.service.ServiceException;

public class ContactsManagerTests {
	
	static ContactsManager mgr;

	public static void main(String[] args) {
		mgr = new ContactsManager();
		
		// testGetContactById(515);
		// testGetContactsForUser("admin    ");
		// testGetMaleContacts();
		// testGetFemaleContacts();
		testGetContactsByState("Texas");
	}

	static void testGetContactsByState(String state) {
		try {
			List<Contact> list = mgr.getContactsByState(state);
			for(Contact c:list){
				System.out.println(c.getName() + " --> " + c.getState());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testGetFemaleContacts() {
		try {
			List<Contact> list = mgr.getAllFemaleContacts();
			for(Contact c:list){
				System.out.println(c.getName() + " --> " + c.getGender());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void testGetMaleContacts() {
		try {
			List<Contact> list = mgr.getAllMaleContacts();
			for(Contact c:list){
				System.out.println(c.getName() + " --> " + c.getGender());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testGetContactsForUser(String userId) {
		try {
			List<Contact> list = mgr.getContacts(userId);
			System.out.printf("There are %d contacts for '%s'\n", list.size(), userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testGetContactById(int id) {
		Contact c;
		try {
			c = mgr.getContact(id);
			System.out.println(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}
