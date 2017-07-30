package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.batch;

import de.tu_berlin.ise.open_data.library.model.Schema;
import de.tu_berlin.ise.open_data.library.service.ApplicationService;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ahmadjawid on 7/19/17.
 * Reader which specifies how to read data from the source
 */

public class CustomFlatFileItemReader extends FlatFileItemReader {


    void setProperties(ApplicationService applicationService, String resourceUrl,
                       Class<? extends Schema> lineMapperClass) throws InstantiationException, IllegalAccessException, MalformedURLException {

        setResource(new UrlResource(new URL(resourceUrl)));
        //skip the header
        setLinesToSkip(1);

        //Set LineMapper which defines how source rows are parsed into Java Objects
        setLineMapper(applicationService.createLineMapper(lineMapperClass));

    }
}
