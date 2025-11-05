package For_Sortings;

import java.util.List;

interface Sorting<T extends Comparable<T>> {
    void sort(List<T> list);
}
//Integer подсвечен жолтым почему?? без этого ошибки все красное
interface Sorting2<Integer> {
    void sort(int arr[]);
}
