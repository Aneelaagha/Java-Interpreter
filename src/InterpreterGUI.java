import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterpreterGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Anz Interpreter ");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setText("""
        ==============================
        💻 Welcome to Anz v1.0
        ------------------------------
        Type HELP to see available commands.
        Type EXIT to leave the interpreter.
        ==============================

        """);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Color.GREEN);
        inputField.setBackground(Color.DARK_GRAY);
        inputField.setForeground(Color.WHITE);
        Font font = new Font("Consolas", Font.BOLD, 14);
        outputArea.setFont(font);
        inputField.setFont(font);


        JScrollPane scroll = new JScrollPane(outputArea);
        JButton runButton = new JButton("Run");

        frame.add(inputField, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(runButton, BorderLayout.SOUTH);

        runButton.addActionListener(e -> {
            String input = inputField.getText().trim();
            if (!input.isEmpty()) {
                String result = Interpreter.handleCommand(input);  // connects to your logic
                outputArea.append("$ " + input + "\n" + result + "\n\n");
                inputField.setText("");
            }
        });

        inputField.addActionListener(e -> runButton.doClick());
        frame.setVisible(true);
    }
}
