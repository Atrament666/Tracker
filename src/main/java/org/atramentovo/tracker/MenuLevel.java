/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Atrament
 */
public class MenuLevel {

    private final String name;
    private final String prompt;
    private final List<Command> commands;

    public MenuLevel(String name, String prompt) {
        this.name = name;
        this.prompt = prompt;
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public Optional<Command> getCommand(String key) {
        return commands.stream().filter(command -> command.getName().equals(key)).findFirst();
    }

    public String getName() {
        return name;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public String getPrompt() {
        return prompt;
    }
    

}
