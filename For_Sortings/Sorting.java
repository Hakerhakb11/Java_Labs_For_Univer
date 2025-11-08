package For_Sortings;

import java.util.List;

public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> list);
}
