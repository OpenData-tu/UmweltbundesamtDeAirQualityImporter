package de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.batch;


import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.config.ResourceProperties;
import de.tu_berlin.ise.open_data.application.airquality.umweltbundesamt.model.AirQuality;
import de.tu_berlin.ise.open_data.library.batch.JobCompletionNotificationListener;
import de.tu_berlin.ise.open_data.library.batch.JsonItemWriter;
import de.tu_berlin.ise.open_data.library.batch.StepProcessListener;
import de.tu_berlin.ise.open_data.library.service.ApplicationService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by ahmadjawid on 7/6/17.
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public ApplicationService applicationService;

    @Autowired
    private ResourceProperties resourceProperties;


    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    //TODO if possible make the readers only one by creating a reader class and using constructor to set related properties

    @Bean
    public FlatFileItemReader readerPM10() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();

        String url = resourceProperties.getPreviousDayUrl("PM10", "1TMW");

        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;
    }

    @Bean
    public FlatFileItemReader readerSO2() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("SO2", "1TMW");

        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;


    }

    @Bean
    public FlatFileItemReader readerO3() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("O3", "8SMW_MAX");

        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;


    }

    @Bean
    public FlatFileItemReader readerNO2() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {


        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("NO2", "1SMW_MAX");

        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;
    }

    @Bean
    public FlatFileItemReader readerCO() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("CO", "8SMW_MAX");

        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;


    }

    @Bean
    public AirQualityItemProcessor processor() {
        return new AirQualityItemProcessor();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new JsonItemWriter();
    }

    @Bean
    public StepProcessListener stepExecutionListener() {
        return new StepProcessListener();
    }



    @Bean
    public Job umweltAirQualityJob(JobCompletionNotificationListener listener) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, MalformedURLException {
        return jobBuilderFactory.get("umweltAirQualityJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1()).next(step2()).next(step3()).next(step4()).next(step5())
                .end()
                .build();
    }

    @Bean
    public Step step1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step1").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerPM10())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step2").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerSO2())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step3").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerO3())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step4").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerNO2())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step5").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerCO())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
