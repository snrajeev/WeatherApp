package com.westpac.mad.weatherforecast.RESTInterface;

import android.os.AsyncTask;
import android.util.Log;

import com.westpac.mad.weatherforecast.models.MainModel;
import com.westpac.mad.weatherforecast.parser.RESTResponseJSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by RajeevUTD on 8/4/2016.
 */
public class RESTHTTPTask extends AsyncTask<String, String, MainModel> {

    private static final String TAG = "RESTHTTPTask";

    public interface RESTResponseListener {
        void receivedRESTResponse(MainModel mainModel);
    }

    RESTResponseListener listener = null;

    public void addListener(RESTResponseListener listener) {
        this.listener = listener;
    }

    @Override
    protected MainModel doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            RESTResponseJSONParser parser = new RESTResponseJSONParser(stream);
            MainModel mainModel = parser.parseJSON();

            return mainModel;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(MainModel mainModel) {
        super.onPostExecute(mainModel);
        if(mainModel == null) {
            Log.e(TAG, "JSON Result is: null");
        } else {
            Log.d(TAG, "Successfully parsed the JSON response and built the models");
            if(listener != null) {
                listener.receivedRESTResponse(mainModel);
            }
        }
    }
}
