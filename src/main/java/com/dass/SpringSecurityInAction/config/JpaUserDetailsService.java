package com.dass.SpringSecurityInAction.config;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dass.SpringSecurityInAction.domain.User;
import com.dass.SpringSecurityInAction.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("User not found");

		User user = userRepository.findUserByUsername(username).orElseThrow(s);

		return new CustomUserDetails(user);
	}

}
