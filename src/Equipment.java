public class Equipment {
    // Private fields for encapsulation
    private String assetId;
    private String name;
    private boolean checkedOut;
    private String borrower;

    // Constructor initializing required attributes and default availability state
    public Equipment(String assetId, String name) {
        this.assetId = assetId;
        this.name = name;
        this.checkedOut = false;
        this.borrower = "";
    }

    // Accessor (getter) methods
    public String getAssetId() {
        return assetId;
    }

    public String getName() {
        return name;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getBorrower() {
        return borrower;
    }

    // Mutator method to borrow equipment
    public boolean checkOut(String studentName) {
        if (!checkedOut && studentName != null && !studentName.trim().isEmpty()) {
            this.checkedOut = true;
            this.borrower = studentName;
            return true;
        }
        return false; // Already checked out or invalid student name
    }

    // Mutator method to return equipment
    public boolean checkIn() {
        if (checkedOut) {
            this.checkedOut = false;
            this.borrower = "";
            return true;
        }
        return false; // Item was not checked out
    }

    // Displays the current state of this specific Equipment object
    public void printDetails() {
        if (checkedOut) {
            System.out.println("ID: " + assetId + " | Name: " + name + " | Status: Checked Out (Borrower: " + borrower + ")");
        } else {
            System.out.println("ID: " + assetId + " | Name: " + name + " | Status: Available");
        }
    }



}
