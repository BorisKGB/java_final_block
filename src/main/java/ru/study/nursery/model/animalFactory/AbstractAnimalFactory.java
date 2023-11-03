package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.animal.Animal;

import java.util.Date;

public interface AbstractAnimalFactory<T extends Animal> {
    T create(String name, Date bdate);
}
