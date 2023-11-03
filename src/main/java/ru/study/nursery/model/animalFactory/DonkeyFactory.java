package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.packAnimals.Donkey;

import java.util.Date;

public class DonkeyFactory implements AbstractAnimalFactory<Donkey>{

    @Override
    public Donkey create(String name, Date bdate) {
        return new Donkey(name, bdate);
    }
}