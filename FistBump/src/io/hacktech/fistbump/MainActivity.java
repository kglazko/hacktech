package io.hacktech.fistbump;

import io.hacktech.fistbump.usersetup.NotLoggedInLandingActivity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;


public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	    SharedPreferences sharedPrefs = getApplicationContext().getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
	    boolean loggedIn = sharedPrefs.getBoolean("loggedIn", false);
	    if (!loggedIn) {
	        Intent intent = new Intent(getBaseContext(), NotLoggedInLandingActivity.class);
			startActivity(intent);
	    } else {
			setContentView(R.layout.activity_main);
			bindFindUsersButton();
			bindFistBumpButton();
	    }
	}

	private void bindFindUsersButton() {
		Button buttonOne = (Button)findViewById(R.id.find_users_btn);
		buttonOne.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), LocationActivity.class);
				startActivity(intent);
		    }
		});
	}

	private void bindFistBumpButton() {
		Button button = (Button)findViewById(R.id.bump_user_btn);
		button.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), NFCCommunication.class);
				startActivity(intent);
		    }
		});
	}
}
