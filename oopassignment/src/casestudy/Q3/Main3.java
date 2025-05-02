package casestudy.Q3;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BabyClass babyClass = new BabyClass("BC001");
        MiddleClass middleClass = new MiddleClass("MC001");
        TopClass topClass = new TopClass("TC001");

        // Teachers (IDs are now integers converted to String)
        Teacher teacher1 = new Teacher(String.valueOf(1), "Ms. Sarah", "Early Childhood Educator");
        Teacher teacher2 = new Teacher(String.valueOf(2), "Mr. John", "Assistant");
        Teacher teacher3 = new Teacher(String.valueOf(3), "Ms. Emily", "Senior Teacher");

        try {
            babyClass.setAssignedTeacher(teacher1); // Should work
            middleClass.setAssignedTeacher(teacher2); // Now allowed
            topClass.setAssignedTeacher(teacher3);    // Now allowed
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Students (IDs are integers as strings)
        babyClass.enrollStudent(new Student(String.valueOf(1), "Emma", 2, "Mrs. Thompson"));
        middleClass.enrollStudent(new Student(String.valueOf(2), "Noah", 3, "Mr. Wilson"));
        middleClass.enrollStudent(new Student(String.valueOf(3), "Ava", 3, "Mrs. Garcia"));
        topClass.enrollStudent(new Student(String.valueOf(4), "Olivia", 4, "Mrs. Brown"));

        // Invalid enrollments
        babyClass.enrollStudent(new Student(String.valueOf(4), "Olivia", 4, "Mrs. Brown")); // Wrong age
        babyClass.enrollStudent(new Student(String.valueOf(1), "Duplicate", 2, "Someone")); // Duplicate

        // Activities
        babyClass.conductActivity("Finger Painting");
        babyClass.conductActivity("Music Time");
        middleClass.conductActivity("Storytelling");
        middleClass.conductActivity("Basic Counting");
        topClass.conductActivity("Alphabet Practice");
        topClass.conductActivity("Number Recognition");

        // Assessments
        topClass.conductAssessment("First Term");

        // Progress Tracking
        babyClass.trackProgress();
        middleClass.trackProgress();
        topClass.trackProgress();

        // Reports
        System.out.println(babyClass.generateClassReport());
        System.out.println(middleClass.generateClassReport());
        System.out.println(topClass.generateClassReport());

        // Menu
        boolean running = true;
        while (running) {
            System.out.println("\n===== NURSERY SCHOOL MANAGEMENT SYSTEM =====");
            System.out.println("1. Enroll a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Conduct an activity");
            System.out.println("4. Conduct an assessment (Top Class only)");
            System.out.println("5. Generate class reports");
            System.out.println("6. List all students");
            System.out.println("7. List all teachers");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> enrollNewStudent(scanner, babyClass, middleClass, topClass);
                case 2 -> addNewTeacher(scanner, babyClass, middleClass, topClass);
                case 3 -> conductActivity(scanner, babyClass, middleClass, topClass);
                case 4 -> {
                    System.out.print("Enter assessment term name: ");
                    String termName = scanner.nextLine();
                    topClass.conductAssessment(termName);
                }
                case 5 -> {
                    System.out.println(babyClass.generateClassReport());
                    System.out.println(middleClass.generateClassReport());
                    System.out.println(topClass.generateClassReport());
                }
                case 6 -> listAllStudents(babyClass, middleClass, topClass);
                case 7 -> {
                    System.out.println("Teachers:");
                    System.out.println(teacher1);
                    System.out.println(teacher2);
                    System.out.println(teacher3);
                }
                case 8 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Nursery School Management System!");
        scanner.close();
    }

    private static void enrollNewStudent(Scanner scanner, BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.print("Enter student ID (single digit 0–9): ");
        String studentId = scanner.nextLine();
        if (!studentId.matches("\\d") || studentId.length() != 1) {
            System.out.println("Invalid student ID. Must be one digit (0–9).");
            return;
        }

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        if (studentName.matches("\\d+")) {
            System.out.println("Invalid student name. Please enter a valid name.");
            return;
        }

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter guardian name: ");
        String guardianName = scanner.nextLine();

        Student student = new Student(studentId, studentName, age, guardianName);

        System.out.println("Select class to enroll:");
        System.out.println("1. Baby Class (Ages 2-3)");
        System.out.println("2. Middle Class (Ages 3-4)");
        System.out.println("3. Top Class (Ages 4-5)");
        System.out.print("Enter your choice: ");

        int classChoice = scanner.nextInt();
        scanner.nextLine();

        switch (classChoice) {
            case 1 -> babyClass.enrollStudent(student);
            case 2 -> middleClass.enrollStudent(student);
            case 3 -> topClass.enrollStudent(student);
            default -> System.out.println("Invalid choice. Student not enrolled.");
        }
    }

    private static void addNewTeacher(Scanner scanner, BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.print("Enter teacher ID (single digit 0–9): ");
        String teacherId = scanner.nextLine();
        if (!teacherId.matches("\\d") || teacherId.length() != 1) {
            System.out.println("Invalid teacher ID. Must be one digit (0–9).");
            return;
        }

        System.out.print("Enter teacher name: ");
        String teacherName = scanner.nextLine();
        if (teacherName.matches("\\d+")) {
            System.out.println("Invalid teacher name. Please enter a valid name.");
            return;
        }

        System.out.println("Select teacher role:");
        System.out.println("1. Early Childhood Educator");
        System.out.println("2. Assistant");
        System.out.println("3. Senior Teacher");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        String teacherRole = switch (roleChoice) {
            case 1 -> "Early Childhood Educator";
            case 2 -> "Assistant";
            case 3 -> "Senior Teacher";
            default -> "Assistant";
        };

        Teacher teacher = new Teacher(teacherId, teacherName, teacherRole);

        System.out.println("Assign teacher to class:");
        System.out.println("1. Baby Class (requires Early Childhood Educator)");
        System.out.println("2. Middle Class");
        System.out.println("3. Top Class");
        int classChoice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (classChoice) {
                case 1 -> babyClass.setAssignedTeacher(teacher);
                case 2 -> middleClass.setAssignedTeacher(teacher);
                case 3 -> topClass.setAssignedTeacher(teacher);
                default -> System.out.println("Invalid class. Teacher not assigned.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void conductActivity(Scanner scanner, BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.print("Enter activity name: ");
        String activityName = scanner.nextLine();

        System.out.println("Select class for activity:");
        System.out.println("1. Baby Class");
        System.out.println("2. Middle Class");
        System.out.println("3. Top Class");
        int classChoice = scanner.nextInt();
        scanner.nextLine();

        switch (classChoice) {
            case 1 -> babyClass.conductActivity(activityName);
            case 2 -> middleClass.conductActivity(activityName);
            case 3 -> topClass.conductActivity(activityName);
            default -> System.out.println("Invalid class. Activity not conducted.");
        }
    }

    private static void listAllStudents(BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.println("Baby Class Students:");
        for (Student student : babyClass.getStudents()) {
            System.out.println(student);
        }

        System.out.println("\nMiddle Class Students:");
        for (Student student : middleClass.getStudents()) {
            System.out.println(student);
        }

        System.out.println("\nTop Class Students:");
        for (Student student : topClass.getStudents()) {
            System.out.println(student);
        }
    }
}
