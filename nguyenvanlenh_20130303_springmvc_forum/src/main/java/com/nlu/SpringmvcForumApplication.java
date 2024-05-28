package com.nlu;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcForumApplication.class, args);
		String url = "http://localhost:8080";
		String os = System.getProperty("os.name").toLowerCase();
		try {
			if (os.contains("win")) {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			} else if (os.contains("mac")) {
				Runtime.getRuntime().exec("open " + url);
			} else {
				Runtime.getRuntime().exec("xdg-open " + url);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
