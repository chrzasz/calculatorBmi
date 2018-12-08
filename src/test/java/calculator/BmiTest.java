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
                new Object[]{0, 0, "0.0"},
                new Object[]{1, 1, "9.223"},
                new Object[]{-1, -1, "0.0"},
                new Object[]{100, 100, "100.0"},
                new Object[]{200, 200, "50.0"},
                new Object[]{300, 300, "33.333"},
                new Object[]{400, 400, "25.0"},
                new Object[]{500, 500, "20.0"},
        };
    }

    @Test
    @Parameters(method = "interpretBmi")
    public void interpretTest(String bmi, String label) {
        Calculator calc = new CalculatorBmi();
        Assert.assertEquals(label, calc.interpret());
    }

    public Object[] interpretBmi() {
        return new Object[]{
                new Object[]{"14.9", "very severely underweight"},
                new Object[]{"15", "severely underweight"},
                new Object[]{"16", "underweight"},
                new Object[]{"18.5", "Normal (healthy weight)"},
                new Object[]{"25", "Overweight"}
        };
    }
}






