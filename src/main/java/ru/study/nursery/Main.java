package ru.study.nursery;

import ru.study.nursery.ui.Console;
import ru.study.nursery.ui.UI;

public class Main {
    public static void main(String[] args) {
        UI view = new Console();
        view.start();
    }
}
