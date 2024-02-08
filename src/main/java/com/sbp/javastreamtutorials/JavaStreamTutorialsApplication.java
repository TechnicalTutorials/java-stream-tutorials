package com.sbp.javastreamtutorials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaStreamTutorialsApplication {
	private static final Logger Log = LoggerFactory.getLogger(JavaStreamTutorialsApplication.class);

	public static void main(String[] args) {

		Log.info("Java stream tutorials");

		SpringApplication.run(JavaStreamTutorialsApplication.class, args);
	}

}
