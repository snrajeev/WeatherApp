package com.westpac.mad.weatherforecast.service;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class LocationService extends Service {

    private final IBinder binder = new LocationBinder();

    private static final String TAG = "LocationService";
    private LatLong latLong = null;

    public static final double LATITUDE_SYDNEY_CBD = -33.8675;
    public static final double LONGITUDE_SYDNEY_CBD = 151.207;

    public LocationService() {
        //Using Sydney CBD as default location
        latLong = new LatLong(LATITUDE_SYDNEY_CBD, LONGITUDE_SYDNEY_CBD);
    }

    public class LocationBinder extends Binder {
        public LocationService getLocationService() {
            return LocationService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(location != null) {
                    latLong.setLatitude(location.getLatitude());
                    latLong.setLongitude(location.getLongitude());
                } else {
                    Log.e(TAG, "Received empty location object. Using default/previous location");
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //TODO: Call request permissions. For now, just use a default location (Sydney CBD)
            Log.e(TAG, "User declined permission to use Location. Using default location (Sydney CBD)");
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, listener);
    }

    public LatLong getLatLong() {
        return latLong;
    }
}
