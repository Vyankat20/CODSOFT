import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class number2 extends JFrame {

    private int randomNumber;
    private JTextField guessField;
    private JTextArea resultArea;

    public number2() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        randomNumber = (int) (Math.random() * 10) + 1;
        JLabel guessLabel = new JLabel("Enter your guess (1-100):");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        setLayout(new FlowLayout());
        add(guessLabel);
        add(guessField);
        add(guessButton);
        add(resultArea);
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            if (userGuess == randomNumber) {
                resultArea.setText("Congratulations! You guessed the correct number.");
            } else {
                resultArea.setText("Wrong guess. Try again!");
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new number2().setVisible(true);
            }
        });
    }
}
