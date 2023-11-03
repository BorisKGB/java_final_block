package ru.study.nursery.model.pets;

import ru.study.nursery.model.animal.Animal;

import java.util.Calendar;

public abstract class Pets extends Animal {
    private final short max_commands = 16;
    private final byte learn_probability = 45;
    public Pets(String name, Calendar bdate) {
        super(name, bdate);
    }
}