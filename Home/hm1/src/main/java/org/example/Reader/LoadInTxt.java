package org.example.Reader;

import org.example.Person;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class LoadInTxt implements PersonReaderInFile{
    @Override
    public Person readPerson(String filePath) {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.err.println("Файл не найден: " + filePath);
                    return null;
                }

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                    String line;
                    String name = null;
                    int phone = 0;

                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("Имя: ")) {
                            name = line.substring(5); // Извлекаем имя
                        } else if (line.startsWith("Номер: ")) {
                            phone = Integer.parseInt(line.substring(7)); // Извлекаем номер телефона
                        }
                    }

                    if (name != null) {
                        return new Person(name, phone);
                    } else {
                        System.err.println("Данные в файле не корректны: " + filePath);
                        return null;
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e.getMessage());
                    return null;
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка в формате номера телефона: " + e.getMessage());
                    return null;
                }
            }
        }
