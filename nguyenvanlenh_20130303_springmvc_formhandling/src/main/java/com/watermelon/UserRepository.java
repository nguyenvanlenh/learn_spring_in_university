package com.watermelon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByGender(String gender);
	boolean existsByEmail(String email);

}
