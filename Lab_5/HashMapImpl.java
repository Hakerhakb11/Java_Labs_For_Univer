package Lab_5;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    private List<List<Data<V>>> map;
    private List<Integer> arr = new ArrayList<>(); //To debug

    public HashMapImpl() {
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

        List<Data<V>> equalHashList = map.get(keyHash);
        for (Data<V> data : equalHashList) {
            if (data.getKey().equals(key)) {
                data.setValue(value);
                return;
            }
        }
        equalHashList.add(new Data<>(key, value));

        // To debug
        if (!arr.contains(keyHash)) {
            arr.add(keyHash);
        }
    }


    @Override
    public V getValue(String key) {
        int keyHash = (int)hashByString(key);
        for (int i = 0; i < map.get(keyHash).size(); i++) {
            if (map.get(keyHash).get(i).getKey() == key) {
                V object = map.get(keyHash).get(i).getValue();
                return object;
            }
        }
        return null;
    }


    @Override
    public V delete(String key) {
        int keyHash = (int)hashByString(key);

        List<Data<V>> equalHashList = map.get(keyHash);
        for (int i = 0; i < equalHashList.size(); i++) {
            if (equalHashList.get(i).getKey() == key) {
                V removed = equalHashList.get(i).getValue();
                equalHashList.remove(i);

                // To debug
                if (equalHashList.isEmpty()) {
                    for (int j = 0; j < arr.size(); j++) {
                        if (arr.get(j) == keyHash) {
                            arr.remove(j);
                        }
                    } 
                }
                return removed;
            }
        }
        return null;
    }

    
    //Func to debug-print map.
    @Override
    public String toString() {
        System.out.println("------------------------------------");
        for(int i = 0; i < arr.size(); i++) {
            List<Data<V>> byKey = map.get(arr.get(i));
            for (Data<V> data : byKey) {
                System.out.print("<" + data.getKey() + ", ");
                System.out.print(data.getValue() + "> : hash=");
                System.out.println(arr.get(i));
            }
        }
        System.out.println("");
        return "";
    }
} 
