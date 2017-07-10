package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service;

import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Schema;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created by ahmadjawid on 6/10/17.
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public String[] getFields(Class<? extends Object> aClass) {

        Field[] aClassDeclaredFields = aClass.getDeclaredFields();

        String[] fieldsArray = new String[aClassDeclaredFields.length];

        for (int index = 0; index < aClassDeclaredFields.length; index++)
            fieldsArray[index] = aClassDeclaredFields[index].getName();

        return fieldsArray;
    }

    @Override
    public Double parseToFloat(String number) {

        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    @Override
    public String toISODateFormat(String date) {
        return date + "Z";
    }

    @Override
    public LineMapper createLineMapper(Class<? extends Schema> aClass, Schema userModelInstance) {
        return new DefaultLineMapper<Schema>() {{
            setLineTokenizer(new DelimitedLineTokenizer(userModelInstance.getDelimiter()) {{
                setNames(getFields(aClass));
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Schema>() {{
                setTargetType(userModelInstance.getClass());
            }});
        }};
    }

    @Override
    public URL generateUrl(String forPollutant, String startDate,  String endDate) throws MalformedURLException {
        LocalTime time = LocalTime.of(22, 00, 00);
        LocalDate fromDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE).minusDays(1);
        LocalDate toDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE).minusDays(1);

        LocalDateTime fromDateTime = LocalDateTime.of(fromDate, time);
        LocalDateTime toDateTime = LocalDateTime.of(toDate, time);

        URL url = new URL("https://www.umweltbundesamt.de/uaq/csv/stations/data?pollutant[]=" +forPollutant + "&scope[]=1TMW&group" +
                "[]=station&range[]="+fromDateTime.toEpochSecond(ZoneOffset.UTC) + "," + toDateTime.toEpochSecond(ZoneOffset.UTC));

        return url;
    }
}
