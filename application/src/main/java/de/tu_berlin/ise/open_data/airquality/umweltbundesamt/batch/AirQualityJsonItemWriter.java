package de.tu_berlin.ise.open_data.airquality.umweltbundesamt.batch;


import de.tu_berlin.ise.open_data.airquality.umweltbundesamt.service.KafkaServiceRecordProducer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ahmadjawid on 7/6/17.
 */
public class AirQualityJsonItemWriter implements ItemWriter<String> {

    @Autowired
    KafkaServiceRecordProducer kafkaServiceRecordProducer;


    @Override
    public void write(List<? extends String> items) throws Exception {

        for (String jsonObject : items){
            kafkaServiceRecordProducer.produce(jsonObject);
        }

    }
}
