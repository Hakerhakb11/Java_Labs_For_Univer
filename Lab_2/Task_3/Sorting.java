package Lab_2.Task_3;

import java.util.List;

interface Sorting<T extends Comparable<T>> {
    void sort(List<T> list);
}
