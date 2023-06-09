/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Atrament
 */
public class AppTest {

    @Test
    public void testStage4() {
        Database db = new Database();
        MyCredentialValidator cv = new MyCredentialValidator();
        PointsValidator pv = new PointsValidator();
        String inputString
                = "add students" + System.lineSeparator()
                + "John Doe johnd@email.net" + System.lineSeparator()
                + "Jane Spark jspark@yahoo.com" + System.lineSeparator()
                + "back" + System.lineSeparator()
                + "list" + System.lineSeparator()
                + "add points" + System.lineSeparator()
                + "10000 8 7 7 5" + System.lineSeparator()
                + "10000 7 6 9 7" + System.lineSeparator()
                + "10000 6 5 5 0" + System.lineSeparator()
                + "10001 8 0 8 6" + System.lineSeparator()
                + "10001 7 0 0 0" + System.lineSeparator()
                + "10001 9 0 0 5" + System.lineSeparator()
                + "back" + System.lineSeparator()
                + "statistics" + System.lineSeparator()
                + "Python" + System.lineSeparator()
                + "DSA" + System.lineSeparator()
                + "Databases" + System.lineSeparator()
                + "Flask" + System.lineSeparator()
                + "back" + System.lineSeparator()
                + "exit";

        Menu menu = new Menu(db, cv, pv, new ByteArrayInputStream(inputString.getBytes()));

        menu.show();

    }

}
