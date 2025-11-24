package Lab_5;

public class Main {
    public static void main (String[] args) {
        HashMap<String, String> map = new HashMapImpl<>();
        
        map.put("Igor", "Value");
        map.put("Andrey", "Programmer");
        map.put("Heroes 3", "Best strategy game");
        map.put("Cat", "Animal");
        map.toString();

        map.delete("Igor");
        map.delete("Andrey");
        map.delete("Cat");
        map.toString();

        map.put("Igor", "Value");
        map.put("Andrey", "Programmer");
        map.put("Heroes 3", "Best strategy game");
        map.put("Cat", "Animal");
        map.toString();

        System.out.println(map.getValue("Igor"));
        System.out.println(map.getValue("igor"));
        System.out.println(map.getValue("Cat"));
    }
}
