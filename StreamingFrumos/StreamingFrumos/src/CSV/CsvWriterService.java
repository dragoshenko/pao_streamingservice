package CSV;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterService {
    private static final CsvWriterService INSTANCE = new CsvWriterService();
    private BufferedWriter writer;

    private CsvWriterService() {
        try {
            this.writer = new BufferedWriter(new FileWriter("output.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Error initializing CSV writer", e);
        }
    }

    public static CsvWriterService getInstance() {
        return INSTANCE;
    }

    public void write(List<String[]> records) {
        try {
            for (String[] record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file", e);
        }
    }
}

