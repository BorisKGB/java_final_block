package ru.study.nursery.model.packAnimals;

import java.util.Date;

public class Horse extends PackAnimals {
    private final byte learn_probability = 35;
    public Horse(String name, Date bdate) {
        super(name, bdate);
    }
}
