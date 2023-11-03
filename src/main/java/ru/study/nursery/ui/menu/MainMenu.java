package ru.study.nursery.ui.menu;

import ru.study.nursery.ui.UI;
import ru.study.nursery.ui.menu.command.*;

public class MainMenu extends Menu {
    public MainMenu(UI view) {
        super(view, true, "Главное меню\n",
                new ShowAnimals(view),
                new ShowAnimalsByDate(view),
                new AddAnimal(view),
                new GetAnimalCount(view)
        );
    }


}