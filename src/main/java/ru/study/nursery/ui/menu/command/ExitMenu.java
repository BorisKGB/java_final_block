package ru.study.nursery.ui.menu.command;

import ru.study.nursery.ui.UI;
import ru.study.nursery.ui.menu.MainMenu;
import ru.study.nursery.ui.menu.Menu;

public class ExitMenu implements Command {
    private UI view;
    private Menu menu;
    public ExitMenu(UI view, Menu menu) {
        this.view = view;
        this.menu = menu;
    }

    @Override
    public String getDescription() {
        if (menu.getClass().equals(MainMenu.class)) return "Завершить программу";
        else return "Выйти из меню";
    }

    @Override
    public void exec() {
        menu.unsetActive();
    }
}
