package ru.study.nursery.presenter;

import ru.study.nursery.model.NurseryService;
import ru.study.nursery.ui.UI;

public class Presenter {
    private UI view;
    private NurseryService model;

    public Presenter(UI view) {
        this.view = view;
        model = new NurseryService();
    }
}
