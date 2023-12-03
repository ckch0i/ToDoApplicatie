package com.test.todo.ToDoApplicatie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ToDoApplicatieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplicatieApplication.class, args);
	}

}
