package net.javaguidelines.spring_annotations;

import net.javaguidelines.spring_annotations.configProperties.AppPropertiesDemo;
import net.javaguidelines.spring_annotations.controllers.MyController;
import net.javaguidelines.spring_annotations.controllers.PizzaController;
import net.javaguidelines.spring_annotations.lazy.LazyLoader;
import net.javaguidelines.spring_annotations.repository.MyRepository;
import net.javaguidelines.spring_annotations.service.MyService;
import net.javaguidelines.spring_annotations.service.VegPizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringAnnotationsApplication.class, args);
//		PizzaController pizzaController= context.getBean(PizzaController.class);
//		System.out.println(pizzaController.getPizza());
MyController myController=context.getBean(MyController.class);
		System.out.println(myController.hello());

		MyService myService=context.getBean(MyService.class);
		System.out.println(myService.hello());

		MyRepository myRepository=context.getBean(MyRepository.class);
		System.out.println(myRepository.hello());

		LazyLoader lazyLoader=context.getBean(LazyLoader.class);
//		VegPizza vegPizza= context.getBean(VegPizza.class);
//		System.out.println(vegPizza.getPizza());

		AppPropertiesDemo appPropertiesDemo=context.getBean(AppPropertiesDemo.class);
		appPropertiesDemo.display();
	}

}
