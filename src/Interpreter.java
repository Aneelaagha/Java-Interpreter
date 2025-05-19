import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class Interpreter {
    private static HashMap<String, Integer> variables = new HashMap<>();

    public static String handleCommand(String input) {
        try {
            String[] parts = input.split(" ");

            if (parts.length == 0) return "No command entered.";

            switch (parts[0].toUpperCase()) {
                case "SET":
                    if (parts.length == 4 && parts[2].equals("=")) {
                        String variable = parts[1];
                        int value = Integer.parseInt(parts[3]);
                        variables.put(variable, value);
                        return "Set " + variable + " to " + value;
                    }
                    return "Invalid SET syntax. Use: SET x = 10";

                case "PRINT":
                    String variable = parts[1];
                    if (variables.containsKey(variable)) {
                        return variable + " = " + variables.get(variable);
                    }
                    return "Variable " + variable + " not found.";

                case "ADD":
                    variable = parts[1];
                    int addVal = Integer.parseInt(parts[2]);
                    if (variables.containsKey(variable)) {
                        int newVal = variables.get(variable) + addVal;
                        variables.put(variable, newVal);
                        return variable + " updated to " + newVal;
                    }
                    return "Variable not found.";

                case "SUB":
                    variable = parts[1];
                    int subVal = Integer.parseInt(parts[2]);
                    if (variables.containsKey(variable)) {
                        int newVal = variables.get(variable) - subVal;
                        variables.put(variable, newVal);
                        return variable + " updated to " + newVal;
                    }
                    return "Variable not found.";

                case "LIST":
                    return "Variables: " + variables;

                case "HELP":
                    return """
                        Commands:
                        - SET x = 10
                        - ADD x 5
                        - SUB x 3
                        - PRINT x
                        - LIST
                        - EXIT
                    """;

                case "EXIT":
                    System.exit(0);
            }

            return "Unknown command. Try HELP.";

        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}

