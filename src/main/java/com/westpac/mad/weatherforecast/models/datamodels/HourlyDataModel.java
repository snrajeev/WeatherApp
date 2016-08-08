package com.westpac.mad.weatherforecast.models.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class HourlyDataModel implements Parcelable{
    private float precipAccumulation;

    private boolean isPrecipAccumulationAvailable;

    public HourlyDataModel() {
        precipAccumulation = 0;
        isPrecipAccumulationAvailable = false;
    }

    public void setPrecipAccumulation(float precipAccumulation) {
        this.precipAccumulation = precipAccumulation;
        isPrecipAccumulationAvailable = true;
    }

    public float getPrecipAccumulation() {
        return precipAccumulation;
    }

    public boolean isPrecipAccumulationAvailable() {
        return isPrecipAccumulationAvailable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(precipAccumulation);

        boolean array[] = new boolean[1];
        array[0] = isPrecipAccumulationAvailable;
        parcel.writeBooleanArray(array);
    }

    public static final Parcelable.Creator<HourlyDataModel> CREATOR
            = new Parcelable.Creator<HourlyDataModel>() {
        public HourlyDataModel createFromParcel(Parcel in) {
            return new HourlyDataModel(in);
        }

        public HourlyDataModel[] newArray(int size) {
            return new HourlyDataModel[size];
        }
    };

    public HourlyDataModel(Parcel in) {
        precipAccumulation = in.readFloat();
        boolean array[] = new boolean[1];
        isPrecipAccumulationAvailable = array[0];
    }
}
