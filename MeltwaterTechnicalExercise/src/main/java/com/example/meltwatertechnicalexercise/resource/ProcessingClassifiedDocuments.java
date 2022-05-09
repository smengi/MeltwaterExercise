package com.example.meltwatertechnicalexercise.resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

// will keep unused imports if given the chance to go back and finish the optimal solution

public class ProcessingClassifiedDocuments {
 //   public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";


    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void saveFile(String maskedText) {
        System.out.println(maskedText);
        try (PrintWriter out = new PrintWriter("output.txt")) {
            out.println(maskedText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static List<String> parseInputString(String removedWords) {
        String[] censoredWords = removedWords.replace(",", "").split("\"");
        List<String> parsedInput = new ArrayList<>();
        for (String censoredWord : censoredWords) {
            if (!removedWords.contains("\"" + censoredWord + "\"")) {
                String[] classifiedWords = censoredWord.split("'");
                for (String classifiedWord : classifiedWords) {
                    if (!removedWords.contains("'" + classifiedWord + "'")) {
                        String[] secretWords = classifiedWord.split(" ");
                        parsedInput.addAll(Arrays.asList(secretWords));
                    } else {
                        parsedInput.add(classifiedWord);
                    }
                }
            } else {
                parsedInput.add(censoredWord);
            }
        }
        parsedInput.remove("");
        return parsedInput;
    }
    public static String parsePhrase(List<String> wordsToReplace, String inputString) {
        String outputString = inputString;
        for (String phrase : wordsToReplace) {
            outputString = outputString.replaceAll(phrase, "xxxx");
        }
        return outputString;
    }
}
