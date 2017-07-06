package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model;

/**
 * Created by ahmadjawid on 7/6/17.
 */
public class Station {



    private String station_name;
    private String station_latitude_deg;
    private String station_local_code;
    private String station_european_code;
    private String station_longitude_deg;

    public Station(String s, String s1) {

        this.station_latitude_deg = s;
        this.station_longitude_deg = s1;

    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getStation_latitude_deg() {
        return station_latitude_deg;
    }

    public void setStation_latitude_deg(String station_latitude_deg) {
        this.station_latitude_deg = station_latitude_deg;
    }

    public String getStation_local_code() {
        return station_local_code;
    }

    public void setStation_local_code(String station_local_code) {
        this.station_local_code = station_local_code;
    }

    public String getStation_european_code() {
        return station_european_code;
    }

    public void setStation_european_code(String station_european_code) {
        this.station_european_code = station_european_code;
    }

    public String getStation_longitude_deg() {
        return station_longitude_deg;
    }

    public void setStation_longitude_deg(String station_longitude_deg) {
        this.station_longitude_deg = station_longitude_deg;
    }
}
