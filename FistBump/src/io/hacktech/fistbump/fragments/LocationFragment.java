package io.hacktech.fistbump.fragments;

import io.hacktech.fistbump.R;
import io.hacktech.fistbump.SearchResultsActivity;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;

public class LocationFragment extends SherlockFragment 
		implements GooglePlayServicesClient.ConnectionCallbacks, 
		GooglePlayServicesClient.OnConnectionFailedListener, Runnable {
	private static final int REQUEST_ID = 1337;
	private LocationClient client = null;
	private Handler handler = new Handler();
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		client = new LocationClient(getActivity(), this, this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		client.connect();
	}

	@Override
	public void onPause() {
		handler.removeCallbacks(this);
		client.disconnect();
		super.onPause();
	}

	@Override
	public void run() {
		Location loc = client.getLastLocation();
		if (loc == null) {
			handler.postDelayed(this, 1000);
		} else {
			Log.i("location", loc.getLatitude() + ", " + loc.getLongitude());
		}
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		boolean anyLuck = false;

		if (result.hasResolution()) {
			try {
				result.startResolutionForResult(getActivity(), REQUEST_ID);
				anyLuck = true;
			} catch (IntentSender.SendIntentException e) {
				Log.e(getClass().getSimpleName(),
						"Exception trying to startResolutionForResult()", e);
			}
		}

		if (!anyLuck) {
			Toast.makeText(getActivity(), R.string.no_fused, Toast.LENGTH_LONG)
					.show();
			getActivity().finish();
		}
	}

	@Override
	public void onConnected(Bundle arg0) {
		run();
	}

	@Override
	public void onDisconnected() {
		// Not used
		
	}
}
