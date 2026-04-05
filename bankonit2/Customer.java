import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {
	static final long serialVersionUID = 1L;

	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args){
		Customer c = new Customer();
		if (c.login()){
			c.start;
		}
	}

	public Customer(){
		this.userName = "Alice";
		this.PIN = "1111";
	}

	public Customer(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
	}

	public String getReport(){
		String report = "User: " + this.getUserName();
		report += ", Checking: " + this.checking.getBalanceString();
		report += ", Savings: " + this.savings.getBalanceString();
		return report;
	}

	public void start(){

		boolean keepGoing = true;
		String result;
		while (keepGoing){
			result = menu();
			if (result.equals("0")){
				keepGoing = false;
			} else if (result.equals("1")){
				System.out.println("Checking account: ");
				this.checking.start();
			} else {
				System.out.println("Enter 0-3");
			}
		}

		// main loop for customer
		// ask for menu input
		// go to correct place
	}

	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Customer Menu");
		System.out.println("0) Exit");
		System.out.println("1) Manage Checking");
		System.out.println("2) Manage Savings");
		System.out.println("3) Change PIN");
		System.out.println();
		System.out.println("You action: 0-3 ");
		String result = input.nextLine();


	return result;
	}

}

