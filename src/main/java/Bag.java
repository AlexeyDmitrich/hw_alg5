import java.util.ArrayList;

public class Bag {
    double freeSpace; // После укладки будет оставаться свободное место.
    public double readyWeight;
    double readyUsefull;
    ArrayList <Item> items;
    ArrayList <Item> complete;

    public Bag(double volume) {
        // рюкзак должен обладать грузоподъемностью и вмещать вещи, суммарно не превышающие её
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
            readyWeight += item[i].weight; // любая вещь имеет вес
            readyUsefull += item[i].usefull; // полезность потенциального содержимого рюкзака увеличивается
            items.add(item[i]); // на этом этапе вещь подготовлена и изменила состояние укладки
        }
    }

    private ArrayList<Item> bagComplete = new ArrayList<>();
    /**
     * метод для непосредственной упаковки вещей в рюкзак
     * @param items принимает на вход укладку (АррЛист) взвешенных вещей с посчитаной пользой
     * @return возвращает упакованный в АррЛист рюкзак
     */
    public ArrayList <Item> completeIn (ArrayList<Item> items) {
        items.sort(Item::compareTo);
        int itemCounter = items.size();
        if (freeSpace == 0 || itemCounter == 0) {
            return bagComplete;
        } else if (freeSpace >= items.get(itemCounter-1).weight) {
            bagComplete.add(items.get(itemCounter-1));
            freeSpace -= items.get(itemCounter-1).weight;
            items.remove(itemCounter-1);
            return completeIn(items);
        } else if (freeSpace < items.get(itemCounter-1).weight) {
            items.remove(itemCounter-1);
            return completeIn(items);
        }
        return bagComplete;
    }

    public void print (){
        System.out.println("результат:");
        for (Item item:
             complete) {
            System.out.println(item.name + " польза: " + item.usability);
        }
    }
}
