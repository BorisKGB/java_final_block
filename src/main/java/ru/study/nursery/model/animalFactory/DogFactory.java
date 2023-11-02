package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.pets.Dog;

import java.util.Date;

public class DogFactory implements AbstractAnimalFactory<Dog>{

    @Override
    public Dog create(String name, Date bdate) {
        return new Dog(name, bdate);
    }
}