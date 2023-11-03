package ru.study.nursery.model.pets;

import ru.study.nursery.model.animal.Animal;

import java.util.Date;

public abstract class Pets extends Animal {
    private final short max_commands = 16;
    private final byte learn_probability = 45;
    public Pets(String name, Date bdate) {
        super(name, bdate);
    }
}