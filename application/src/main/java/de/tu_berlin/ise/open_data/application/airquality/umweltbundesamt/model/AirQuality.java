package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model;

import de.tu_berlin.ise.open_data.library.model.Schema;

import java.time.LocalDateTime;
import java.util.StringTokenizer;

/**
 * Created by ahmadjawid on 7/6/17.
 *All necessary fields for parsing data from source is defined here.
 * Final fields are not used when parsing from file
 */
public class AirQuality extends Schema {

    /**
     * The order of declaring fields should be the same as in csv file to parse correctly
     */

    private String stationCode;
    private String stationName;
    private String network;
    private String pollutant;
    private String dataType;
    private String timestamp;
    private String measurement;

    /**
     * Declared as final to skip the field when parsing csv file
     */
    private final String sourceId = "umweltbundesamt_de";

    /**
     * Declared as final to skip the field when parsing csv file
     */
    private final String license = "find out";


    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getTimestamp() {
        return toISOTimestamp(timestamp);
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getLicense() {
        return license;
    }

    private String toISOTimestamp(String timestamp) {
        StringTokenizer stringTokenizer = new StringTokenizer(timestamp, ".");
        try {
            String day = stringTokenizer.nextToken();
            String month = stringTokenizer.nextToken();
            String year = stringTokenizer.nextToken();
            return year + "-" + month + "-" + day + "T22:00:00Z";

        } catch (NullPointerException e) {
            return LocalDateTime.now().minusDays(1).toString() + "Z";
        }

    }




    @Override
    public String getDelimiter() {
        return ";";
    }
}
