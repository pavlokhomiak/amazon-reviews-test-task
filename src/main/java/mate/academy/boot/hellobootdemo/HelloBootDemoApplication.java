package mate.academy.boot.hellobootdemo;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HelloBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBootDemoApplication.class, args);

        try {
            CSVReader csvReader = new CSVReader(
                    new FileReader("./src/main/resources/Reviews.csv"));
            List<String[]> allData = new ArrayList<>();
            String[] nextRecord;
            while((nextRecord = csvReader.readNext()) != null) {
                System.out.println(Arrays.toString(nextRecord));
                allData.add(nextRecord);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file ", e);
        }
    }
}
