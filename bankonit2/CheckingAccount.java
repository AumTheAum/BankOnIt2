import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {
	double balance;

	public static void main(String[] args){
		CheckingAccount ca = new CheckingAccount();
		ca.start();
	} //end main
	
	public CheckingAccount(){
		this.balance = 0d;
	} //end constructor
	
	public CheckingAccount(double balance){
		this.balance = balance;
	} //end constructor
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("0) quit");
		System.out.println("1) check balance");
		System.out.println("2) make a deposit");
		System.out.println("3) make a withdrawal");
		System.out.println("");
		System.out.print("Please enter 0-3: ");
		String response = input.nextLine();
		return response;
	} //end menu
	
	public void start(){
		boolean keepGoing = false;
		String response;
		while(keepGoing){
			response = menu();
			if (response.equals("0")){
				keepGoing = false;
			} else if (response.equals("1")){
				System.out.println(" Checking balance...");
				this.checkBalance();
			} else if (response.equals("2")){
				System.out.println("Making a deposit...");
				this.makeDeposit();
			} else if (response.equals("3")){
				System.out.println("Making a withdrawal...");
				this.makeWithdrawal();
			} else {
				System.out.println("Please enter one of the right numbers");
			} // end if
		} // end while
	} //end star
	//t
	
	public double getBalance(){
		return this.balance;
	}

	public String getBalanceString(){
		String result = String.format("$%.02f", this.balance);
		return result;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}
	private double getDouble(){
		Scanner input = new Scanner(System.in);
		String resultString = input.nextLine();
		double result = 0d;
		try {
			result = Double.parseDouble(resultString);
		} catch (Exception e){
			System.out.println("Not a legal input. Changing to 0");
			result = 0d;
		}
		return result;
	}

	public void checkBalance(){
		System.out.println("this.getBalanceString");
	}

	public void makeDeposit(){
		System.out.println("How much to deposit? ");
		double deposit = this.getDouble();
		this.balance += deposit;
		System.out.println("New balance: " + this.getBalanceString());
	}

	public void makeWithdrawal(){
		System.out.println("How much to withdraw? ");
		double withdrawal = this.getDouble();
		if (withdrawal > this.balance){
			System.out.println("Insufficient funds...");
		} else {
			this.balance -= withdrawal;
		}
		System.out.println("New balance: " + this.getBalanceString());
	}

} //end class def
