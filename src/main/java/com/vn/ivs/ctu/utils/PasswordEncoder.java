package com.vn.ivs.ctu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
public class PasswordEncoder {
	
	public static String BCryptPassdEncoder(String rawPassword) {
		return new  BCryptPasswordEncoder().encode(rawPassword);
	}
	public static String defaultPassWord() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode("abc123");
	}
	public static boolean matches(String pass1, String pass2) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if (passwordEncoder.matches(pass1, pass2)) {
		    return true;
		} else {
		    return false;
		}
	}
	public static void main(String[] args ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("123");
		System.out.println(result);
	}
}
