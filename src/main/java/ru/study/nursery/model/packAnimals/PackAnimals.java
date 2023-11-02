package ru.study.nursery.model.packAnimals;

import ru.study.nursery.model.animal.Animal;

import java.util.Date;

public abstract class PackAnimals extends Animal {
    private final short max_commands = 5;
    private final byte learn_probability = 15;

    public PackAnimals(String name, Date bdate) {
        super(name, bdate);
    }
}