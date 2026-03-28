import java.util.*;
import java.io.*;

public class Admin extends User implements HasMenu, Serializable {
	public static void main(String[] args){
		Admin a = new Admin();
		a.login();
	} //end main
	
	public Admin(){
		this.userName = "admin";
		this.PIN = "0000";
	}

	public String menu(){
		Scanner input = new Scanner(System.in);

		System.out.println("Admin Menu");
		System.out.println("");
		System.out.println("0) Exit");
		System.out.println("1) Customer Report");
		System.out.println("Add User");
		System.out.println("Apply Interest to Savings Accouts");
		System.out.println("");
		System.out.println("Action: ");
		String response = input.nextLine();
		return response;
	}

	public void start(){
		//will be implemented in bank
	}

	public String getReport(){
		String report = "Admin userName: " + this.getUserName();
		report += ", Admin PIN " + this.getPIN();
		return report
	}


}
