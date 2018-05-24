package training.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.dao.ContactsDao;
import training.dao.impl.JdbcContactsDao;

// This class defines beans (like the context.xml files, 
// so this class acts as a replacement of XML configuration)
@Configuration // --> equivalent to <beans></beans>
public class AppConfig1 {

	// The return object is the bean maintained by the spring container
	@Bean(name = "dao") // --> equivalent to <bean id="dao" class=".."></bean>
	public ContactsDao dao() {
		JdbcContactsDao jdao = new JdbcContactsDao();
		// setter injection be like:
		jdao.setUrl("jdbc:h2:tcp://localhost/~/slk");
		jdao.setUsername("sa");
		jdao.setPassword("");
		jdao.setDriver("org.h2.Driver");
		
		return jdao;
	}
}
