package Spring.Hm7.logservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class JsonLogWriter implements LogWriter {
    private final String LOG_FILE_PATH = "log.json";

    @Override
    public void log(String nameUser, String methodName, String inputArgs, String returnedValues) {

        Map<String, String> log = new HashMap<>();
        log.put(nameUser, "Method : " + methodName + " Input args: " + inputArgs + " Returned values: " + returnedValues);
        try {
                writeToFile(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void writeToFile(Map<String, String> values) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File log = new File(LOG_FILE_PATH);
        objectMapper.writeValue(log, values);
    }

}
