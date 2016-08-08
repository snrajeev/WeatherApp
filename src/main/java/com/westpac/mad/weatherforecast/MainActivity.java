package com.westpac.mad.weatherforecast;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.westpac.mad.weatherforecast.RESTInterface.RESTHTTPTask;
import com.westpac.mad.weatherforecast.models.MainModel;
import com.westpac.mad.weatherforecast.models.datamodels.CurrentlyDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;
import com.westpac.mad.weatherforecast.service.LatLong;
import com.westpac.mad.weatherforecast.service.LocationService;
import com.westpac.mad.weatherforecast.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends Activity implements RESTHTTPTask.RESTResponseListener{

    MainModel mainModel = null;
    private static final String TAG = "MainActivity";
    public static final String EXTRA_DATA_MAIN_MODEL = "EXTRA_DATA_MAIN_MODEL";
    public static final String EXTRA_DATA_DAILY_MODEL = "EXTRA_DATA_DAILY_MODEL";
    public static final String EXTRA_DATA_HOURLY_MODEL = "EXTRA_DATA_HOURLY_MODEL";

    private LocationService locationService = null;
    private boolean bound = false;
    private LatLong latLong = new LatLong(LocationService.LATITUDE_SYDNEY_CBD,
            LocationService.LONGITUDE_SYDNEY_CBD);

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationService.LocationBinder locationBinder =
                    (LocationService.LocationBinder) iBinder;
            locationService = locationBinder.getLocationService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLocation();

        MainModel recreatedMainModel = null;
        if(savedInstanceState != null) {
            recreatedMainModel = savedInstanceState.getParcelable("MainModel");
        }
        if(recreatedMainModel != null) {
            if(mainModel == null) {
                mainModel = recreatedMainModel;
            }
            createUI();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("MainModel", mainModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, LocationService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(bound) {
            unbindService(serviceConnection);
            bound = false;
        }
    }

    private void getLocation() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(locationService != null) {
                    latLong = locationService.getLatLong();
                    Log.d(TAG, "Received location with latitude: "
                    + latLong.getLatitude() + " and longitude: "
                    + latLong.getLongitude());
                }
                //Try again after 60 seconds
                handler.postDelayed(this, 60000);
            }
        });
    }

    public void makeRESTRequest(View view) {
        Button button = (Button) findViewById(R.id.requestButton);
        button.setEnabled(false);

        String requestURL = "https://api.forecast.io/forecast/a3295d8d5e925c494a59455deef99e74/";//37.8267,-122.423
        StringBuffer buffer = new StringBuffer(requestURL);
        buffer.append(latLong.getLatitude());
        buffer.append(",");
        buffer.append(latLong.getLongitude());
        Log.d(TAG, "Request URL constructed to be: " + buffer.toString());

        RESTHTTPTask requestTask;
        requestTask = new RESTHTTPTask();
        requestTask.addListener(this);
        requestTask.execute(buffer.toString());
    }


    @Override
    public void receivedRESTResponse(MainModel mainModel) {
        this.mainModel = mainModel;
        createUI();
    }

    public void createUI() {
        Button button = (Button) findViewById(R.id.requestButton);
        buildMainActivity();
        button.setEnabled(true);

        TextView mainHeading = (TextView) findViewById(R.id.mainHeading);
        mainHeading.setVisibility(View.VISIBLE);

        Button dailyButton = (Button) findViewById(R.id.dailyForecastButton);
        dailyButton.setVisibility(View.VISIBLE);

        Button HourlyButton = (Button) findViewById(R.id.hourlyForecastButton);
        HourlyButton.setVisibility(View.VISIBLE);

        Button minutelyButton = (Button) findViewById(R.id.minutelyForecastButton);
        minutelyButton.setVisibility(View.VISIBLE);
    }

    public void buildMainActivity() {
        if(mainModel.getCurrentlyModel().getGenericDataModel().isIconAvailable()) {
            String icon = mainModel.getCurrentlyModel().getGenericDataModel().getIcon();
            ImageView currentIcon = (ImageView) findViewById(R.id.currentIcon);
            Utils.setIcon(currentIcon, icon);
        }

        StringBuffer buffer = new StringBuffer();
        GenericDataModel genericDataModel = mainModel.getCurrentlyModel().getGenericDataModel();
        TextView currentDetails = (TextView) findViewById(R.id.currentDetails);

        if(genericDataModel.isSummaryAvailable()) {
            buffer.append(genericDataModel.getSummary() + "\n");
        }

        if(genericDataModel.isTimeAvailable()) {
            long currentTimeMillis = genericDataModel.getTime();
            Date date = new Date(currentTimeMillis * 1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.US);

            sdf.setTimeZone(TimeZone.getTimeZone(mainModel.getTimezone()));
            String formattedDate = sdf.format(date);
            buffer.append(formattedDate + "\n");
        }

        if(genericDataModel.isTemperatureAvailable()) {
            float temperature = genericDataModel.getTemperature();
            buffer.append("Currently "+ temperature + " deg. F\n");
        }

        if(genericDataModel.isApparentTemperatureAvailable()) {
            float apparentTemperature = genericDataModel.getApparentTemperature();
            buffer.append("Feels like "+ apparentTemperature + " deg. F\n");
        }

        currentDetails.setText(buffer.toString());

        buildAdditionalInfo();
    }

    public void buildAdditionalInfo() {
        TextView additionalInfoHeading = (TextView) findViewById(R.id.additionalInfoHeading);
        additionalInfoHeading.setVisibility(View.VISIBLE);

        TextView additionalInfo = (TextView) findViewById(R.id.additionalInfo);
        GenericDataModel genericDataModel = mainModel.getCurrentlyModel().getGenericDataModel();
        CurrentlyDataModel currentlyDataModel = mainModel.getCurrentlyModel().getCurrentlyDataModel();
        StringBuffer buffer = new StringBuffer();

        if(genericDataModel.isCloudCoverAvailable()) {
            buffer.append("Cloud Cover: " + genericDataModel.getCloudCover() + "\t");
        }
        if(genericDataModel.isDewPointAvailable()) {
            buffer.append("Dew Point: " + genericDataModel.getDewPoint() + "\t");
        }
        if(genericDataModel.isHumidityAvailable()) {
            buffer.append("Humidity: " + genericDataModel.getHumidity() + "\t");
        }
        if(genericDataModel.isOzoneAvailable()) {
            buffer.append("Ozone: " + genericDataModel.getOzone() + "\t");
        }
        if(genericDataModel.isPrecipIntensityAvailable()) {
            buffer.append("Precipitation Intensity: " + genericDataModel.getPrecipIntensity() + "\t");
        }
        if(genericDataModel.isPrecipProbabilityAvailable()) {
            buffer.append("Precipitation Probability: " + genericDataModel.getPrecipProbability() + "\t");
        }
        if(genericDataModel.isPrecipTypeAvailable()) {
            buffer.append("Precipitation Type: " + genericDataModel.getPrecipType() + "\t");
        }
        if(genericDataModel.isPressureAvailable()) {
            buffer.append("Pressure: " + genericDataModel.getPressure() + "\t");
        }
        if(genericDataModel.isVisibilityAvailable()) {
            buffer.append("Visibility: " + genericDataModel.getVisibility() + "\t");
        }
        if(genericDataModel.isWindBearingAvailable()) {
            buffer.append("Wind Bearing: " + genericDataModel.getWindBearing() + "\t");
        }
        if(genericDataModel.isWindSpeedAvailable()) {
            buffer.append("Wind Speed: " + genericDataModel.getWindSpeed() + "\t");
        }

        if(currentlyDataModel.isNearestStormBearingAvailable()) {
            buffer.append("Nearest Storm Bearing: " + currentlyDataModel.getNearestStormBearing() + "\t");
        }
        if(currentlyDataModel.isNearestStormDistanceAvailable()) {
            buffer.append("Nearest Storm Distance: " + currentlyDataModel.getNearestStormDistance());
        }

        additionalInfo.setText(buffer.toString());
    }

    public void launchDailyForecast(View view) {
        Intent intent = new Intent(this, DailyForecastActivity.class);
        intent.putExtra(EXTRA_DATA_DAILY_MODEL, mainModel.getDailyModel());
        startActivity(intent);
    }

    public void launchHourlyForecast(View view) {
        Intent intent = new Intent(this, HourlyForecastActivity.class);
        intent.putExtra(EXTRA_DATA_HOURLY_MODEL, mainModel.getHourlyModel());
        startActivity(intent);
    }

    public void launchMinutelyForecast(View view) {
        Intent intent = new Intent(this, MinutelyListActivity.class);
        intent.putExtra(EXTRA_DATA_MAIN_MODEL, mainModel);
        startActivity(intent);
    }
}
