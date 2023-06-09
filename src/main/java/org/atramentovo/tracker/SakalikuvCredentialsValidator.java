/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public class SakalikuvCredentialsValidator implements CredentialValidator{

    @Override
    public boolean isValidEmail(String string) {
        return string.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    }

    @Override
    public boolean isValidFirstName(String string) {
        return string.matches("^[a-zA-Z]+(-|')?[a-zA-Z]+$");
    }

    @Override
    public boolean isValidLastName(String string) {
        return string.matches("^[a-zA-Z]+((-|')?[ a-zA-Z]+)*(-|')?[a-zA-Z]+$");
    }

    @Override
    public CredentialStatus checkCredentialStatus(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
