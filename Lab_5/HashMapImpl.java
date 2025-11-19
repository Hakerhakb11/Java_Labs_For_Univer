package Lab_5;

import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    ArrayList<LinkedList<Data>> map;
    ArrayList<Integer> arr = new ArrayList<>(); //To debug

    
    HashMapImpl() {
        map = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            map.add(new LinkedList<>());
        }
    }

    /**
     * Алгоритм хеширования строк.
    *
    * @param value ключ, по которому сохранится значение в хэш-таблицу
    * @return значение хэша
    */
   private long hashByString(String value) {
       long hash = 0;
       for (Character ch : value.toCharArray()) {
           hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }
    
    @Override
    public void put(String key, V value) {
    int keyHash = (int)hashByString(key);
    LinkedList<Data> list = new LinkedList<>();
    list.add(new Data<>(key, value));
    map.set(keyHash, list);
    arr.add(keyHash); // to debug.
    }

    
    @Override
    public V getValue(String key) {
	// TODO
        return null;
    }

    @Override
    public V delete(String key) {
	// TODO
        return null;
    }

    //Func to debug print map
    @Override
    public String toString() {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(map.get(arr.get(i).intValue()).get(0).getKey() + ": ");
            System.out.println(arr.get(i));
            // System.out.println(map.get(1).get(0).getKey());
        }
        return "";
    }
} 
