package org.example;
public class StudentStack {
    Node top;
    // Node in stack
    static class Node {
        Student student;
        Node next;
        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }
    // Add student to stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }
    // Get student from stack
    public Student pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        Student student = top.student;
        top = top.next;
        return student;
    }
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    // View top student
    public Student peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top.student;
    }
    // Show all students
    public void displayStudents() {
        Node current = top;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
    public Node getTop() {
        return top;
    }
}
