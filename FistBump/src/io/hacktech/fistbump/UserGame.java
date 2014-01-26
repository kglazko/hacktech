package io.hacktech.fistbump;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UserGame extends Activity {
	public String name;
	public String joke;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();  
        name = extras.getString("stringpass");
        
        TextView myTextView= (TextView) findViewById(R.id.mySharedString);
        myTextView.setText(name);
       
		setContentView(R.layout.game_play);
		//bindFinishedButton();
    }

}
