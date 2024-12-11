package org.example;
import java.util.Comparator;
import java.util.Stack;

public class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement() {
        studentStack = new StudentStack();
    }
    public boolean isIdDuplicate(int id) {
        StudentStack.Node current = studentStack.getTop();
        while (current != null) {
            if (current.student.getId() == id) {
                return true; // ID already exists
            }
            current = current.next;
        }
        return false; // ID is not duplicated
    }

    // Add student to stack
    public void addStudent(Student student) {
        studentStack.push(student);
        displayStudents();
    }
    // Update student information by ID
    public void updateStudent(int id, String newName, double newScore) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                tempStack.push(new Student(id, newName, newScore));
                found = true;
            } else {
                tempStack.push(student);
            }
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student with ID " + id + " updated successfully.");
        } else {
            System.out.println("No student found with ID: " + id);
        }
        displayStudents();
    }

    // Delete student by ID
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack();

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            }
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
        System.out.println("Deleted student with ID: " + id);
        displayStudents();
    }
    // Sort students by score
    public void sortByScore() {
        if (studentStack.isEmpty()) {
            System.out.println("Stack is empty. No students to sort.");
            return;
        }

        StudentStack sortedStack = new StudentStack();
        while (!studentStack.isEmpty()) {
            Student temp = studentStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek().getScore() <
                    temp.getScore()) {
                studentStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            studentStack.push(sortedStack.pop());
        }
        System.out.println("Students sorted by score.");
        displayStudents();
    }
    // Find students by name
    public void searchStudentByName(String name) {
        StudentStack.Node current = studentStack.getTop();
        boolean found = false;
        while (current != null) {
            if (current.student.getName().equalsIgnoreCase(name)) {
                System.out.println("Found students: " + current.student);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }
    // Show all students
    public void displayStudents() {
        if (studentStack.isEmpty()) {
            System.out.println("There are no students.");
            return;
        }
        studentStack.displayStudents();
    }
}


