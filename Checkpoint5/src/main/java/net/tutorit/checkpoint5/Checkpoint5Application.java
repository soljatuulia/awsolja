package net.tutorit.checkpoint5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Checkpoint5Application {
        @Autowired
        Populate pop;
    
	public static void main(String[] args) {
		SpringApplication.run(Checkpoint5Application.class, args);
	}

}
