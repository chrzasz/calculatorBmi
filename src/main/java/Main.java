import calculator.CalculatorBmi;

import java.util.Scanner;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  12:08 PM
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your weight in kg:");
        int m = scanner.nextInt();
        System.out.println("Type your height in cm:");
        int w = scanner.nextInt();

        CalculatorBmi bmi = new CalculatorBmi(m, w);
        System.out.print("BMI = " + bmi.calculate() + "\tYou are ");
        System.out.println(bmi.interpret());

        CalculatorBmi bmi1 = new CalculatorBmi(50, 200);
        CalculatorBmi bmi2 = new CalculatorBmi(60, 200);
        CalculatorBmi bmi3 = new CalculatorBmi(70, 200);
        CalculatorBmi bmi4 = new CalculatorBmi(80, 200);
        CalculatorBmi bmi5 = new CalculatorBmi(115, 200);

        System.out.print("BMI 1 = " + bmi1.calculate() + "\tYou are ");
        System.out.println(bmi1.interpret());
        System.out.print("BMI 2 = " + bmi2.calculate() + "\tYou are ");
        System.out.println(bmi2.interpret());
        System.out.print("BMI 3 = " + bmi3.calculate() + "\tYou are ");
        System.out.println(bmi3.interpret());
        System.out.print("BMI 4 = " + bmi4.calculate() + "\tYou are ");
        System.out.println(bmi4.interpret());
        System.out.print("BMI 5 = " + bmi5.calculate() + "\tYou are ");
        System.out.println(bmi5.interpret());
        System.out.println("\n\n\n");





    }
}
