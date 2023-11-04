package ru.study.nursery.presenter;

import ru.study.nursery.model.NurseryService;
import ru.study.nursery.ui.UI;

import java.util.List;

public class Presenter {
    private UI view;
    private NurseryService model;

    public Presenter(UI view) {
        this.view = view;
        model = new NurseryService();
    }

    public void showAnimals(boolean orderByDate) {
        List<String> animalStrings = model.getAnimalsDescription(orderByDate);
        if (animalStrings.isEmpty()) view.print(view.noData());
        else {
            StringBuilder result = new StringBuilder();
            for (String animalStr : animalStrings) {
                result.append(animalStr).append("\n");
            }
            view.print(result.toString());
        }
    }

    public void addTestData() {
        model.addTestData();
    }
}
