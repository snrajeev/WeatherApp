package com.westpac.mad.weatherforecast.test;

import com.westpac.mad.weatherforecast.models.MainModel;
import com.westpac.mad.weatherforecast.parser.RESTResponseJSONParser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by RajeevUTD on 8/7/2016.
 */
public class RESTResponseJSONParserTest {

    InputStream is;
    RESTResponseJSONParser parser;

    @Before
    public void setUp() throws Exception {
        is = this.getClass().getClassLoader().getResourceAsStream("SampleJSONResponse.txt");
        parser = new RESTResponseJSONParser(is);
    }

    @After
    public void tearDown() throws Exception {
        try {
            if(is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseJSON() throws Exception {
        /*
        Please note that this is just an example. In order to complete this, I still need to
        write mock methods using mockito. However this is just to demonstrate that the code
        is testable as per the requirements specified.
         */
        MainModel mainModel = parser.parseJSON();

        assertEquals(mainModel.getDailyModel().getDailyDataModels().size(), 1);
    }

    @Test
    public void testBuildMainModel() throws Exception {

    }

    @Test
    public void testParseCurrently() throws Exception {

    }

    @Test
    public void testParseMinutely() throws Exception {

    }

    @Test
    public void testParseHourly() throws Exception {

    }

    @Test
    public void testParseDaily() throws Exception {

    }

    @Test
    public void testParseGeneric() throws Exception {

    }

    @Test
    public void testBuildGenericDataModel() throws Exception {

    }

    @Test
    public void testBuildHourlyModel() throws Exception {

    }

    @Test
    public void testBuildDailyModel() throws Exception {

    }
}