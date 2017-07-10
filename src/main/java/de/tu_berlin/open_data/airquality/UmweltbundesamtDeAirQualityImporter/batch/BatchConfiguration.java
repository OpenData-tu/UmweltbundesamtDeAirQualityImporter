package de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.batch;


import de.tu_berlin.open_data.airquality.UmweltbundesamtDeAirQualityImporter.model.AirQuality;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;


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

   private String startDate = LocalDate.now().minusDays(1).toString();
   private String endDate = LocalDate.now().toString();

    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    //TODO if possible make the readers only one by creating a reader class and using constructor to set related properties

    @Bean
    public FlatFileItemReader readerPM10() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        FlatFileItemReader reader = new FlatFileItemReader<>();

       URL theUrl = applicationService.generateUrl("PM10", "1TMW", startDate, endDate);

        reader.setResource(new UrlResource(theUrl));

        reader.setLinesToSkip(1);

        reader.setLineMapper(applicationService.createLineMapper(AirQuality.class));

        return reader;
    }

    @Bean
    public FlatFileItemReader readerSO2() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        FlatFileItemReader reader = new FlatFileItemReader<>();
        String startDate = LocalDate.now().minusDays(1).toString();
        String endDate = LocalDate.now().toString();

        URL theUrl = applicationService.generateUrl("SO2", "1TMW", startDate, endDate);

        reader.setResource(new UrlResource(theUrl));

        reader.setLinesToSkip(1);

        reader.setLineMapper(applicationService.createLineMapper(AirQuality.class));

        return reader;
    }

    @Bean
    public FlatFileItemReader readerO3() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        FlatFileItemReader reader = new FlatFileItemReader<>();
        String startDate = LocalDate.now().minusDays(1).toString();
        String endDate = LocalDate.now().toString();

        URL theUrl = applicationService.generateUrl("O3", "8SMW_MAX", startDate, endDate);

        reader.setResource(new UrlResource(theUrl));

        reader.setLinesToSkip(1);

        reader.setLineMapper(applicationService.createLineMapper(AirQuality.class));

        return reader;
    }

    @Bean
    public FlatFileItemReader readerNO2() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        FlatFileItemReader reader = new FlatFileItemReader<>();
        String startDate = LocalDate.now().minusDays(1).toString();
        String endDate = LocalDate.now().toString();

        URL theUrl = applicationService.generateUrl("NO2", "1SMW_MAX", startDate, endDate);

        reader.setResource(new UrlResource(theUrl));

        reader.setLinesToSkip(1);

        reader.setLineMapper(applicationService.createLineMapper(AirQuality.class));

        return reader;
    }

    @Bean
    public FlatFileItemReader readerCO() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        FlatFileItemReader reader = new FlatFileItemReader<>();
        String startDate = LocalDate.now().minusDays(1).toString();
        String endDate = LocalDate.now().toString();

        URL theUrl = applicationService.generateUrl("CO", "8SMW_MAX", startDate, endDate);

        reader.setResource(new UrlResource(theUrl));

        reader.setLinesToSkip(1);

        reader.setLineMapper(applicationService.createLineMapper(AirQuality.class));

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
        return stepBuilderFactory.get("step1")
                .<AirQuality, AirQuality>chunk(10)
                .reader(readerPM10())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step2")
                .<AirQuality, AirQuality>chunk(10)
                .reader(readerSO2())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step3")
                .<AirQuality, AirQuality>chunk(10)
                .reader(readerO3())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step4")
                .<AirQuality, AirQuality>chunk(10)
                .reader(readerNO2())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Step step5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step5")
                .<AirQuality, AirQuality>chunk(10)
                .reader(readerCO())
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
