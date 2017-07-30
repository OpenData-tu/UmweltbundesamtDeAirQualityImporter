package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.batch;


import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.service.JsonSchemaCreator;
import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model.AirQuality;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by ahmadjawid on 7/6/17.
 */

public class AirQualityItemProcessor implements ItemProcessor<AirQuality, String> {

    @Autowired
    @Qualifier("airQualityJsonSchemaCreator")
    private JsonSchemaCreator jsonSchemaCreator;

    @Override
    public String process(AirQuality item) throws Exception {

        return jsonSchemaCreator.create(item);
    }

}
