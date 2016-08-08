package com.westpac.mad.weatherforecast.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.westpac.mad.weatherforecast.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by RajeevUTD on 8/6/2016.
 */
public class Utils {

    private static final String TAG = "Utils";

    public static void setIcon(ImageView currentIcon, String icon) {
        switch (icon) {
            case "clear-day": currentIcon.setImageResource(R.drawable.clear_day);
                break;
            case "clear-night": currentIcon.setImageResource(R.drawable.clear_night);
                break;
            case "rain": currentIcon.setImageResource(R.drawable.rain);
                break;
            case "snow": currentIcon.setImageResource(R.drawable.snow);
                break;
            case "sleet": currentIcon.setImageResource(R.drawable.sleet);
                break;
            case "wind": currentIcon.setImageResource(R.drawable.wind);
                break;
            case "fog": currentIcon.setImageResource(R.drawable.fog);
                break;
            case "cloudy": currentIcon.setImageResource(R.drawable.cloudy);
                break;
            case "partly-cloudy-day": currentIcon.setImageResource(R.drawable.partly_cloudy_day);
                break;
            case "partly-cloudy-night": currentIcon.setImageResource(R.drawable.partly_cloudy_night);
                break;
            default:
                Log.e(TAG, "Icon not found");
                break;
        }
    }

    public static String formatDate(long currentTimeMillis) {
        Date date = new Date(currentTimeMillis * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.US);

        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
