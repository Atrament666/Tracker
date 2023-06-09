/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.atramentovo.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Atrament
 */
public class CredentialsValidatorTest {
    
    //private final CredentialValidator cv = new CredentialValidator();
    private final CredentialValidator cv = new SakalikuvCredentialsValidator();

    public CredentialsValidatorTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testIsValidEmail() {
        
        assertTrue(cv.isValidEmail("atrament@gmail.com"));
        assertTrue(cv.isValidEmail("atrament.black@gmail.com"));
        assertFalse(cv.isValidEmail("sadkfj"));
        assertFalse(cv.isValidEmail("atrament@gmail"));
        assertFalse(cv.isValidEmail("@gmail"));
        assertFalse(cv.isValidEmail("a"));
        assertFalse(cv.isValidEmail("atrament.gmail@"));
    }

    @Test
    public void testIsValidFirstName() {
        
        assertTrue(cv.isValidFirstName("John"));
        assertTrue(cv.isValidFirstName("Jo"));
        assertTrue(cv.isValidFirstName("Jean-Luc"));
        
        assertFalse(cv.isValidFirstName("J"));
        assertFalse(cv.isValidFirstName("~John1"));
        assertFalse(cv.isValidFirstName("-John"));
        assertFalse(cv.isValidFirstName("John-"));
        assertFalse(cv.isValidFirstName("'John1"));
        assertFalse(cv.isValidFirstName("John1'"));
        assertFalse(cv.isValidFirstName("Joh''n"));
        assertFalse(cv.isValidFirstName("Joh--n"));
        assertFalse(cv.isValidFirstName("J."));
    }
    
    @Test
    public void testIsValidLastName() {
        assertTrue(cv.isValidLastName("O'Neill"));
        assertTrue(cv.isValidLastName("van der Graaf"));
        
    }

}
