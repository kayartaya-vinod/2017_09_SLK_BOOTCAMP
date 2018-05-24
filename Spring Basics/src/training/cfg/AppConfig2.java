package training.cfg;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import training.dao.ContactsDao;
import training.dao.impl.JdbcContactsDao;

@Configuration
public class AppConfig2 {

	@Bean(name = { "dataSourcexx" })
	public DataSource ds() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("org.h2.Driver");
		dmds.setUrl("jdbc:h2:tcp://localhost/~/slk");
		dmds.setUsername("sa");
		dmds.setPassword("");
		return dmds;
	}

	@Bean(name = "dao")
	public ContactsDao dao() {
		JdbcContactsDao jdao = new JdbcContactsDao();
		return jdao;
	}
}







