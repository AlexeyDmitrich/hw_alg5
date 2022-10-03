import java.util.Scanner;

public class Complicated {
    Scanner input = new Scanner(System.in);

    public Item[] mustComplete () {
        System.out.println("Сколько вещей должно быть создано?");
        int counter = input.nextInt();
        Item[] items = new Item[counter];
        for (int i = 0; i < items.length; i++) {
            items[i] = createItem();
        }
        return items;
    }

    public Item createItem (){
        System.out.println("Введите название создаваемой вещи (желательно одним словом)");
        String name = input.next();
        System.out.println("введите вес вещи в кг");
        Double weight = input.nextDouble();
        System.out.println("введите вероятность того, что вещь будет использована (0-100)");
        int nesesoryPer = input.nextInt();
        System.out.println("введите вероятность наступления негативных последствий, если вещь понадобится, но будет отсутствовать (0-100)");
        int negativePer = input.nextInt();
        System.out.println("введите тяжесть вероятных негативных последствий, при их наступлении (0-100)");
        int fatalPer = input.nextInt();
        int usefull = (nesesoryPer + negativePer + fatalPer);
        Item item = new Item(weight, usefull, name);
        return item;
    }

}
