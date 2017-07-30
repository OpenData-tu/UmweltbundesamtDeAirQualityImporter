package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model;

/**
 * Created by ahmadjawid on 7/30/17.
 */
public class Extra {

    private String pollutant;
    private String network;
    private String dataType;
    private String stationCode;

    public Extra(String pollutant, String network, String dataType, String stationCode) {
        this.pollutant = pollutant;
        this.network = network;
        this.dataType = dataType;
        this.stationCode = stationCode;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
}
