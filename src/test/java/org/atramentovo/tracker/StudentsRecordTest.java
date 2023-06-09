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
public class StudentsRecordTest {

    public StudentsRecordTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testUpdateRecord() {
        StudentsRecord sr = new StudentsRecord();
        sr.updateRecord(Course.DSA, 7);
        sr.updateRecord(Course.DSA, 9);
        sr.updateRecord(Course.Python, 3);

        assertTrue(sr.getActivity(Course.DSA) == 2);
        assertTrue(sr.getActivity(Course.Python) == 1);
        assertTrue(sr.getActivity(Course.Databases) == 0);
        assertTrue(sr.getActivity(Course.Flask) == 0);

        assertTrue(sr.getPoints(Course.DSA) == 16);
        assertTrue(sr.getPoints(Course.Python) == 3);
        assertTrue(sr.getPoints(Course.Databases) == 0);
        assertTrue(sr.getPoints(Course.Flask) == 0);
    }

}
