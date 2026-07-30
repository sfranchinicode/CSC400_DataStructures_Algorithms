public class BagDemo {
        // Main class to run and test Bag class with additional methods created
    public static void main(String[] args) {

        // Two separate bags of vehicle types
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // Added items in bags including duplicates
        bag1.add("Car");
        bag1.add("Truck");
        bag2.add("Car");
        bag2.add("Motorcycle");
        bag1.add("Car");
        bag1.add("Boat");
        bag1.add("Trailer");
        bag2.add("Truck");
        bag1.add("Boat");
        bag2.add("Car");

        // Show the size of each bag inlcuding duplicates
        System.out.println("\nTotal size of bag1: " + bag1.size());
        System.out.println("\nTotal size of bag2: " + bag2.size());

        // Verify whats in bag1 and bag2 prior to merge
        System.out.println("\nBag1 prior to merge: " + bag1);
        System.out.println("Bag2 prior to merge: " + bag2);
        // Merge the bags and print the merged contents
        bag1.merge(bag2);
        System.out.println("\nBag 1 merged is: " + bag1);
        // Verify bag2 remained unchanged after the merge
        System.out.println("Bag 2 after merge: " + bag2); 

        // Create and print the distinct bag
        Bag<String> distinctBag = bag2.distinct();
        System.out.println("\nHere are the distinct entries for bag2: " + distinctBag);
        System.out.println();

    }
}