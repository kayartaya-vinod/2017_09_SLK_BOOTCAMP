package training.dao;

import java.util.List;

import training.entity.Contact;

public interface ContactsDao {
	
	// CRUD operations
	
	public void createContact(Contact contact) throws DaoException;
	
	public Contact getContact(int id) throws DaoException;
	
	public void updateContact(Contact contact) throws DaoException;
	
	public void deleteContact(int id) throws DaoException;
	
	// Queries
	
	public int contactsCount() throws DaoException;
	
	public List<Contact> getAll() throws DaoException;
	
}
