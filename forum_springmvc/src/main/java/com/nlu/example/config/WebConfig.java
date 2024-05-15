package com.nlu.example.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { 
//		"com.nlu.example.model",
//		"com.nlu.example.service",
		"com.nlu.example.controller"})
public class WebConfig implements WebMvcConfigurer {

	// Cấu hình cho việc xử lý các yêu cầu DefaultServlet, ví dụ: yêu cầu đến các
	// tài nguyên tĩnh
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

		@Bean
		public InternalResourceViewResolver internalResourceViewResolver() {
			InternalResourceViewResolver r = new InternalResourceViewResolver();
			r.setViewClass(JstlView.class);
			r.setPrefix("/WEB-INF/jsp/");
			r.setSuffix(".jsp");

			return r;
		}
		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
			converters.add(converter);
		}
}
