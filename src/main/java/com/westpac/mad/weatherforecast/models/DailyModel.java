package com.westpac.mad.weatherforecast.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.westpac.mad.weatherforecast.models.datamodels.DailyDataModel;
import com.westpac.mad.weatherforecast.models.datamodels.GenericDataModel;

import java.util.ArrayList;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class DailyModel implements Parcelable{
    private String summary;
    private String icon;
    private boolean isSummaryAvailable;
    private boolean isIconAvailable;
    private ArrayList<GenericDataModel> genericDataModels;
    private ArrayList<DailyDataModel> dailyDataModels;

    public DailyModel() {
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

    public ArrayList<DailyDataModel> getDailyDataModels() {
        return dailyDataModels;
    }

    public void setDailyDataModels(ArrayList<DailyDataModel> dailyDataModels) {
        this.dailyDataModels = dailyDataModels;
    }

    public boolean isSummaryAvailable() {
        return isSummaryAvailable;
    }

    public boolean isIconAvailable() {
        return isIconAvailable;
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
        parcel.writeTypedList(dailyDataModels);
    }

    public static final Parcelable.Creator<DailyModel> CREATOR
            = new Parcelable.Creator<DailyModel>() {
        public DailyModel createFromParcel(Parcel in) {
            return new DailyModel(in);
        }

        public DailyModel[] newArray(int size) {
            return new DailyModel[size];
        }
    };

    public DailyModel(Parcel in) {
        summary = in.readString();
        icon = in.readString();

        boolean array[] = new boolean[2];
        in.readBooleanArray(array);
        isSummaryAvailable = array[0];
        isIconAvailable = array[1];

        genericDataModels = new ArrayList<GenericDataModel>();
        dailyDataModels = new ArrayList<DailyDataModel>();
        in.readTypedList(genericDataModels, GenericDataModel.CREATOR);
        in.readTypedList(dailyDataModels, DailyDataModel.CREATOR);
    }
}
