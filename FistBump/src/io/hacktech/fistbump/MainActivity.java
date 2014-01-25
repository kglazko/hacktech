package io.hacktech.fistbump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bindLoginButton();
		bindFindUsersButton();
	}
	
	private void bindLoginButton() {
		Button button = (Button)findViewById(R.id.login_btn);
		button.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), LoginActivity.class);
				startActivity(intent);
		    }
		});
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
}
