package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created by ahmadjawid on 6/30/17.
 */

@Configuration
@ConfigurationProperties("resource")
public class ResourceProperties {


    private String url;

    private String startDate = LocalDate.now().minusDays(1).toString();
    private String endDate = LocalDate.now().toString();

    public ResourceProperties() {

    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Generate the url for previous day.
     * @param forPollutant
     * @param scope
     * @return String
     * */
    public String getPreviousDayUrl(String forPollutant, String scope) {

        //If not time is provided set to 22:00:00 (this is the default time in our importers when no time is provided
        LocalTime time = LocalTime.of(22, 00, 00);
        LocalDate fromDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE).minusDays(1);
        LocalDate toDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE).minusDays(1);

        LocalDateTime fromDateTime = LocalDateTime.of(fromDate, time);
        LocalDateTime toDateTime = LocalDateTime.of(toDate, time);

        String url = "https://www.umweltbundesamt.de/uaq/csv/stations/data?pollutant[]=" + forPollutant + "&scope[]=" + scope + "&group" +
                "[]=station&range[]=" + fromDateTime.toEpochSecond(ZoneOffset.UTC) + "," + toDateTime.toEpochSecond(ZoneOffset.UTC);

        return url;
    }
}
