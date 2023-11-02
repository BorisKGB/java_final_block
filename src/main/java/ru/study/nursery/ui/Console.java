package ru.study.nursery.ui;

import ru.study.nursery.presenter.Presenter;

public class Console implements UI{
    private Presenter presenter;

    public Console() {
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
    }
}
