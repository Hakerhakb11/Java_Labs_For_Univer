package Lab_2.Task_3;

import java.util.List;

// Этот интерфейс я переместил сюда так как импортировать не могу.
// А было бы очень круто новерное если бы import просто так работал, так как я задумывал.
interface Sorting<T extends Comparable<T>> {
    void sort(List<T> list);
}
