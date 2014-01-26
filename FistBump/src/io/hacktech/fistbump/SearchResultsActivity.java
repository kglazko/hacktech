package io.hacktech.fistbump;

import io.hacktech.fistbump.fragments.MapFragment;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

public class SearchResultsActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);
        displayCurrentLocation();
    }
    
    private void displayCurrentLocation() {
        LocationManager locationManager = 
        		(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);
		
		MapFragment map = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map_fragment);
		if (location != null) {
			map.zoomToCoordinates(location.getLatitude(), location.getLongitude());
		}
    }
}
