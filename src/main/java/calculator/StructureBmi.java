package calculator;

/**
 * Created by Grzegorz Chrzaszczyk on 08-12-2018  02:24 PM
 */
public class StructureBmi {

    private double min;
    private double max;
    private String label;

    public StructureBmi() {
        this.min = 0;
        this.max = 0;
        this.label = "";
    }

    public StructureBmi(double min, double max, String label) {
        this.min = min;
        this.max = max;
        this.label = label;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
