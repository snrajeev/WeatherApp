package com.westpac.mad.weatherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.westpac.mad.weatherforecast.R;
import com.westpac.mad.weatherforecast.models.DailyModel;
import com.westpac.mad.weatherforecast.models.HourlyModel;
import com.westpac.mad.weatherforecast.models.datamodels.DailyDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.HourlyDataModel;
import com.westpac.mad.weatherforecast.utils.Utils;

/**
 * Created by RajeevUTD on 8/6/2016.
 */
public class ForecastListAdapter extends BaseAdapter {

    DailyModel dailyModel = null;
    HourlyModel hourlyModel = null;
    Context context;
    private static final String TAG = "ForecastListAdapter";

    private enum AdapterType {
        DAILY_MODEL_ADAPTER,
        HOURLY_MODEL_ADAPTER
    }

    private AdapterType type;

    public ForecastListAdapter(DailyModel dailyModel, Context context) {
        this.dailyModel = dailyModel;
        this.context = context;
        this.type = AdapterType.DAILY_MODEL_ADAPTER;
    }

    public ForecastListAdapter(HourlyModel hourlyModel, Context context) {
        this.hourlyModel = hourlyModel;
        this.context = context;
        this.type = AdapterType.HOURLY_MODEL_ADAPTER;
    }

    private static class ViewHolder {
        public ImageView rowIcon;
        public TextView currentDetails;
        public TextView additionalInfoHeading;
        public TextView additionalInfo;
    }

    @Override
    public int getCount() {
        if(type == AdapterType.DAILY_MODEL_ADAPTER) {
            return dailyModel.getDailyDataModels().size();
        } else if(type == AdapterType.HOURLY_MODEL_ADAPTER){
            return hourlyModel.getHourlyDataModels().size();
        } else {
            return 0;
        }
    }

    @Override
    public DailyModel getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = new ViewHolder();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_layout, null);


            viewHolder.rowIcon = (ImageView) view.findViewById(R.id.rowIcon);
            viewHolder.currentDetails = (TextView) view.findViewById(R.id.currentDetails);
            viewHolder.additionalInfoHeading = (TextView) view.findViewById(R.id.additionalInfoHeading);
            viewHolder.additionalInfo = (TextView) view.findViewById(R.id.additionalInfo);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if(type == AdapterType.DAILY_MODEL_ADAPTER) {
            GenericDataModel genericDataModel = dailyModel.getGenericDataModels().get(i);
            DailyDataModel dailyDataModel = dailyModel.getDailyDataModels().get(i);

            buildMainInfo(viewHolder, genericDataModel);
            buildAdditionalInfo(viewHolder, genericDataModel);
            buildAdditionalInfo(viewHolder, dailyDataModel);
        } else if(type == AdapterType.HOURLY_MODEL_ADAPTER) {
            GenericDataModel genericDataModel = hourlyModel.getGenericDataModels().get(i);
            HourlyDataModel hourlyDataModel = hourlyModel.getHourlyDataModels().get(i);

            buildMainInfo(viewHolder, genericDataModel);
            buildAdditionalInfo(viewHolder, genericDataModel);
            buildAdditionalInfo(viewHolder, hourlyDataModel);
        }


        return view;
    }

    private void buildMainInfo(ViewHolder viewHolder, GenericDataModel genericDataModel) {
        ImageView imageView = viewHolder.rowIcon;
        TextView currentDetails = viewHolder.currentDetails;
        StringBuffer buffer = new StringBuffer();

        if(genericDataModel.isIconAvailable()) {
            String icon = genericDataModel.getIcon();
            Utils.setIcon(imageView, icon);
        }

        if(genericDataModel.isSummaryAvailable()) {
            buffer.append(genericDataModel.getSummary() + "\n");
        }

        if(genericDataModel.isTimeAvailable()) {
            long currentTimeMillis = genericDataModel.getTime();
            String formattedDate = Utils.formatDate(currentTimeMillis);
            buffer.append(formattedDate + "\n");
        }

        if(genericDataModel.isTemperatureAvailable()) {
            float temperature = genericDataModel.getTemperature();
            buffer.append("Temperature "+ temperature + " deg. F\n");
        }

        if(genericDataModel.isApparentTemperatureAvailable()) {
            float apparentTemperature = genericDataModel.getApparentTemperature();
            buffer.append("Feels like "+ apparentTemperature + " deg. F\n");
        }

        currentDetails.setText(buffer.toString());
    }

    private void buildAdditionalInfo(ViewHolder viewHolder, GenericDataModel genericDataModel) {
        TextView additionalInfo = viewHolder.additionalInfo;
        StringBuffer buffer = new StringBuffer();

        if(genericDataModel.isPrecipTypeAvailable()) {
            String precipType = genericDataModel.getPrecipType();
            buffer.append("Precipitation type: " + precipType + "\t");
        }

        if(genericDataModel.isPrecipProbabilityAvailable()) {
            float precipProbability = genericDataModel.getPrecipProbability();
            buffer.append("Precipitation probability: " + precipProbability + "\t");
        }

        if(genericDataModel.isPrecipIntensityAvailable()) {
            double precipIntensity = genericDataModel.getPrecipIntensity();
            buffer.append("Precipitation Intensity: " + precipIntensity + "\t");
        }

        if(genericDataModel.isDewPointAvailable()) {
            float dewPoint = genericDataModel.getDewPoint();
            buffer.append("DewPoint: " + dewPoint + "\t");
        }

        if(genericDataModel.isHumidityAvailable()) {
            float humidity = genericDataModel.getHumidity();
            buffer.append("Humidity: " + humidity + "\t");
        }

        if(genericDataModel.isWindSpeedAvailable()) {
            float windSpeed = genericDataModel.getWindSpeed();
            buffer.append("Wind speed: " + windSpeed + "\t");
        }

        if(genericDataModel.isWindBearingAvailable()) {
            int windBearing = genericDataModel.getWindBearing();
            buffer.append("Wind bearing: " + windBearing + "\t");
        }

        if(genericDataModel.isVisibilityAvailable()) {
            float visibility = genericDataModel.getVisibility();
            buffer.append("Visibility: " + visibility + "\t");
        }

        if(genericDataModel.isCloudCoverAvailable()) {
            float cloudCover = genericDataModel.getCloudCover();
            buffer.append("Cloud cover: " + cloudCover + "\t");
        }

        if(genericDataModel.isPressureAvailable()) {
            float pressure = genericDataModel.getPressure();
            buffer.append("Pressure: " + pressure + "\t");
        }

        if(genericDataModel.isOzoneAvailable()) {
            float ozone = genericDataModel.getOzone();
            buffer.append("Ozone: " + ozone + "\t");
        }

        additionalInfo.setText(buffer.toString());
    }

    private void buildAdditionalInfo(ViewHolder viewHolder, DailyDataModel dailyDataModel) {
        TextView additionalInfo = viewHolder.additionalInfo;
        StringBuffer buffer = new StringBuffer(additionalInfo.getText());

        if(dailyDataModel.isSunriseTimeAvailable()) {
            long currentTimeMillis = dailyDataModel.getSunriseTime();
            String formattedDate = Utils.formatDate(currentTimeMillis);
            buffer.append("Sunrise Time: " + formattedDate + "\t");
        }

        if(dailyDataModel.isSunsetTimeAvailable()) {
            long currentTimeMillis = dailyDataModel.getSunsetTime();
            String formattedDate = Utils.formatDate(currentTimeMillis);
            buffer.append("Sunset Time: " + formattedDate + "\t");
        }

        if(dailyDataModel.isMoonPhaseAvailable()) {
            float moonPhase = dailyDataModel.getMoonPhase();
            buffer.append("Moon phase: " + moonPhase + "\t");
        }

        if(dailyDataModel.isPrecipAccumulationAvailable()) {
            float precipAccumulation = dailyDataModel.getPrecipAccumulation();
            buffer.append("Precipitation Accumulation: " + precipAccumulation + "\t");
        }

        if(dailyDataModel.isPrecipIntensityMaxAvailable()) {
            double precipIntensityMax = dailyDataModel.getPrecipIntensityMax();
            buffer.append("Precipitation Intensity Max: " + precipIntensityMax + "\t");
        }

        if(dailyDataModel.isPrecipIntensityMaxTimeAvailable()) {
            long precipIntensityMaxTime = dailyDataModel.getPrecipIntensityMaxTime();
            String formattedDate = Utils.formatDate(precipIntensityMaxTime);
            buffer.append("Precipitation Intensity Max Time: " + formattedDate + "\t");
        }

        if(dailyDataModel.isTemperatureMaxAvailable()) {
            double temperatureMax = dailyDataModel.getTemperatureMax();
            buffer.append("Temperature Max: " + temperatureMax + "\t");
        }

        if(dailyDataModel.isTemperatureMaxTimeAvailable()) {
            long temperatureMaxTime = dailyDataModel.getPrecipIntensityMaxTime();
            String formattedDate = Utils.formatDate(temperatureMaxTime);
            buffer.append("Temperature Max Time: " + formattedDate + "\t");
        }

        if(dailyDataModel.isTemperatureMinAvailable()) {
            double temperatureMin = dailyDataModel.getTemperatureMin();
            buffer.append("Temperature Min: " + temperatureMin + "\t");
        }

        if(dailyDataModel.isTemperatureMinTimeAvailable()) {
            long temperatureMinTime = dailyDataModel.getTemperatureMinTime();
            String formattedDate = Utils.formatDate(temperatureMinTime);
            buffer.append("Temperature Min Time: " + formattedDate + "\t");
        }

        if(dailyDataModel.isApparentTemperatureMaxAvailable()) {
            double apparentTemperatureMax = dailyDataModel.getApparentTemperatureMax();
            buffer.append("Apparent Temperature Max: " + apparentTemperatureMax + "\t");
        }

        if(dailyDataModel.isApparentTemperatureMaxTimeAvailable()) {
            long apparentTemperatureMaxTime = dailyDataModel.getApparentTemperatureMaxTime();
            String formattedDate = Utils.formatDate(apparentTemperatureMaxTime);
            buffer.append("Apparent Temperature Max Time: " + formattedDate + "\t");
        }

        if(dailyDataModel.isApparentTemperatureMinAvailable()) {
            double apparentTemperatureMin = dailyDataModel.getApparentTemperatureMin();
            buffer.append("Apparent Temperature Min: " + apparentTemperatureMin + "\t");
        }

        if(dailyDataModel.isApparentTemperatureMinTimeAvailable()) {
            long apparentTemperatureMinTime = dailyDataModel.getApparentTemperatureMinTime();
            String formattedDate = Utils.formatDate(apparentTemperatureMinTime);
            buffer.append("Apparent Temperature Min Time: " + formattedDate + "\t");
        }

        additionalInfo.setText(buffer.toString());
    }

    private void buildAdditionalInfo(ViewHolder viewHolder, HourlyDataModel hourlyDataModel) {
        TextView additionalInfo = viewHolder.additionalInfo;
        StringBuffer buffer = new StringBuffer(additionalInfo.getText());

        if(hourlyDataModel.isPrecipAccumulationAvailable()) {
            float precipAccumulation = hourlyDataModel.getPrecipAccumulation();
            buffer.append("Precipitation Accumulation: " + precipAccumulation + "\t");
        }

        additionalInfo.setText(buffer.toString());
    }
}
