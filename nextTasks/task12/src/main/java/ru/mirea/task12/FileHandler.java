package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SuppressWarnings({"SpellCheckingInspection", "FieldCanBeLocal"})
@Service
public class FileHandler {

    @Value("${in:#{null}}") // pass in argument from CLI: --in="someFile.txt", argument is optional
    private String input;
    @Value("${out}")
    private String output;

    private File fileIn;
    private File fileOut;

    public FileHandler(){
        System.out.println("Yare Yare Daze");
    }

    @PostConstruct
    private void postConstruct() throws Exception {
        fileOut = new File(output);
        if (input != null) {
            fileIn = new File(input);
            this.two();
        }
        else {
            this.one();
        }
        System.out.println("postConstruct");
    }

    private void two() throws IOException {
        String inputData = new String(Files.readAllBytes(Paths.get(input)));
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileOut));
        outputWriter.write(DigestUtils.md5DigestAsHex(inputData.getBytes()));
        outputWriter.close();
    }

    private void one() throws IOException {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileOut));
        outputWriter.write("null");
        outputWriter.close();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @PreDestroy
    private void preDestroy() {
        fileIn.delete();
        System.out.println("preDestroy");
    }

}
