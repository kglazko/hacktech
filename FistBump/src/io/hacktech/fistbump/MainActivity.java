package io.hacktech.fistbump;

import io.hacktech.fistbump.controller.Geo;
import io.hacktech.fistbump.usersetup.NotLoggedInLandingActivity;
import android.content.Context;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;


public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GlobalConstants.initialize();//initialize constants
		Geo.startGPS(this, new LocationListener(){

			@Override
			public void onLocationChanged(Location arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
		});

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
