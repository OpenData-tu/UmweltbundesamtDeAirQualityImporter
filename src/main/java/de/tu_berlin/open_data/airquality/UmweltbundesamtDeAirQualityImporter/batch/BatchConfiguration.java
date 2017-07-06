package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.batch;


import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.http.HttpService;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.AirQuality;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.Schema;
import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.service.ApplicationService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;


/**
 * Created by ahmadjawid on 7/6/17.
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Value("${resource.url}")
    private String resourceUrl;


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public ApplicationService applicationService;

    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    @Autowired
    private HttpService httpFileDownloaderService;

    @Bean
    public FlatFileItemReader readerBME() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
      //  MultiResourceItemReader multiResourceItemReader = new MultiResourceItemReader();
        String sensorType = "bme";
      //  multiResourceItemReader.setResources(httpFileDownloaderService.getUrlResources(resourceUrl, sensorType));

        FlatFileItemReader reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("data.csv"));

        reader.setLinesToSkip(1);

        Schema userModelInstance = new AirQuality();

        reader.setLineMapper(applicationService.createLineMapper(AirQuality.class, userModelInstance));

        return reader;
    }


    @Bean
    public AirQualityItemProcessor processor() {
        return new AirQualityItemProcessor();
    }

    @Bean
    public AirQualityJsonItemWriter writer() {
        return new AirQualityJsonItemWriter();
    }



    @Bean
    public Job weatherDataJob(JobCompletionNotificationListener listener) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, MalformedURLException {
        return jobBuilderFactory.get("weatherDataJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step1")
                .<AirQuality, AirQuality>chunk(10)
                .reader(readerBME())
                .processor(processor())
                .writer(writer())
                .build();
    }


    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcess(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
        return jobRegistryBeanPostProcessor;
    }
}
