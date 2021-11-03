package emailApplication;

import java.util.Scanner;

//this class creates the objects
public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternteEmail;
	private String companySuffix = "company.com";
	
	// Constructor needs to receive the first name and the last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		// Call a Method asking for the department - return the department
		this.department = setDepartment();
		
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+ companySuffix;
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("New Worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none \nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "Sales";
		}
		else if (depChoice == 2) {
			return "Development";
		}
		else if (depChoice == 3) {
			return "Accounting";
		}
		else {
			return "";
		}
	}
	
	//Generate a random password 
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!?@";
		char [] password = new char [length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			 password[i] = passwordSet.charAt(rand);
			
		}
		return new String (password);
	}
	
	// Set the mailbox capacity  
	public void setMailboxCapacity (int capacity) {
		this.mailboxCapacity = capacity; 
	}
	
	// Set the alternate email 
	 public void setAlternateEmail (String altEmail) {
		 this.alternteEmail = altEmail;
	 }
	
	// Change the password 
	public void changePassword(String password) {
		this.password = password;
	}
	
	// get method for mailbox capacity 
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	// get method for alternative email
	public String getAlternativeEmail() {
		return alternteEmail;
	}
	
	// get method for password
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX: " + mailboxCapacity + "mb";
	}

}
