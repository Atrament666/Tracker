/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Atrament
 */
public class StudentsRecord {
    
    private final Map<Course, Integer> points;
    private final Map<Course, Integer> activity;

    public StudentsRecord() {
        points = new HashMap<>();
        activity = new HashMap<>();
         for (Course c : Course.values()) {
            points.put(c, 0);
            activity.put(c, 0);
        }
    }
    
    
    public void updateRecord(Course course, int value) {
        points.put(course, points.get(course) + value);
        activity.put(course, activity.get(course) + 1);
        
    }
  
    public int getPoints(Course course) {
        return points.get(course);
    }
    
    public int getActivity(Course course) {
        return activity.get(course);
    }
    
    
    
    
    
    
}
