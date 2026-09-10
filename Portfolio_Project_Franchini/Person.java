public class Person {
	// Declare firstName, lastName, and age using private to protect fields
	private String firstName;
	private String lastName; 
	private int age; 
	
	public Person(String firstName, String lastName, int age) {
		// Take the parameter and store it into an object field
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	// Getter methods for classes to peak at data without modifying them
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	// Display data without displaying the built in memory
	@Override
	public String toString() {
		return firstName + " " + lastName + ", Age: " + age;
	}
}