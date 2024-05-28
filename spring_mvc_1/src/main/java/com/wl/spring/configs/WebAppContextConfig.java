package com.wl.spring.configs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wl.spring.validators.LoginValidator;
import com.wl.spring.validators.WebAppValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.wl.spring.controllers", "com.wl.spring.repositories", "com.wl.spring.services",
		"com.wl.spring.models" })
public class WebAppContextConfig implements WebMvcConfigurer {

	// Cấu hình cho việc xử lý các yêu cầu DefaultServlet, ví dụ: yêu cầu đến các
	// tài nguyên tĩnh
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// Cấu hình message converter cho ứng dụng, ở đây sử dụng
	// MappingJackson2HttpMessageConverter để xử lý định dạng JSON
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converters.add(converter);
	}
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new NoCacheInterceptor());
	    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");

	}

	// Cấu hình view resolver để giúp Spring tìm kiếm các trang JSP
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setViewClass(JstlView.class);
		r.setPrefix("/WEB-INF/jsp/");
		r.setSuffix(".jsp");

		return r;
	}

	// property file

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("message");

		return resource;
	}

	// upload file
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(10 * 1024 * 1024); // 10MB

		return resolver;
	}

	// upload file to cloudinary
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(
				ObjectUtils.asMap(
						"cloud_name", "drygpquvb",
						"api_key", "159643128387577",
						"api_secret", "gWhaKF8-JV2Tm9weD0DH5F88kzg",
						"secure", true));
		return cloudinary;
	}
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());

		return validator;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

	@Bean
	public WebAppValidator loginValidator() {
		Set<Validator> springValidators = new HashSet<>();
		springValidators.add(new LoginValidator());

		WebAppValidator validator = new WebAppValidator();
		validator.setSpringValidators(springValidators);
		return validator;
	}

}
