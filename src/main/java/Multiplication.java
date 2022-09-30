public class Multiplication {

    private final double num1;
    private final double num2;

    private double product;
    private double productTemp;


public Multiplication(double num1, double num2) {
    this.num1 = num1;
    this.num2 = num2;
    setProduct();
}
    public double getProduct() {
        return product;
    }

    private void setProduct() {
        this.product = findProduct(num1, num2);
    }

    public double getProductTemp() {
        return productTemp;
    }

    public void setProductTemp(double productTemp) {
        this.productTemp = productTemp;
    }

    public static double findProduct1 (double num1, double num2) {
        double product = 0;
        for (int i = 0; i < num2; ) {
            product += num1;
            i++;
        }
        return product;
    }
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double findProduct(double num1, double num2) {
        int counter = getCounter();
        double product = getProductTemp();
        if (num1 == 0 || num2 ==0) {
            return 0;
        } else if (counter == num2) {
            return product;
        } else if (counter < num2){
            product += num1;
            setCounter(counter+1);
            setProductTemp(product);
            return findProduct(num1, num2);
        }
        return product;
    }
}
