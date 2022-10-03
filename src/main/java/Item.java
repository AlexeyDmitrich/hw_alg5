import java.util.Objects;

public class Item implements Comparable<Item> {
    // вещь - имеет вес и практическую ценность
    double weight;
    int usefull;
    // будет логично, если вещь будет иметь название (возможно, именно эту программу я смогу применить на практике)
    String name;

    double usability; // пусть вещь имеет полезную нагрузку, по типу КПД, только для вещи

    public double getUsability() {
        return usability;
    }

    public Item(double weight, int usefull, String name) {
        this.weight = weight;
        this.usefull = usefull;
        this.name = name;
        this.usability = (usefull / weight) * 100;
    }


    @Override
    public int compareTo(Item o) {
        return (int)(this.getUsability()-o.getUsability());
    }
}
