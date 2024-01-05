package org.example.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SavePersonToJSON implements SavePersonFormat {
    @Override
    public boolean saveToFilePerson(Person pesrson, String pathDir) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String strPerson = gson.toJson(pesrson);
        return   saveToFile(strPerson,pathDir,pesrson.getName()+".json");

    }
    //region private methods
    private boolean saveToFile(String person, String directoryPath, String fileName) {
        File directory = new File(directoryPath);
        // Проверка существования директории и создание, если она не существует
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                System.err.println("Не удалось создать директорию: " + directoryPath);
                return false;
            }
        }
        // Создание полного пути к файлу, объединяя директорию и имя файла
        String fullPath = directoryPath + File.separator + fileName;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullPath), StandardCharsets.UTF_8))) {
            bufferedWriter.write(person);
            bufferedWriter.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    //endregion

}
