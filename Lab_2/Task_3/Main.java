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
        
        students.sort((s1, s2) -> {
            return Integer.compare(s1.getage(), s2.getage());
        } );
        
        students.sort((s1, s2) -> {
            return s1.getname().compareTo(s2.getname());
        });
     
        for (Student obj : students) {
            System.out.println(obj.getname() + " " + obj.getage());
        }
    }
}