import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersonQueue queue = new PersonQueue(5); // Set to 5
		
		// Loop to get names and ages using scanner
		for (int i = 0; i < 5; i++) {
			System.out.println("\nSEnter info for person " +(i + 1) + ":");
			System.out.println("\nFirst Name: ");
			String firstName = scanner.nextLine();
			System.out.println("\nLast Name: ");
			String lastName = scanner.nextLine();
			System.out.println("\nAge: ");
			int age = scanner.nextInt();
			// Clear leftover newline so next loops newLine works
			scanner.nextLine();
			
			// Call to add the person to the queue
			Person p = new Person(firstName, lastName, age);
			queue.addPerson(p);
		}
		// Display the orginial results 
		System.out.println("\nOriginal Queue: ");
		queue.displayQueue();
		
		// Display sorted by last names
		queue.sortByLastNameDescending();
	    System.out.println("\nSorted by last name in descending order: ");
	    queue.displayQueue();
		
		// Display sorted by age 
		queue.sortByAgeDescending();
		System.out.println("\nSorted by age in descending order: ");
		queue.displayQueue();
	}
}