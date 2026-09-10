public class PersonQueue {
	// Declare arrays to hold Person objects
	private Person[] people;
	// Tracks how many people are currently stored in array
	private int count;
	
	// Constructor
	public PersonQueue(int capacity) {
		people = new Person[capacity];
		count = 0; // Must start at 0
	}
	
	// addPerson method
	public void addPerson(Person p) {
		// add an if statement as a safety precaution for a full queue
		if (count < people.length) {
		    people[count] = p; 
		    count++;
		}
		else {
			System.out.println("Queue is full, cannot add more people.");
		}
	}
	
	// Display whats in the queue using i as a counter
	public void displayQueue() {
		for (int i = 0; i < count; i++) {
			System.out.println(people[i]);
		}
	}
	
	/*
	Quicksort section of the array by lastname in descending order using 
	low and high to mark the boundaries
	*/
	private static void quicksortByLastName(Person[] arr, int low, int high) {
		// Only sort if more than one element
		if (low < high) {
			int pivotIndex = partitionByLastName(arr, low, high);
			// Recursive sort everything to left of pivotIndex
			quicksortByLastName(arr, low, pivotIndex - 1);
			// Recursive sort everything to right of pivotIndex
			quicksortByLastName(arr, pivotIndex + 1, high);
		}
	}
	
	/*
	Rearrange one section of the array around the pivot value
	Letters alphabetically after pivotIndex go left side the others go to the right
	*/
    private static int partitionByLastName(Person[] arr, int low, int high){
	    // Last element is the pivot for now
	    Person pivot = arr[high];
	    int i = low - 1;
	
	    // loop to compare elements
	    for (int j = low; j < high; j++) {
		    // Get names and compare using ">" for descending order
		    if (arr[j].getLastName().compareTo(pivot.getLastName()) > 0) {
			    i++;
			    // Place in temporary array while sorting
			    Person temp = arr[i];
			    arr[i] = arr[j];
			    arr[j] = temp;
		    }
	    }
	    // Place pivot into its final spot
        Person temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	
	    // Return pivots final index for next split
	    return i + 1;
	}
	
	// Sort by age in descending order (similar to above)
	private static void quicksortByAge(Person[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partitionByAge(arr, low, high);
			quicksortByAge(arr, low, pivotIndex - 1);
			quicksortByAge(arr, pivotIndex + 1, high);
		}
	}
	
	// Similar rearrange to above for the the ages
	private static int partitionByAge(Person[] arr, int low, int high) {
		Person pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getAge() > pivot.getAge()) {
				i++;
				// Hold temporary array
				Person temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		Person temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	
	/* 
	Wrapper methods for Main to call
	count - 1 -> ensuring the correct index is used
	for the last name in the array
	*/
	public void sortByLastNameDescending() {
		quicksortByLastName(people, 0, count - 1);
	}
	
	public void sortByAgeDescending() {
		quicksortByAge(people, 0, count - 1);
	}
}