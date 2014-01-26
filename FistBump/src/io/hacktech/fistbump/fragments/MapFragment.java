package io.hacktech.fistbump.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import io.hacktech.fistbump.SherlockMapFragment;

public class MapFragment extends SherlockMapFragment {
	private GoogleMap googleMap;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        googleMap = getMap();
        return root;
    }
    
    public void zoomToCoordinates(double latitude, double longitude) {
    	LatLng ll = new LatLng(latitude, longitude);
    	googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 20));
    }
}
