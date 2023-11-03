package ru.study.nursery.ui.menu.command;

import ru.study.nursery.ui.UI;

public class ShowAnimals implements Command {
    private UI view;
    public ShowAnimals(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать список животных";
    }

    @Override
    public void exec() {
        view.showAnimals(false);
    }
}
