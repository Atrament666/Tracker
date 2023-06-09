/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public interface CredentialValidator {

    boolean isValidEmail(String string);

    boolean isValidFirstName(String string);
    
    boolean isValidLastName(String string);
    
    CredentialStatus checkCredentialStatus(String string);
    
}
