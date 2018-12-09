package calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  10:29 AM
 */

@RunWith(JUnitParamsRunner.class)


public class BmiTest {

    @Test
    @Parameters({"0,0",
            "-1,-1",
            "1,1",
            "1000,1000"})
    public void contructorTest(int weigth, int height) {
        new CalculatorBmi(weigth, height);
    }

    @Test
    @Parameters(method = "calcValues")
    public void calculatorTest(int weight, int heigth, String expected) {
        CalculatorBmi calc = new CalculatorBmi(weight, heigth);
        Assert.assertEquals(expected, calc.calculate());
    }

    public Object[] calcValues() {
        return new Object[]{
                //Weight, Height, BMI
                new Object[]{0, 0, ".00"},
                new Object[]{1, 1, "10000.00"},
                new Object[]{-1, -1, ".00"},
                new Object[]{100, 100, "100.00"},
                new Object[]{200, 200, "50.00"},
                new Object[]{300, 300, "33.33"},
                new Object[]{400, 400, "25.00"},
                new Object[]{500, 500, "20.00"},
                new Object[]{60, 170, "20.76"},
                new Object[]{65, 200, "16.25"},
        };
    }

    @Test
    @Parameters(method = "interpretBmi")
    public void interpretTest(double bmi, String label) {
        CalculatorBmi calc = new CalculatorBmi();
        calc.setBmi(bmi);
        calc.calculate();
        Assert.assertEquals(label, calc.interpret());
    }

    public Object[] interpretBmi() {
        return new Object[]{
                new Object[]{0, "???"},
                new Object[]{0.01d, "Very severely underweight"},
                new Object[]{1, "Very severely underweight"},
                new Object[]{14.99d, "Very severely underweight"},
                new Object[]{15d, "Severely underweight"},
                new Object[]{15.1d, "Severely underweight"},
                new Object[]{16d, "Underweight"},
                new Object[]{16.1d, "Underweight"},
                new Object[]{18.5d, "Normal (healthy weight)"},
                new Object[]{18.6d, "Normal (healthy weight)"},
                new Object[]{25d, "Overweight"},
                new Object[]{25.01d, "Overweight"},
                new Object[]{30d, "Obese Class I (Moderately obese)"},
                new Object[]{34.99d, "Obese Class I (Moderately obese)"},
                new Object[]{35d, "Obese Class II (Severely obese)"},
                new Object[]{40d, "Obese Class III (Very severely obese)"},
                new Object[]{45d, "Obese Class IV (Morbidly Obese)"},
                new Object[]{50d, "Obese Class V (Super Obese)"},
                new Object[]{60d, "Obese Class VI (Hyper Obese)"},
        };
    }


}






