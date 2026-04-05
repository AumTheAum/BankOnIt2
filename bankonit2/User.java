import java.util.*;
import java.io.*;

public abstract class User implements Serializable, HasMenu {
	String userName = "";
	String PIN = "";

	public void setUser(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setPIN(String PIN) {
		if (PIN.matches("^\\d{4}$")){
			this.PIN = PIN;
		} else {
			System.out.println("PIN must be 4 numeric digits...");
			System.out.println("Setting PIN to 0000");
			this.PIN = "0000";
		}
	}

	public String getPIN(){
		return this.PIN;
	}

	public boolean login(String userNameIn, String pinIn){
		boolean result = false;
		if (userNameIn.equals(this.userName)){
			if (pinIn.equals(this.PIN)){
				result = true;
			}
		}
		return result;
	}

	public boolean login(){
		Scanner input = new Scanner(System.in);
		boolean result = false;
		System.out.print("User name: ");
		String userNameIn = input.nextLine();
		if (userNameIn.equals(this.userName)){
			System.out.print("PIN: ");
			String pinIn = input.nextLine();

			if (pinIn.equals(this.PIN)){
				System.out.println("login successful");
				result = true;
			}
				 else {	
				System.out.println("Incorrect PIN");
				}
			} else {
				System.out.println("Incorrect Username");
			}
			return result;
	}

	public abstract String getReport();

}
