Bank.class: Bank.java Customer.class User.class Admin.class
	javac -g Bank.java 

Admin.class: Admin.java User.java
	javac -g Admin.java

Costomer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	javac -g Costumer.java

User.class: User.java HasMenu.class
	javac -g User.java

CheckingAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

testAdmin: Admin.class
	java admin

testCustomer: Customer.class
	java Customer

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

clean:
	rm *.class

run: Bank.class
	java Bank

debug: Bank.class
	jdb Bank