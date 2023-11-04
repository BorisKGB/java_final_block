package ru.study.nursery.model;

import ru.study.nursery.model.animal.Animal;
import ru.study.nursery.model.animalFactory.AbstractAnimalFactory;
import ru.study.nursery.model.animalFactory.FactoryAnimalProvider;
import ru.study.nursery.model.command.Command;
import ru.study.nursery.model.command.CommandList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Random;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class NurseryService {
    private final List<Animal> animals;
    private final CommandList availableCommands;
    private int animalCounter;

    public static int numberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min)+1) + min;
    }

    public NurseryService() {
        animalCounter = 0;
        animals = new ArrayList<>();
        availableCommands = CommandList.getInstance();
    }

    public List<String> getAnimalTypes() {
        return FactoryAnimalProvider.availableAnimalClass;
    }

    @SuppressWarnings("unchecked")
    public boolean addAnimal(String type, String name, Calendar bdate) {
        AbstractAnimalFactory<Animal> factory = FactoryAnimalProvider.getFactory(type);
        if (factory != null) {
            animals.add(factory.create(name, bdate));
            animalCounter++;
            return true;
        }
        else return false;
    }

    public int getAnimalCounter(){
        return animalCounter;
    }

    public Set<String> getAvailableCommands(){
        return availableCommands.listAvailableCommandsNames();
    }

    /**
     * Search for animal by name ignore Case
     * @param name name to search
     * @return Animal obj or null
     */
    private Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) return animal;
        }
        return null;
    }

    private boolean teachCommand(Animal animal, Command command) {
        if (animal != null) {
            if (command != null) return animal.learn(command);
        }
        return false;
    }

    public boolean teachCommand(String animalName, String commandName) {
        return teachCommand(getAnimalByName(animalName), availableCommands.getCommand(commandName));
    }

    private List<String> getAnimalCommandNames(Animal animal)
    {
        List<String> result = new ArrayList<>();
        if (animal != null) {
            List<Command> commands = animal.getCommands();
            if (commands != null) {
                for (Command command : commands) {
                    result.add(command.toString());
                }
            }
        }
        return result;
    }

    public List<String> getAnimalCommandNames(String name) {
        return getAnimalCommandNames(getAnimalByName(name));
    }

    private String getAnimalDescription(Animal animal) {
        if (animal != null) {
            return animal.toString();
        }
        else return null;
    }

    private String getAnimalDescription(String name) {
        return getAnimalDescription(getAnimalByName(name));
    }

    public List<String> getAnimalsDescription() {
        return getAnimalsDescription(false);
    }

    public List<String> getAnimalsDescription(boolean sortByDate) {
        List<Animal> animalList = animals;
        if (sortByDate) {
            animalList = new ArrayList<>(animals);
            animalList.sort((Comparator.comparing(Animal::getBirthDate)));
        }
        List<String> result = new ArrayList<>();
        for (Animal animal : animalList) {
            result.add(getAnimalDescription(animal));
        }
        return result;
    }
}
