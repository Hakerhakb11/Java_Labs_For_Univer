package Lab_2.Task_3;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Vasya  ", 21));
        students.add(new Student("Anton  ", 22));
        students.add(new Student("Vasya  ", 19));
        students.add(new Student("Antonio", 23));
        int N = students.size();
        System.out.println(N);

        StructSort sorting = new StructSort();

        sorting.sortByAge(students);
        sorting.sortByName(students);
        
        for (Student obj : students) {
            System.out.println(obj.getname() + " " + obj.getage());
        }
    }
}