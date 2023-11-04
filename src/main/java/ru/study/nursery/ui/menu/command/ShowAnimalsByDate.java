package ru.study.nursery.ui.menu.command;

import ru.study.nursery.ui.UI;

public class ShowAnimalsByDate implements Command {
    private UI view;
    public ShowAnimalsByDate(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать список животных(упорядоченный по дате)";
    }

    @Override
    public void exec() {
        view.showAnimals(true);
    }
}
