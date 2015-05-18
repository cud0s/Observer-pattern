/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author slvai_000
 */
class WeatherStation extends Observable implements Runnable {

    private String city = new String();
    private String country = new String();
    private String description = new String();
    private double temp;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void run() {
        while (true) {
            Gson gson = new Gson();
            String fileData = new String();

            try {
                // read JSON file data as String
                URL foodSearch = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units=metric");
                fileData = new Scanner(foodSearch.openStream(), "UTF-8").useDelimiter("\\A").next();
                foodSearch.openStream().close();
            } catch (MalformedURLException ex) {
                //Logger.getLogger(Expenditure.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(Expenditure.class.getName()).log(Level.SEVERE, null, ex);
            }
            GsonData gsonWeatherReport = gson.fromJson(fileData, GsonData.class);

            boolean hasChanged = false;
            if (gsonWeatherReport != null) {
                if (temp != gsonWeatherReport.main.getTemp()) {
                    temp = gsonWeatherReport.main.getTemp();
                    System.out.println(temp);
                    hasChanged = true;
                }
                if (!description.equals(gsonWeatherReport.weather[0].getDescription())) {
                    description = gsonWeatherReport.weather[0].getDescription();
                    hasChanged = true;
                }
                if (!city.equals(gsonWeatherReport.name)) {
                    city = gsonWeatherReport.name;
                    hasChanged = true;
                }
                if (!country.equals(gsonWeatherReport.sys.getCountry())) {
                    country = gsonWeatherReport.sys.getCountry();
                    hasChanged = true;
                }

                if (hasChanged) {
                    this.setChanged();
                    this.notifyObservers();
                }
            }
            try {
                Thread.sleep(1000);                 //ms
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    WeatherStation(String newCity, String newCountry) {
        city = newCity;
        country = newCountry;
    }
}
