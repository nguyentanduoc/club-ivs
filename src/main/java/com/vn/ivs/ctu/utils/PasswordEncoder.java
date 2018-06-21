package com.vn.ivs.ctu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
public class PasswordEncoder {
	public static String BCryptPassdEncoder(String rawPassword) {
		return new  BCryptPasswordEncoder().encode(rawPassword);
	}
	public static void main(String[] args ) {
		System.out.println(BCryptPassdEncoder("admin@123"));
	}
}
