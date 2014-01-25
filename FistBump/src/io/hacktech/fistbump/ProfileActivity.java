package io.hacktech.fistbump;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class ProfileActivity extends BaseActivity {
    public static final String PREFS_NAME = "SavedProfile";
	String[] fields = { "full_name", "phone_number", "favorite_color", "favorite_joke" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		restoreProfile();
    }
        
    @Override
    protected void onStop() {
    	super.onStop();
    	
    	saveProfile();
    }
    
    private void saveProfile() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        
        for (int i = 0; i < fields.length; ++i) {
        	String field = fields[i];
			try {
				int editTextNum = i + 1;
				int id = R.id.class.getField("editText" + editTextNum).getInt(0);
	        	EditText editText = (EditText)findViewById(id);
	            editor.putString(field, editText.getText().toString());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        editor.commit();
    }
    
    private void restoreProfile() {
		SharedPreferences savedProfile = getSharedPreferences(PREFS_NAME, 0);

		for (int i = 0; i < fields.length; ++i) {
			String field = fields[i];
			try {
				String savedVal = savedProfile.getString(field, "");
				int editTextNum = i + 1;
				int id = R.id.class.getField("editText" + editTextNum).getInt(0);
				EditText editText = (EditText)findViewById(id);
				editText.setText(savedVal);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
