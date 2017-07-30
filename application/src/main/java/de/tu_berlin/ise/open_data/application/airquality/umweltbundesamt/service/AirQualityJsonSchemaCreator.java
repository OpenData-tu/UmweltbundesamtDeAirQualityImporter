package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.service;

import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.batch.AirQualityItemProcessor;
import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model.AirQuality;
import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model.Extra;
import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model.Location;
import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.util.LocationToCoordinates;
import de.tu_berlin.ise.open_data.library.model.Schema;
import de.tu_berlin.ise.open_data.library.service.JsonSchemaCreator;
import de.tu_berlin.ise.open_data.library.service.JsonStringBuilder;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by ahmadjawid on 7/6/17.
 * Implementation of {@link JsonSchemaCreator}
 */
@Service
public class AirQualityJsonSchemaCreator implements JsonSchemaCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirQualityItemProcessor.class);


    /**
     * Get an objects which is extended from {@link Schema} class
     * and converts it to json
     * @param schema
     * @return String
     * */
    @Override
    public String create(Schema schema) throws JSONException {
        AirQuality item = (AirQuality) schema;

        JsonStringBuilder jsonBuilder = new JsonStringBuilder();

        jsonBuilder.setSourceId(item.getSourceId());
        jsonBuilder.setDevice(item.getStationName());
        jsonBuilder.setTimestamp(item.getTimestamp());

        Location location = LocationToCoordinates.locationNamesToCoordinates.get(item.getStationCode());

        if (location != null)
            jsonBuilder.setLocation(location.getLat() + "", location.getLon() + "");
        else
            LOGGER.error(item.getStationCode() + " coordinates for the location not found. Consider adding to the dictionary.");


        //add as PM10 pollutant if the observation is PM10
        if (item.getPollutant().contains("PM10"))
            jsonBuilder.setSensor("PM10DailyAverage", "Particles PM10", item.getMeasurement());

        else if (item.getPollutant().contains("SO2"))
            jsonBuilder.setSensor("SO2DailyAverage", "Sulfur dioxide", item.getMeasurement());

        else if (item.getPollutant().contains("O3"))
            jsonBuilder.setSensor("O3Max8hAverage", "Ozone", item.getMeasurement());

        else if (item.getPollutant().contains("NO2"))
            jsonBuilder.setSensor("NO2Max1hAverage", "Nitrogen dioxide", item.getMeasurement());

        else if (item.getPollutant().contains("CO"))
            jsonBuilder.setSensor("COMax8hAverage", "Carbon monoxide", item.getMeasurement());


        Extra extra = new Extra(item.getPollutant(), item.getNetwork(), item.getDataType(), item.getStationCode());

        jsonBuilder.setExtra(extra);

        return jsonBuilder.build();
    }
}
