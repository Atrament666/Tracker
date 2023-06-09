/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.atramentovo.tracker;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author Atrament
 */
public class Menu {

    private final Stack<MenuLevel> menuStack;
    private Scanner sc;

    private static final int ID_START = 10000;

    public Menu(Database db, CredentialValidator credentialValidator, PointsValidator pointsValidator, InputStream inputStream) {
        this.sc = new Scanner(inputStream, Charset.defaultCharset());
        this.menuStack = new Stack<>();
        MenuLevel rootLevel = new MenuLevel("Learning progress tracker", "Enter 'exit' to exit the program.");

        rootLevel.addCommand(new Command("add students", () -> {
            String input;
            int counter = 0;
            while (true) {
                System.out.println("Enter student credentials or 'back' to return:");
                System.out.print("> ");
                input = sc.nextLine();
                if (input.equals("back")) {
                    break;
                }
                CredentialStatus result = credentialValidator.checkCredentialStatus(input);

                if (result == CredentialStatus.OK) {
                    String[] data = input.split(" ");
                    String firstName = data[0];
                    String lastName = Arrays.toString(Arrays.copyOfRange(data, 1, data.length - 2));
                    String email = data[data.length - 1];
                    if (db.emailExists(email)) {
                        System.out.println("This email is already taken.");
                    } else {
                        Student student = new Student(ID_START + counter, firstName, lastName, email);
                        db.addStudent(student);
                        System.out.println(result.getType());
                        counter++;
                    }

                } else {
                    System.out.println(result.getType());
                }
            }

            System.out.println("Total " + counter + " students have been added");
        }));

        rootLevel.addCommand(new Command("list", () -> {
            if (db.getStudents().isEmpty()) {
                System.out.println("No students found");
            } else {
                System.out.println("Students:");
                db.getStudents().stream().forEach(s -> System.out.println(s.id()));
            }
        }));

        rootLevel.addCommand(new Command("add points", () -> {
            String input;
            while (true) {
                System.out.println("Enter an id and points or 'back' to return.");
                System.out.print("> ");
                input = sc.nextLine();
                if (input.equals("back")) {
                    break;
                }
                if (pointsValidator.isValid(input)) {
                    String[] data = input.split(" ");
                    int studentId = Integer.parseInt(data[0]);
                    Optional<Student> student = db.getStudent(studentId);
                    if (student.isPresent()) {
                        db.updateStudentsRecord(student.get(), Arrays.copyOfRange(data, 1, data.length));
                        System.out.println("Points updated");
                    } else {
                        System.out.println("No students found for id=" + studentId);
                    }
                } else {
                    System.out.println("Incorrect points format");
                }

            }
        }));

        rootLevel.addCommand(new Command("find", () -> {
            System.out.println("Enter an id or 'back' to return.");
            System.out.print("> ");
            int id = Integer.parseInt(sc.nextLine());
            Optional<Student> std = db.getStudents().stream().filter(s -> s.id() == id).findFirst();
            if (std.isPresent()) {
                Student s = std.get();
                StudentsRecord record = db.getStudentsRecord(s);
                System.out.printf("%s points: Python=%s; DSA=%s; Databases=%s; Flask=%s%n",
                        s.id(),
                        record.getPoints(Course.Python),
                        record.getPoints(Course.DSA),
                        record.getPoints(Course.Databases),
                        record.getPoints(Course.Flask));

            } else {
                System.out.printf("No student is found for id=%s%n", id);
            }

        }));

        rootLevel.addCommand(new Command("statistics", () -> {
            System.out.println("Type the name of a course to see details or 'back' to quit: ");
            System.out.println("Most popular: " + db.getMostPopular().stream().map(Enum::toString).collect(Collectors.joining(",")));
            System.out.println("Least popular: " + db.getLeastPopular().stream().map(Enum::toString).collect(Collectors.joining(",")));
            System.out.println("Highest activity: " + db.getHighestActivity().stream().map(Enum::toString).collect(Collectors.joining(",")));
            System.out.println("Lowest activity: " + db.getLowestActivity().stream().map(Enum::toString).collect(Collectors.joining(",")));
            System.out.println("Easiest course: ");
            System.out.println("Hardest course: ");
            while (true) {
                System.out.print("> ");
                String cmd = sc.nextLine();
                if (cmd.equals("back")) {
                    break;
                }
                if (Arrays.stream(Course.values()).anyMatch(c -> c.name().equals(cmd))) {
                    Course course = Course.valueOf(cmd);
                    System.out.println(course.toString());
                    System.out.printf("id\tpoints\tcompleted\n");
                    List<Student> students = db.getStudentsForCourse(course);
                    for (Student s : students) {
                        StudentsRecord record = db.getStudentsRecord(s);
                        int points = record.getPoints(course);
                        double finished = (points / course.getMaxPoints()) * 100;
                        System.out.printf("%s\t%d\t%4.2f%%%n", s.id(), points, finished);
                    }
                } else {
                    System.out.println("Not a course name");
                }
            }

        }));

        rootLevel.addCommand(new Command("exit", menuStack::pop));
        menuStack.push(rootLevel);
    }

    public void show() {

        System.out.println("Learning progress tracker");

        while (!menuStack.isEmpty()) {
            MenuLevel currentLevel = menuStack.peek();

            System.out.println(currentLevel.getPrompt());
            //currentLevel.getCommands().stream().forEach(System.out::println);

            System.out.print("> ");
            String input = sc.nextLine().toLowerCase().trim();
            if (input.isEmpty()) {
                System.out.println("No input.");
                continue;
            }

            Optional<Command> cmd = currentLevel.getCommand(input);
            if (cmd.isPresent()) {
                cmd.get().execute();

            } else {
                System.out.println("Error: unknown command!");
            }
        }
        System.out.println("Bye!");

    }

}
