package org.example;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class Person {
    private final String name;
    private final UUID id;
    private int phone;

    public Person(String name) {
        this.name = name;
        this.id = Generators.randomBasedGenerator().generate();
    }

    public Person(String name, int phone) {
        this.name = name;
        this.id = Generators.randomBasedGenerator().generate();
        this.phone = phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        if(this.getPhone() != 0){
        return "Person{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }else {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
