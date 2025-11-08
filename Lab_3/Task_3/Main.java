package Lab_3.Task_3;

// Импортируем библеотеки
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
// Импортируем другие классы.
import For_Sortings.Sorting;
import For_Sortings.Student;

public class Main {
    public static void main (String[] args) {
        //Student Sort ————————————————————————————
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vasya  ", 21));
        students.add(new Student("Anton  ", 22));
        students.add(new Student("Vasya  ", 19));
        students.add(new Student("Antonio", 23));
        //Создаем класс Sorting
        Sorting<Student> studentsSort = new MergeSort<Student>();
        studentsSort.sort(students);
        System.out.println("\nResult of Student Sort:");
        //Выводим результат...
        for(Student i : students) {
            System.out.print(i.getName() + " " + i.getAge() + "\n");
        }
        
        //Integer Sort ————————————————————————————
        List<Integer> arr = Arrays.asList(124, 1, 68, 57, 0, 93, 60, 24, 71, 125, 70, 87, 83, 105, 34, 30, 15, 1, 2);
        //Создаем класс Sorting
        Sorting<Integer> listSorting = new MergeSort<Integer>();
        listSorting.sort(arr);
        System.out.println("\nResult of Integer Sort:");
        //Выводим результат...
        for(int i : arr) { 
            System.out.print(i + " ");
        }

        //String Sort ————————————————————————————
        List<String> stringArr = Arrays.asList("World of Tanks", "WoW", "gd", "Clan war", "Clash Royale", "dota2");
        //Создаем класс Sorting
        Sorting<String> stringSort = new MergeSort<String>();
        stringSort.sort(stringArr);
        System.out.println("\n\nResult of String Sort:");
        //Выводим результат...
        for(String i : stringArr) {
            System.out.print(i + "\n");
        }

        //LocalDateTime Sort ————————————————————————————
        List<LocalDateTime> timeArr = Arrays.asList(LocalDateTime.of(1945, 4, 29, 23, 0),
        LocalDateTime.of(1945, 4, 29, 0, 0),
        LocalDateTime.of(2024, 1, 1, 10, 0),
        LocalDateTime.of(2024, 6, 15, 9, 0));
        //Создаем класс Sorting
        Sorting<LocalDateTime> timeSort = new MergeSort<LocalDateTime>();
        timeSort.sort(timeArr);
        System.out.println("\n\nResult of Time Sort");
        //Выводим результат...
        for(LocalDateTime i : timeArr) {
            System.out.print(i + "\n");
        }

        //UUID Sort ————————————————————————————
        List<UUID> UUIDArr = Arrays.asList(UUID.fromString("9bd25bc2-4b63-427d-b2da-3ec3bb22facd"),
        UUID.fromString("72dc1016-c1b4-4960-8332-4c65aa0e6e7f"),
        UUID.fromString("52ab7a0c-029f-4c1c-86dc-c51857c5caf4"),
        UUID.fromString("436bc49a-52d7-43f4-b463-85059aada829"));
        //Создаем класс Sorting
        Sorting<UUID> UUIDSort = new MergeSort<UUID>();
        UUIDSort.sort(UUIDArr);
        System.out.println("\n\nResult of Time Sort");
        //Выводим рузельтат...
        for(UUID i : UUIDArr) {
            System.out.print(i + "\n");
        }

    }
}
