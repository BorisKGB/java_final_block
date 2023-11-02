package ru.study.nursery.model.animal;

import ru.study.nursery.model.command.Command;

import java.util.Date;
import java.util.List;

public abstract class Animal {
    private String name;
    private Date birthDate;
    private List<Command> commands;

    /**
     * Try to learn Command
     * By default animals can not learn
     * @param command to learn
     * @return learning result
     */
    public boolean learn(Command command) {
        return false;
    }
}