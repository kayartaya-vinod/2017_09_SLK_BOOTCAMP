package training.service.impl;

import training.service.HelloService;

public class EnglishHelloService implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.printf("Hello, %s\n", name);
	}

}
