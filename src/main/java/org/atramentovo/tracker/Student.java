/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public record Student(int id, String firstName, String lastName, String email) {
    
    
    @Override
    public String toString() {
        return id + " " + lastName + ", " + firstName + ", e-mail: " + email; 
    }

}
