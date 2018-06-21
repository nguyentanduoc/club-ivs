package com.vn.ivs.ctu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
public class PasswordEncoder {
	public static String BCryptPassdEncoder(String rawPassword) {
		return new  BCryptPasswordEncoder().encode(rawPassword);
	}
	/*public static void main(String[] args ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("123456");
		System.out.println(result);
		System.out.println(encoder.matches("myPassword", "$2a$10$ovGyFeg3Y99UsEc9t/Lpte1wbE9cRp6tH4aZTJBHhJiS/JeHfSOLC"));
	}*/
}
