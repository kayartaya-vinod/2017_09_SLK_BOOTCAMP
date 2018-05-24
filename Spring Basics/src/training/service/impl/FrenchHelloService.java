package training.service.impl;

import training.service.HelloService;

public class FrenchHelloService implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.printf("Bonjore, %s\n", name);
	}

}
