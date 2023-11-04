package ru.study.nursery.ui;

import ru.study.nursery.presenter.Presenter;
import ru.study.nursery.ui.menu.MainMenu;
import ru.study.nursery.ui.menu.Menu;

import java.util.Scanner;

public class Console implements UI{
    private static final String GREETING = "Hello.";
    private static final String FAREWELL = "Have a nice day.";
    private static final String WRONGCHOICE = "Такого пункта нет, попробуйте ещё раз.";
    private static final String NODATA = "Нет данных";
    private Scanner scanner;
    private Presenter presenter;
    private boolean active;

    public Console() {
        scanner = new Scanner(System.in);
        active = false;
        presenter = new Presenter(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        active = true;
        print(GREETING);
        enterMainMenu();
        finish();
    }

    @Override
    public void finish() {
        active = false;
        print(FAREWELL);
    }

    private void enterMainMenu() {
        Menu mainMenu = new MainMenu(this);
        enterMenu(mainMenu);
    }

    private void enterMenu(Menu menu) {
        menu.setActive();
        while (active && menu.isActive()) {
            printMenu(menu);
            userInteract(menu);
        }
    }

    private void printMenu(Menu menu){
        print(menu.buildMenu());
    }

    private void userInteract(Menu menu) {
        String userInput = scanner.nextLine();
        int choice = parseInput(userInput, menu);
        if (choice != -1) {
            menu.exec(choice);
        } else {
            print(WRONGCHOICE);
        }
    }

    private int parseInput(String input, Menu menu) {
        if (input.matches("^\\d+$")) {
            int numInput = Integer.parseInt(input);
            if (numInput > 0 && numInput <= menu.size()) return numInput;
        }
        return -1;
    }

    @Override
    public String noData() {
        return NODATA;
    }

    @Override
    public void addAnimal() {
        print("add");
        return;
    }

    @Override
    public void getAnimalCount() {
        print("count");
        return;
    }

    @Override
    public void showAnimals(boolean orderByDate) {
        presenter.showAnimals(orderByDate);
    }

    @Override
    public void addTestData() {
        presenter.addTestData();
    }
}
