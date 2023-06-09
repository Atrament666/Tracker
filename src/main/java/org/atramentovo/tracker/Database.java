/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 *
 * @author Atrament
 */
public class Database {

    private final Map<Student, StudentsRecord> studentsRecords;
    private final Map<Course, Integer> activity;

    public Database() {
        this.studentsRecords = new HashMap<>();
        this.activity = new HashMap();
        for (Course c : Course.values()) {
            activity.put(c, 0);
        }
    }

    public void addStudent(Student student) {
        if (!studentsRecords.keySet().contains(student)) {
            studentsRecords.put(student, new StudentsRecord());
        }
    }
    
    public Optional<Student> getStudent(int id) {
        return studentsRecords.keySet().stream().filter(s -> s.id() == id).findFirst();
    }

    public boolean emailExists(String email) {
        return studentsRecords.keySet().stream().filter(s -> s.email().equals(email)).findAny().isPresent();
    }

    public boolean studentIdExists(int id) {
        return studentsRecords.keySet().stream().filter(s -> s.id() == id).findAny().isPresent();
    }

    private Map<Course,Integer> createPopularityMap() {
        Map<Course, Integer> popularity = new HashMap<>();
        for (Course c : Course.values()) {
            popularity.put(c, 0);
        }
        studentsRecords.values().forEach(record -> {
            for (Course c : Course.values()) {
                if (record.getPoints(c) > 0) {
                    popularity.put(c, popularity.get(c) + 1);
                }
            }
        });
        return popularity;
    }

    public List<Course> getMostPopular() {
        var popularity = createPopularityMap();
        int highest = Collections.max(popularity.values());
        return popularity.entrySet().stream().filter(e -> e.getValue() == highest).map(e -> e.getKey()).toList();
    }

    public int getCourseActivity(Course course) {
        return activity.get(course);
    }

    public void updateStudentsRecord(Student student, String[] data) {
        StudentsRecord sr = studentsRecords.get(student);
        for (int i = 0; i < Course.values().length; i++) {
            sr.updateRecord(Course.values()[i], Integer.parseInt(data[i]));
            if (Integer.parseInt(data[i]) > 0) {
                activity.put(Course.values()[i], activity.get(Course.values()[i]) + 1);
            }
        }
    }

    public List<Course> getLeastPopular() {
        var popularity = createPopularityMap();
        int lowest = Collections.min(popularity.values());
        return popularity.entrySet().stream().filter(e -> e.getValue() == lowest).map(e -> e.getKey()).toList();
    }

    public List<Course> getHighestActivity() {
        int highest = Collections.max(activity.values());
        return activity.entrySet().stream().filter(e -> e.getValue() == highest).map(e -> e.getKey()).toList();
    }

    public List<Course> getLowestActivity() {
        int lowest = Collections.min(activity.values());
        return activity.entrySet().stream().filter(e -> e.getValue() == lowest).map(e -> e.getKey()).toList();
    }

    public List<Student> getStudentsForCourse(Course course) {
        return studentsRecords.entrySet().stream().filter(r -> r.getValue().getPoints(course) > 0).map(Entry::getKey).toList();
        
    }

    public List<Student> getStudents() {
        return studentsRecords.keySet().stream().toList();
    }
    
    public StudentsRecord getStudentsRecord(Student student) {
        return studentsRecords.get(student);
    }

    public double getCourseCompletion(int id, Course course) {
        Optional<Student> student = getStudent(id);
        if (student.isPresent()) {
            StudentsRecord record = studentsRecords.get(student.get());
            return ((double)record.getPoints(course) / course.getMaxPoints()) * 100;
        }
        return 0;
    }

}
