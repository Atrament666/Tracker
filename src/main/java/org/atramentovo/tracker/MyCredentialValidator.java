/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public class MyCredentialValidator implements CredentialValidator {

    @Override
    public boolean isValidEmail(String string) {
        if ((string.startsWith(".") || string.startsWith("@") || string.endsWith(".") || string.endsWith("@"))) {
            return false;
        }
        return (string.contains("@") && string.contains("."));
    }

    @Override
    public boolean isValidFirstName(String string) {
        return isValidLastName(string);

    }

    @Override
    public boolean isValidLastName(String string) {
        //string can't be shorter than 2 characters
        if (string.length() < 2) {
            return false;
        }

        //shouldn't start or end with - or '
        if (string.startsWith("-") || string.startsWith("'") || string.endsWith("-") || string.endsWith("'")) {
            return false;
        }

        //shouldn't contain -- or ''
        if (string.contains("--") || string.contains("''")) {
            return false;
        }

        for (var c : string.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                return c == '\'' || c == '-';

            }
        }

        return true;
    }

    @Override
    public CredentialStatus checkCredentialStatus(String input) {
        String[] parts = input.split(" ");
        if (parts.length < 3) {
            return CredentialStatus.IncorrectCredentials;
        }
        if (!isValidFirstName(parts[0])) {
            return CredentialStatus.IncorrectFirst;
        }

        for (int i = 1; i < parts.length - 1; i++) {
            if (!isValidFirstName(parts[i])) {
                return CredentialStatus.IncorrectLast;
            }

        }

        if (!isValidEmail((parts[parts.length - 1]))) {
            return CredentialStatus.IncorrectEmail;
        }

        return CredentialStatus.OK;
    }

    

}
