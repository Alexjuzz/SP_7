package Spring.Hm7.logservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Component
public class JsonLogWriter implements LogWriter {
    private final String LOG_FILE_PATH = "log.json";
    private final String LOG_FILE_PATH2 = "log2.json";

    @Override
    public void log(String nameUser, String methodName, String inputArgs, String returnedValues) {

        Map<String, String> log = new HashMap<>();
        log.put(nameUser, "Method : " + methodName + " Input args: " + inputArgs + " Returned values: " + returnedValues);
        try {
                writeToFile(log);
                writeToFileWithBufferWriter(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void writeToFile(Map<String, String> values) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File log = new File(LOG_FILE_PATH);

        Map<String, String> curr = new HashMap<>();
        if(log.exists() && log.length() > 0) {
            curr = objectMapper.readValue(log,Map.class);
            System.out.println(curr.values() + "dwadad");
        }
        System.out.println(values + "ssssssssss");
        curr.putAll(values);
        objectMapper.writeValue(log,curr);
    }

    private void writeToFileWithBufferWriter(Map<String, String>  values)throws  IOException{

        try(  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOG_FILE_PATH2,true))){

                for(Map.Entry<String, String> v : values.entrySet()){
                    bufferedWriter.write("{\"" + v.getKey() +"\":\""+v.getValue()+"\"}" + "\n");
                }

        }catch (IOException e){
            log.info(e.getMessage());
        }
    }


}
