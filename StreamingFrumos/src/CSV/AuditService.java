package CSV;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class AuditService {
    private static final AuditService INSTANCE = new AuditService();
    private CsvWriterService csvWriterService = CsvWriterService.getInstance();

    private AuditService() {}

    public static AuditService getInstance() {
        return INSTANCE;
    }

    public void logAction(String actionName) {
        String timestamp = LocalDateTime.now().toString();
        String[] record = {actionName, timestamp};
        csvWriterService.write(Collections.singletonList(record));
    }
}
