package Lab_5;

public class Main {
    public static void main (String[] args) {
        HashMap<String, String> map = new HashMapImpl<>();
        
        map.put("Igor", "Value");
        map.put("Andrey", "Programmer");
        map.put("Heroes might and magic 3", "The Best strategy game");
        map.put("Cat", "Animal");
        // map.toString();

        map.delete("Heroes might and magic 3");
        map.delete("Igor");
        map.delete("Andrey");
        map.delete("Cat");
        // map.toString();

        map.put("Igor", "Value");
        map.put("Andrey", "Programmer");
        map.put("Heroes might and magic 3", "The Best strategy game");
        map.put("Cat", "Animal");
        // map.toString();

        map.getValue("Igor");
        map.getValue("igor");
        map.getValue("Cat");
    }
}
