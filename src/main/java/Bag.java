import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Bag {
    // рюкзак должен обладать грузоподъемностью и вмещать вещи, суммарно не превышающие её
    private final double volume;
    double freeSpace; // После укладки будет оставаться свободное место.
    double unitedUsefull; // общая полезность вещей в рюкзаке.
    double readyWeight;
    double readyUsefull;
    ArrayList <Item> items;
    ArrayList <Item> complete;

    public Bag(double volume) {
        this.volume = volume;
        this.freeSpace = volume;
        items = new ArrayList<>();
        complete = completeIn(items);
    }


    //ArrayList <Item> items = new ArrayList<>();
    // грубо говоря - весь комплект посчитаных вещей
    //ArrayList <Item> complete = completeIn(items);

    /**
     * Метод должен сформировать список всех вещей, подготовленных к упаковке, расчитать их вес и полезность
     * @param item на вход принимает масси всех вещей
     */
    public void readyAllItem (Item[] item){  // для удобства реализации я планирую работать с массивом вещей
        for (int i=0; i< item.length; i++){
            //TODO: заполнить метод добавления вещей в рюкзак
            readyWeight += item[i].weight; // любая вещь имеет вес
            readyUsefull += item[i].usefull; // полезность потенциального содержимого рюкзака увеличивается
            items.add(item[i]); // на этом этапе вещь подготовлена и изменила состояние укладки
        }
    }

    /**
     * метод не тестировался
     * @param items
     * @return
     */
    public ArrayList <Item> completeIn (ArrayList<Item> items) {
        ArrayList<Item> bagComplete = new ArrayList<>();
        items.sort(Item::compareTo);
        int itemCounter = items.size();
        if (freeSpace == 0 || itemCounter == 0) {
            return bagComplete;
        } else if (freeSpace >= items.get(itemCounter).weight) {
            bagComplete.add(items.get(itemCounter));
            freeSpace -= items.get(itemCounter).weight;
            items.remove(itemCounter);
            return completeIn(items);
        } else if (freeSpace < items.get(itemCounter).weight) {
            items.remove(itemCounter);
            return completeIn(items);
        }
        return bagComplete;
    }


    @Override
    public String toString() {
        String str1 = new String();
        for (int i = 0; i < complete.size(); i++) {
        str1.concat(complete.get(i).name);
        }
        return str1;
    }
}
