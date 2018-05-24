package training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig3;
import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

public class P04_TestSpringContactsDao {

	public static void main(String[] args) throws DaoException {

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig3.class);

		ContactsDao dao = ctx.getBean("dao", ContactsDao.class);
		Contact c1 = dao.getContact(12);
		System.out.println(c1);

		List<Contact> list = dao.getAll();
		System.out.printf("There are %d contacts\n", list.size());

		int cc = dao.contactsCount();
		System.out.printf("There are %d contacts\n", cc);

		ctx.close();

	}
}
