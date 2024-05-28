package com.watermelon;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationInit {

	@Bean
	@ConditionalOnProperty(prefix = "spring", value = "datasource.driverClassName", havingValue = "org.h2.Driver")
	ApplicationRunner applicationRunner(UserRepository userRepository) {
		return args -> {
			if (userRepository.findById(1L).isEmpty()) {
				var user = new User();
				user.setId(1L);
				user.setAddress("Ho Chi Minh City");
				user.setBirthday(new Date(2002 - 1900, 1, 12));
				user.setCity("Hồ Chí Minh");
				user.setCounty("quan1");
				user.setEmail("20130303@st.hcmuaf.edu.vn");
				user.setGender("Nam");
				user.setName("Nguyễn Văn Lênh");
				user.setPassword("12345678");
				user.setPhone("0987654321");
				user.setProfession("Đại học");
				user.setWard("phuongBenNghe");

				userRepository.save(user);
			}
		};
	}
}
