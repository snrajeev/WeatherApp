package com.westpac.mad.weatherforecast.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.westpac.mad.weatherforecast.models.datamodels.CurrentlyDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class CurrentlyModel implements Parcelable{
    private GenericDataModel genericDataModel;
    private CurrentlyDataModel currentlyDataModel;

    public CurrentlyModel() {
    }

    public GenericDataModel getGenericDataModel() {
        return genericDataModel;
    }

    public void setGenericDataModel(GenericDataModel genericDataModel) {
        this.genericDataModel = genericDataModel;
    }

    public CurrentlyDataModel getCurrentlyDataModel() {
        return currentlyDataModel;
    }

    public void setCurrentlyDataModel(CurrentlyDataModel currentlyDataModel) {
        this.currentlyDataModel = currentlyDataModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(genericDataModel, i);
        parcel.writeParcelable(currentlyDataModel, i);
    }

    public static final Parcelable.Creator<CurrentlyModel> CREATOR
            = new Parcelable.Creator<CurrentlyModel>() {
        public CurrentlyModel createFromParcel(Parcel in) {
            return new CurrentlyModel(in);
        }

        public CurrentlyModel[] newArray(int size) {
            return new CurrentlyModel[size];
        }
    };

    public CurrentlyModel(Parcel in) {
        genericDataModel = in.readParcelable(GenericDataModel.class.getClassLoader());
        currentlyDataModel = in.readParcelable(CurrentlyDataModel.class.getClassLoader());
    }
}
