package training.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

public class JdbcContactsDao implements ContactsDao {

	// This class depends on the following information
	// private variables are also known as FIELDS
	private String driver;
	private String url;
	private String username;
	private String password;

	// connection pool
	@Autowired(required = false)
	private DataSource dataSource;

	// default constructor (ALWAYS A GOOD PRACTICE)
	// Spring calls this by default
	public JdbcContactsDao() {
	}

	// We can ask spring to invoke this constructor to inject the dependencies
	public JdbcContactsDao(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public JdbcContactsDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// setters are also known as MUTATORS or WRITABLE PROPERTIES
	// WRITABLE PROPERTY "driver"
	// "driver" --> property
	// "setDriver" --> function / method
	public void setDriver(String driver) {
		System.out.println("Setting driver to " + driver);
		this.driver = driver;
	}

	// Writable property "url"
	public void setUrl(String url) {
		System.out.println("Setting url to " + url);
		this.url = url;
	}

	public void setUsername(String username) {
		System.out.println("Setting username to " + username);
		this.username = username;
	}

	public void setPassword(String password) {
		System.out.println("Setting password to " + password);
		this.password = password;
	}

	// writable property called "dataSource"
	// <property name="dataSource" ... />
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createContact(Contact contact) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public int contactsCount() throws DaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// obtain a connection
			conn = getConnection();
			String sql = "select count(*) from contacts";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
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
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
		return 0;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		if (dataSource != null) {
			System.out.println("Getting a connection from the pool...");
			return dataSource.getConnection();
		}

		System.out.println("Manufacturing a new connection...");
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

}
