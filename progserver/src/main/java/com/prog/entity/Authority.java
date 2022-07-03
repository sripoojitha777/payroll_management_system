package com.prog.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	
	private String authority;
	
	
	public Authority(String authority) {
		super();
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}


	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}
	
	
	
}
