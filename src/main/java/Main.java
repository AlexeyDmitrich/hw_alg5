public class Main {
    /**
     * метод сделан исключительно для тестирования классов умножения и возведения в степень
     * @param args в качестве тестовых я использовал только целые положительные числа и 0.
     */
    public static void main(String[] args) {
    //    Multiplication test1 = new Multiplication(5,3);
    //    System.out.println(test1.getProduct());
    //    Multiplication test2 = new Multiplication(5,6);
    //    System.out.println(test2.getProduct());
    //    Multiplication test3 = new Multiplication(7,4);
    //    System.out.println(test3.getProduct());
    //    Multiplication test4 = new Multiplication(11,5);
    //    System.out.println(test4.getProduct());
    //    Multiplication test5 = new Multiplication(2,0);
    //    System.out.println(test5.getProduct());

    //    System.out.println("Степени:");
    //    Exponentiation test6 = new Exponentiation(5, 3);
    //    double temp6 = test6.getExponent();
    //    System.out.println(temp6);
    //    Exponentiation test7 = new Exponentiation(2, 3);
    //    double temp7 = test7.getExponent();
    //    System.out.println(temp7);
    //    Exponentiation test8 = new Exponentiation(3, 1);
    //    double temp8 = test8.getExponent();
    //    System.out.println(temp8);

        System.out.println("Класс Complicated, в консоли задаст Вам нужные вопросы и создаст нужную вещь.\n" +
                "ВНИМАНИЕ! Методы взаимодействия с пользователем не защищены от некорректного ввода. \n" +
                "Класс Bag: примет массив из созданных вещей, взвесит их, подготовит к упаковке, создаст рюкзак, аккуратно сложит туда те вещи, которые он считает оптимальными и напечатает результат. \n" +
                "УДАЧИ!");
        Bag bag = new Bag(50);
        Complicated kit = new Complicated();
        Item[] items = kit.mustComplete();
        bag.readyAllItem(items);
        bag.completeIn(bag.items);
        System.out.println("results:");
        bag.print();


    }
}
