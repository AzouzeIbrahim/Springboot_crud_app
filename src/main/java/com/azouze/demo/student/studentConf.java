package com.azouze.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class studentConf {
    @Bean
    CommandLineRunner commandLineRunner(
            studentRepository repository
    ) {
        return args -> {
            repository.save ( new student ("alex","alex@gmail.com",LocalDate.of(2010,Month.DECEMBER,3)));
            repository.save( new student ("john","john@gmail.com",LocalDate.of(2000,Month.APRIL,3)));
        };
    }
}
