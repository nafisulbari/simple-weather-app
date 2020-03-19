package com.nafisulbari.weather.controller;

import com.nafisulbari.weather.service.WeatherService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public AnchorPane anchorPane;
    public Label location;
    public Label degree;
    public Label weatherType;
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


    WeatherService weatherService = WeatherService.getInstance();

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

    public void setWeatherType(String weatherTypeVal){
        this.weatherType.setText(weatherTypeVal);
    }

    public void setRealFeel(String realFeelVal){
        realFeel.setText(realFeelVal);
    }






    //-------------------------End of Get & Set methods-------------------------------------------------------------







    //-------------------------Controller Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public void degreeOnClicked(MouseEvent mouseEvent) {
        degree.setText(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
    }






    //------------------------End of Controller Methods--------------------------------------------------------------

}
