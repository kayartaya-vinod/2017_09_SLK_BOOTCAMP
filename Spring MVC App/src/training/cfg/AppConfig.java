package training.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "training.dao.impl"})
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig3 instantiated...");
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("org.h2.Driver");
		dmds.setUrl("jdbc:h2:tcp://localhost/~/slk");
		dmds.setUsername("sa");
		dmds.setPassword("");
		return dmds;
	}

	@Bean(autowire = Autowire.BY_NAME)
	public JdbcTemplate template() {
		return new JdbcTemplate();
	}

}
