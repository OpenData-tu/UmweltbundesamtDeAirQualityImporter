package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.batch.AirQualityItemProcessor;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.AirQuality;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Location;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Schema;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.util.LocationToCoordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ahmadjawid on 7/6/17.
 */
@Service
public class AirQualityJsonSchemaCreator implements JsonSchemaCreator {

    private static final Logger log = LoggerFactory.getLogger(AirQualityItemProcessor.class);


    @Autowired
    ApplicationService applicationService;

    @Override
    public String create(Schema schema) {
        AirQuality airQualityItem = (AirQuality) schema;

        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;

        ObjectNode mainObject = nodeFactory.objectNode();

        mainObject.put("source_id", "umweltbundesamt_de");
        mainObject.put("device", airQualityItem.getStationName());
        mainObject.put("timestamp", airQualityItem.getTimestamp().toString());


        ObjectNode firstLevelChild = nodeFactory.objectNode();

        Location location = LocationToCoordinates.locationNamesToCoordinates.get(airQualityItem.getStationCode());

        if (location != null) {
            firstLevelChild.put("lat", LocationToCoordinates.locationNamesToCoordinates.get(airQualityItem.getStationCode()).getLat());
            firstLevelChild.put("lon", LocationToCoordinates.locationNamesToCoordinates.get(airQualityItem.getStationCode()).getLon());
        } else {
            log.error(airQualityItem.getStationCode() + " coordinates for the location not found. Consider adding to the dictionary.");
        }


        mainObject.set("location", firstLevelChild);

        mainObject.put("license", "find out");

        firstLevelChild = nodeFactory.objectNode();

        //add as PM10 pollutant if the observation is PM10
        ObjectNode secondLevelChild = nodeFactory.objectNode();
        if (airQualityItem.getPollutant().contains("PM10")) {

            secondLevelChild.put("sensor", "Particles PM10");
            secondLevelChild.put("observation_value", applicationService.parseToDouble(airQualityItem.getMeasurement()));
            firstLevelChild.set("PM10DailyAverage", secondLevelChild);

        } else if (airQualityItem.getPollutant().contains("SO2")) {
            secondLevelChild.put("sensor", "Sulfur dioxide");
            secondLevelChild.put("observation_value", applicationService.parseToDouble(airQualityItem.getMeasurement()));
            firstLevelChild.set("SO2DailyAverage", secondLevelChild);

        }else if (airQualityItem.getPollutant().contains("O3")) {
            secondLevelChild.put("sensor", "Ozone");
            secondLevelChild.put("observation_value", applicationService.parseToDouble(airQualityItem.getMeasurement()));
            firstLevelChild.set("O3Max8hAverage", secondLevelChild);

        }else if (airQualityItem.getPollutant().contains("NO2")) {
            secondLevelChild.put("sensor", "Nitrogen dioxide");
            secondLevelChild.put("observation_value", applicationService.parseToDouble(airQualityItem.getMeasurement()));
            firstLevelChild.set("NO2Max1hAverage", secondLevelChild);

        }else if (airQualityItem.getPollutant().contains("CO")) {
            secondLevelChild.put("sensor", "Carbon monoxide");
            secondLevelChild.put("observation_value", applicationService.parseToDouble(airQualityItem.getMeasurement()));
            firstLevelChild.set("COMax8hAverage", secondLevelChild);
        }


        mainObject.set("sensors", firstLevelChild);
        firstLevelChild = nodeFactory.objectNode();

        firstLevelChild.put("pollutant", airQualityItem.getPollutant());
        firstLevelChild.put("network", airQualityItem.getNetwork());
        firstLevelChild.put("dataType", airQualityItem.getDataType());
        firstLevelChild.put("stationCode", airQualityItem.getStationCode());
        mainObject.set("extra", firstLevelChild);

        return mainObject.toString();
    }
}
