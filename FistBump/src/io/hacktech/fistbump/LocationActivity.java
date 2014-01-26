package io.hacktech.fistbump;

import io.hacktech.fistbump.controller.Geo;

import java.util.concurrent.Semaphore;

import android.os.Bundle;

public class LocationActivity extends BaseActivity {

	Semaphore location_control = new Semaphore(0);
	Thread thread;
	boolean mIsActive = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);

		final LocationActivity me = this;
		this.thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						me.location_control.acquire();
						me.location_control.drainPermits();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					while (me.mIsActive) {
						me.ping();
						try {
							Thread.sleep(300000);// 5 min
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		this.thread.start();
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.mIsActive = true;
		this.location_control.drainPermits();
		this.location_control.release();
	}

	protected void onPause() {
		super.onPause();
		this.mIsActive = false;
	}

	private void ping() {
		System.out.println("pinging geo server");
		Geo.pingGeoServer(this);
	}
}
