package io.hacktech.fistbump.usersetup;

import io.hacktech.fistbump.ProfileActivity;
import io.hacktech.fistbump.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class RegistrationActivity extends SherlockActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		bindNextButton();
	}
	
	private void bindNextButton() {
		// Submit registration form here
		
		Button button = (Button)findViewById(R.id.next_btn);
		button.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
				startActivity(intent);
		    }
		});
	}
}
