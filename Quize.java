import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quize {
    private static int score = 0;
    private static int currentQuestion = 0;
    private static Timer timer;
    private static boolean isAnswered = false;

    private static String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
    };

    private static String[][] options = {
        {"A. Rome", "B. Madrid", "C. Paris", "D. Berlin"},
        {"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"},
    };

    private static char[] correctAnswers = {'C', 'B', };

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isAnswered) {
                    System.out.println("\nTime's up! Moving to the next question.");
                    nextQuestion();
                }
            }
        }, 15000); 

        displayQuestion();

        try (
        Scanner scanner = new Scanner(System.in)) {
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            
            checkAnswer(userAnswer);
        }
        
        timer.cancel();

      
        nextQuestion();
    }

    private static void displayQuestion() {
        System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
    }

    private static void checkAnswer(char userAnswer) {
        isAnswered = true;
        if (userAnswer == correctAnswers[currentQuestion]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
    }

    private static void nextQuestion() {
        currentQuestion++;
        isAnswered = false;

        if (currentQuestion < questions.length) {
            startQuiz();
        } else {
            displayResult();
        }
    }

    private static void displayResult() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.length);
    }
}


