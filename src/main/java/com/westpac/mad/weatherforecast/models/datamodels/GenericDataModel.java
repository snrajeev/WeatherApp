package com.westpac.mad.weatherforecast.models.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class GenericDataModel implements Parcelable{
    private long time;
    private String summary;
    private String icon;
    private double precipIntensity;
    private float precipProbability;
    private String precipType;
    private float temperature;
    private float apparentTemperature;
    private float dewPoint;
    private float humidity;
    private float windSpeed;
    private int windBearing;
    private float visibility;
    private float cloudCover;
    private float pressure;
    private float ozone;

    private boolean isTimeAvailable;
    private boolean isSummaryAvailable;
    private boolean isIconAvailable;
    private boolean isPrecipIntensityAvailable;
    private boolean isPrecipProbabilityAvailable;
    private boolean isPrecipTypeAvailable;
    private boolean isTemperatureAvailable;
    private boolean isApparentTemperatureAvailable;
    private boolean isDewPointAvailable;
    private boolean isHumidityAvailable;
    private boolean isWindSpeedAvailable;
    private boolean isWindBearingAvailable;
    private boolean isVisibilityAvailable;
    private boolean isCloudCoverAvailable;
    private boolean isPressureAvailable;
    private boolean isOzoneAvailable;

    public GenericDataModel() {
        time = 0;
        summary = "";
        icon = "Icon";
        precipIntensity = 0.0;
        precipProbability = 0;
        precipType = "";
        temperature = 0;
        apparentTemperature = 0;
        dewPoint = 0;
        humidity = 0;
        windSpeed = 0;
        windBearing = 0;
        visibility = 0;
        cloudCover = 0;
        pressure = 0;
        ozone = 0;

        isTimeAvailable = false;
        isSummaryAvailable = false;
        isIconAvailable = false;
        isPrecipIntensityAvailable = false;
        isPrecipProbabilityAvailable = false;
        isPrecipTypeAvailable = false;
        isTemperatureAvailable = false;
        isApparentTemperatureAvailable = false;
        isDewPointAvailable = false;
        isHumidityAvailable = false;
        isWindSpeedAvailable = false;
        isWindBearingAvailable = false;
        isVisibilityAvailable = false;
        isCloudCoverAvailable = false;
        isPressureAvailable = false;
        isOzoneAvailable = false;
    }

    public long getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public float getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getApparentTemperature() {
        return apparentTemperature;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public int getWindBearing() {
        return windBearing;
    }

    public float getVisibility() {
        return visibility;
    }

    public float getCloudCover() {
        return cloudCover;
    }

    public float getPressure() {
        return pressure;
    }

    public float getOzone() {
        return ozone;
    }

    public boolean isTimeAvailable() {
        return isTimeAvailable;
    }

    public boolean isSummaryAvailable() {
        return isSummaryAvailable;
    }

    public boolean isIconAvailable() {
        return isIconAvailable;
    }

    public boolean isPrecipIntensityAvailable() {
        return isPrecipIntensityAvailable;
    }

    public boolean isPrecipProbabilityAvailable() {
        return isPrecipProbabilityAvailable;
    }

    public boolean isPrecipTypeAvailable() {
        return isPrecipTypeAvailable;
    }

    public boolean isTemperatureAvailable() {
        return isTemperatureAvailable;
    }

    public boolean isApparentTemperatureAvailable() {
        return isApparentTemperatureAvailable;
    }

    public boolean isDewPointAvailable() {
        return isDewPointAvailable;
    }

    public boolean isHumidityAvailable() {
        return isHumidityAvailable;
    }

    public boolean isWindSpeedAvailable() {
        return isWindSpeedAvailable;
    }

    public boolean isWindBearingAvailable() {
        return isWindBearingAvailable;
    }

    public boolean isVisibilityAvailable() {
        return isVisibilityAvailable;
    }

    public boolean isCloudCoverAvailable() {
        return isCloudCoverAvailable;
    }

    public boolean isPressureAvailable() {
        return isPressureAvailable;
    }

    public boolean isOzoneAvailable() {
        return isOzoneAvailable;
    }

    public void setTime(long time) {
        this.time = time;
        isTimeAvailable = true;
    }

    public void setSummary(String summary) {
        this.summary = summary;
        isSummaryAvailable = true;
    }

    public void setIcon(String icon) {
        this.icon = icon;
        isIconAvailable = true;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
        isPrecipIntensityAvailable = true;
    }

    public void setPrecipProbability(float precipProbability) {
        this.precipProbability = precipProbability;
        isPrecipProbabilityAvailable = true;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
        isPrecipTypeAvailable = true;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        isTemperatureAvailable = true;
    }

    public void setApparentTemperature(float apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
        isApparentTemperatureAvailable = true;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
        isDewPointAvailable = true;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        isHumidityAvailable = true;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
        isWindSpeedAvailable = true;
    }

    public void setWindBearing(int windBearing) {
        this.windBearing = windBearing;
        isWindBearingAvailable = true;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
        isVisibilityAvailable = true;
    }

    public void setCloudCover(float cloudCover) {
        this.cloudCover = cloudCover;
        isCloudCoverAvailable = true;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        isPressureAvailable = true;
    }

    public void setOzone(float ozone) {
        this.ozone = ozone;
        isOzoneAvailable = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(time);
        parcel.writeString(summary);
        parcel.writeString(icon);
        parcel.writeDouble(precipIntensity);
        parcel.writeFloat(precipProbability);
        parcel.writeString(precipType);
        parcel.writeFloat(temperature);
        parcel.writeFloat(apparentTemperature);
        parcel.writeFloat(dewPoint);
        parcel.writeFloat(humidity);
        parcel.writeFloat(windSpeed);
        parcel.writeInt(windBearing);
        parcel.writeFloat(visibility);
        parcel.writeFloat(cloudCover);
        parcel.writeFloat(pressure);
        parcel.writeFloat(ozone);

        boolean array[] = new boolean[16];
        array[0] = isTimeAvailable;
        array[1] = isSummaryAvailable;
        array[2] = isIconAvailable;
        array[3] = isPrecipIntensityAvailable;
        array[4] = isPrecipProbabilityAvailable;
        array[5] = isPrecipTypeAvailable;
        array[6] = isTemperatureAvailable;
        array[7] = isApparentTemperatureAvailable;
        array[8] = isDewPointAvailable;
        array[9] = isHumidityAvailable;
        array[10] = isWindSpeedAvailable;
        array[11] = isWindBearingAvailable;
        array[12] = isVisibilityAvailable;
        array[13] = isCloudCoverAvailable;
        array[14] = isPressureAvailable;
        array[15] = isOzoneAvailable;
        parcel.writeBooleanArray(array);
    }

    public static final Parcelable.Creator<GenericDataModel> CREATOR
            = new Parcelable.Creator<GenericDataModel>() {
        public GenericDataModel createFromParcel(Parcel in) {
            return new GenericDataModel(in);
        }

        public GenericDataModel[] newArray(int size) {
            return new GenericDataModel[size];
        }
    };

    public GenericDataModel(Parcel in) {
        time = in.readLong();
        summary = in.readString();
        icon = in.readString();
        precipIntensity = in.readDouble();
        precipProbability = in.readFloat();
        precipType = in.readString();
        temperature = in.readFloat();
        apparentTemperature = in.readFloat();
        dewPoint = in.readFloat();
        humidity = in.readFloat();
        windSpeed = in.readFloat();
        windBearing = in.readInt();
        visibility = in.readFloat();
        cloudCover = in.readFloat();
        pressure = in.readFloat();
        ozone = in.readFloat();

        boolean array[] = new boolean[16];
        in.readBooleanArray(array);
        isTimeAvailable = array[0];
        isSummaryAvailable = array[1];
        isIconAvailable = array[2];
        isPrecipIntensityAvailable = array[3];
        isPrecipProbabilityAvailable = array[4];
        isPrecipTypeAvailable = array[5];
        isTemperatureAvailable = array[6];
        isApparentTemperatureAvailable = array[7];
        isDewPointAvailable = array[8];
        isHumidityAvailable = array[9];
        isWindSpeedAvailable = array[10];
        isWindBearingAvailable = array[11];
        isVisibilityAvailable = array[12];
        isCloudCoverAvailable = array[13];
        isPressureAvailable = array[14];
        isOzoneAvailable = array[15];
    }

    @Override
    public String toString() {
        super.toString();

        StringBuffer buffer = new StringBuffer();

        if(isTimeAvailable) {
            long currentTimeMillis = time;
            Date date = new Date(currentTimeMillis * 1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.US);

            //sdf.setTimeZone(TimeZone.getTimeZone(mainModel.getTimezone()));
            String formattedDate = sdf.format(date);
            buffer.append(formattedDate + "\n");
        }
        if(isSummaryAvailable) buffer.append("Summary: " + summary + "\t");
        //isIconAvailable
        if(isPrecipIntensityAvailable) buffer.append("Precip Intensity: " + precipIntensity + "\t");
        if(isPrecipProbabilityAvailable) buffer.append("Precip Probabiliity: " + precipProbability + "\t");
        if(isPrecipTypeAvailable) buffer.append("Precip Type: " + precipType + "\t");
        if(isTemperatureAvailable) buffer.append("Temperature: " + temperature + "\t");
        if(isApparentTemperatureAvailable) buffer.append("Feels like: " + apparentTemperature + "\t");
        if(isDewPointAvailable) buffer.append("Dew Point: " + dewPoint + "\t");
        if(isHumidityAvailable) buffer.append("Humidity: " + humidity + "\t");
        if(isWindSpeedAvailable) buffer.append("Wind speed: " + windSpeed + "\t");
        if(isWindBearingAvailable) buffer.append("Wind Bearing: " + windBearing + "\t");
        if(isVisibilityAvailable) buffer.append("Visibility: " + visibility + "\t");
        if(isCloudCoverAvailable) buffer.append("Cloud Cover: " + cloudCover + "\t");
        if(isPressureAvailable) buffer.append("Pressure: " + pressure + "\t");
        if(isOzoneAvailable) buffer.append("Ozone: " + ozone + "\t");

        return buffer.toString();
    }
}
