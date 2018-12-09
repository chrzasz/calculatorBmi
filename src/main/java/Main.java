import calculator.CalculatorBmi;

import java.util.Scanner;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  12:08 PM
 */
public class Main {

    public static void main(String[] args) {

        int w = getWeight();
        int h = getHeight();
        showResult(w, h);
    }

    private static void showResult(int weight, int height) {
        CalculatorBmi bmi = new CalculatorBmi(weight, height);
        String s = bmi.calculate();
        System.out.print("BMI = " + s + "\t\tYou are ");
        System.out.println(bmi.interpret());
    }

    private static int getHeight() {
        boolean valid = false;
        int input = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type your height in [cm]:");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                valid = true;
            }
        } while (!valid);
        return input;
    }

    private static int getWeight() {
        boolean valid = false;
        int input = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type your weight in [kg]:");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                valid = true;
            }
        } while (!valid);
        return input;
    }

} //END Main
