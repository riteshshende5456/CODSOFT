import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    void display() {
        System.out.println(rollNo + "\t" + name + "\t" + grade);
    }
}

// Main class
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add student
    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(roll, name, grade));
        System.out.println("Student added successfully!");
    }

    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nRollNo\tName\tGrade");
        for (Student s : students) {
            s.display();
        }
    }

    // Search student
    static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Student Found:");
                System.out.println("RollNo: " + s.rollNo);
                System.out.println("Name: " + s.name);
                System.out.println("Grade: " + s.grade);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Remove student
    static void removeStudent() {
        System.out.print("Enter Roll Number to remove: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                students.remove(s);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: removeStudent(); break;
                case 5: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
