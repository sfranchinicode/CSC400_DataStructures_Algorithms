import java.util.HashMap;
import java.util.Map;

/*
A generic bag (multiset) data structure
Internally this uses a HashMap to map each distinct item to 
how many times it shows up instead of storing each duplicate 
separately
*/

public class Bag<T> {
    // Private key for mapping
    private Map<T, Integer> items;

    // New bag starts empty
    public Bag() {
        items = new HashMap<>();
    }

    /* 
    Add an item to the bag. Increment if item is already there 
    otherwise start it at 1.
     */
    public void add(T item) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1);
        }
        else {
            items.put(item, 1);
        }
    }

    // Remove one occurance of the item. If its not in the bag this will do nothing
    public void remove(T item) {
        if (items.containsKey(item)) {
            if (items.get(item) == 1) {
                items.remove(item); // last one, drop it from the map
            }
            else {
                items.put(item, items.get(item) - 1);
            }
        }
    }

    // Boolean to see if item exists
    public boolean contains(T item) {
        if (items.containsKey(item)) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
    See how many of a specific item are currently in the bag.
    If there are none return 0
     */
    public int count(T item) {
        if (items.containsKey(item)) {
            return items.get(item);
        }
        else {
            return 0;
        }
    }

    // Build a readable string of everything in the bag
    public String toString() {
        String result = "";
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            result += entry.getKey() + " x" + entry.getValue() + ", " ;
        }
        return result;
    }

    // Method to incorporate size()
    public int size() {
        int total = 0; 
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            total += entry.getValue(); // No need for key here just the values
        }
        return total;
    }

    /*
    This method combines the contents of otherBag into this bag preserving duplicates
    I.E if otherBag has Car x2, this bag gains 2 Cars. 
    */
    public void merge(Bag<T> otherBag) {
        for (Map.Entry<T, Integer> entry : otherBag.items.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) { // i represents the counter
                add(entry.getKey()); // Just a standard add since its being added to this bag not otherBag
            }
        }
    }
    /* 
    This method returns a new bag containing only the distinct items from this bag
    Each key appears one time regardless of occurance
    */
    public Bag<T> distinct() {
        Bag<T> result = new Bag<>();
        for (Map.Entry<T, Integer> entry : items.entrySet()) { // Loop through the set to find all distinct keys
            result.add(entry.getKey()); // Add only the key as that is the distinct value
        }
        return result;
    }
}