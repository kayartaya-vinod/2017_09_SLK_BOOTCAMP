package training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.service.HelloService;

public class P01_SpringAsFactory {

	public static void main(String[] args) {

		// A variable representing the spring container (ApplicationContext)
		ClassPathXmlApplicationContext ctx;
		
		// an object representingthe spring container
		ctx = new ClassPathXmlApplicationContext("context1.xml");
		
		// obtain a bean from the container
		HelloService service = (HelloService) ctx.getBean("english");
		service.sayHello("Vinod");
		
		service = ctx.getBean("kannada", HelloService.class);
		service.sayHello("Vinod");
		
		ctx.close();
	}
}





