/*
 * Team: G2 Project
 * Contributor: Ibrahim Abdulai
 * Class: InventoryItem
 * Purpose: Model class representing a single inventory item with properties and methods
 */

public class InventoryItem {
    private int itemID;
    private String itemName;
    private int quantity;
    private double price;
    private String description;

    // Constructor
    public InventoryItem(int itemID, String itemName, int quantity, double price, String description) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    // Getters
    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Calculate total value
    public double getTotalValue() {
        return quantity * price;
    }

    // Override toString for display
    @Override
    public String toString() {
        return "InventoryItem{\" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=$" + String.format("%.2f", price) +
                ", description='" + description + '\'' +
                ", totalValue=$" + String.format("%.2f", getTotalValue()) +
                '}';
    }

    // Override equals for comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem item = (InventoryItem) o;
        return itemID == item.itemID;
    }
}