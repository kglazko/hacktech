package io.hacktech.fistbump;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

import io.hacktech.fistbump.fragments.MapFragment;
import android.location.Location;
import android.os.Bundle;

public class SearchResultsActivity extends BaseActivity 
		implements LocationListener, ConnectionCallbacks, 
		OnConnectionFailedListener {
	LocationClient client;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);
        
		client = new LocationClient(this, this, this);
    }

    @Override
    protected void onStop() {
        // If the client is connected
        if (client.isConnected()) {
            client.removeLocationUpdates(this);
        }
        client.disconnect();
        super.onStop();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	client.connect();
    }
    
    @Override
    protected void onPause() {
    	client.disconnect();
    	super.onPause();
    }
    
    private void zoomLocation(Location loc) {
		MapFragment map = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map_fragment);
		map.zoomToLocation(loc);
    }
    
    private void panToLocation(Location loc) {
		MapFragment map = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map_fragment);
		map.panToLocation(loc);
    }

	@Override
	public void onLocationChanged(Location loc) {
		panToLocation(loc);
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onConnected(Bundle arg0) {
		Location location = client.getLastLocation();
		zoomLocation(location);
		
        LocationRequest request = LocationRequest.create();
		client.requestLocationUpdates(request, this);
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
	}
}
