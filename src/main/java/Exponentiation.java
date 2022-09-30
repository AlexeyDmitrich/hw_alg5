public class Exponentiation {
    private double num;
    private double degree;
    private double exponent;
    private double exponentTemp = 1;
    private int counter;

    public Exponentiation(double num, double degree) {
        this.num = num;
        this.degree = degree;
        setExponent();
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent() {
        this.exponent = exponentFind(num, degree);
    }

    public double getExponentTemp() {
        return exponentTemp;
    }

    public void setExponentTemp(double exponentTemp) {
        this.exponentTemp = exponentTemp;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private double exponentFind (double num, double degree) {
        int counter = getCounter();
        double exponent = getExponentTemp();
        Multiplication product = new Multiplication(num, exponent);
        if (num == 0) {
            return 0;
        } else if (degree == 0) {
            return 1;
        } else if (counter == degree) {
            return exponent;
        } else if (counter < degree) {
            exponent = product.getProduct();
            counter++;
            setCounter(counter);
            setExponentTemp(exponent);
            return exponentFind(num, degree);
        }
        return exponent;
    }


}
