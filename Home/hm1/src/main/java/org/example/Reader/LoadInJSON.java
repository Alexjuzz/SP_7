package org.example.Reader;

import com.google.gson.Gson;
import org.example.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LoadInJSON implements PersonReaderInFile {

    @Override
    public Person readPerson(String filePath) {
        File file = new File(filePath);
        System.out.println(file);
        if (!file.exists()) {
            System.err.println("Файл не найден: " + filePath);
            return null;
        }
        Gson gson = new Gson();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            StringBuilder st = new StringBuilder();
            while ((line=bufferedReader.readLine()) != null){
                st.append(line);
            }
            return  gson.fromJson(String.valueOf(st),Person.class);
        } catch (Exception e) {
            return null;
        }
    }
}
