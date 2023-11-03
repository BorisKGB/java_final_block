package ru.study.nursery.model.command;

class AbstractCommand implements Command {
    private final String name = null;
    @Override
    public String exec() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
