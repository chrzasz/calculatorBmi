package calculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  10:33 AM
 */
public class CalculatorBmi implements Calculator {

    private int weight; // [dag]
    private int height; // [cm]
    private double bmi;

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

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    @Override
    public String calculate() {

        bmi = 0;

        if ((this.weight > 0) && (this.height) > 0) {
            bmi = round(this.weight / pow(this.height/100, 2), 3);
        }

        return Double.toString(bmi);
    }

    @Override
    public String interpret() {

        this.setBmi(Double.parseDouble(calculate()));

        List<StructureBmi> lstBmi = new ArrayList<StructureBmi>();

        lstBmi.add(new StructureBmi(0, 15, "Very severely underweight"));
        lstBmi.add(new StructureBmi(15, 16, "Severely underweight"));
        lstBmi.add(new StructureBmi(16, 18.5, "Underweight"));
        lstBmi.add(new StructureBmi(18.5, 25, "Normal (healthy weight)"));
        lstBmi.add(new StructureBmi(25, 1000, "Overweight"));

        for (StructureBmi o : lstBmi) {
            if ((bmi >= o.getMin()) && (bmi < o.getMax())) {
                return o.getLabel();
            }
        }

        return null;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}


