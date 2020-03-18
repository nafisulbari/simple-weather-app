package com.nafisulbari.weather;



import com.nafisulbari.weather.service.WeatherService;


import java.io.IOException;

/**
 * A simple weather app
 *
 * @author  Ahmed Nafisul Bari
 */

public class Main {
    public static void main(String[] args) throws IOException {

WeatherService weatherService=new WeatherService();

        System.out.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("summary"));

        System.out.println(weatherService.getLatLong());

        System.out.println("Array");
        System.out.println(weatherService.getWeatherData().get("hourly").getAsJsonObject().get("data").getAsJsonArray());


    }
}
