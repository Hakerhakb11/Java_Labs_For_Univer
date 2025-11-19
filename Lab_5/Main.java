package Lab_5;

public class Main {
    public static void main (String[] args) {
        System.out.println("Start Lab 5\n");

        HashMap<String, String> map = new HashMapImpl<>();

        map.put("Igor", "Value");
        map.put("Andrey", "Programmer");
        map.put("Heroes might and magic 3", "The Best strategy game");
        map.put("Cat", "Animal");

        map.toString();

        


        System.out.println("\nEnd Lab 5");
    }
}