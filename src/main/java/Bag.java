import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bag {
    // рюкзак должен обладать грузоподъемностью и вмещать вещи, суммарно не превышающие её
    private final double volume;

    public Bag(double volume) {
        this.volume = volume;
    }

    ArrayList <Item> items = new ArrayList<>();
    // грубо говоря - ячейки для заполнения вещами

    public void putItemInBag (Item[] item){  // для удобства реализации я планирую работать с массивом вещей

        for (int i=0; i< item.length; i++){
            //TODO: заполнить метод добавления вещей в рюкзак
        }
    }
}
