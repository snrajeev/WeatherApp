package com.westpac.mad.weatherforecast;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.westpac.mad.weatherforecast.adapter.ForecastListAdapter;
import com.westpac.mad.weatherforecast.models.DailyModel;

public class DailyForecastActivity extends ListActivity {

    DailyModel dailyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_list);
        TextView title = (TextView) findViewById(R.id.mainHeading);
        title.setText(R.string.DailyWeatherTitle);

        dailyModel = getIntent().getParcelableExtra(MainActivity.EXTRA_DATA_DAILY_MODEL);

        ListView listView = (ListView) findViewById(android.R.id.list);

        if(dailyModel == null || dailyModel.getGenericDataModels() == null
                || dailyModel.getDailyDataModels() == null) {
            TextView emptyText = (TextView)findViewById(android.R.id.empty);
            emptyText.setText("Sorry! Daily forecast is unavailable for this location at this time. " +
                    "Please try again later.");
            listView.setEmptyView(emptyText);
            return;
        }

        ForecastListAdapter adapter = new ForecastListAdapter(dailyModel, this);
        listView.setAdapter(adapter);
    }
}
