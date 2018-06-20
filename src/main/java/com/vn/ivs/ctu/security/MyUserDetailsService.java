package com.vn.ivs.ctu.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.MemberDAOImpl;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.utils.MyUserDetail;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	MemberDAOImpl memberDAOImpl;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
		Member member;

		try{
			member  = memberDAOImpl.findByUseName(username);			
			if(member==null) {
				log.error("Username not found");
				throw new UsernameNotFoundException("Username not found");
			}
		}catch(Exception  e) {
			log.error("Username not found");
			throw new UsernameNotFoundException("Username not found");
		}		
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : member.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCodeRole()));
		}
		MyUserDetail myUserDetail = new MyUserDetail(username, member.getPassWordMember(), true, true, true, true, authorities);
		BeanUtils.copyProperties(member, myUserDetail);
		return myUserDetail;
	}
	
}
