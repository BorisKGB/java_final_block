package ru.study.nursery.model.animalFactory;

import java.util.Date;

public interface AbstractAnimalFactory<T> {
    T create(String name, Date bdate);
}
