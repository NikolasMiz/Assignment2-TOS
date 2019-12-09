////////////////////////////////////////////////////////////////////
// Nicholas Miazzo 1161392
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

public class MenuItem {


    public enum ItemType {
        PANINO, FRITTO, BEVANDA;

    }
    public MenuItem(ItemType itemType, String name, double price) {

        if(itemType == null) {
            throw new IllegalArgumentException("ItemType cannot be null");
        }
        if(name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name is not valid");
        }
        if(price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    private ItemType itemType;
    private String name;
    private double price;
}
