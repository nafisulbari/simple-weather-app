package com.nafisulbari.weather.controller;

import com.google.gson.JsonObject;
import com.nafisulbari.weather.service.WeatherService;


import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class Controller implements Initializable {


    static int timeCount = 0;

    public AnchorPane anchorPane;

    public Label location;
    public Label degree;
    public Label timer;
    public Label weatherType;
    public Label windSpeed;
    public Label realFeel;

    public Label label1;
    public Label label1H;
    public Label label1L;

    public Label label2;
    public Label label2H;
    public Label label2L;

    public Label label3;
    public Label label3H;
    public Label label3L;

    public Label label4;
    public Label label4H;
    public Label label4L;

    public Label label5;
    public Label label5H;
    public Label label5L;

    public Label label6;
    public Label label6H;
    public Label label6L;

    public Label label7;
    public Label label7H;
    public Label label7L;

    public ImageView buttonClose;
    public ImageView buttonRefresh;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    //-----------------------Get & Set methods for Controller injection--------------------------------------------
    //-------------------------------------------------------------------------------------------------------------

    public void setDegree(String degreeVal) {
        this.degree.setText(degreeVal);
    }

    public void setLocation(String locationVal) {
        this.location.setText(locationVal);
    }

    public void setTimer(String timerVal) {
        this.timer.setText(timerVal);
    }

    public void setWeatherType(String weatherTypeVal) {
        this.weatherType.setText(weatherTypeVal);
    }

    public void setWindSpeed(String windSpeedVal) {
        this.windSpeed.setText(windSpeedVal);
    }

    public void setRealFeel(String realFeelVal) {
        realFeel.setText(realFeelVal);
    }

    public void setLabel1(String label1) {
        this.label1.setText(label1);
    }

    public void setLabel1H(String label1H) {
        this.label1H.setText(label1H);
    }

    public void setLabel1L(String label1L) {
        this.label1L.setText(label1L);
    }

    public void setLabel2(String label2) {
        this.label2.setText(label2);
    }

    public void setLabel2H(String label2H) {
        this.label2H.setText(label2H);
    }

    public void setLabel2L(String label2L) {
        this.label2L.setText(label2L);
    }

    public void setLabel3(String label3) {
        this.label3.setText(label3);
    }

    public void setLabel3H(String label3H) {
        this.label3H.setText(label3H);
    }

    public void setLabel3L(String label3L) {
        this.label3L.setText(label3L);
    }

    public void setLabel4(String label4) {
        this.label4.setText(label4);
    }

    public void setLabel4H(String label4H) {
        this.label4H.setText(label4H);
    }

    public void setLabel4L(String label4L) {
        this.label4L.setText(label4L);
    }

    public void setLabel5(String label5) {
        this.label5.setText(label5);
    }

    public void setLabel5H(String label5H) {
        this.label5H.setText(label5H);
    }

    public void setLabel5L(String label5L) {
        this.label5L.setText(label5L);
    }

    public void setLabel6(String label6) {
        this.label6.setText(label6);
    }

    public void setLabel6H(String label6H) {
        this.label6H.setText(label6H);
    }

    public void setLabel6L(String label6L) {
        this.label6L.setText(label6L);
    }

    public void setLabel7(String label7) {
        this.label7.setText(label7);
    }

    public void setLabel7H(String label7H) {
        this.label7H.setText(label7H);
    }

    public void setLabel7L(String label7L) {
        this.label7L.setText(label7L);
    }


//-------------------------End of Get & Set methods-------------------------------------------------------------


    //-------------------------Controller Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------


    public void buttonCloseOnClicked(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void buttonRefreshOnClicked(MouseEvent mouseEvent) {
        updateWeather();
    }


    //------------------------End of Controller Methods--------------------------------------------------------------


    public String longToDayString(long l) {
        Date date = new Date(l * 1000L);
        return date.toString().substring(0, 1);
    }


    public void updateWeather() {
        WeatherService weatherService = WeatherService.getInstance();
        JsonObject locationData = weatherService.getLocationData();
        JsonObject weatherData = weatherService.getWeatherData(locationData);


        setDegree(weatherData.get("currently").getAsJsonObject().get("temperature").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLocation(locationData.get("city").toString().replace("\"", ""));

        timeCount = 0;
        setTimer("Updated 0 minutes ago");

        setWeatherType(weatherData.get("currently").getAsJsonObject().get("summary").toString().replace("\"", ""));
        setWindSpeed("Wind " + weatherData.get("currently").getAsJsonObject().get("windSpeed").toString().concat(" km/h"));
        setRealFeel("RealFeel " + weatherData.get("currently").getAsJsonObject().get("apparentTemperature").toString().split("\\.", 2)[0].concat("\u00B0"));


        setLabel1(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("time").getAsLong()));
        setLabel1H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel1L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        setLabel2(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(1).getAsJsonObject().get("time").getAsLong()));
        setLabel2H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(1).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel2L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(1).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        setLabel3(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(2).getAsJsonObject().get("time").getAsLong()));
        setLabel3H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(2).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel3L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(2).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        setLabel4(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(3).getAsJsonObject().get("time").getAsLong()));
        setLabel4H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(3).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel4L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(3).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        setLabel5(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(4).getAsJsonObject().get("time").getAsLong()));
        setLabel5H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(4).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel5L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(4).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        setLabel6(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(5).getAsJsonObject().get("time").getAsLong()));
        setLabel6H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(5).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel6L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(5).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        setLabel7(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(6).getAsJsonObject().get("time").getAsLong()));
        setLabel7H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(6).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        setLabel7L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(6).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));
    }


    //----Using timer to update weather data----
    public void startTimer() {


        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Platform.runLater(() -> setTimer("Updated " + timeCount + " minutes ago"));
                timeCount++;

                if (timeCount == 15) {
                    Platform.runLater(() -> updateWeather());
                }

            }
        }, 0, 1000 * 60 * MINUTES);

    }
    //-------------------------------------------
}
