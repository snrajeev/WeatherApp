package com.westpac.mad.weatherforecast;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.westpac.mad.weatherforecast.models.MainModel;
import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;

import java.util.Arrays;

public class MinutelyListActivity extends ListActivity {

    MainModel mainModel;
    private static final String TAG = "MinutelyListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_list);
        TextView title = (TextView) findViewById(R.id.mainHeading);
        title.setText(R.string.MinutelyWeatherTitle);

        ListView listView = (ListView) findViewById(android.R.id.list);

        mainModel = getIntent().getParcelableExtra(MainActivity.EXTRA_DATA_MAIN_MODEL);
        if(mainModel == null || mainModel.getMinutelyModel() == null ||
                mainModel.getMinutelyModel().getGenericDataModels() == null) {
            TextView emptyText = (TextView)findViewById(android.R.id.empty);
            emptyText.setText("Sorry! Minutely forecast is unavailable for this location at this time. " +
                    "Please try again later.");
            listView.setEmptyView(emptyText);
            return;
        }

        Object[] objects = mainModel.getMinutelyModel().getGenericDataModels().toArray();
        GenericDataModel[] genericDataModels = Arrays.copyOf(objects, objects.length, GenericDataModel[].class);

        ArrayAdapter<GenericDataModel> adapter = new ArrayAdapter<GenericDataModel>(
                this,
                android.R.layout.simple_list_item_1,
                genericDataModels);

        listView.setAdapter(adapter);
    }
}
