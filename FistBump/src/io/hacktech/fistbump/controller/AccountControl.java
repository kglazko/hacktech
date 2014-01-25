package src.io.hacktech.fistbump.controller;

import src.io.hacktech.fistbump.GlobalConstants;

import com.firebase.client.Firebase;
import com.firebase.simplelogin.SimpleLogin;
import com.firebase.simplelogin.SimpleLoginAuthenticatedHandler;
import com.firebase.simplelogin.User;

public class AccountControl {

	public static void checkLogin(Firebase ref,
			SimpleLoginAuthenticatedHandler handler, String email, String pwd) {
		SimpleLogin auth = new SimpleLogin(ref);
		auth.checkAuthStatus(handler);
	}

	public static void login(String email, String pwd) {
		GlobalConstants.SIMPLELOGIN.loginWithEmail(email, pwd,
				new SimpleLoginAuthenticatedHandler() {
					@Override
					public void authenticated(
							com.firebase.simplelogin.enums.Error error,
							User user) {
						if (error != null) {
							// There was an error logging into this account
						} else {
							// We are good
						}
					}
				});
	}

	public static void register(String email, String pwd) {
		GlobalConstants.SIMPLELOGIN.createUser(email, pwd,
				new SimpleLoginAuthenticatedHandler() {
					public void authenticated(
							com.firebase.simplelogin.enums.Error error,
							User user) {
						if (error != null) {
							// There was an error creating this account
						} else {
							// We are now logged in
						}
					}
				});
	}
}
