/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public enum Course {
    
    Python(600), DSA(400), Databases(480), Flask(550);
    
    private final int maxPoints;

    private Course(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
    
    @Override
    public String toString() {
        return name();
    }
}
