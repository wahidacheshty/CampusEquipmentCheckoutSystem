public class Main {
    public static void main(String[] args) {
        // Step 1 – Create Equipment objects
        Equipment eq1 = new Equipment("EQ101", "Laptop");
        Equipment eq2 = new Equipment("EQ102", "Projector");
        Equipment eq3 = new Equipment("EQ103", "Tablet");

        // Step 2 – Create an EquipmentInventory object and add items
        EquipmentInventory inventory = new EquipmentInventory();
        inventory.addEquipment(eq1);
        inventory.addEquipment(eq2);
        inventory.addEquipment(eq3);
        System.out.println("=== Step 1 & 2: Initial Inventory Loaded ===");
        System.out.println("Total items registered: " + inventory.getCount() + "\n");

        // Step 3 – Test checkout operations
        System.out.println("=== Step 3: Testing Checkouts ===");
        boolean checkout1 = inventory.checkOutById("EQ101", "Alex");
        System.out.println("Checkout EQ101 (Laptop) to Alex: " + (checkout1 ? "Success" : "Failed"));

        boolean checkout2 = inventory.checkOutById("EQ101", "Mina");
        System.out.println("Checkout EQ101 (Laptop) to Mina: " + (checkout2 ? "Success" : "Failed (Already checked out)"));

        boolean checkout3 = inventory.checkOutById("EQ103", "Mina");
        System.out.println("Checkout EQ103 (Tablet) to Mina: " + (checkout3 ? "Success" : "Failed") + "\n");

        // Step 4 – Test return operations
        System.out.println("=== Step 4: Testing Return ===");
        boolean return1 = inventory.checkInById("EQ101");
        System.out.println("Return EQ101 (Laptop): " + (return1 ? "Success" : "Failed") + "\n");

        // Step 5 – Display inventory
        System.out.println("=== Step 5: Current Inventory Status ===");
        inventory.printAll();
        System.out.println("Available equipment count: " + inventory.getAvailableCount() + "\n");

        // Step 6 – Test searching
        System.out.println("=== Step 6: Testing Search ===");
        int foundIndex = inventory.findIndexById("EQ103");
        System.out.println("Search for EQ103 index: " + foundIndex);

        int missingIndex = inventory.findIndexById("EQ999");
        System.out.println("Search for EQ999 index: " + missingIndex + "\n");

        // Step 7 – Test ArrayList update
        System.out.println("=== Step 7: Replacing Equipment at Index 1 ===");
        Equipment eq4 = new Equipment("EQ104", "Camera");
        boolean replaced = inventory.replaceEquipment(1, eq4);
        System.out.println("Replace index 1 with EQ104 (Camera): " + (replaced ? "Success" : "Failed") + "\n");

        // Step 8 – Display final results
        System.out.println("=== Step 8: Final Inventory Status ===");
        inventory.printAll();
        System.out.println("Total equipment count (unchanged): " + inventory.getCount());
        System.out.println("Available equipment count: " + inventory.getAvailableCount());
    }
}
