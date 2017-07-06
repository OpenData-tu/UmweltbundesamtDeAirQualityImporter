package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.AirQuality;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Location;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Schema;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.util.LocationToCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ahmadjawid on 7/6/17.
 */
@Service
public class AirQualityJsonSchemaCreator implements JsonSchemaCreator {

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

        if (location != null){
            firstLevelChild.put("lat", LocationToCoordinates.locationNamesToCoordinates.get(airQualityItem.getStationCode()).getLat());
            firstLevelChild.put("lon", LocationToCoordinates.locationNamesToCoordinates.get(airQualityItem.getStationCode()).getLon());
        }else {
            System.out.println(airQualityItem.getStationCode());
        }


        mainObject.set("location", firstLevelChild);

        mainObject.put("license", "find out");

        firstLevelChild = nodeFactory.objectNode();

        ObjectNode secondLevelChild = nodeFactory.objectNode();
        secondLevelChild.put("sensor", "Particles PM10");
        secondLevelChild.put("observation_value", applicationService.parseToFloat(airQualityItem.getMeasurement()));
        firstLevelChild.set("PM10", secondLevelChild);

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
