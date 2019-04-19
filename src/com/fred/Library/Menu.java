package com.fred.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fred.Dao.MemberDao;
import com.fred.beans.Book;
import com.fred.beans.Member;
import com.fred.services.BookService;
import com.fred.services.MemberService;

public class Menu {
	Scanner scanner = new Scanner(System.in);
//	Library lib = new Library();
	boolean exit;
	BookService bs = new BookService();
	MemberService ms = new MemberService();
//	Member member;
	
	
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
				
		}while(userChoice < 0 || userChoice > 3);
		 return userChoice;
	
	}

	
	private void performAction(int userChoice) {
		switch(userChoice) {
			case 0:
				exit = true;
				System.out.println("Thank you for visiting Rev Library");
				break;
			case 1:
				runSignUp();
				break;
			case 2:
				runLogIn();
				break;
			case 3:
				runAdminLogin();
				break;
			default:
				printMenu();       // come back here to change possibly depending on selections
		}
	}
	
	private void runSignUp() {
		
		String fname, lname, username, pass, email, address, phone;
		System.out.println("Please enter in first name: ");
		fname = scanner.nextLine();
		System.out.println("Please enter in Last name: ");
		lname = scanner.nextLine();
		System.out.println("Please enter in a username of your choosing: ");
		username = scanner.nextLine();
		System.out.println("Please enter in a password of your choosing: ");
		pass = scanner.nextLine();
		System.out.println("Please enter in your email address");
		email = scanner.nextLine();
		System.out.println("Please enter in your address: ");
		address = scanner.nextLine();
		System.out.println("Please enter in your phone number: ");
		phone = scanner.nextLine();
		
		
		ms.addNewMember(new Member(fname, lname, username, pass, email, address, phone));
		
		
		}
//		String memberType, fname, lname, username, password, address, phone;
//		boolean valid = false;
//		while(!valid) {
//			
//			System.out.println("Please enter in Selection. Are you a Student/Faculty member?");
			
//				
//				Member member;
//				if(memberType.equalsIgnoreCase("Student")) {
//					member = new StudentMember(fname, lname, username, password, address, phone);
//				}
//				else{
//					member = new FacultyMember(fname, lname, username, password, address, phone);
//				}
//				Library.addMember(member);
////				Patron patron = new Patron(account);
//				
//				System.out.println("Thank You");
//				Library.addMember(account);
//				
//				
//			}
//			else {
//				System.out.println("Please Enter in Student or Faculty");
//			}
//			
//		}	
//		
	
	
	
	private void runLogIn() {
//		Member member;
		String username, pass;
		boolean valid = false;
		while(!valid) {
		System.out.println("Please Enter your Username");
		username = scanner.nextLine();
		System.out.println("Please Enter your password");
		pass = scanner.nextLine();
		List<Member> memberas = ms.getAllMembers();{
			for(Member m: memberas ) {
				if(m.getUsername().equals(username) && m.getPass().equals(pass)) {
					valid = true;
					runMemberMenu();
					int userChoice = getUserInput();
					performMemberAction(userChoice);
					return;
				}
			}
		}


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
				int userInput2 = getUserInput2();
				performAdminAction(userInput2);
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
			break;
		case 1:
			List<Book> bookas = bs.getAllBooks();
			for(Book b : bookas) {
				System.out.println(b);
			}
			
			break;
//		default:
//			runMemberMenu();
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
		switch(userChoice2) {
		case 0:
			exit = true;
			System.out.println("Thank you for visiting Rev Library");
			break;
		
		case 1:
			Scanner kb = new Scanner(System.in);
			System.out.println("Please enter Book ID");
			String book_ID_temp = kb.nextLine();
			int book_ID = Integer.parseInt(book_ID_temp);
			System.out.println("Please enter Title");
			String title = kb.nextLine();
			System.out.println("Please enter Author");
			String author = kb.nextLine();
			bs.addNewBook(new Book(book_ID,title,author));
			System.out.println();
			runAdminMenu();
			performAdminAction(getUserInput2());;
			break;
		
		case 2:
			Integer bookid = scanner.nextInt();
			bs.getBooksById(bookid);
			System.out.println();
			runAdminMenu();
			performAdminAction(getUserInput2());;
			break;
		
		case 3:
			List<Book> bookas = bs.getAllBooks();
			for(Book b : bookas) {
				System.out.println(b);
				}
			System.out.println();
			runAdminMenu();
			performAdminAction(getUserInput2());;
			break;
			
		case 4:
			System.out.println("Please Enter Book ID");
			int book_ID1= scanner.nextInt();
			bs.deleteBookById(book_ID1);
			System.out.println();
			runAdminMenu();
			performAdminAction(getUserInput2());;
			break;
		
		default:
			performAdminAction(getUserInput2());;
			
			

		}
	}
	
	
}
