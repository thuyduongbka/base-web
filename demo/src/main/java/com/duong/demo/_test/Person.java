package com.duong.demo._test;


import lombok.Getter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Person {

    private String firstName;
    private String lastName;
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Nguyen", "Duong");
        Field[] fields = Person.class.getDeclaredFields();
        List<String> result = new ArrayList<>();
        Object value;
        for(Field field : fields) {                           // Iterate over the object's fields

            field.setAccessible(true);                        // Ignore the private modifier
            value = field.get(person);                       // Get the value stored in the field
            result.add((String) value);
        }
        System.out.println(result);
    }
}
