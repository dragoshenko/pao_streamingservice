package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {
    private static final CsvReaderService INSTANCE = new CsvReaderService();
    private BufferedReader reader;

    private CsvReaderService() {
        try {
            this.reader = new BufferedReader(new FileReader("input.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Error initializing CSV reader", e);
        }
    }

    public static CsvReaderService getInstance() {
        return INSTANCE;
    }

    public List<String[]> read() {
        List<String[]> records = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine())!= null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from CSV file", e);
        }
        return records;
    }
}