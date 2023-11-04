package ru.study.nursery.model.animalFactory;

import ru.study.nursery.model.animal.Animal;

import java.util.Calendar;

public interface AbstractAnimalFactory<T extends Animal> {
    T create(String name, Calendar bdate);
}
