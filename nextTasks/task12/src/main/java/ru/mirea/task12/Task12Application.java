package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task12Application implements CommandLineRunner { // to get CLI arguments

	@SuppressWarnings({"unused", "FieldCanBeLocal"})
	@Autowired
	private FileHandler fileHandler;

	public static void main(String[] args) {
		SpringApplication.run(Task12Application.class, args);
	}

	@Override
	public void run(String... args) {

	}
}
