package training.programs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import training.cfg.AppConfig3;
import training.entity.Contact;

public class P03_TestingJdbcTemplate {

	static JdbcTemplate template;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);

		template = ctx.getBean(JdbcTemplate.class);

		// getContactsCount(template);
		// getNameById(12);
		// getFullDetails(12);
		// getRecordsByState("Texas");
		// getContactById(12);
		getContactsByState("Texas");
		

		ctx.close();

	}

	static void getContactsByState(String state) {
		String sql = "select * from contacts where state = ?";
		ContactRowMapper crm = new ContactRowMapper();
		List<Contact> list = template.query(sql, crm, state);
		for(Contact c: list){
			System.out.println(c.getName() + " --> " + c.getCity());
		}
	}

	static void getContactById(int id) {
		String sql = "select * from contacts where id = ?";
		ContactRowMapper crm = new ContactRowMapper();
		Contact c1 = template.queryForObject(sql, crm, id);
		System.out.println(c1);
	}

	static void getRecordsByState(String state) {
		String sql = "select * from contacts where state = ?";
		// use queryForList when the sql returns multiple rows, with multiple
		// columns
		List<Map<String, Object>> list = template.queryForList(sql, state);
		for (Map<String, Object> c : list) {
			System.out.println(c.get("name") + " --> " + c.get("city"));
		}
	}

	static void getFullDetails(int id) {
		String sql = "select * from contacts where id = ?";
		// use queryForMap when the sql returns 1 row, multiple columns
		Map<String, Object> details = template.queryForMap(sql, id);
		System.out.println("Name = " + details.get("name"));
		System.out.println("Email = " + details.get("email"));
		System.out.println("Phone = " + details.get("phone"));
		System.out.println("City = " + details.get("city"));
		System.out.println("Country = " + details.get("COUNTRY"));
	}

	static void getNameById(int id) {
		String sql = "select name from contacts where id = ?";
		// use queryForObject when the SQL returns 1 row 1 column
		String name = template.queryForObject(sql, String.class, id);
		System.out.println("Name = " + name);
	}

	static void getContactsCount() {
		int cc = template.queryForObject("select count(*) from contacts", Integer.class);
		System.out.printf("There are %d contacts\n", cc);
	}

	static class ContactRowMapper implements RowMapper<Contact> {

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
