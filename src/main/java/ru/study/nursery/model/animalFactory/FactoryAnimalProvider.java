package ru.study.nursery.model.animalFactory;

public class FactoryAnimalProvider {
    public static AbstractAnimalFactory getFactory(String choice) {
        switch (choice.toLowerCase()) {
            case "camel":
                return new CamelFactory();
            case "cat":
                return new CatFactory();
            case "dog":
                return new DogFactory();
            case "donkey":
                return new DonkeyFactory();
            case "hamster":
                return new HamsterFactory();
            case "horse":
                return new HorseFactory();
            default:
                return null;
        }
    }
}
