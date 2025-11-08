package For_Sortings;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getname() { return name; }
    public int getage() { return age; }
}
