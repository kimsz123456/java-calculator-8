package calculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        StringCalculator calculator = new StringCalculator();

        output.printInputPrompt();
        String inputString = input.readInput();
        int result = calculator.calculate(inputString);
        output.printResult(result);
    }
}