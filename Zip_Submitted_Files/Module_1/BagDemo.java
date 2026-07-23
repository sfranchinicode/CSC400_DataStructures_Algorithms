public class BagDemo {
        // Main class to run and test Bag class
    public static void main(String[] args) {

        // New bag of vehicle types
        Bag<String> bag = new Bag<>();

        // Added items including duplicates
        bag.add("Car");
        bag.add("Truck");
        bag.add("Car");
        bag.add("Motorcycle");
        bag.add("Car");
        bag.add("Boat");
        bag.add("Trailer");
        bag.add("Truck");
        bag.add("Boat");
        bag.add("Car");

        // Show whats in the bag
        System.out.println("\nHere is what you currently have in the bag:");
        System.out.println(bag);

        // Check contains for a couple items
        System.out.println("\nKey one test(Car): " + bag.contains("Car"));
        System.out.println("Key two test(Bike): " + bag.contains("Bike"));

        // Check counts for a few items
        System.out.println("\nTotal Cars: " + bag.count("Car"));
        System.out.println("Total Trucks: " + bag.count("Truck"));

        // Remove one item and show bag again
        bag.remove("Car");
        System.out.println("\nCurrent bag: " + bag);

        // Confirm contains/count updated after the remove
        System.out.println("\nKey test (Car): " + bag.contains("Car"));
        System.out.println("Total Cars: " + bag.count("Car"));
    }
}