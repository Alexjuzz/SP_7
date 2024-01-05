package org.example;

import org.example.Reader.LoadInJSON;
import org.example.Writer.SavePersonToJSON;
import org.example.Writer.SavePersonToTxt;

public class Main {
    public static void main(String[] args) {

    Person p = new Person("Anatol",84182);
    Person p2 = new Person("Anatol");
    SavePersonToJSON json = new SavePersonToJSON();
    SavePersonToTxt txt = new SavePersonToTxt();
        System.out.println(json.saveToFilePerson(p,"."));
        System.out.println(txt.saveToFilePerson(p,"."));
        System.out.println(new LoadInJSON().readPerson("Anatol.json"));

    }
}