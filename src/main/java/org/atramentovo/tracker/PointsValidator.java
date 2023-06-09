/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public class PointsValidator {

    public boolean isValid(String string) {
        String[] parts = string.split(" ");
        if (parts.length > 5 || parts.length < 5) {
            return false;
        }
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part);
                if (number < 0) {
                    return false;
                }
            } catch (NumberFormatException ex) {
                return false;

            }
        }
        return true;
    }

}
