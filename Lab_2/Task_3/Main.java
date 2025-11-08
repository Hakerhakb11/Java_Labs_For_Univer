package Lab_2.Task_3;

import java.util.*;
import For_Sortings.Sorting;
import For_Sortings.StructSort;
import For_Sortings.Student;

class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Vasya  ", 21));
        students.add(new Student("Anton  ", 22));
        students.add(new Student("Vasya  ", 19));
        students.add(new Student("Antonio", 23));
        System.out.println(students.size());

        Sorting<Student> sorting = new StructSort();
        sorting.sort(students);

        for (Student obj : students) {
            System.out.println(obj.getname() + " " + obj.getage());
        }
    }
}