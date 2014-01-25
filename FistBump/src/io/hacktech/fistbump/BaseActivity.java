package io.hacktech.fistbump;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import io.hacktech.fistbump.*;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class BaseActivity extends SherlockActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return (super.onCreateOptionsMenu(menu));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case android.R.id.home: {
				Intent intent = new Intent(getBaseContext(), MainActivity.class);
				startActivity(intent);
				return true;
			}
			case R.id.profile: {
				Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
				startActivity(intent);
				return true;
			}
			case R.id.find_users: {
				Intent intent = new Intent(getBaseContext(), LocationActivity.class);
				startActivity(intent);
				return true;	
			}
			case R.id.help: {
				String url = "http://www.google.com";
				Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(openUrlIntent);
			}
			default: return super.onOptionsItemSelected(item);
		}
	}
}
