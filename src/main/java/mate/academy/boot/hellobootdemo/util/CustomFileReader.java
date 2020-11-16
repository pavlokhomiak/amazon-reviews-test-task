package mate.academy.boot.hellobootdemo.util;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CustomFileReader implements ReadFileService {

    @Override
    public List<String[]> readFile(String filePath) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            List<String[]> allData = new ArrayList<>();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                allData.add(nextRecord);
            }
            return allData;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
    }
}
