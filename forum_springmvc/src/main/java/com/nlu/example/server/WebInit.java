package com.nlu.example.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nlu.example.config.AppConfig;
import com.nlu.example.config.WebConfig;

public class WebInit implements WebApplicationInitializer {

	 @Override
	  public void onStartup(ServletContext container) {

	    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	    rootContext.register(AppConfig.class);
	    ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
	    container.addListener(contextLoaderListener);

	    AnnotationConfigWebApplicationContext servletContext =
	        new AnnotationConfigWebApplicationContext();
	    servletContext.register(WebConfig.class);
	    ServletRegistration.Dynamic dispatcher =
	        container.addServlet("dispatcher", new DispatcherServlet(servletContext));
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("/");
	  }
}
