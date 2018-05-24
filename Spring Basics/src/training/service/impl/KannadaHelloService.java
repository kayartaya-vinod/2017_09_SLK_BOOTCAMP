package training.service.impl;

import training.service.HelloService;

public class KannadaHelloService implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.printf("ಹಲೋ, %s\n", name);
	}

}
