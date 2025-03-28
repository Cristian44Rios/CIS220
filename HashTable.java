// Cristian Rios
// Chpt6 PA

// Class to represent the key-value pair (Item)
class Item {
    String key;  
    String value;  
    Item next;  

    public Item(String key, String value) {
        this.key = key;  
        this.value = value;  
        this.next = null;  
    }
}

// Class to represent a hash table 
class HashTable {
    private Item[] hashTable;  
    private int length;  

    public HashTable (int size) {
        this.length = size;  
        this.hashTable = new Item[length];  
    }

    // Hash method using modified version of Figure 6.8.3 pseudocode
    public int hash(String key) {
        int initialValue = 0;
        int multiplier = 13;
        int stringHash = initialValue;
        for (int i = 0; i < key.length(); i++) {
            stringHash = (stringHash * multiplier) + key.charAt(i);
        }
        return stringHash; // Do not mod by number of buckets per instructions
    }

    public boolean hashInsert(String key, String value) {
        int bucketIndex = hash(key) % length;  

        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                currentItem.value = value;  
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        Item newItem = new Item(key, value);  
        if (hashTable[bucketIndex] == null) {  
            hashTable[bucketIndex] = newItem;  
        } else {
            previousItem.next = newItem;  
        }
        return true;  
    }

    public String hashGet(String key) {
        int bucketIndex = hash(key) % length;  
        Item item = hashTable[bucketIndex];  

        while (item != null) {  
            if (item.key.equals(key)) {  
                return item.value;  
            }
            item = item.next;  
        }

        return null;  
    }

    public boolean hashRemove(String key) {
        int bucketIndex = hash(key) % length;  
        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                if (previousItem == null) {  
                    hashTable[bucketIndex] = currentItem.next;  
                } else {  
                    previousItem.next = currentItem.next;  
                }
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        return false;  
    }

    // Print the hash for each key-value pair
    public void printTable() {
        for (int i = 0; i < length; i++) {  
            System.out.print("Bucket " + i + ": ");  
            Item currentItem = hashTable[i];  
            if (currentItem == null) {  
                System.out.println("empty");  
            } else {
                while (currentItem != null) {  
                    System.out.print("[Key: " + currentItem.key + ", Value: " + currentItem.value + ", Hash: " + hash(currentItem.key) + "] ");
                    currentItem = currentItem.next;  
                }
                System.out.println();  
            }
        }
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(5);

        table.hashInsert("keyA1", "value1");
        table.hashInsert("keyB2", "value2");
        table.hashInsert("keyC3", "value3");
        table.hashInsert("keyD23", "value23");
        table.hashInsert("keyE45", "value45");
        table.hashInsert("keyF52", "value52");

        System.out.println("\nInitial Table:");
        table.printTable();

        // Remove keyF52
        if (table.hashRemove("keyF52")) {
            System.out.println("Successfully removed keyF52.");
        } else {
            System.out.println("Failed to remove keyF52.");
        }

        // Attempt to get non-existing key keyZ6
        String result = table.hashGet("keyZ6");
        if (result == null) {
            System.out.println("keyZ6 not found.");
        } else {
            System.out.println("Found keyZ6: " + result);
        }

        // Get existing key keyC3
        result = table.hashGet("keyC3");
        if (result == null) {
            System.out.println("keyC3 not found.");
        } else {
            System.out.println("Found keyC3: " + result);
        }

        table.hashInsert("keyG18", "value18");
        table.hashInsert("keyH7", "value7");
        table.hashInsert("keyI33", "value33");

        // Update keyD23
        table.hashInsert("keyD23", "newvalue23");

        System.out.println("\nUpdated Table:");
        table.printTable();
    }
}
