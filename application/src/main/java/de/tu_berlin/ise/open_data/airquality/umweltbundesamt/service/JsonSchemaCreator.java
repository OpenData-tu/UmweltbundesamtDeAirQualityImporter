package de.tu_berlin.ise.open_data.airquality.umweltbundesamt.service;


import de.tu_berlin.ise.open_data.airquality.umweltbundesamt.model.Schema;

/**
 * Created by ahmadjawid on 6/9/17.
 */
public interface JsonSchemaCreator {

     String create(Schema schema);
}
