package ru.study.nursery.model.pets;

import java.util.Date;

public class Dog extends Pets {
    private final short max_commands = 24;
    private final byte learn_probability = 65;
    public Dog(String name, Date bdate) {
        super(name, bdate);
    }
}
