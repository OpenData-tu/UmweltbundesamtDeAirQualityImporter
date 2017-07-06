package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service;


import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Schema;

/**
 * Created by ahmadjawid on 6/9/17.
 */
public interface JsonSchemaCreator {

     String create(Schema schema);
}
