package training.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

// @Repository --> used for DAO classes (such as this one)
// @Service --> used for BusinessLogic classes
// @Controller --> used for Web appliction's controllers 
// @RestController --> introduced in Spring 4.0, used for REST controllers
@Component("dao")
public class SpringContactsDao implements ContactsDao {
	
	public SpringContactsDao() {
		System.out.println("SpringContactsDao instnatiated...");
	}

	@Autowired
	private JdbcTemplate template;

	@Override
	public void createContact(Contact contact) throws DaoException {
		try {
			String sql = "insert into contacts(name,gender,email,phone,"
					+ "address,city,state,country,user_id) values (?,?,?,?,?,?,?,?,?)";
			template.update(sql, contact.getName(), contact.getGender(), contact.getEmail(), 
					contact.getPhone(), contact.getAddress(), contact.getCity(), 
					contact.getState(), contact.getCountry(), contact.getUserId());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		try {
			String sql = "update contacts set name=?, gender=?, email=?, phone=?, "
					+ "address=?, city=?, state=?, country=?, user_id=? "
					+ "where id = ?";
			template.update(sql, contact.getName(), contact.getGender(), contact.getEmail(), 
					contact.getPhone(), contact.getAddress(), contact.getCity(), 
					contact.getState(), contact.getCountry(), contact.getUserId(), 
					contact.getId());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		try {
			return template.queryForObject("select * from contacts where id = ?", new ContactRowMapper(), id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		try {
			String sql = "delete from contacts where id = ?";
			int rc = template.update(sql, id);
			if (rc == 0) {
				throw new DaoException("Invalid id for deletion!");
			}
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public int contactsCount() throws DaoException {
		try {
			return template.queryForObject("select count(*) from contacts", Integer.class);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		try {
			return template.query("select * from contacts", new ContactRowMapper());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	class ContactRowMapper implements RowMapper<Contact> {
		@Override
		public Contact mapRow(ResultSet rs, int index) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setName(rs.getString("name"));
			contact.setEmail(rs.getString("email"));
			contact.setPhone(rs.getString("phone"));
			contact.setGender(rs.getString("gender"));
			contact.setAddress(rs.getString("address"));
			contact.setCity(rs.getString("city"));
			contact.setState(rs.getString("state"));
			contact.setCountry(rs.getString("country"));
			contact.setUserId(rs.getString("user_id"));
			return contact;
		}
	}
}
