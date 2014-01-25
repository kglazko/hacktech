package io.hacktech.fistbump;

import com.firebase.simplelogin.SimpleLoginAuthenticatedHandler;
import com.firebase.simplelogin.User;

import io.hacktech.fistbump.controller.AccountControl;
import android.app.AlertDialog;
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
		final MainActivity me = this;
		final Button login_btn = (Button) findViewById(R.id.login_btn);
		final Button register_btn = (Button) findViewById(R.id.register_btn);
		// login
		login_btn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				login_btn.setEnabled(false);
				register_btn.setEnabled(false);
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
									String error_msg;
									switch (error) {
									case InvalidEmail:
										error_msg = "Invalid email address";
										break;
									case InvalidPassword:
										error_msg = "Entered password was incorrect";
										break;
									case PermissionDenied:
										error_msg = "App does not have internet privileges.";
										break;
									default:
										error_msg = "Connection error";
										break;
									}
									AlertDialog dialog = new AlertDialog.Builder(
											me).setMessage(error_msg)
											.setTitle("Failure!")
											.setPositiveButton("Ok", null)
											.create();
									dialog.show();
									login_btn.setEnabled(true);
									register_btn.setEnabled(true);
								} else {
									// We are good switch to different view
								}
							}
						});
			}
		});
		// register
		register_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				login_btn.setEnabled(false);
				register_btn.setEnabled(false);
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
									String error_msg;
									switch (error) {
									case EmailTaken:
										error_msg = "Email already taken";
										break;
									case PermissionDenied:
										error_msg = "App does not have internet privileges.";
										break;
									default:
										error_msg = "Connection error";
										break;
									}
									AlertDialog dialog = new AlertDialog.Builder(
											me).setMessage(error_msg)
											.setTitle("Failure!")
											.setPositiveButton("Ok", null)
											.create();
									dialog.show();
									login_btn.setEnabled(true);
									register_btn.setEnabled(true);
								} else {
									// login and gogogo
								}
							}
						});
			}
		});
	}
}
