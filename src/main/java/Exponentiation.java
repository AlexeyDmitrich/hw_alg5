/**
 * Класс для возведения в положительную целочисленную степень
 */
public class Exponentiation {
    private double num; // возводимое число
    private double degree; // степень
    private double exponent; // результат возведения
    private double exponentTemp = 1; // временное возведение.
    private int counter; // счетчик итераций для рекурсивного расчета

    /**
     * При вызове конструктора передаем
     * @param num возводимое число
     * @param degree и целую положительную степень для возведения
     */
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

    /**
     * метод расчета возведения на вход принимает
     * @param num число для возведения
     * @param degree и степень
     * @return вернет число num в степени degree
     */
    private double exponentFind (double num, double degree) {
        int counter = getCounter();             // задаем счетчик итераций
        double exponent = getExponentTemp();    // принимаем временный результат
        Multiplication product = new Multiplication(num, exponent);  // создаем новое произведение числа на временный результат
        if (num == 0) {                         // возвращаем 0, при возведении 0 в любую степень
            return 0;
        } else if (degree == 0) {               // возвращаем 1 при возведении в степень 0
            return 1;
        } else if (counter == degree) {         // при достаточном числе итераций возвращаем временный результат
            return exponent;
        } else if (counter < degree) {          // пока итераций меньше, чем значение степени:
            exponent = product.getProduct();    // передаем во временный результат произведение числа на себя
            counter++;                          // увеличиваем счетчик
            setCounter(counter);                // накручиваем внешний счетчик
            setExponentTemp(exponent);          // передаем наружу временный результат
            return exponentFind(num, degree);   // выходим на круг рекурсии
        }
        return exponent;
    }


}
