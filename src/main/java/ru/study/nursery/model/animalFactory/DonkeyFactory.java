package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.packAnimals.Donkey;

import java.util.Calendar;

public class DonkeyFactory implements AbstractAnimalFactory<Donkey>{

    @Override
    public Donkey create(String name, Calendar bdate) {
        return new Donkey(name, bdate);
    }
}