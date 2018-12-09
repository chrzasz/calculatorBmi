package calculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.pow;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  10:33 AM
 */
public class CalculatorBmi implements Calculator {

    private int weight; // [kg]
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

        DecimalFormat df = new DecimalFormat("##.00", DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);

        if ((weight > 0) && (height) > 0) {

            Double pom = (double) (height * height) / 10000d;
            if ((pom.isInfinite() || (pom == 0d))) pom = 1d;
            bmi = (double) weight / pom.doubleValue();
            return df.format(bmi);
        }
        return df.format(bmi);
    }

    @Override
    public String interpret() {

        setBmi(Double.parseDouble(calculate()));

        List<StructureBmi> lstBmi = new ArrayList<StructureBmi>();

        lstBmi.add(new StructureBmi(0d, 0.01d, "???"));
        lstBmi.add(new StructureBmi(0.01d, 15d, "Very severely underweight"));
        lstBmi.add(new StructureBmi(15d, 16d, "Severely underweight"));
        lstBmi.add(new StructureBmi(16d, 18.5d, "Underweight"));
        lstBmi.add(new StructureBmi(18.5d, 25d, "Normal (healthy weight)"));
        lstBmi.add(new StructureBmi(25d, 30d, "Overweight"));
        lstBmi.add(new StructureBmi(30d, 35d, "Obese Class I (Moderately obese)"));
        lstBmi.add(new StructureBmi(35d, 40d, "Obese Class II (Severely obese)"));
        lstBmi.add(new StructureBmi(40d, 45d, "Obese Class III (Very severely obese)"));
        lstBmi.add(new StructureBmi(45d, 50d, "Obese Class IV (Morbidly Obese)"));
        lstBmi.add(new StructureBmi(50d, 60d, "Obese Class V (Super Obese)"));
        lstBmi.add(new StructureBmi(60d, 170d, "Obese Class VI (Hyper Obese)"));
        lstBmi.add(new StructureBmi(170d, 1000000d, "over human limit!"));


        for (StructureBmi o : lstBmi) {
            if ((getBmi() >= o.getMin()) && (getBmi() < o.getMax())) {
                return o.getLabel();
            }
        }
        return null;
    }

}


