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
		this.saveCustomers();
		this.loadCustomers();
		this.start();
		this.saveCustomers();
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
				this.loginAsCustomer();
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
				this.addUser();
			} else if (response.equals("3")){
				System.out.println("Apply Interest to Savings");
				this.applyInterest();
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

	public void addUser(){
		Scanner input = new Scanner(System.in);
		System.out.print("Username: ");
		String userName = input.nextLine();
		System.out.print("PIN: ");
		String PIN = input.nextLine();
		customers.add(new Customer(userName, PIN));
}

	public void applyInterest(){
		for(Customer customer: customers){
			customer.savings.calcInterest();
		}
	}

	public void loginAsCustomer(){
		Scanner input = new Scanner(System.in);
                System.out.print("Username: ");
                String userNameIn =  input.nextLine();
                System.out.print("PIN: ");
                String PINin = input.nextLine();

		Customer currentCustomer = null;
		for (Customer customer: customers){
			if (customer.login(userNameIn, PINin)){
				currentCustomer = customer;
			}
		}

		if (currentCustomer == null){
			System.out.println("Customer not found");
		} else {
			currentCustomer.start();
		}
	}

	public void saveCustomers(){
		try {
			FileOutputStream fo = new FileOutputStream("Customers.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(customers);
			obOut.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	public void loadCustomers(){
		try {
			FileInputStream fi = new FileInputStream("Customers.dat");
			ObjectInputStream obIn = new ObjectInputStream(fi);
			customers = (CustomerList)obIn.readObject();
			obIn.close();
			fi.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}

class CustomerList extends ArrayList<Customer> {};

