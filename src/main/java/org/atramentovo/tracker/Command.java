/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public class Command {

    private final String name;
    private final Runnable action;

    public Command(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        action.run();
    }

    @Override
    public String toString() {
        return name;
    }

}
