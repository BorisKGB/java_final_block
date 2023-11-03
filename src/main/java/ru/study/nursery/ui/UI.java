package ru.study.nursery.ui;

public interface UI {
    void print(String text);
    void start();
    void finish();
    String noData();
    void addAnimal();
    void getAnimalCount();
    void showAnimals(boolean orderByDate);
}
