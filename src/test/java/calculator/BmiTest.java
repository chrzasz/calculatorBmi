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
                new Object[]{1, 1, "1.0"},
                new Object[]{-1, -1, "0.0"},
                new Object[]{10000, 100, "1.0"},
        };
    }

}
