package ru.study.nursery.presenter;

import ru.study.nursery.model.NurseryService;
import ru.study.nursery.ui.UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public void getAnimalCount() {
        view.print(String.format("Животных учтено: %d", model.getAnimalCounter()));
    }

    public void showAnimalTypes() {
        List<String> animalTypes = model.getAnimalTypes();
        for (int i = 0; i < animalTypes.size(); i++) {
            view.print(String.format("%d. %s", i+1, animalTypes.get(i)));
        }
    }
    public List<String> getAnimalTypes() {
        return model.getAnimalTypes();
    }

    public boolean addAnimal(int animalTypeNumber, String name, String birthDateStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(birthDateStr));
            return model.addAnimal(model.getAnimalTypes().get(animalTypeNumber-1), name, cal);
        } catch (ParseException e) {
            return false;
        }
    }
}
