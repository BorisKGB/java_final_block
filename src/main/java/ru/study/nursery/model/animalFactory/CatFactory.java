package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.pets.Cat;

import java.util.Date;

public class CatFactory implements AbstractAnimalFactory<Cat>{

    @Override
    public Cat create(String name, Date bdate) {
        return new Cat(name, bdate);
    }
}