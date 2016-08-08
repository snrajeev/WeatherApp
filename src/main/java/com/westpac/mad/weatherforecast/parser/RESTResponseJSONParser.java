package com.westpac.mad.weatherforecast.parser;

import android.util.JsonReader;
import android.util.Log;

import com.westpac.mad.weatherforecast.models.CurrentlyModel;
import com.westpac.mad.weatherforecast.models.DailyModel;
import com.westpac.mad.weatherforecast.models.HourlyModel;
import com.westpac.mad.weatherforecast.models.MainModel;
import com.westpac.mad.weatherforecast.models.MinutelyModel;
import com.westpac.mad.weatherforecast.models.datamodels.CurrentlyDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.DailyDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.HourlyDataModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class RESTResponseJSONParser {
    private InputStream inputStream = null;
    MainModel mainModel = null;

    private static final String TAG = "RESTResponseJSONParser";
    private static final boolean DBG = false;

    public RESTResponseJSONParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public MainModel parseJSON() {
        mainModel = new MainModel();

        JsonReader reader = null;
        try {
            reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            buildMainModel(reader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return mainModel;
    }

    void buildMainModel(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case JSONKeys.LATITUDE:
                    mainModel.setLatitude(reader.nextDouble());
                    if(DBG) Log.d(TAG, "Latitude: " + mainModel.getLatitude());
                    break;
                case JSONKeys.LONGITUDE:
                    mainModel.setLongitude(reader.nextDouble());
                    if(DBG) Log.d(TAG, "Longitude: " + mainModel.getLongitude());
                    break;
                case JSONKeys.TIMEZONE:
                    mainModel.setTimezone(reader.nextString());
                    if(DBG) Log.d(TAG, "Timezone: " + mainModel.getTimezone());
                    break;
                case JSONKeys.OFFSET:
                    mainModel.setOffset((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "Offset: " + mainModel.getOffset());
                    break;
                case JSONKeys.CURRENTLY:
                    mainModel.setCurrentlyModel(parseCurrently(reader));
                    break;
                case JSONKeys.MINUTELY:
                    mainModel.setMinutelyModel(parseMinutely(reader));
                    break;
                case JSONKeys.HOURLY:
                    mainModel.setHourlyModel(parseHourly(reader));
                    break;
                case JSONKeys.DAILY:
                    mainModel.setDailyModel(parseDaily(reader));
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        reader.close();
    }

    CurrentlyModel parseCurrently(JsonReader reader) throws IOException {
        CurrentlyModel currentlyModel = new CurrentlyModel();
        CurrentlyDataModel currentlyDataModel = new CurrentlyDataModel();
        GenericDataModel genericDataModel = new GenericDataModel();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case JSONKeys.NEAREST_STORM_DISTANCE:
                    currentlyDataModel.setNearestStormDistance(reader.nextInt());
                    if(DBG) Log.d(TAG, "NearestStormDistance: " + currentlyDataModel.getNearestStormDistance());
                    break;
                case JSONKeys.NEAREST_STORM_BEARING:
                    currentlyDataModel.setNearestStormBearing(reader.nextInt());
                    if(DBG) Log.d(TAG, "NearestStormBearing: " + currentlyDataModel.getNearestStormBearing());
                    break;
                default:
                    if(JSONKeys.keyTable.containsKey(name)) {
                        parseGeneric(reader, name, genericDataModel);
                    } else {
                        if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                        reader.skipValue();
                    }
                    break;
            }
        }
        reader.endObject();

        currentlyModel.setCurrentlyDataModel(currentlyDataModel);
        currentlyModel.setGenericDataModel(genericDataModel);

        return currentlyModel;
    }

    MinutelyModel parseMinutely(JsonReader reader) throws IOException {
        MinutelyModel minutelyModel = new MinutelyModel();
        ArrayList<GenericDataModel> genericDataModels = new ArrayList<GenericDataModel>();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case JSONKeys.SUMMARY:
                    minutelyModel.setSummary(reader.nextString());
                    if(DBG) Log.d(TAG, "Summary: " + minutelyModel.getSummary());
                    break;
                case JSONKeys.ICON:
                    minutelyModel.setIcon(reader.nextString());
                    if(DBG) Log.d(TAG, "Icon: " + minutelyModel.getIcon());
                    break;
                case JSONKeys.DATA:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        GenericDataModel genericDataModel = new GenericDataModel();
                        buildGenericDataModel(reader, genericDataModel);
                        genericDataModels.add(genericDataModel);
                    }
                    reader.endArray();
                    break;
                default:
                    if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();

        minutelyModel.setGenericDataModels(genericDataModels);

        return minutelyModel;
    }

    HourlyModel parseHourly(JsonReader reader) throws IOException {
        HourlyModel hourlyModel = new HourlyModel();
        ArrayList<HourlyDataModel> hourlyDataModels = new ArrayList<HourlyDataModel>();
        ArrayList<GenericDataModel> genericDataModels = new ArrayList<GenericDataModel>();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case JSONKeys.SUMMARY:
                    hourlyModel.setSummary(reader.nextString());
                    if(DBG) Log.d(TAG, "Summary: " + hourlyModel.getSummary());
                    break;
                case JSONKeys.ICON:
                    hourlyModel.setIcon(reader.nextString());
                    if(DBG) Log.d(TAG, "Icon: " + hourlyModel.getIcon());
                    break;
                case JSONKeys.DATA:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        GenericDataModel genericDataModel = new GenericDataModel();
                        HourlyDataModel hourlyDataModel = new HourlyDataModel();

                        buildHourlyModel(reader, hourlyDataModel, genericDataModel);

                        hourlyDataModels.add(hourlyDataModel);
                        genericDataModels.add(genericDataModel);
                    }
                    reader.endArray();
                    break;
                default:
                    if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();

        hourlyModel.setHourlyDataModels(hourlyDataModels);
        hourlyModel.setGenericDataModels(genericDataModels);
        return hourlyModel;
    }

    DailyModel parseDaily(JsonReader reader) throws IOException {
        DailyModel dailyModel = new DailyModel();
        ArrayList<DailyDataModel> dailyDataModels = new ArrayList<DailyDataModel>();
        ArrayList<GenericDataModel> genericDataModels = new ArrayList<GenericDataModel>();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case JSONKeys.SUMMARY:
                    dailyModel.setSummary(reader.nextString());
                    if(DBG) Log.d(TAG, "Daily Summary: " + dailyModel.getSummary());
                    break;
                case JSONKeys.ICON:
                    dailyModel.setIcon(reader.nextString());
                    if(DBG) Log.d(TAG, "Daily Icon: " + dailyModel.getIcon());
                    break;
                case JSONKeys.DATA:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        GenericDataModel genericDataModel = new GenericDataModel();
                        DailyDataModel dailyDataModel = new DailyDataModel();

                        buildDailyModel(reader, dailyDataModel, genericDataModel);

                        dailyDataModels.add(dailyDataModel);
                        genericDataModels.add(genericDataModel);
                    }
                    reader.endArray();
                    break;
                default:
                    if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();

        dailyModel.setDailyDataModels(dailyDataModels);
        dailyModel.setGenericDataModels(genericDataModels);
        return dailyModel;
    }

    void parseGeneric(JsonReader reader, String name,
                      GenericDataModel genericDataModel) throws IOException {
        switch (name) {
            case JSONKeys.TIME:
                genericDataModel.setTime(reader.nextLong());
                if(DBG) Log.d(TAG, "Time: " + genericDataModel.getTime());
                break;
            case JSONKeys.SUMMARY:
                genericDataModel.setSummary(reader.nextString());
                if(DBG) Log.d(TAG, "Summary: " + genericDataModel.getSummary());
                break;
            case JSONKeys.ICON:
                genericDataModel.setIcon(reader.nextString());
                if(DBG) Log.d(TAG, "Icon: " + genericDataModel.getIcon());
                break;
            case JSONKeys.PRECIP_INTENSITY:
                genericDataModel.setPrecipIntensity(reader.nextDouble());
                if(DBG) Log.d(TAG, "PrecipIntensity: " + genericDataModel.getPrecipIntensity());
                break;
            case JSONKeys.PRECIP_PROBABILITY:
                genericDataModel.setPrecipProbability((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "PrecipProbability: " + genericDataModel.getPrecipProbability());
                break;
            case JSONKeys.PRECIP_TYPE:
                genericDataModel.setPrecipType(reader.nextString());
                if(DBG) Log.d(TAG, "PrecipType: " + genericDataModel.getPrecipType());
                break;
            case JSONKeys.TEMPERATURE:
                genericDataModel.setTemperature((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "Temperature: " + genericDataModel.getTemperature());
                break;
            case JSONKeys.APPARENT_TEMPERATURE:
                genericDataModel.setApparentTemperature((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "ApparentTemperature: " + genericDataModel.getApparentTemperature());
                break;
            case JSONKeys.DEW_POINT:
                genericDataModel.setDewPoint((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "DewPoint: " + genericDataModel.getDewPoint());
                break;
            case JSONKeys.HUMIDITY:
                genericDataModel.setHumidity((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "Humidity: " + genericDataModel.getHumidity());
                break;
            case JSONKeys.WIND_SPEED:
                genericDataModel.setWindSpeed((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "WindSpeed: " + genericDataModel.getWindSpeed());
                break;
            case JSONKeys.WIND_BEARING:
                genericDataModel.setWindBearing(reader.nextInt());
                if(DBG) Log.d(TAG, "WindBearing: " + genericDataModel.getWindBearing());
                break;
            case JSONKeys.VISIBILITY:
                genericDataModel.setVisibility((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "Visibility: " + genericDataModel.getVisibility());
                break;
            case JSONKeys.CLOUD_COVER:
                genericDataModel.setCloudCover((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "CloudCover: " + genericDataModel.getCloudCover());
                break;
            case JSONKeys.PRESSURE:
                genericDataModel.setPressure((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "Pressure: " + genericDataModel.getPressure());
                break;
            case JSONKeys.OZONE:
                genericDataModel.setOzone((float) reader.nextDouble());
                if(DBG) Log.d(TAG, "Ozone: " + genericDataModel.getOzone());
                break;
        }
    }

    void buildGenericDataModel(JsonReader reader,
                               GenericDataModel genericDataModel) throws IOException {
        if(DBG) Log.d(TAG, "Building generic data model");
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if(JSONKeys.keyTable.containsKey(name)) {
                parseGeneric(reader, name, genericDataModel);
            } else {
                if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                reader.skipValue();
            }
        }
        reader.endObject();
        if(DBG) Log.d(TAG, "Built generic data model");
    }

    void buildHourlyModel(JsonReader reader, HourlyDataModel hourlyDataModel,
                               GenericDataModel genericDataModel) throws IOException {
        if(DBG) Log.d(TAG, "Building hourly data model");
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if(JSONKeys.keyTable.containsKey(name)) {
                if(name == JSONKeys.PRECIP_ACCUMULATION) {
                    hourlyDataModel.setPrecipAccumulation((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "PrecipAccumulation: " + hourlyDataModel.getPrecipAccumulation());
                } else {
                    parseGeneric(reader, name, genericDataModel);
                }
            } else {
                if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                reader.skipValue();
            }
        }
        reader.endObject();
        if(DBG) Log.d(TAG, "Built hourly data model");
    }

    void buildDailyModel(JsonReader reader, DailyDataModel dailyDataModel,
                          GenericDataModel genericDataModel) throws IOException {
        if(DBG) Log.d(TAG, "Building daily data model");
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();

            switch (name) {
                case JSONKeys.SUNRISE_TIME:
                    dailyDataModel.setSunriseTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "SunriseTime: " + dailyDataModel.getSunriseTime());
                    break;
                case JSONKeys.SUNSET_TIME:
                    dailyDataModel.setSunsetTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "SunsetTime: " + dailyDataModel.getSunsetTime());
                    break;
                case JSONKeys.MOON_PHASE:
                    dailyDataModel.setMoonPhase((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "MoonPhase: " + dailyDataModel.getMoonPhase());
                    break;
                case JSONKeys.PRECIP_INTENSITY_MAX:
                    dailyDataModel.setPrecipIntensityMax((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "PrecipIntensityMax: " + dailyDataModel.getPrecipIntensityMax());
                    break;
                case JSONKeys.PRECIP_INTENSITY_MAX_TIME:
                    dailyDataModel.setPrecipIntensityMaxTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "PrecipIntensityMaxTime: " + dailyDataModel.getPrecipIntensityMaxTime());
                    break;
                case JSONKeys.PRECIP_ACCUMULATION:
                    dailyDataModel.setPrecipAccumulation((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "PrecipAccumulation: " + dailyDataModel.getPrecipAccumulation());
                    break;
                case JSONKeys.TEMPERATURE_MIN:
                    dailyDataModel.setTemperatureMin((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "TemperatureMin: " + dailyDataModel.getTemperatureMin());
                    break;
                case JSONKeys.TEMPERATURE_MIN_TIME:
                    dailyDataModel.setTemperatureMinTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "TemperatureMinTime: " + dailyDataModel.getTemperatureMinTime());
                    break;
                case JSONKeys.TEMPERATURE_MAX:
                    dailyDataModel.setTemperatureMax((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "TemperatureMax: " + dailyDataModel.getTemperatureMax());
                    break;
                case JSONKeys.TEMPERATURE_MAX_TIME:
                    dailyDataModel.setTemperatureMaxTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "TemperatureMaxTime: " + dailyDataModel.getTemperatureMaxTime());
                    break;
                case JSONKeys.APPARENT_TEMPERATURE_MIN:
                    dailyDataModel.setApparentTemperatureMin((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "ApparentTemperatureMin: " + dailyDataModel.getApparentTemperatureMin());
                    break;
                case JSONKeys.APPARENT_TEMPERATURE_MIN_TIME:
                    dailyDataModel.setApparentTemperatureMinTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "ApparentTemperatureMinTime: " + dailyDataModel.getApparentTemperatureMinTime());
                    break;
                case JSONKeys.APPARENT_TEMPERATURE_MAX:
                    dailyDataModel.setApparentTemperatureMax((float) reader.nextDouble());
                    if(DBG) Log.d(TAG, "ApparentTemperatureMax: " + dailyDataModel.getApparentTemperatureMax());
                    break;
                case JSONKeys.APPARENT_TEMPERATURE_MAX_TIME:
                    dailyDataModel.setApparentTemperatureMaxTime(reader.nextLong());
                    if(DBG) Log.d(TAG, "ApparentTemperatureMaxTime: " + dailyDataModel.getApparentTemperatureMaxTime());
                    break;
                default:
                    if(JSONKeys.keyTable.containsKey(name)) {
                        parseGeneric(reader, name, genericDataModel);
                    } else {
                        if(DBG) Log.e(TAG, "Unknown name: " + name + ". Skipping it");
                        reader.skipValue();
                    }
                    break;
            }
        }
        reader.endObject();
        if(DBG) Log.d(TAG, "Built daily data model");
    }
}
