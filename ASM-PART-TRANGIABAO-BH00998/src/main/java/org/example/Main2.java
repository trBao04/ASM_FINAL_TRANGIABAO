package org.example;

import java.util.*;

class QuickSort {
    // QuickSort method
    public static void quickSort(List<Student> students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);
            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }
    private static int partition(List<Student> students, int low, int high) {
        Student pivot = students.get(high);
        double pivotMarks = pivot.getScore();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).getScore() >= pivotMarks) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, high);
        return i + 1;
    }
    public static void mergeSort(List<Student> students, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(students, left, middle);
            mergeSort(students, middle + 1, right);
            merge(students, left, middle, right);
        }
    }
    private static void merge(List<Student> students, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        List<Student> leftList = new ArrayList<>();
        List<Student> rightList = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            leftList.add(students.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(students.get(middle + 1 + j));
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getScore() >= rightList.get(j).getScore()) {
                students.set(k, leftList.get(i));
                i++;
            } else {
                students.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            students.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            students.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
    // Main Method for Performance Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter Number of Students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= numberOfStudents; i++) {
            String id = "ID" + i;
            String name = "Student " + i;
            double score = random.nextDouble() * 10; // Random marks between 0 and 10
            students.add(new Student(i, name, score));
        }
        System.out.println("Generated List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
        List<Student> studentsForQuickSort = new ArrayList<>(students);
        List<Student> studentsForMergeSort = new ArrayList<>(students);
        long quickSortTime = 0;
        long mergeSortTime = 0;
        while (true) {
            System.out.println("Select algorithm:");
            System.out.println("1. QuickSort");
            System.out.println("2. MergeSort");
            System.out.println("3. Compare the time of both algorithms");
            System.out.println("4. Exit");
            System.out.print("Enter selection: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    long startTimeQuickSort = System.nanoTime();
                    quickSort(studentsForQuickSort, 0, studentsForQuickSort.size() - 1);
                    long endTimeQuickSort = System.nanoTime();
                    quickSortTime = endTimeQuickSort - startTimeQuickSort;
                    System.out.println("Students sorted using QuickSort:");
                    for (Student student : studentsForQuickSort) {
                        System.out.println(student);
                    }
                    System.out.println("QuickSort Time: " + quickSortTime + " nanoseconds");
                    break;
                case 2:
                    long startTimeMergeSort = System.nanoTime();
                    mergeSort(studentsForMergeSort, 0, studentsForMergeSort.size() - 1);
                    long endTimeMergeSort = System.nanoTime();
                    mergeSortTime = endTimeMergeSort - startTimeMergeSort;
                    System.out.println("Students sorted using MergeSort:");
                    for (Student student : studentsForMergeSort) {
                        System.out.println(student);
                    }
                    System.out.println("MergeSort Time: " + mergeSortTime + " nanoseconds");
                    break;
                case 3:
                    studentsForQuickSort = new ArrayList<>(students);
                    studentsForMergeSort = new ArrayList<>(students);

                    if (quickSortTime == 0) {
                        quickSort(studentsForQuickSort, 0, studentsForQuickSort.size() - 1);
                    }
                    if (mergeSortTime == 0) {
                        mergeSort(studentsForMergeSort, 0, studentsForMergeSort.size() - 1);
                    }

                    System.out.println("QuickSort Time: " + quickSortTime + " nanoseconds");
                    System.out.println("MergeSort Time: " + mergeSortTime + " nanoseconds");
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}