package com.example.meltwatertechnicalexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.meltwatertechnicalexercise.resource.ProcessingClassifiedDocuments.*;

// Could add Spring Security but for now will leave it out so non local machines will have no problems while running app
@SpringBootApplication (exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class MeltwaterTechnicalExerciseApplication {


    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    public static void main(String[] args) throws IOException {

        SpringApplication.run(MeltwaterTechnicalExerciseApplication.class, args);

        // Having some technical errors so will run manually and check
        String removedWords = readFile(System.getProperty("user.home") + "/Downloads/uploads/removedwords2.txt"); // works in 8 combination 3 manual tries
        String fileToMask = readFile(System.getProperty("user.home") + "/Downloads/uploads/Untitled.txt"); // Temp solution but can explain what the end picture was
        List<String> wordsToReplace = parseInputString(removedWords);
        saveFile(parsePhrase(wordsToReplace, fileToMask));
        // outputs to console for now
        // works perfectly in java and angular... will try to make it work within the angular app and then try to add the DB search
        // If not enough time will leave java as is but proof of concept is there and works



    }
    @Bean
    public CorsFilter corsFilter() {
        // this is the best piece of code anyone should have saved when dealing with spring and angular and multiple hosts.
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "File-Name"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
