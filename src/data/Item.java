package data;

/**
 * Created by Jan on 05.01.2016.
 */
public class Item extends Equipment {
    String itemName;
    String itemWeight;
    String itemPrice;
    String itemDescription;

    Item(String itemName, String itemWeight, String itemPrice) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemPrice = itemPrice;
    }

    Item(String itemName, String itemWeight, String itemPrice, String itemDescription) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    @Override
    public String getName() {
        return itemName;
    }

    @Override
    void print() {
        if(itemDescription != null) {
            System.out.println("Item:\t\t\t" + itemName + "\nWeight:\t\t\t" + itemWeight + "\nPrice\t\t\t" + itemPrice + "\nDescription:\t" + itemDescription);
        } else {
            System.out.println("Item:\t\t\t" + itemName + "\nWeight:\t\t\t" + itemWeight + "\nPrice\t\t\t" + itemPrice);
        }
    }
}
