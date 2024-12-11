package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        while (true) {
            System.out.println("-----------Menu-----------");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Score");
            System.out.println("5. Search Student by Name");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.println("--------------------------");
            System.out.print ("Enter your selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear newline character
                    if (studentManagement.isIdDuplicate(id)) {
                        System.out.println("ID already exists. Please enter a unique ID.");
                        break; // Do not add student if ID is duplicated
                    }
                    String name;
                    while (true) {
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();
                        if (name.matches("[a-zA-Z\\s]+")) {
                            break;
                        } else {
                            System.out.println("Invalid name. Please enter only letters and spaces.");
                        }
                    }
                    System.out.print("Enter student scores: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine(); // Clear newline character
                    studentManagement.addStudent(new Student(id, name, score));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    double newMark = scanner.nextDouble();
                    scanner.nextLine();
                    studentManagement.updateStudent(updateId, newName, newMark);
                    System.out.println("Information updated successfully");
                    break;
                case 3:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    studentManagement.deleteStudent(deleteId);
                    System.out.println("Delete information successfully");
                    break;
                case 4:
                    studentManagement.sortByScore();
                    break;
                case 5:
                    System.out.print("Enter the name of the student to search: ");
                    String searchName = scanner.nextLine();
                    studentManagement.searchStudentByName(searchName);
                    break;
                case 6:
                    studentManagement.displayStudents();
                    break;
                case 7:
                    System.out.println("See you again.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


