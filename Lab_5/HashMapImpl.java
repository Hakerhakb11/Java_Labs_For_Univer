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
        System.out.println("ALL NECESSARY INFO: " + key + "\n2 " + value + "\n3 " + keyHash);
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
        
        return null;
    }

    @Override
    public V delete(String key) {
        int keyHash = (int)hashByString(key);
        map.remove(keyHash);
        System.out.println("DELETE PRINT: " + keyHash + "\narr size: " + arr.size() + "\n");
        // To debug
        for(int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == keyHash) {
                System.out.println("Arr.get(i); : " + arr.get(i));
                arr.remove(i);
            }
        } // To debug
        
        return null;
    }

    //Func to debug print map | have bug if you put new Data in some HashCode.
    @Override
    public String toString() {
        System.out.println("Key      Value   HashCode\n");
        for(int i = 0; i < arr.size(); i++) {
            System.out.println("Aere seiz\n" + arr.size());
            System.out.println("to string arr.get:  " + arr.get(i));
            System.out.println("to string arr.get:  " + map.get(arr.get(i)));
            
            System.out.print(map.get(arr.get(i)).get(0).getKey() + " - ");
            System.out.print(map.get(arr.get(i)).get(0).getValue() + ": ");
            System.out.println(arr.get(i));
            // System.out.println(map.get(1).get(0).getKey());
        }
        System.out.println("");
        return "";
    }
} 
