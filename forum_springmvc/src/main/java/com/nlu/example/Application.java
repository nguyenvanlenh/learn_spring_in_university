package com.nlu.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nlu.example.server.ServerConfig;

public class Application {
	public static void main(String[] args) {

	    System.setProperty("org.apache.catalina.startup.EXIT_ON_INIT_FAILURE", "true");
	    System.setProperty("PORT", "8080");
	    System.setProperty("temp-path", "tomcat-base-dir");
	    System.setProperty("additional-web-inf-path", "target/classes");

	    AnnotationConfigApplicationContext ctx;
	    try {

	      ctx = new AnnotationConfigApplicationContext();
	      ctx.register(ServerConfig.class);

	      ctx.refresh();
	      ctx.start();

	    } catch (Exception e) {
	    	System.err.println(e.getMessage());
	    }
	  }

}
