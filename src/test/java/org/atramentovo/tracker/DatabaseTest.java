/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.atramentovo.tracker;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Atrament
 */
public class DatabaseTest {
    
    private Database db;
    private final Student john= new Student(10000, "John", "Doe", "johnd@email.net");
    private final Student jane = new Student(10001, "Jane", "Spark", "jspark@yahoo.com");
    private final Student mark = new Student(10002, "Mark", "Smith", "msmith@gmail.com");
    
    public DatabaseTest() {
        
    }
    
    @BeforeEach
    public void setUp() {
        db = new Database();
        db.addStudent(john);
        db.addStudent(jane);
        db.updateStudentsRecord(john, new String[]{"8", "7", "7", "5"});
        db.updateStudentsRecord(john, new String[]{"7", "6", "9", "7"});
        db.updateStudentsRecord(john, new String[]{"6", "5", "5", "0"});
        db.updateStudentsRecord(jane, new String[]{"8", "0", "8", "6"});
        db.updateStudentsRecord(jane, new String[]{"7", "0", "0", "0"});
        db.updateStudentsRecord(jane, new String[]{"9", "0", "0", "5"});
    }
    
    
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddStudent() {
        db.addStudent(mark);
        db.addStudent(mark);
        assertTrue(db.getStudents().size() == 3, "Actual number of students: " + db.getStudents().size());
    }
    

    @Test
    public void testEmailExists() {
        assertTrue(db.emailExists("johnd@email.net"));
        assertFalse(db.emailExists("atrament@gmail.com"));
    }

    @Test
    public void testStudentIdExists() {
        assertTrue(db.studentIdExists(10001));
        assertFalse(db.studentIdExists(999));
    }

   
    @Test
    public void testGetMostPopular() {
        List<Course> actual = db.getMostPopular();
        System.out.println(actual);
        List<Course> expected = List.of(Course.Python, Course.Databases, Course.Flask);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected));
    }
    
    @Test
    public void testGetLeastPopular() {
        List<Course> actual = db.getLeastPopular();
        System.out.println(actual);
        List<Course> expected = List.of(Course.DSA);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected));
    }

    @Test
    public void testGetCourseActivity() {
        assertTrue(db.getCourseActivity(Course.Python) == 6, "Python actual course activity " + db.getCourseActivity(Course.Python));
        assertTrue(db.getCourseActivity(Course.DSA) == 3, "Dsa actual course activity " + db.getCourseActivity(Course.DSA));
        assertTrue(db.getCourseActivity(Course.Databases) == 4, "Databases actual course activity " + db.getCourseActivity(Course.Databases));
        assertTrue(db.getCourseActivity(Course.Flask) == 4, "Flask actual course activity " + db.getCourseActivity(Course.Flask));
    }
    
     @Test
    public void testGetHighestActivity() {
        List<Course> actual = db.getHighestActivity();
        System.out.println(actual);
        List<Course> expected = List.of(Course.Python);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected));
    }
    
    @Test
    public void testGetLowestActivity() {
        List<Course> actual = db.getLowestActivity();
        System.out.println(actual);
        List<Course> expected = List.of(Course.DSA);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected));
    }

    @Test
    public void testUpdateStudentsRecord() {
        db.updateStudentsRecord(jane, new String[]{"5", "0", "0", "0"});
        assertTrue(db.getCourseActivity(Course.Python) == 7, "Python actual course activity " + db.getCourseActivity(Course.Python));
        assertTrue(db.getCourseActivity(Course.DSA) == 3, "Dsa actual course activity " + db.getCourseActivity(Course.DSA));
        assertTrue(db.getCourseActivity(Course.Databases) == 4, "Databases actual course activity " + db.getCourseActivity(Course.Databases));
        assertTrue(db.getCourseActivity(Course.Flask) == 4, "Flask actual course activity " + db.getCourseActivity(Course.Flask));
    }
    
    @Test
    public void testGetStudentsForCourse() {
        List<Student> expected = List.of(john,jane);
        List<Student> actual = db.getStudentsForCourse(Course.Python);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected));
        expected = List.of(john);
        actual = db.getStudentsForCourse(Course.DSA);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected));
    }
    
    @Test
    public void testCourseCompletion() {
        double expected = 4.0;
        double actual = db.getCourseCompletion(10001, Course.Python);
        assertTrue(expected == actual, "Actual completion was: " + actual);
    }
    
}
