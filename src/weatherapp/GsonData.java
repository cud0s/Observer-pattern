/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

/**
 *
 * @author slvai_000
 */
public class GsonData {

    GsonSys sys;
    GsonWeather[] weather;
    GsonMain main;
    String name;

    public static class GsonSys {
        private String country;

        public String getCountry() {
            return country;
        }
    }

    public static class GsonWeather {
        private String description;

        public String getDescription() {
            return description;
        }
    }

    public static class GsonMain {
        private double temp;

        public double getTemp() {
            return temp;
        }
    }
}
