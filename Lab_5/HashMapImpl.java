package Lab_5;

import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    ArrayList<LinkedList<Data<V>>> map;

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
        LinkedList<Data<V>> list = new LinkedList<>();
        list.add(new Data<>(key, value));
        map.set(keyHash, list);

        // To debug
        int check = 0;
        for(int obj : arr) {
            if (obj == keyHash) {
                check = 1;
            }
        } if (check == 0) {
            arr.add(keyHash);
        }
        // To debug
    }


    @Override
    public V getValue(String key) {
        int keyHash = (int)hashByString(key);
        for (int i = 0; i < map.get(keyHash).size(); i++) {
            if (map.get(keyHash).get(i).getKey() == key) {
                V object = map.get(keyHash).get(i).getValue();
                System.out.println(object);
                return object;
            }
        }
        System.out.println("null");
        return null;
    }


    @Override
    public V delete(String key) {
        int keyHash = (int)hashByString(key);
        for (int i = 0; i < map.get(keyHash).size(); i++) {
            if (map.get(keyHash).get(i).getKey() == key) {
                V removed = map.get(keyHash).get(i).getValue();
                map.set(keyHash, new LinkedList<>());
                return removed;
            }
        }
        
        // To debug
        for(int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == keyHash) {
                arr.remove(i);
            }
        } 
        // To debug
        System.out.println("null");
        return null;
    }

    
    //Func to debug-print map.
    @Override
    public String toString() {
        System.out.println("------------------------------------");
        for(int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < map.get(arr.get(i)).size(); j++) {
                System.out.print(map.get(arr.get(i)).get(j).getKey() + " - ");
                System.out.print(map.get(arr.get(i)).get(j).getValue() + ": ");
                System.out.println(arr.get(i));
            }
        }System.out.println("");
        return "";
    }
} 
