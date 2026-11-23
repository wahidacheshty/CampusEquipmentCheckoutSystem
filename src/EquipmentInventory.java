import java.util.ArrayList;

public class EquipmentInventory {
//    This class manages the ArrayList<Equipment> collection.
//    Rather than directly modifying an item's status itself,
//    it locates the target Equipment object and delegates the action
//    by calling that object's public methods
//    (checkOut, checkIn, printDetails, isCheckedOut, getAssetId).

    // Private ArrayList holding Equipment objects
    private ArrayList<Equipment> items;

    // Constructor initializing an empty ArrayList
    public EquipmentInventory() {
        this.items = new ArrayList<>();
    }

    // Adds an Equipment object to the collection
    public void addEquipment(Equipment item) {
        if (item != null) {
            items.add(item);
        }
    }

    // Returns total number of equipment items in the inventory
    public int getCount() {
        return items.size();
    }

    // Uses a while loop to find the index of an item by its assetId
    public int findIndexById(String assetId) {
        int index = 0;
        while (index < items.size()) {
            // Object interaction: calling getAssetId() on each Equipment object
            if (items.get(index).getAssetId().equalsIgnoreCase(assetId)) {
                return index;
            }
            index++;
        }
        return -1; // Not found
    }

    // Locates equipment and delegates checkout to the Equipment object
    public boolean checkOutById(String assetId, String studentName) {
        int index = findIndexById(assetId);
        if (index != -1) {
            Equipment target = items.get(index);
            return target.checkOut(studentName); // Object interaction
        }
        return false;
    }

    // Locates equipment and delegates check-in to the Equipment object
    public boolean checkInById(String assetId) {
        int index = findIndexById(assetId);
        if (index != -1) {
            Equipment target = items.get(index);
            return target.checkIn(); // Object interaction
        }
        return false;
    }

    // Uses a for-each loop to count available items
    public int getAvailableCount() {
        int availableCount = 0;
        for (Equipment item : items) {
            if (!item.isCheckedOut()) { // Object interaction
                availableCount++;
            }
        }
        return availableCount;
    }

    // Uses a for-each loop to print details of every item
    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("Inventory is currently empty.");
            return;
        }
        for (Equipment item : items) {
            item.printDetails(); // Object interaction
        }
    }

    // Replaces equipment at a valid index without changing list size
    public boolean replaceEquipment(int index, Equipment replacement) {
        if (index >= 0 && index < items.size() && replacement != null) {
            items.set(index, replacement);
            return true;
        }
        return false;
    }






}
