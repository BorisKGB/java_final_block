package ru.study.nursery.model.animal;

import ru.study.nursery.model.command.Command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.study.nursery.model.NurseryService.numberInRange;

public abstract class Animal {
    private String name;
    private final Date birthDate;
    private List<Command> commands;
    private final short max_commands = 0;
    private final byte learn_probability = 0;

    public Animal(String name, Date bdate) {
        this(name, bdate, null);
    }

    public Animal(String name, Date bdate, List<Command> commands) {
        this.name = name;
        this.birthDate = bdate;
        if (commands == null) commands = new ArrayList<>();
        this.commands = commands;
    }

    /**
     * Try to learn Command
     * By default animals can not learn
     * @param command to learn
     * @return learning result
     */
    public boolean learn(Command command) {
        if (commands != null && commands.size() < max_commands && numberInRange(0, 100) <= learn_probability) {
            commands.add(command);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public short getMax_commands() {
        return max_commands;
    }

    public byte getLearn_probability() {
        return learn_probability;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", commands=" + commands +
                '}';
    }
}