package com.westpac.mad.weatherforecast.models.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.westpac.mad.weatherforecast.models.DailyModel;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class DailyDataModel implements Parcelable{
    private long sunriseTime;
    private long sunsetTime;
    private float moonPhase;
    private double precipIntensityMax;
    private long precipIntensityMaxTime;
    private float precipAccumulation;
    private float temperatureMin;
    private long temperatureMinTime;
    private float temperatureMax;
    private long temperatureMaxTime;
    private float apparentTemperatureMin;
    private long apparentTemperatureMinTime;
    private float apparentTemperatureMax;
    private long apparentTemperatureMaxTime;

    private boolean isSunriseTimeAvailable;
    private boolean isSunsetTimeAvailable;
    private boolean isMoonPhaseAvailable;
    private boolean isPrecipIntensityMaxAvailable;
    private boolean isPrecipIntensityMaxTimeAvailable;
    private boolean isPrecipAccumulationAvailable;
    private boolean isTemperatureMinAvailable;
    private boolean isTemperatureMinTimeAvailable;
    private boolean isTemperatureMaxAvailable;
    private boolean isTemperatureMaxTimeAvailable;
    private boolean isApparentTemperatureMinAvailable;
    private boolean isApparentTemperatureMinTimeAvailable;
    private boolean isApparentTemperatureMaxAvailable;
    private boolean isApparentTemperatureMaxTimeAvailable;

    public DailyDataModel() {
        sunriseTime = 0;
        sunsetTime = 0;
        moonPhase = 0;
        precipIntensityMax = 0.0;
        precipIntensityMaxTime = 0;
        precipAccumulation = 0;
        temperatureMin = 0;
        temperatureMinTime = 0;
        temperatureMax = 0;
        temperatureMaxTime = 0;
        apparentTemperatureMin = 0;
        apparentTemperatureMinTime = 0;
        apparentTemperatureMax = 0;
        apparentTemperatureMaxTime = 0;

        isSunriseTimeAvailable = false;
        isSunsetTimeAvailable = false;
        isMoonPhaseAvailable = false;
        isPrecipIntensityMaxAvailable = false;
        isPrecipIntensityMaxTimeAvailable = false;
        isPrecipAccumulationAvailable = false;
        isTemperatureMinAvailable = false;
        isTemperatureMinTimeAvailable = false;
        isTemperatureMaxAvailable = false;
        isTemperatureMaxTimeAvailable = false;
        isApparentTemperatureMinAvailable = false;
        isApparentTemperatureMinTimeAvailable = false;
        isApparentTemperatureMaxAvailable = false;
        isApparentTemperatureMaxTimeAvailable = false;
    }

    public long getSunriseTime() {
        return sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public float getMoonPhase() {
        return moonPhase;
    }

    public double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public long getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public float getPrecipAccumulation() {
        return precipAccumulation;
    }

    public float getTemperatureMin() {
        return temperatureMin;
    }

    public long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public float getTemperatureMax() {
        return temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public float getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public float getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public boolean isSunriseTimeAvailable() {
        return isSunriseTimeAvailable;
    }

    public boolean isSunsetTimeAvailable() {
        return isSunsetTimeAvailable;
    }

    public boolean isMoonPhaseAvailable() {
        return isMoonPhaseAvailable;
    }

    public boolean isPrecipIntensityMaxAvailable() {
        return isPrecipIntensityMaxAvailable;
    }

    public boolean isPrecipIntensityMaxTimeAvailable() {
        return isPrecipIntensityMaxTimeAvailable;
    }

    public boolean isPrecipAccumulationAvailable() {
        return isPrecipAccumulationAvailable;
    }

    public boolean isTemperatureMinAvailable() {
        return isTemperatureMinAvailable;
    }

    public boolean isTemperatureMinTimeAvailable() {
        return isTemperatureMinTimeAvailable;
    }

    public boolean isTemperatureMaxAvailable() {
        return isTemperatureMaxAvailable;
    }

    public boolean isTemperatureMaxTimeAvailable() {
        return isTemperatureMaxTimeAvailable;
    }

    public boolean isApparentTemperatureMinAvailable() {
        return isApparentTemperatureMinAvailable;
    }

    public boolean isApparentTemperatureMinTimeAvailable() {
        return isApparentTemperatureMinTimeAvailable;
    }

    public boolean isApparentTemperatureMaxAvailable() {
        return isApparentTemperatureMaxAvailable;
    }

    public boolean isApparentTemperatureMaxTimeAvailable() {
        return isApparentTemperatureMaxTimeAvailable;
    }

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
        isSunriseTimeAvailable = true;
    }

    public void setSunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
        isSunsetTimeAvailable = true;
    }

    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
        isMoonPhaseAvailable = true;
    }

    public void setPrecipIntensityMax(double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
        isPrecipIntensityMaxAvailable = true;
    }

    public void setPrecipIntensityMaxTime(long precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        isPrecipIntensityMaxTimeAvailable = true;
    }

    public void setPrecipAccumulation(float precipAccumulation) {
        this.precipAccumulation = precipAccumulation;
        isPrecipAccumulationAvailable = true;
    }

    public void setTemperatureMin(float temperatureMin) {
        this.temperatureMin = temperatureMin;
        isTemperatureMinAvailable = true;
    }

    public void setTemperatureMinTime(long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
        isTemperatureMinTimeAvailable = true;
    }

    public void setTemperatureMax(float temperatureMax) {
        this.temperatureMax = temperatureMax;
        isTemperatureMaxAvailable = true;
    }

    public void setTemperatureMaxTime(long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
        isTemperatureMaxTimeAvailable = true;
    }

    public void setApparentTemperatureMin(float apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
        isApparentTemperatureMinAvailable = true;
    }

    public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        isApparentTemperatureMinTimeAvailable = true;
    }

    public void setApparentTemperatureMax(float apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
        isApparentTemperatureMaxAvailable = true;
    }

    public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
        isApparentTemperatureMaxTimeAvailable = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(sunriseTime);
        parcel.writeLong(sunsetTime);
        parcel.writeFloat(moonPhase);
        parcel.writeDouble(precipIntensityMax);
        parcel.writeLong(precipIntensityMaxTime);
        parcel.writeFloat(precipAccumulation);
        parcel.writeFloat(temperatureMin);
        parcel.writeLong(temperatureMinTime);
        parcel.writeFloat(temperatureMax);
        parcel.writeLong(temperatureMaxTime);
        parcel.writeFloat(apparentTemperatureMin);
        parcel.writeLong(apparentTemperatureMinTime);
        parcel.writeFloat(apparentTemperatureMax);
        parcel.writeLong(apparentTemperatureMaxTime);

        boolean array[] = new boolean[14];
        array[0] = isSunriseTimeAvailable;
        array[1] = isSunsetTimeAvailable;
        array[2] = isMoonPhaseAvailable;
        array[3] = isPrecipIntensityMaxAvailable;
        array[4] = isPrecipIntensityMaxTimeAvailable;
        array[5] = isPrecipAccumulationAvailable;
        array[6] = isTemperatureMinAvailable;
        array[7] = isTemperatureMinTimeAvailable;
        array[8] = isTemperatureMaxAvailable;
        array[9] = isTemperatureMaxTimeAvailable;
        array[10] = isApparentTemperatureMinAvailable;
        array[11] = isApparentTemperatureMinTimeAvailable;
        array[12] = isApparentTemperatureMaxAvailable;
        array[13] = isApparentTemperatureMaxTimeAvailable;

        parcel.writeBooleanArray(array);
    }

    public static final Parcelable.Creator<DailyDataModel> CREATOR
            = new Parcelable.Creator<DailyDataModel>() {
        public DailyDataModel createFromParcel(Parcel in) {
            return new DailyDataModel(in);
        }

        public DailyDataModel[] newArray(int size) {
            return new DailyDataModel[size];
        }
    };

    public DailyDataModel(Parcel in) {
        sunriseTime = in.readLong();
        sunsetTime = in.readLong();
        moonPhase = in.readFloat();
        precipIntensityMax = in.readDouble();
        precipIntensityMaxTime = in.readLong();
        precipAccumulation = in.readFloat();
        temperatureMin = in.readFloat();
        temperatureMinTime = in.readLong();
        temperatureMax = in.readFloat();
        temperatureMaxTime = in.readLong();
        apparentTemperatureMin = in.readFloat();
        apparentTemperatureMinTime = in.readLong();
        apparentTemperatureMax = in.readFloat();
        apparentTemperatureMaxTime = in.readLong();

        boolean array[] = new boolean[14];
        in.readBooleanArray(array);

        isSunriseTimeAvailable = array[0];
        isSunsetTimeAvailable = array[1];
        isMoonPhaseAvailable = array[2];
        isPrecipIntensityMaxAvailable = array[3];
        isPrecipIntensityMaxTimeAvailable = array[4];
        isPrecipAccumulationAvailable = array[5];
        isTemperatureMinAvailable = array[6];
        isTemperatureMinTimeAvailable = array[7];
        isTemperatureMaxAvailable = array[8];
        isTemperatureMaxTimeAvailable = array[9];
        isApparentTemperatureMinAvailable = array[10];
        isApparentTemperatureMinTimeAvailable = array[11];
        isApparentTemperatureMaxAvailable = array[12];
        isApparentTemperatureMaxTimeAvailable = array[13];
    }
}
