package For_Sortings;

import java.util.List;

public class StructSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        sortByAge(students);
        sortByName(students);
    }
    
    public void sortByAge(List<Student> students) {
        students.sort((s1, s2) -> {
            return Integer.compare(s1.getAge(), s2.getAge());
        } );
        
    }
    public void sortByName(List<Student> students) {
        students.sort((s1, s2) -> {
            return s1.getName().compareTo(s2.getName());
        });
    }
}
