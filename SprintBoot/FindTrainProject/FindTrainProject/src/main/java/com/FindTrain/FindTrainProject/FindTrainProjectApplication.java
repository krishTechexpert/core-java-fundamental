package com.FindTrain.FindTrainProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FindTrainProjectApplication {

	public static void main(String[] args) {

		//SpringApplication.run(FindTrainProjectApplication.class, args);
		ApplicationContext context = SpringApplication.run(FindTrainProjectApplication.class, args);

		// to hide banner
//		SpringApplication app = new SpringApplication(FindTrainProjectApplication.class);
//		app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
//		app.run(args);

		// Get the BeanChecker Bean from the IoC container
		BeanChecker beanChecker = context.getBean(BeanChecker.class);

		// Call the showBeans() method
		beanChecker.showBeans();

	}

}
