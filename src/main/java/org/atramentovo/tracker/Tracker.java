/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.atramentovo.tracker;

/**
 *
 * @author Atrament
 */
public class Tracker {

    public static void main(String[] args) {
        Database db = new Database();
        CredentialValidator cv = new MyCredentialValidator();
        PointsValidator pv = new PointsValidator();
        Menu menu = new Menu(db, cv, pv, System.in);
        menu.show();
    }
}
