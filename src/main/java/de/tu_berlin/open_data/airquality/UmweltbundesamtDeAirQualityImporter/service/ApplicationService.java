package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service;

import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Schema;
import org.springframework.batch.item.file.LineMapper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ahmadjawid on 6/10/17.
 */
public interface ApplicationService {
    String [] getFields(Class<? extends Object> weatherDataClass);
    Double parseToFloat(String number);
    String toISODateFormat(String date);

    LineMapper createLineMapper(Class<? extends Schema> aClass, Schema userModelInstance);

    URL generateUrl(String forPollutant, String scope, String startDate, String endDate) throws MalformedURLException;
}
