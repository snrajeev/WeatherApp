package com.westpac.mad.weatherforecast.parser;

import java.util.Hashtable;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class JSONKeys {
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String TIMEZONE = "timezone";
    public static final String OFFSET = "offset";
    public static final String CURRENTLY = "currently";
    public static final String MINUTELY = "minutely";
    public static final String HOURLY = "hourly";
    public static final String DAILY = "daily";
    public static final String FLAGS = "flags";
    public static final String TIME = "time";
    public static final String SUMMARY = "summary";
    public static final String ICON = "icon";
    public static final String NEAREST_STORM_DISTANCE = "nearestStormDistance";
    public static final String NEAREST_STORM_BEARING = "nearestStormBearing";
    public static final String PRECIP_INTENSITY = "precipIntensity";
    public static final String PRECIP_PROBABILITY = "precipProbability";
    public static final String TEMPERATURE = "temperature";
    public static final String APPARENT_TEMPERATURE = "apparentTemperature";
    public static final String DEW_POINT = "dewPoint";
    public static final String HUMIDITY = "humidity";
    public static final String WIND_SPEED = "windSpeed";
    public static final String WIND_BEARING = "windBearing";
    public static final String VISIBILITY = "visibility";
    public static final String CLOUD_COVER = "cloudCover";
    public static final String PRESSURE = "pressure";
    public static final String OZONE = "ozone";
    public static final String DATA = "data";
    public static final String SUNRISE_TIME = "sunriseTime";
    public static final String SUNSET_TIME = "sunsetTime";
    public static final String MOON_PHASE = "moonPhase";
    public static final String PRECIP_INTENSITY_MAX = "precipIntensityMax";
    public static final String PRECIP_INTENSITY_MAX_TIME = "precipIntensityMaxTime";
    public static final String PRECIP_ACCUMULATION = "precipAccumulation";
    public static final String PRECIP_TYPE = "precipType";
    public static final String TEMPERATURE_MIN = "temperatureMin";
    public static final String TEMPERATURE_MIN_TIME = "temperatureMinTime";
    public static final String TEMPERATURE_MAX = "temperatureMax";
    public static final String TEMPERATURE_MAX_TIME = "temperatureMaxTime";
    public static final String APPARENT_TEMPERATURE_MIN = "apparentTemperatureMin";
    public static final String APPARENT_TEMPERATURE_MIN_TIME = "apparentTemperatureMinTime";
    public static final String APPARENT_TEMPERATURE_MAX = "apparentTemperatureMax";
    public static final String APPARENT_TEMPERATURE_MAX_TIME = "apparentTemperatureMaxTime";

    public static Hashtable<String, String> keyTable = new Hashtable<String, String>();

    static {
        keyTable.put(LATITUDE, "latitude");
        keyTable.put(LONGITUDE, "longitude");
        keyTable.put(TIMEZONE, "timezone");
        keyTable.put(OFFSET, "offset");
        keyTable.put(CURRENTLY, "currently");
        keyTable.put(MINUTELY, "minutely");
        keyTable.put(HOURLY, "hourly");
        keyTable.put(DAILY, "daily");
        keyTable.put(FLAGS, "flags");
        keyTable.put(TIME, "time");
        keyTable.put(SUMMARY, "summary");
        keyTable.put(ICON, "icon");
        keyTable.put(NEAREST_STORM_DISTANCE, "nearestStormDistance");
        keyTable.put(NEAREST_STORM_BEARING, "nearestStormBearing");
        keyTable.put(PRECIP_INTENSITY, "precipIntensity");
        keyTable.put(PRECIP_PROBABILITY, "precipProbability");
        keyTable.put(TEMPERATURE, "temperature");
        keyTable.put(APPARENT_TEMPERATURE, "apparentTemperature");
        keyTable.put(DEW_POINT, "dewPoint");
        keyTable.put(HUMIDITY, "humidity");
        keyTable.put(WIND_SPEED, "windSpeed");
        keyTable.put(WIND_BEARING, "windBearing");
        keyTable.put(VISIBILITY, "visibility");
        keyTable.put(CLOUD_COVER, "cloudCover");
        keyTable.put(PRESSURE, "pressure");
        keyTable.put(OZONE, "ozone");
        keyTable.put(DATA, "data");
        keyTable.put(SUNRISE_TIME, "sunriseTime");
        keyTable.put(SUNSET_TIME, "sunsetTime");
        keyTable.put(MOON_PHASE, "moonPhase");
        keyTable.put(PRECIP_INTENSITY_MAX, "precipIntensityMax");
        keyTable.put(PRECIP_INTENSITY_MAX_TIME, "precipIntensityMaxTime");
        keyTable.put(PRECIP_ACCUMULATION, "precipAccumulation");
        keyTable.put(PRECIP_TYPE, "precipType");
        keyTable.put(TEMPERATURE_MIN, "temperatureMin");
        keyTable.put(TEMPERATURE_MIN_TIME, "temperatureMinTime");
        keyTable.put(TEMPERATURE_MAX, "temperatureMax");
        keyTable.put(TEMPERATURE_MAX_TIME, "temperatureMaxTime");
        keyTable.put(APPARENT_TEMPERATURE_MIN, "apparentTemperatureMin");
        keyTable.put(APPARENT_TEMPERATURE_MIN_TIME, "apparentTemperatureMinTime");
        keyTable.put(APPARENT_TEMPERATURE_MAX, "apparentTemperatureMax");
        keyTable.put(APPARENT_TEMPERATURE_MAX_TIME, "apparentTemperatureMaxTime");
    }
}
