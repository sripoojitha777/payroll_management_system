package com.prog.helper;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("User with this username exists!!");
	}
	public UserFoundException(String msg) {
		super(msg);
	}
	
	
}
