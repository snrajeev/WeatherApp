package com.westpac.mad.weatherforecast.models.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class CurrentlyDataModel implements Parcelable{
    private int nearestStormDistance;
    private int nearestStormBearing;

    private boolean isNearestStormDistanceAvailable;
    private boolean isNearestStormBearingAvailable;

    public CurrentlyDataModel() {
        this.nearestStormDistance = 0;
        this.nearestStormBearing = 0;

        this.isNearestStormBearingAvailable = false;
        this.isNearestStormDistanceAvailable = false;
    }

    public boolean isNearestStormDistanceAvailable() {
        return isNearestStormDistanceAvailable;
    }

    public boolean isNearestStormBearingAvailable() {
        return isNearestStormBearingAvailable;
    }

    public int getNearestStormDistance() {
        return nearestStormDistance;
    }

    public int getNearestStormBearing() {
        return nearestStormBearing;
    }
    public void setNearestStormDistance(int nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
        isNearestStormDistanceAvailable = true;
    }

    public void setNearestStormBearing(int nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
        isNearestStormBearingAvailable = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(nearestStormDistance);
        parcel.writeInt(nearestStormBearing);
        boolean array[] = new boolean[2];
        array[0] = isNearestStormDistanceAvailable;
        array[1] = isNearestStormBearingAvailable;
        parcel.writeBooleanArray(array);
    }

    public static final Parcelable.Creator<CurrentlyDataModel> CREATOR
            = new Parcelable.Creator<CurrentlyDataModel>() {
        public CurrentlyDataModel createFromParcel(Parcel in) {
            return new CurrentlyDataModel(in);
        }

        public CurrentlyDataModel[] newArray(int size) {
            return new CurrentlyDataModel[size];
        }
    };

    public CurrentlyDataModel(Parcel in) {
        nearestStormDistance = in.readInt();
        nearestStormBearing = in.readInt();
        boolean array[] = new boolean[2];
        in.readBooleanArray(array);
        isNearestStormDistanceAvailable = array[0];
        isNearestStormBearingAvailable = array[1];
    }
}
