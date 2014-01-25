package io.hacktech.fistbump.usersetup;

import com.actionbarsherlock.app.SherlockActivity;

import io.hacktech.fistbump.MainActivity;
import io.hacktech.fistbump.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends SherlockActivity {
    public static final String APP_SHARED_PREFS = "app_preferences";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		bindLoginButton();
	}
	
	private void bindLoginButton() {
		// Submit login form here
	    SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
	    sharedPrefs.edit().putBoolean("loggedIn", true).commit();

		Button button = (Button)findViewById(R.id.login_btn);
		button.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), MainActivity.class);
				startActivity(intent);
		    }
		});
	}
}
