package com.nafisulbari.weather.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    private static WeatherService instance = new WeatherService();

    private WeatherService(){}

    public static WeatherService getInstance(){
        return instance;
    }


    /**
     * //todo
     *
     * @return weather data as json Object
     */
    public JsonObject getWeatherData() {
        JsonObject locationData =getLocationData();
        JsonObject weatherData = new JsonObject();

        try {

            URL url = new URL("https://api.darksky.net/forecast/d257f7195d5a5ac353a59304d20032db/" + locationData.get("lat") + "," + locationData.get("lon")+"?units=si");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String json = br.readLine();

            System.out.println("Weather Data ....");
            System.out.println(json);

            weatherData = new Gson().fromJson(json, JsonObject.class);
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherData;
    }


    /**
     * gets public ip address of machine,
     * fetches location value from ip address.
     *
     * @return machines latitude,longitude.
     */
    public JsonObject getLocationData() {

        JsonObject locationData = new JsonObject();

        try {

            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc =
                    new BufferedReader(new InputStreamReader(url_name.openStream()));
            String machinesIpAddress = sc.readLine().trim();


            URL url = new URL("http://ip-api.com/json/" + machinesIpAddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            String json = br.readLine();

            System.out.println("Location data ....");
            System.out.println(json);


            locationData = new Gson().fromJson(json, JsonObject.class);
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return locationData;
    }
}
