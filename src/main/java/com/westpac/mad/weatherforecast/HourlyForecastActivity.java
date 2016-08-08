package com.westpac.mad.weatherforecast;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.westpac.mad.weatherforecast.adapter.ForecastListAdapter;
import com.westpac.mad.weatherforecast.models.HourlyModel;

public class HourlyForecastActivity extends ListActivity {

    HourlyModel hourlyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_list);
        TextView title = (TextView) findViewById(R.id.mainHeading);
        title.setText(R.string.HourlyWeatherTitle);

        hourlyModel = getIntent().getParcelableExtra(MainActivity.EXTRA_DATA_HOURLY_MODEL);

        ListView listView = (ListView) findViewById(android.R.id.list);

        if(hourlyModel == null || hourlyModel.getGenericDataModels() == null
                || hourlyModel.getHourlyDataModels() == null) {
            TextView emptyText = (TextView)findViewById(android.R.id.empty);
            emptyText.setText("Sorry! Hourly forecast is unavailable for this location at this time. " +
                    "Please try again later.");
            listView.setEmptyView(emptyText);
            return;
        }

        ForecastListAdapter adapter = new ForecastListAdapter(hourlyModel, this);

        listView.setAdapter(adapter);
    }
}
