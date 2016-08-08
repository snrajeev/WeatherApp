package com.westpac.mad.weatherforecast.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.HourlyDataModel;

import java.util.ArrayList;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class HourlyModel implements Parcelable{
    private String summary;
    private String icon;
    private boolean isSummaryAvailable;
    private boolean isIconAvailable;
    private ArrayList<GenericDataModel> genericDataModels;
    private ArrayList<HourlyDataModel> hourlyDataModels;

    public HourlyModel() {
        summary = "";
        icon = "";
        isSummaryAvailable = false;
        isIconAvailable = false;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
        isSummaryAvailable = true;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
        isIconAvailable = true;
    }

    public ArrayList<GenericDataModel> getGenericDataModels() {
        return genericDataModels;
    }

    public void setGenericDataModels(ArrayList<GenericDataModel> genericDataModels) {
        this.genericDataModels = genericDataModels;
    }

    public ArrayList<HourlyDataModel> getHourlyDataModels() {
        return hourlyDataModels;
    }

    public void setHourlyDataModels(ArrayList<HourlyDataModel> hourlyDataModels) {
        this.hourlyDataModels = hourlyDataModels;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(summary);
        parcel.writeString(icon);

        boolean array[] = new boolean[2];
        array[0] = isSummaryAvailable;
        array[1] = isIconAvailable;
        parcel.writeBooleanArray(array);

        parcel.writeTypedList(genericDataModels);
        parcel.writeTypedList(hourlyDataModels);
    }

    public static final Parcelable.Creator<HourlyModel> CREATOR
            = new Parcelable.Creator<HourlyModel>() {
        public HourlyModel createFromParcel(Parcel in) {
            return new HourlyModel(in);
        }

        public HourlyModel[] newArray(int size) {
            return new HourlyModel[size];
        }
    };

    public HourlyModel(Parcel in) {
        summary = in.readString();
        icon = in.readString();

        boolean array[] = new boolean[2];
        in.readBooleanArray(array);
        isSummaryAvailable = array[0];
        isIconAvailable = array[1];

        genericDataModels = new ArrayList<GenericDataModel>();
        hourlyDataModels = new ArrayList<HourlyDataModel>();
        in.readTypedList(genericDataModels, GenericDataModel.CREATOR);
        in.readTypedList(hourlyDataModels, HourlyDataModel.CREATOR);
    }
}
