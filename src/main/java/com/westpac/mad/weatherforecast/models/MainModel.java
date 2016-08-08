package com.westpac.mad.weatherforecast.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class MainModel implements Parcelable{
    private double latitude;
    private double longitude;
    private String timezone;
    private float offset;
    private CurrentlyModel currentlyModel;
    private MinutelyModel minutelyModel;
    private HourlyModel hourlyModel;
    private DailyModel dailyModel;

    public MainModel() {
        latitude = 0.0;
        longitude = 0.0;
        timezone = "";
        offset = 0;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public CurrentlyModel getCurrentlyModel() {
        return currentlyModel;
    }

    public void setCurrentlyModel(CurrentlyModel currentlyModel) {
        this.currentlyModel = currentlyModel;
    }

    public MinutelyModel getMinutelyModel() {
        return minutelyModel;
    }

    public void setMinutelyModel(MinutelyModel minutelyModel) {
        this.minutelyModel = minutelyModel;
    }

    public HourlyModel getHourlyModel() {
        return hourlyModel;
    }

    public void setHourlyModel(HourlyModel hourlyModel) {
        this.hourlyModel = hourlyModel;
    }

    public DailyModel getDailyModel() {
        return dailyModel;
    }

    public void setDailyModel(DailyModel dailyModel) {
        this.dailyModel = dailyModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeString(timezone);
        parcel.writeFloat(offset);
        parcel.writeParcelable(currentlyModel, i);
        parcel.writeParcelable(minutelyModel, i);
        parcel.writeParcelable(hourlyModel, i);
        parcel.writeParcelable(dailyModel, i);
    }

    public static final Parcelable.Creator<MainModel> CREATOR
            = new Parcelable.Creator<MainModel>() {
        public MainModel createFromParcel(Parcel in) {
            return new MainModel(in);
        }

        public MainModel[] newArray(int size) {
            return new MainModel[size];
        }
    };

    public MainModel(Parcel in) {
        timezone = new String();
        latitude = in.readDouble();
        longitude = in.readDouble();
        timezone = in.readString();
        offset = in.readFloat();
        currentlyModel = in.readParcelable(CurrentlyModel.class.getClassLoader());
        minutelyModel = in.readParcelable(MinutelyModel.class.getClassLoader());
        hourlyModel = in.readParcelable(HourlyModel.class.getClassLoader());
        //TODO: Fix this later
        //The below statement is causing a crash. Comment it out for now.
        //dailyModel = in.readParcelable(DailyModel.class.getClassLoader());
    }
}
