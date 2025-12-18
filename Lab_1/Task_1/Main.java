package Lab_1.Task_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "{[()]}";
        System.out.println("Input: str = " + text);
        Deque<Object> stack = new ArrayDeque<>();
        
        List<Character> OpenBracket = List.of('(', '[', '{');
        List<Character> CloseBracket = List.of(')', ']', '}');

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for(Character Bracket : text.toCharArray()) {
            if (OpenBracket.contains(Bracket)) {
                stack.push(Bracket);
            }
            else if (CloseBracket.contains(Bracket)) {
                if (map.get(Bracket) == stack.peek()) {
                    stack.pop();
                } else {
                    System.out.println("Outout " + false);
                    System.exit(0);
                }
            }
        }
        System.out.println("Outout " + stack.isEmpty());
    }
}