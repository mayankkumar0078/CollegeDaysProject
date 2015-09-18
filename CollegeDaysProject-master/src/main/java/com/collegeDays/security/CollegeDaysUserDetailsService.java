package com.collegeDays.security;
/**
 * @author Mayank
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.collegeDays.dao.UserRepository;
import com.collegeDays.entity.User;

import static com.collegeDays.util.CommonUtil.isEmpty;;

@Service
public class CollegeDaysUserDetailsService  implements UserDetailsService {

	 @Autowired
	 private UserRepository userRepository;

	 @Override
	 public User loadUserByUsername(String email) throws UsernameNotFoundException {
		 if (isEmpty(email)) {
		    return null;
		 }
		 System.out.println("userRepository.findByEmail(email) "+userRepository.findByEmail(email));
		 return userRepository.findByEmail(email);
	 }

}
