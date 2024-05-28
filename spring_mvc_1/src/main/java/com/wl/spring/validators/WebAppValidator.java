package com.wl.spring.validators;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wl.spring.models.request.LoginRequest;


/* Spring validator + Bean Validator
 * 1 . using spring validator
 * 2. create @Bean at class WebAppConfig
 * 3. composition Bean validator
 * 4. using err.reject of spring validator to notice err for bean Validator
 * 
 * */

@Component
public class WebAppValidator implements Validator {

	//1
	private Set<Validator> springValidators = new HashSet<>();
	
	//3
	@Autowired
	private javax.validation.Validator beanValidator;
	
	//1
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return LoginRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//3
		Set<ConstraintViolation<Object>> beans= this.beanValidator.validate(target);
		for(ConstraintViolation<Object> obj : beans)
			errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
		
		//1
		for(Validator v : springValidators)
			v.validate(target, errors);
		
	}

}
