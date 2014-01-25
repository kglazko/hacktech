package io.hacktech.fistbump;

import com.firebase.simplelogin.SimpleLoginAuthenticatedHandler;
import com.firebase.simplelogin.User;

import io.hacktech.fistbump.controller.AccountControl;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GlobalConstants.initialize();

		this.initializeButtons();

	}

	private void initializeButtons() {
		// login
		final Button button = (Button) findViewById(R.id.login_btn);
		button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				AccountControl.login(
						((EditText) findViewById(R.id.login_email)).getText()
								.toString(),
						((EditText) findViewById(R.id.login_pwd)).getText()
								.toString(),
						new SimpleLoginAuthenticatedHandler() {
							@Override
							public void authenticated(
									com.firebase.simplelogin.enums.Error error,
									User user) {
								if (error != null) {
									// There was an error logging into this
									// account
								} else {
									// We are good switch to different view
								}
							}
						});
			}
		});
		// register
		final Button button2 = (Button) findViewById(R.id.register_btn);
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				AccountControl.register(
						((EditText) findViewById(R.id.login_email)).getText()
								.toString(),
						((EditText) findViewById(R.id.login_pwd)).getText()
								.toString(),
						new SimpleLoginAuthenticatedHandler() {
							public void authenticated(
									com.firebase.simplelogin.enums.Error error,
									User user) {
								if (error != null) {
									// There was an error creating this account
								} else {
									// We are now registered, login time!
								}
							}
						});
			}
		});
	}
}
