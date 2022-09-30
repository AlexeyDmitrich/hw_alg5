/**
 * Класс для осуществления умножения с помощью рекурсивного вызова сложения.
 * Класс расчитан на получение произведения двух целых положительных чисел,
 * с другими числами не проверялся.
 */
public class Multiplication {

    private final double num1;
    private final double num2;

    private double product;   // произведение (сюда ляжет конечный результат)
    private double productTemp; // временное произведение - введено для удобства реализации


    /**
     * Для получения результата создается новый объект, который в итоге будет представлять произведение.
     * При вызове конструктора поиск произведения начнется автоматически
     * @param num1 в качестве параметров при создании указываются положительные множители
     * @param num2
     *
     */
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

    /**
     * нерекурсивный метод для умножения
     * @param num1 1 множитель
     * @param num2 2 множитель
     * @return вернёт произведение
     */
    public static double findProduct1 (double num1, double num2) {
        double product = 0;
        for (int i = 0; i < num2; ) {
            product += num1;
            i++;
        }
        return product;
    }

    /**
     * для рекурсивного метода реализован внешний счетчик с геттером и сеттером
     */
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * метод рекурсивного умножения
     * @param num1 1 множитель
     * @param num2 2 множитель
     * @return произведение
     */
    public double findProduct(double num1, double num2) {
        // первая часть метода нужна для определения большего и меньшего множителей
        double numMaster;
        double numSlave;
        if (num1 >= num2) {
            numMaster = num1;
            numSlave = num2;
        } else {
            numMaster = num2;
            numSlave = num1;
        }
        // умножать удобнее на меньший из множителей, т.к. это снизит число итераций

        int counter = getCounter();         // получаем значение внешнего счетчика
        double product = getProductTemp();  // получаем временное произведение
        if (numMaster == 0 || numSlave ==0) {        // возвращаем 0, если один из множителей == 0
            return 0;
        } else if (counter == numSlave) {       // если число итераций равно второму множителю, возвращаем результат
            return product;
        } else if (counter < numSlave){         // пока счетчик меньше второго множителя:
            product += numMaster;                // прибавляем к первому множителю его же
            setCounter(counter+1);          // считаем итерации
            setProductTemp(product);        // записываем результат во временное произведение
            return findProduct(numMaster, numSlave); // заходим на следующий круг в рекурсии
        }
        return product;
    }
}
