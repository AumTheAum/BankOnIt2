import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

	public static void main(String[] args){
		new Bank();
	}

	public Bank(){
		this.loadSampleCustomers();
		this.start();
	}

	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Bank Menu");
		System.out.println("");
		System.out.println("0) Exit");
		System.out.println("1) Login as Admin");
		System.out.println("2) Login as Customer");
		System.out.println("");
		System.out.println("Action: ");
		String response = input.nextLine();
		return response;
	}

	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String response = menu();
			if (response.equals("0")){
				keepGoing = false;
			} else if (response.equals("1")){
				System.out.println("Admin Login");
				if (this.admin.login()){
					startAdmin();
				}
			} else if (response.equals("2")){
				System.out.println("Costumer Login");
			} else {
				System.out.println("Please enter 0, 1, or 2");
			}
		}
	}

	public void startAdmin(){
		boolean keepGoing = true;
		while (keepGoing){
			String response = admin.menu();
			if (response.equals("0")){
				keepGoing = false;
			} else if (response.equals("1")){
				System.out.println("Full Customer Report");
				this.reportAllCustomers();
			} else if (response.equals("2")){
				System.out.println("Add a User");
			} else if (response.equals("3")){
				System.out.println("Apply Interest to Savings");
			}
		}
	}


	public void loadSampleCustomers(){
		customers.add(new Customer("Alice", "1111"));
		customers.add(new Customer("Bob", "2222"));
		customers.add(new Customer("Cindy", "3333"));
		customers.add(new Customer("Damien", "4444"));
	}

	public void reportAllCustomers(){
		for (Customer customer: customers){
			System.out.println(customer.getReport());
		}
	}

}

class CustomerList extends ArrayList<Customer> {};

