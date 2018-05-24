package training.service.impl;

import training.service.HelloService;

public class SpanishHelloService implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.printf("Hola, %s\n", name);
	}

}
