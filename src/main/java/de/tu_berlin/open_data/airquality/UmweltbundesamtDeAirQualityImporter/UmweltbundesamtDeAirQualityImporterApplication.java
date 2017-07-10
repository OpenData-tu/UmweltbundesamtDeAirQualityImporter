package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter;

import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableTask
public class UmweltbundesamtDeAirQualityImporterApplication {
//    private String station_name;
//    private String station_latitude_deg;
//    private String station_local_code;
//    private String station_european_code;
//    private String station_longitude_deg;
//
//    static Map<String, Station> myMapp = new HashMap();

    public static void main(String[] args) throws IOException, ParseException {

//        JSONParser jsonParser = new JSONParser();
//        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("data.json"));
//        //Map<String, Object> objectMap = jsonJsonParser.parseMap(jsonJsonParser);
//
//        for (int index = 0; index < jsonArray.size(); index++) {
//            JSONObject jsonObject = (JSONObject) jsonArray.get(index);
//            myMapp.put(jsonObject.get("station_name").toString(), new Station(jsonObject.get("station_latitude_deg").toString(),
//                    jsonObject.get("station_longitude_deg").toString()));
//            String stationCode = jsonObject.get("station_local_code").toString();
//            String stationName = jsonObject.get("station_name").toString();
//            String latitude = jsonObject.get("station_latitude_deg").toString();
//            String longitude = jsonObject.get("station_longitude_deg").toString();
//
//
//          // System.out.println("locationDictionary.put(\"" + stationCode + "\", new Location(" + latitude + "," + longitude + "));");
//        }

        SpringApplication.run(UmweltbundesamtDeAirQualityImporterApplication.class, args);
    }
}
