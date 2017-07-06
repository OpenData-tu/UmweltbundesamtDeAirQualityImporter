package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.batch;


import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.AirQuality;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service.ApplicationService;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service.JsonSchemaCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by ahmadjawid on 7/6/17.
 */

public class AirQualityItemProcessor implements ItemProcessor<AirQuality, String> {

    private static final Logger log = LoggerFactory.getLogger(AirQualityItemProcessor.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    @Qualifier("airQualityJsonSchemaCreator")
    private JsonSchemaCreator jsonSchemaCreator;

    @Override
    public String process(AirQuality item) throws Exception {
        item.setTimestamp(applicationService.toISODateFormat(item.getTimestamp()));
        return jsonSchemaCreator.create(item);
    }

}
