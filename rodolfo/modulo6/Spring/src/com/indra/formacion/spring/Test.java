package com.indra.formacion.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		/*********** Contextos ************/
		ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext.xml");

		/*********** Singleton ************/
		IHolaMundo holaMundo1 = context1.getBean("holaMundoSingleton", IHolaMundo.class);
		System.out.println("Antes de llamar holaMundo");
		holaMundo1.setNombre("Rodolfo");
		holaMundo1.holaMundo();
		
		IHolaMundo holaMundo2 = context1.getBean("holaMundoSingleton", IHolaMundo.class);
		holaMundo2.holaMundo();

		context2.getBean("holaMundoSingleton", IHolaMundo.class).holaMundo();
		
		/*********** Prototype ************/
		System.out.println("\n\n");
		holaMundo1 = context1.getBean("holaMundoPrototype", IHolaMundo.class);
		holaMundo1.setNombre("Rodolfo");
		holaMundo1.holaMundo();
		
		context1.getBean("holaMundoPrototype", IHolaMundo.class).holaMundo(); // Esta es una nueva instancia!
	}

}
