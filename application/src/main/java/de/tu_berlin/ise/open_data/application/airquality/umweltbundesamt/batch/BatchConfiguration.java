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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;


/**
 * Created by ahmadjawid on 7/6/17.
 * Configurations including jobs, job steps and how to read, write and process
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

    /**
     * Register a bean of type {@link FlatFileItemReader} which defines how to read data from the source (all files
     * which are of type PM10 sensor type
     * @return CustomFlatFileItemReader
     * */
    @Bean
    public FlatFileItemReader readerPM10() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();

        String url = resourceProperties.getPreviousDayUrl("PM10", "1TMW");

        //set properties
        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;
    }


    /**
     * Register a bean of type {@link FlatFileItemReader} which defines how to read data from the source (all files
     * which are of type SO2 sensor type
     * @return CustomFlatFileItemReader
     * */
    @Bean
    public FlatFileItemReader readerSO2() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("SO2", "1TMW");
        //set properties
        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;


    }


    /**
     * Register a bean of type {@link FlatFileItemReader} which defines how to read data from the source (all files
     * which are of type O3 sensor type
     * @return CustomFlatFileItemReader
     * */
    @Bean
    public FlatFileItemReader readerO3() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("O3", "8SMW_MAX");
        //set properties
        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;


    }


    /**
     * Register a bean of type {@link FlatFileItemReader} which defines how to read data from the source (all files
     * which are of type NO2 sensor type
     * @return CustomFlatFileItemReader
     * */
    @Bean
    public FlatFileItemReader readerNO2() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {


        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("NO2", "1SMW_MAX");
        //set properties
        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;
    }


    /**
     * Register a bean of type {@link FlatFileItemReader} which defines how to read data from the source (all files
     * which are of type CO sensor type
     * @return CustomFlatFileItemReader
     * */
    @Bean
    public FlatFileItemReader readerCO() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomFlatFileItemReader flatFileItemReader = new CustomFlatFileItemReader();
        String url = resourceProperties.getPreviousDayUrl("CO", "8SMW_MAX");
        //set properties
        flatFileItemReader.setProperties(applicationService, url, AirQuality.class);

        return flatFileItemReader;


    }


    /**
     * Register a bean of {@link org.springframework.batch.item.ItemProcessor} which defines how to process individual
     * objects
     * @return AirQualityItemProcessor
     * */
    @Bean
    public AirQualityItemProcessor itemProcessor() {
        return new AirQualityItemProcessor();
    }


    /**
     * Register a bean of {@link org.springframework.batch.item.ItemWriter} which defines how to write individual json objects to kafka queue
     * @return JsonItemWriter
     * */
    @Bean
    public ItemWriter<String> itemWriter() {
        return new JsonItemWriter();
    }


    /**
     * Register a bean of {@link org.springframework.batch.core.StepExecutionListener} which defines
     * methods for listening to the events of processing steps and chunks
     * @return StepProcessListener
     * */
    @Bean
    public StepProcessListener stepExecutionListener() {
        return new StepProcessListener();
    }



    /**
     * Registers a job named 'umweltAirQualityJob' that is finished in four steps
     * @param listener
     * @return {@link Job}
     * */
    @Bean
    public Job umweltAirQualityJob(JobCompletionNotificationListener listener) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, MalformedURLException {
        return jobBuilderFactory.get("umweltAirQualityJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1()).next(step2()).next(step3()).next(step4()).next(step5())
                .end()
                .build();
    }


    /**
     * Registers a job step named 'step1' which defines how to read, process and write.
     * Used to read, process, write PM10 sensor type objects.
     * @return {@link Job}
     * */
    @Bean
    public Step step1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step1").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerPM10())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }


    /**
     * Registers a job step named 'step2' which defines how to read, process and write.
     * Used to read, process, write SO2 sensor type objects.
     * @return {@link Job}
     * */
    @Bean
    public Step step2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step2").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerSO2())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    /**
     * Registers a job step named 'step3' which defines how to read, process and write.
     * Used to read, process, write O3 sensor type objects.
     * @return {@link Job}
     * */
    @Bean
    public Step step3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step3").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerO3())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }


    /**
     * Registers a job step named 'step3' which defines how to read, process and write.
     * Used to read, process, write NO2 sensor type objects.
     * @return {@link Step}
     * */
    @Bean
    public Step step4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step4").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerNO2())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }


    /**
     * Registers a job step named 'step3' which defines how to read, process and write.
     * Used to read, process, write CO sensor type objects.
     * @return {@link Step}
     * */
    @Bean
    public Step step5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step5").listener(stepExecutionListener())
                .<AirQuality, String>chunk(100)
                .reader(readerCO())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }
}
