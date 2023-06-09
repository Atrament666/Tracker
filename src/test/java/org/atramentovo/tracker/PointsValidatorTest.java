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
public class PointsValidatorTest {
    
    private final PointsValidator pv = new PointsValidator();
    
    public PointsValidatorTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testIsValid() {
        assertTrue(pv.isValid("1001 10 10 10 10"));
        assertFalse(pv.isValid("1001 -10 10 10 10"));
        assertFalse(pv.isValid("10 10 10"));
        assertFalse(pv.isValid("1001 10 10 10 10 10"));
        assertFalse(pv.isValid("10000 ? 1 1 1"));
    }
    
}
