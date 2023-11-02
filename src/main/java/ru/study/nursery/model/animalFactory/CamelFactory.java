package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.packAnimals.Camel;

import java.util.Date;

public class CamelFactory implements AbstractAnimalFactory<Camel>{

    @Override
    public Camel create(String name, Date bdate) {
        return new Camel(name, bdate);
    }
}