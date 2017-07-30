package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.batch;


import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model.AirQuality;
import de.tu_berlin.ise.open_data.library.service.JsonSchemaCreator;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by ahmadjawid on 7/6/17.
 * Processing includes converting Java Objects to json string objects according our defined schema
 */

public class AirQualityItemProcessor implements ItemProcessor<AirQuality, String> {

    @Autowired
    @Qualifier("airQualityJsonSchemaCreator")
    private JsonSchemaCreator jsonSchemaCreator;

    @Override
    public String process(AirQuality item) throws Exception {

        //A valid json objects is created and returned
        return jsonSchemaCreator.create(item);
    }

}
