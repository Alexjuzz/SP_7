package org.example.Writer;

import org.example.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SavePersonToTxt implements SavePersonFormat{

    @Override
    public boolean saveToFilePerson(Person person, String pathDir) {
        return   saveToFile(String.valueOf("Имя: " + person.getName() + "\n" + "Номер: " + person.getPhone()),pathDir,person.getName()+".txt");
    }
    private boolean saveToFile(String person,String directoryPath,String fileName){
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
    }

