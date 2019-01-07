package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> OpUser = userRepository.findById(username); // 2.0 Ver 이후 findOne -> findById대체
		User user = OpUser.get(); //Optional 객체에서 User객체를 가져온다.
		if(user == null) {
			throw new UsernameNotFoundException("The requested user is not found");
		}
		return new LoginUserDetails(user);
	}
}
