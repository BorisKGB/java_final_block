package ru.study.nursery.model.pets;

import java.util.Date;

public class Hamster extends Pets {
    private final short max_commands = 5;
    public Hamster(String name, Date bdate) {
        super(name, bdate);
    }
}
