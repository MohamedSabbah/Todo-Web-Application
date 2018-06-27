package com.sabbah.login;

public class LoginService {
	public Boolean userValid(String name, String Password) {
		if(name.equals("ali")&& Password.equals("1234"))
			return true;
		return false;
		
	}

}
