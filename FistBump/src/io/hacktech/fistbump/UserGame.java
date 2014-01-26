package io.hacktech.fistbump;

import android.app.Activity;
import android.os.Bundle;

public class UserGame extends Activity {
	public String name;
	public String joke;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();  
        name = extras.getString("stringpass");
       
		//setContentView(R.layout.activity_profile);
		//bindFinishedButton();
    }

}
