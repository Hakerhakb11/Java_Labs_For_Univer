package Lab_5;

public class Data<V> {
    private String key;
    private V value;

    public Data(String key, V value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
