package com.wl.spring.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wl.spring.models.ERole;
import com.wl.spring.models.Role;
import com.wl.spring.models.User;
import com.wl.spring.repositories.UserRepository;
import com.wl.spring.services.UserService;

@Service("userDetailsService")
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userRepository.getUsers(username);
		if (users.isEmpty())
			throw new UsernameNotFoundException("Username không tồn tại!");
		User u = users.get(0);
		Set<GrantedAuthority> authorities = u.getListRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getRoleName().name()))
				.collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);
	}

	@Override
	public boolean add(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role role = new Role();
		role.setRoleName(ERole.ROLE_USER);
		user.getListRoles().add(role);
		user.setActive(true);
		return this.userRepository.add(user);
	}

	@Override
	public List<User> getUsers(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.getUsers(username);
	}

}
