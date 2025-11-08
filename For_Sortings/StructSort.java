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
            return Integer.compare(s1.getage(), s2.getage());
        } );
        
    }
    public void sortByName(List<Student> students) {
        students.sort((s1, s2) -> {
            return s1.getname().compareTo(s2.getname());
        });
    }
}
