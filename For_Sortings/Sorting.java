package For_Sortings;

import java.util.List;

// Этот интерфейс будет общим для всех остальных сортировок
interface Sorting<T extends Comparable<T>> {
    void sort(List<T> list);
}

interface Sorting2<T extends Comparable<T>> {
    void sort(int arr[]);
}
