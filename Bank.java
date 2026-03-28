import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

	public static void main(String[] args){
		new Bank();
	}

	public Bank(){
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
			} else if (response.equals("2")){
				System.out.println("Costumer Login");
			} else {
				System.out.println("Please enter 0, 1, or 2");
			}
}
	}



}

class CustomerList extends ArrayList<Customer> {};

