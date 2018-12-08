package calculator;

import static java.lang.Math.pow;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  10:33 AM
 */
public class CalculatorBmi implements Calculator{

    private int weight; // [g]
    private int height; // [cm]

    public CalculatorBmi() {
        this.weight = 0;
        this.height = 0;
    }

    public CalculatorBmi(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String calculate() {

        double bmi =0;

        if ( (this.weight>0) && (this.height)>0 ) {
            bmi = this.weight / pow(this.height,2);
        }

        return Double.toString(bmi);
    }

    @Override
    public String interpret() {
        return null;
    }
}


