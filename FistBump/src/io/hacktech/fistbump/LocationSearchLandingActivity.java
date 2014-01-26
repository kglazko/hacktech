package io.hacktech.fistbump;

import android.content.Intent;
import android.os.Bundle;

public class LocationSearchLandingActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		
		Intent intent = new Intent(getBaseContext(), SearchResultsActivity.class);
		startActivity(intent);
	}
}
