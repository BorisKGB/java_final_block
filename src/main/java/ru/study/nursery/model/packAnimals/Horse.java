package ru.study.nursery.model.packAnimals;

import java.util.Calendar;

public class Horse extends PackAnimals {
    private final byte learn_probability = 35;
    public Horse(String name, Calendar bdate) {
        super(name, bdate);
    }
}
