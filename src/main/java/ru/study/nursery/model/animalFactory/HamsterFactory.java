package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.pets.Hamster;

import java.util.Date;

public class HamsterFactory implements AbstractAnimalFactory<Hamster>{

    @Override
    public Hamster create(String name, Date bdate) {
        return new Hamster(name, bdate);
    }
}