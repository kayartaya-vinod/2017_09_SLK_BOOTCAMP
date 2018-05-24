package training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig2;
import training.dao.ContactsDao;
import training.dao.DaoException;

public class P02_GetContactsCount {
	public static void main(String[] args) throws DaoException {
		// ClassPathXmlApplicationContext ctx;
		// ctx = new ClassPathXmlApplicationContext("context3.xml");

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig2.class);

		ContactsDao dao = ctx.getBean(ContactsDao.class);
		System.out.println("Got an instanceof " + dao.getClass());

		int cc = dao.contactsCount();
		System.out.printf("There are %d contacts\n", cc);

		ctx.close();
	}
}
