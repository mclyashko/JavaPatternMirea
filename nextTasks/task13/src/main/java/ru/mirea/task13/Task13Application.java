package ru.mirea.task13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Task13Application implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Task13Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student myClass = (Student) context.getBean("student");

		System.out.println(environment.getProperty("student.name") + " "
				+ environment.getProperty("student.last_name") + " " + environment.getProperty("student.group"));

		System.out.println(myClass);
	}
}
