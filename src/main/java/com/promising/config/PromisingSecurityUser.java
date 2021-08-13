package com.promising.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.promising.vo.MemberRoleVO;
import com.promising.vo.MemberVO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class PromisingSecurityUser extends User{
	 private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	private static final String ROLE_PREFIX = "ROLE_";
	
	 private MemberVO vo;

	public PromisingSecurityUser (String username,String password, Collection<? extends GrantedAuthority> authorities) {
		super(username,password,authorities);
	
	}
	public PromisingSecurityUser(MemberVO member) {
		super(member.getUsername(), member.getPassword(), makeGrantedAuthority(member.getRoles()));	
		
	}
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRoleVO> roles) {
		
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(
				role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX+role.getRoleName()))
				);
		return list;
	}
	
}
