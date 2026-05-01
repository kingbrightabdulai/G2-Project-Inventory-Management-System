import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private List<String> inventory;
    private Map<String, Integer> itemStatistics;

    public InventoryManager() {
        inventory = new ArrayList<>();
        itemStatistics = new HashMap<>();
    }

    public void addItem(String item) {
        inventory.add(item);
        itemStatistics.put(item, itemStatistics.getOrDefault(item, 0) + 1);
    }

    public void removeItem(String item) {
        if (inventory.remove(item)) {
            itemStatistics.put(item, itemStatistics.get(item) - 1);
            if (itemStatistics.get(item) <= 0) {
                itemStatistics.remove(item);
            }
        }
    }

    public void updateItem(String oldItem, String newItem) {
        int index = inventory.indexOf(oldItem);
        if (index != -1) {
            inventory.set(index, newItem);
            itemStatistics.put(newItem, itemStatistics.getOrDefault(newItem, 0) + 1);
            removeItem(oldItem);
        }
    }

    public boolean searchItem(String item) {
        return inventory.contains(item);
    }

    public Map<String, Integer> getStatistics() {
        return itemStatistics;
    }

    @Override
    public String toString() {
        return "Inventory: " + inventory;
    }
}