import java.util.List;

import app.Calculator;
import app.ShuntingYard;
import app.Tokenizer;
import operators.Divide;
import operators.Minus;
import operators.Multiplicate;
import operators.Module;
import operators.Plus;
import operators.Sum;
import tokens.Token;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start ----------------------");

        Calculator calc = new Calculator();
        calc.register("+", () -> new Plus());
        calc.register("-", () -> new Minus());
        calc.register("*", () -> new Multiplicate());
        calc.register("/", () -> new Divide());
        calc.register("sum", () -> new Sum());
        calc.register("%", () -> new Module());

        Tokenizer tokenizer = new Tokenizer();
        ShuntingYard shuntingYard = new ShuntingYard();

        String[] testArray = {
                "sum()",
                "sum(42)",
                "-2.5 + sum(5.5, -1.5) * -2",
                "sum(10, sum(20, sum(30, 40)), 50)"
        };

        float[] expectedResults = {
                0.0f,
                42.0f,
                -2.5f + (5.5f + -1.5f) * -2f,
                10f + (20f + (30f + 40f)) + 50f
        };

        for (int i = 0; i < testArray.length; i++) {
            String expr = testArray[i];
            int testNum = i + 1;

            List<Token> rawTokens = tokenizer.tokenize(expr);
            // printTokens("Тест " + testNum + " [Сырые] -> " + expr, rawTokens);

            List<Token> sortedTokens = shuntingYard.sort(rawTokens, calc);
            // printTokens("Тест " + testNum + " [После Сортировки]", sortedTokens);

            float result = calc.eval(sortedTokens);
            boolean isCorrect = (result == expectedResults[i]);

            System.out.println("Результат " + testNum + ": " + result + " | " + isCorrect);
        }

        System.out.println("End =======================");
    }

    public static void printTokens(String label, List<Token> tokens) {
        System.out.println("\n=== Токены [" + label + "] ===");
        if (tokens == null || tokens.isEmpty()) {
            System.out.println("  Список токенов пуст.");
            return;
        }

        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            String typeName = token.getClass().getSimpleName();
            String info = "";

            if (token instanceof tokens.NumberToken num) {
                info = "Значение: " + num.getNumber();
            } else if (token instanceof tokens.OperandToken op) {
                info = "Оператор: '" + op.getOperand() + "', Арность: " + op.getArity();
            } else if (token instanceof tokens.BracketToken bracket) {
                info = bracket.isOpen() ? "Открывающая скобка '('" : "Закрывающая скобка ')'";
            } else if (token instanceof tokens.CommaToken) {
                info = "Запятая ','";
            } else {
                info = token.toString();
            }

            System.out.printf("  [%d] %-15s -> %s\n", i + 1, typeName, info);
        }
        System.out.println("=================================");
    }
}
