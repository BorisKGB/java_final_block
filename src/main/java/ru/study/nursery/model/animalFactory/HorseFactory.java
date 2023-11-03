package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.packAnimals.Horse;

import java.util.Date;

public class HorseFactory implements AbstractAnimalFactory<Horse>{

    @Override
    public Horse create(String name, Date bdate) {
        return new Horse(name, bdate);
    }
}