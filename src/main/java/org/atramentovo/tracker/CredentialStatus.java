/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public enum CredentialStatus {

    OK("Student has been added"), IncorrectCredentials("Incorrect credentials."), IncorrectFirst("Incorrect first name."), IncorrectLast("Incorrect last name."), IncorrectEmail("Incorrect email.");

    private final String type;

    private CredentialStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    

}
