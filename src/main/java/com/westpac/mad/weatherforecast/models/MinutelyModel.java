package com.westpac.mad.weatherforecast.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;

import java.util.ArrayList;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class MinutelyModel implements Parcelable{
    private String summary;
    private String icon;
    private ArrayList<GenericDataModel> genericDataModels;

    public MinutelyModel() {
        summary = "";
        icon = "";
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<GenericDataModel> getGenericDataModels() {
        return genericDataModels;
    }

    public void setGenericDataModels(ArrayList<GenericDataModel> genericDataModels) {
        this.genericDataModels = genericDataModels;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(summary);
        parcel.writeString(icon);
        parcel.writeTypedList(genericDataModels);
    }

    public static final Parcelable.Creator<MinutelyModel> CREATOR
            = new Parcelable.Creator<MinutelyModel>() {
        public MinutelyModel createFromParcel(Parcel in) {
            return new MinutelyModel(in);
        }

        public MinutelyModel[] newArray(int size) {
            return new MinutelyModel[size];
        }
    };

    public MinutelyModel(Parcel in) {
        summary = in.readString();
        icon = in.readString();
        genericDataModels = new ArrayList<GenericDataModel>();
        in.readTypedList(genericDataModels, GenericDataModel.CREATOR);
    }
}
