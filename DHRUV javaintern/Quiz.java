import java.util.*;

public class QuizApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static List<Question> questions = new ArrayList<>();
    private static int currentQuestionIndex = -1;

    public static void main(String[] args) {
        initializeQuestions();

        System.out.println("Welcome to the General Knowledge Quiz!");

        while (currentQuestionIndex < questions.size() - 1) {
            displayNextQuestion();
            displayOptions();
            int userChoice = getUserChoice();
            if (userChoice == questions.get(currentQuestionIndex).getCorrectOption()) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
        }

        System.out.println("Quiz complete. Thank you for playing!");
    }

    private static void initializeQuestions() {
        // Add your questions here with options and correct answer index
        questions.add(new Question("What is the capital of France?", Arrays.asList("A. London", "B. Paris", "C. Berlin", "D. Rome"), 1));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"), 1));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?", Arrays.asList("A. William Shakespeare", "B. Charles Dickens", "C. Jane Austen", "D. Mark Twain"), 0));
        // Add more questions as needed
    }

    private static void displayNextQuestion() {
        currentQuestionIndex++;
        Question currentQuestion = questions.get(currentQuestionIndex);
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());
    }

    private static void displayOptions() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        for (String option : currentQuestion.getOptions()) {
            System.out.println(option);
        }
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice (A, B, C, or D): ");
        String userInput = scanner.nextLine().toUpperCase();
        switch (userInput) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            default:
                System.out.println("Invalid input. Please enter A, B, C, or D.");
                return getUserChoice();
        }
    }

    static class Question {
        private String question;
        private List<String> options;
        private int correctOption;

        public Question(String question, List<String> options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }

        public String getQuestion() {
            return question;
        }

        public List<String> getOptions() {
            return options;
        }

        public int getCorrectOption() {
            return correctOption;
        }
    }
}
