package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service;

/**
 * Created by ahmadjawid on 6/13/17.
 */

public interface KafkaServiceRecordProducer {
    void produce(String jsonObject);
}
