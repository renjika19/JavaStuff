package com.fred.Library;

import java.util.List;
import java.util.Scanner;

import com.fred.beans.Book;
import com.fred.services.BookService;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	boolean exit;
	BookService bs = new BookService();
	
	
	public static void main(String []args) {
		Menu menu = new Menu();
		menu.runLib();
	
		
		
	}
	
	public void runLib() {
		printHeader();
		while (!exit){
			printMenu();
			int userChoice = getUserInput();
			performAction(userChoice);
//			int userChoice2 = getUserInput2();
//			performAdminAction(userChoice2);

		}
			
	}
	


	private void printHeader(){
		System.out.println("\\---------------------------------//");
		System.out.println("//          Welcome                \\");
		System.out.println("\\          To The                 //");
		System.out.println("//     Library of Rev              \\");
		System.out.println("\\                                 //");
		System.out.println("//---------------------------------//");
		
	}
	
	private void printMenu() {
		System.out.println("\nWhat would you like to do?");
		System.out.println("\n1. Sign Up  ");
		System.out.println("2. Login       ");
		System.out.println("3. Admin      ");
		System.out.println("0. Exit      ");

	}
	
	private int getUserInput() {
		int userChoice = -1;
		while(userChoice < 0 || userChoice > 3) {
			try {
				System.out.println("Enter Choice Here");
				userChoice = Integer.parseInt(scanner.nextLine());
				
			}
				catch(NumberFormatException e) {
				System.out.println("Selection Invalid ");
				System.out.println("Please Choose Again");
				}
			
			if(userChoice < 0 || userChoice > 3) {
				System.out.println("Selection Invalid");
				System.out.println("Please Choose Again");	
			}
				
//					finally {
//						keyboard.close();
//					}
	
		}while(userChoice < 0 || userChoice > 3);
		 return userChoice;
	
	}

	
	private void performAction(int userChoice) {
		switch(userChoice) {
			case 0:
				exit = true;
				System.out.println("Thank you for visiting Rev Library");
				System.out.println("GoodBye");
				break;
			case 1:
				runSignUp();
				break;
			case 2:
				runLogIn();
				break;
			case 3:
				runAdminLogin();
			default:
				printMenu();       // come back here to change possibly depending on selections
		}
	}
	
	private void runSignUp() {
		String memberType, fname, lname, username, password, address, phone;
		boolean valid = false;
		while(!valid) {
			
			System.out.println("Please enter in Selection. Are you a Student/Faculty member?");
			
			memberType = scanner.nextLine();
			if(memberType.equalsIgnoreCase("student") || memberType.equalsIgnoreCase("faculty")){
				valid = true;
				System.out.println("Please enter in first name: ");
				fname = scanner.nextLine();
				System.out.println("Please enter in Last name: ");
				lname = scanner.nextLine();
				System.out.println("Please enter in a username of your choosing: ");
				username = scanner.nextLine();
				System.out.println("Please enter in a password of your choosing: ");
				password = scanner.nextLine();
				System.out.println("Please enter in your address: ");
				address = scanner.nextLine();
				System.out.println("Please enter in your phone number: ");
				phone = scanner.nextLine();
				
				Member account;
				if(memberType.equalsIgnoreCase("Student")) {
					account = new StudentMember(fname, lname, username, password, address, phone);
				}
				else{
					account = new FacultyMember(fname, lname, username, password, address, phone);
				}
				Patron patron = new Patron(account);
				System.out.println("Thank");
				
				
			}
			else {
				System.out.println("Please Enter in Student or Faculty");
			}
			
		}	
		
	}
	
	
	private void runLogIn() {
		String username, password;
		boolean valid = false;
		while(!valid) {
		System.out.println("Please Enter your Username");
		username = scanner.nextLine();
		System.out.println("Please Enter your password");
		password = scanner.nextLine();
		System.out.println("Log In Successful");
		runMemberMenu();
		performMemberAction(getUserInput());
		}
	}
	
	
	private void runAdminLogin() {
		String username, password;
		boolean valid = false;
		while(!valid) {
			System.out.println("Enter username");
			username = scanner.nextLine();
			System.out.println("Enter password");
			password = scanner.nextLine();
			if((username.equals("Jesse") || username.equals("Rachel")) && (password.equals("Revature1"))){
				valid = true;
				runAdminMenu();
				performAdminAction(getUserInput2());
			}	
				
		}
	}
	
	
	
	
	private void runMemberMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\n1. View Books");
		System.out.println("\n0. Exit");
	}
	
	
	
	private void performMemberAction(int UserChoice) {
		runMemberMenu();
		switch(UserChoice) {
		case 0:
			exit = true;
		case 1:
			bs.getAllBooks();
		default:
			runMemberMenu();
		}
		
	}
	
	private int getUserInput2() {
		int userChoice2 = -1;
		while(userChoice2 < 0 || userChoice2 > 4) {
			try {
				System.out.println("Enter Choice Here");
				userChoice2 = Integer.parseInt(scanner.nextLine());
				
			}
				catch(NumberFormatException e) {
				System.out.println("Selection Invalid ");
				System.out.println("Please Choose Again");
				}
			
			if(userChoice2 < 0 || userChoice2 > 4) {
				System.out.println("Selection Invalid");
				System.out.println("Please Choose Again");	
			}
	
		}while(userChoice2 < 0 || userChoice2 > 4);
		 return userChoice2;
	
	}	

	
	
	private void runAdminMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\n1. Add New Book");
		System.out.println("\n2. Select Book");
		System.out.println("\n3. View Books");
		System.out.println("\n4. Update Library Books");
		System.out.println("\n0. Exit");
		
	}

	private void performAdminAction(int userChoice2) {
		runAdminMenu();
		switch(userChoice2) {
		case 0:
			exit = true;
			System.out.println("Thank you for visiting Rev Library");
			break;
		case 1:
			bs.addNewBook(new Book());
			break;
		case 2:
			bs.getBooksById(userChoice2);
			break;
		case 3:
			bs.getAllBooks();
			break;
		case 4:
			bs.deleteBookById(userChoice2);
			break;
		default:
			performAdminAction(getUserInput2());;
			
		

		}
	}
	
	
}
