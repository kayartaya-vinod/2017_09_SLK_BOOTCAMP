package com.slk.training.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.slk.training.entity.Contact;

public class ContactsManager {

	public void addContact(Contact c) throws ServiceException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getNewConnection();
			String sql = "insert into contacts(name, email, phone, gender, address, city, state, country, user_id) values(?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getPhone());
			stmt.setString(4, c.getGender());
			stmt.setString(5, c.getAddress());
			stmt.setString(6, c.getCity());
			stmt.setString(7, c.getState());
			stmt.setString(8, c.getCountry());
			stmt.setString(9, c.getUserId());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, null);
		}
	}

	public void updateContact(Contact c) throws ServiceException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getNewConnection();
			String sql = "update contacts set name=?, email=?, phone=?, gender=?, address=?, city=?, state=?, country=?, user_id=? where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getPhone());
			stmt.setString(4, c.getGender());
			stmt.setString(5, c.getAddress());
			stmt.setString(6, c.getCity());
			stmt.setString(7, c.getState());
			stmt.setString(8, c.getCountry());
			stmt.setString(9, c.getUserId());
			stmt.setInt(10, c.getId());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, null);
		}
	}

	public void deleteContact(int id) throws ServiceException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getNewConnection();
			String sql = "delete from contacts where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();

			if (count == 0) {
				throw new ServiceException("There is no record for id " + id);
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, null);
		}
	}

	public Contact getContactByEmail(String email) throws ServiceException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getNewConnection();
			String sql = "select * from contacts where email = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Contact contact = toContact(rs);
				return contact;
			}

			return null;
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, rs);
		}
	}

	public Contact getContactByPhone(String phone) throws ServiceException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getNewConnection();
			String sql = "select * from contacts where phone = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Contact contact = toContact(rs);
				return contact;
			}

			return null;
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, rs);
		}
	}

	public List<Contact> getAllMaleContacts() throws ServiceException {
		return getContacts("gender", "M");
	}

	public List<Contact> getAllFemaleContacts() throws ServiceException {
		return getContacts("gender", "F");
	}

	public List<Contact> getContactsByCity(String city) throws ServiceException {
		return getContacts("city", city);
	}

	public List<Contact> getContactsByState(String state) throws ServiceException {
		return getContacts("state", state);
	}

	public List<Contact> getContactsByCountry(String country) throws ServiceException {
		return getContacts("country", country);
	}

	private List<Contact> getContacts(String column, String value) throws ServiceException {
		List<Contact> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getNewConnection();
			String sql = "select * from contacts where " + column + " = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, value);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contact contact = toContact(rs);
				list.add(contact);
			}

			return list;
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, rs);
		}
	}

	public Contact getContact(int id) throws ServiceException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getNewConnection();
			String sql = "select * from contacts where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Contact contact = toContact(rs);
				return contact;
			}

			return null;
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, rs);
		}
	}

	public List<Contact> getContacts(String userId) throws ServiceException {
		userId = userId.trim();
		List<Contact> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getNewConnection();
			String sql = "select * from contacts where upper(user_id) = upper(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contact contact = toContact(rs);
				list.add(contact);
			}

			return list;
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			releaseDbResources(conn, stmt, rs);
		}
	}

	private Contact toContact(ResultSet rs) throws SQLException {
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

	private Connection getNewConnection() throws ServiceException {
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/slk", user = "sa", password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	private void releaseDbResources(Connection conn, Statement stmt, ResultSet rs) throws ServiceException {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}
